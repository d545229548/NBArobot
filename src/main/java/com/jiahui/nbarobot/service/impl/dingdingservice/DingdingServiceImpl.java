package com.jiahui.nbarobot.service.impl.dingdingservice;

import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.dao.WeekQuestionMapper;
import com.jiahui.nbarobot.domain.WeekQuestion;
import com.jiahui.nbarobot.domain.dingding.CallbackRequest;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;
import com.jiahui.nbarobot.domain.dingding.TextMessage;
import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import com.jiahui.nbarobot.service.dingdingservice.DingdingService;
import com.jiahui.nbarobot.service.gambleservice.amount.GableAmountService;
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

        String content = request.getContext();
        //指令名称
        String commandName;
        //指令详情
        String command;

        //解析指令
        try {
            commandName = content.substring(0,content.indexOf("["));
            command = content.substring(content.indexOf("["),content.indexOf("]"));
        }catch (Exception e){
            message = new TextMessage("解析指令出现异常，异常信息为 -- " + e);
            return message;
        }

        if(!command.contains(",")){
            message = new TextMessage("指令解析失败,未包含,");
            return message;
        }

        if("记录盈亏".equals(commandName)){
            return gableAmountCommand(command,request);
        }else {
            return new TextMessage("目前未包含该指令");
        }

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


}
