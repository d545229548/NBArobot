package com.jiahui.nbarobot.service.impl.dingdingservice;

import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.dao.WeekQuestionMapper;
import com.jiahui.nbarobot.domain.WeekQuestion;
import com.jiahui.nbarobot.domain.dingding.CallbackRequest;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;
import com.jiahui.nbarobot.domain.dingding.MarkdownMessage;
import com.jiahui.nbarobot.domain.dingding.TextMessage;
import com.jiahui.nbarobot.domain.gamble.amount.AmountVO;
import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import com.jiahui.nbarobot.service.dingdingservice.DingdingService;
import com.jiahui.nbarobot.service.gambleservice.amount.GableAmountService;
import com.jiahui.nbarobot.utils.ExceptionUtil;
import com.jiahui.nbarobot.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author dongjiahui
 */
@Service(value = " DingdingService")
public class DingdingServiceImpl implements DingdingService{

    @Resource
    private WeekQuestionMapper weekQuestionMapper;
    @Resource
    private GableAmountService gableAmountService;

    private static DingtalkMessage commandTemplate = new TextMessage("记录盈亏[来源,金额,简介]");


    @Override
    public String toQc(CallbackRequest request){
        String json = JSON.toJSONString(request);
        return HttpRequestUtil.postJson("http://www.djhbaby.club:8080/api/robot/callback/qc",json);
    }

    @Override
    public DingtalkMessage ai(CallbackRequest request){
        DingtalkMessage message;

        String content = request.getText().getContent();
        if(content.contains("发起每周一问")){
            message = addWeekQuestion(request);
        }
        else if(content.contains("每周一问")){
            message = getWeekQuestion(request);
        }
        //判断是否进入指令模式
        else if(content.contains("[") && content.contains("]")){
            message = command(request);
        }
        else {
            message = new TextMessage(request.getSenderNick() + "我没听懂你的意思,所以你是🐷");
        }
        return message;

    }


    private DingtalkMessage command(CallbackRequest request){
        DingtalkMessage message;

        String content = request.getText().getContent();
        //指令名称
        String commandName;
        //指令详情
        String command;

        //解析指令
        try {
            commandName = content.substring(0,content.indexOf("["));
            command = content.substring(content.indexOf("[")+1,content.indexOf("]"));
        }catch (Exception e){
            message = new TextMessage("解析指令出现异常，异常信息为 -- " + ExceptionUtil.getTrace(e));
            return message;
        }


        if(commandName.contains("记录盈亏")){
            return gableAmountCommand(command,request);
        }else if(commandName.contains("查询盈亏")){
            return selectAmountCommand(command,request);
        }else {
            return new TextMessage("目前未包含该指令");
        }

    }

    /**
     * 查询盈亏记录
     * @param request 请求
     * @return markdown消息
     */
    private DingtalkMessage selectAmountCommand(String command,CallbackRequest request){
        MarkdownMessage message = new MarkdownMessage();
        message.setTitle(request.getSenderNick() + "**盈亏记录**");
        AmountVO amountVO = gableAmountService.getAmount();
        message.add("# **盈亏记录**");
        message.add(" 您的总盈亏金额：<font color=#FF0000>"+ amountVO.getWinAmount() + "</font><br/>");
        message.add(" 您的总胜率：<font color=#FF0000>"+ amountVO.getWinPer() + "</font><br/>");
        message.add(" 您的本月盈亏金额：<font color=#FF0000>"+ amountVO.getMonthsWinAmount() + "</font><br/>");
        message.add(" 您的本月胜率：<font color=#FF0000>"+ amountVO.getMonthsWinPer() + "</font><br/>");
        message.add(" 您的本周盈亏金额：<font color=#FF0000>"+ amountVO.getWeekWinAmount() + "</font><br/>");
        message.add(" 您的本周胜率：<font color=#FF0000>"+ amountVO.getWeekWinPer() + "</font><br/>");
        message.add("您的最近五笔记录如下：");
        for(UserWinLoseInfo log :amountVO.getLogs()){
            String result;
            if("win".equals(log.getResult())){
                result = "<font color=#FF0000>win</font>";
            }else {
                result = "<font color=#00BB00>lose</font>";
            }
            message.add("- " + result + "," + log.getAmt() + "," + log.getSource());
        }

        return message;




    }

    private DingtalkMessage gableAmountCommand(String command,CallbackRequest request){
        DingtalkMessage message;
        String[] list = command.split(",");

        if(list.length < 2 || list.length > 3){
            return new TextMessage("指令解析失败,size不为2或者3");
        }

        UserWinLoseInfo userWinLoseInfo = new UserWinLoseInfo();
        userWinLoseInfo.setCreateTime(new Date());
        userWinLoseInfo.setSource(list[0]);
        try {
            Double amount = Double.valueOf(list[1]);
            userWinLoseInfo.setAmt(amount);
            if(amount > 0 ){
                userWinLoseInfo.setResult("win");
            }else {
                userWinLoseInfo.setResult("lost");
            }
        }catch (Exception e){
            return new TextMessage("金额解析异常");
        }
        userWinLoseInfo.setUser(request.getSenderNick());
        if(list.length == 3){
            userWinLoseInfo.setDesc(list[2]);
        }
        gableAmountService.addLog(userWinLoseInfo);
        return new TextMessage("记录成功");
    }




    private DingtalkMessage addWeekQuestion(CallbackRequest request){
        DingtalkMessage message;
        WeekQuestion lastQuestion = weekQuestionMapper.selectLastQuestion();
        List<String> names = new ArrayList(){{
            add("董佳晖");
            add("许琴琴");
            add("周晓琴");
        }};
        if(!names.contains(request.getSenderNick())){
            return new TextMessage("你这只🐷，你没有权限发起每周一问");
        }



        //判断上一个问题是在本周内创建的，是就不再创建，否就创建
        if(lastQuestion == null || !isThisWeek(lastQuestion.getCreateTime())){
            WeekQuestion weekQuestion = new WeekQuestion();
            weekQuestion.setQuestion(request.getText().getContent().replace("发起每周一问",""));
            weekQuestion.setCreateTime(new Date());
            weekQuestion.setUser(request.getSenderNick());
            weekQuestionMapper.insert(weekQuestion);
            message = new TextMessage(request.getSenderNick() + "成功发起每周一问");
        }else {
            message = new TextMessage("sorry,本周已经发起过每周一问");
        }

        return message;
    }

    private DingtalkMessage getWeekQuestion(CallbackRequest request){
        DingtalkMessage message;
        WeekQuestion lastQuestion = weekQuestionMapper.selectLastQuestion();
        if(lastQuestion == null){
            return new TextMessage("没有每周一问记录");
        }
        if(isThisWeek(lastQuestion.getCreateTime())){
            message = new TextMessage("本周每周一问为 ==== "+lastQuestion.getQuestion());
        }else {
            message = new TextMessage("本周没有发起每周一问");
        }
        return message;
    }


    /**
     * 判断日期是不是在本周
     * @param lastDate 日期
     * @return true 是 false 不是
     */
    public boolean isThisWeek(Date lastDate) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(lastDate);
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return paramWeek == currentWeek;
    }


    public static void main(String[] args){
        CallbackRequest callbackRequest = new CallbackRequest();
        CallbackRequest.TextBean textBean = new CallbackRequest.TextBean();
        callbackRequest.setText(textBean);
        textBean.setContent("记录盈亏[公众号足球,78.75,阿根廷赢了]");
        DingdingServiceImpl dingdingService = new DingdingServiceImpl();
        dingdingService.command(callbackRequest);
    }

}
