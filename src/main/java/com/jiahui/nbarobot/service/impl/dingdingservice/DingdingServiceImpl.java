package com.jiahui.nbarobot.service.impl.dingdingservice;

import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.domain.dingding.CallbackRequest;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;
import com.jiahui.nbarobot.domain.dingding.MarkdownMessage;
import com.jiahui.nbarobot.domain.dingding.TextMessage;
import com.jiahui.nbarobot.domain.gamble.amount.AmountVO;
import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import com.jiahui.nbarobot.domain.gamble.amount.WeekMonthsAmountVO;
import com.jiahui.nbarobot.service.dingdingservice.DingdingService;
import com.jiahui.nbarobot.service.emoticonservice.EmoticonService;
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
    private GableAmountService gableAmountService;
    @Resource
    private EmoticonService emoticonService;

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
        //判断是否进入指令模式
        if(content.contains("[") && content.contains("]")){
            message = command(request);
        }
        if(content.contains("熊猫头说")){
            message = makeImg(content);
        }
        else {
            message = new TextMessage(request.getSenderNick() + "我没听懂你的意思,所以你是🐷");
        }
        return message;

    }

    private DingtalkMessage makeImg(String content){
        String[] cl;
        cl = content.split(" ");
        if(cl.length != 2){
            return new TextMessage("你会不会玩啊,专业点好么？");
        }
        MarkdownMessage message = new MarkdownMessage();
        String imgUrl = emoticonService.makeImg(cl[1]);
        message.add("![]("+imgUrl+")");
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
        } else if (commandName.contains("查询周盈亏")) {
            return selectWeekAmountCommand(command,request);
        } else {
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
            message.add(" 您的总盈亏金额：<font color=#FF0000>"+ amountVO.getWinAmount() + "</font>\n");
            message.add(" 您的总胜率：<font color=#FF0000>"+ amountVO.getWinPer() + "</font>\n");
            message.add(" 您的本月盈亏金额：<font color=#FF0000>"+ amountVO.getMonthsWinAmount() + "</font>\n");
            message.add(" 您的本月胜率：<font color=#FF0000>"+ amountVO.getMonthsWinPer() + "</font>\n");
            message.add(" 您的本周盈亏金额：<font color=#FF0000>"+ amountVO.getWeekWinAmount() + "</font>\n");
            message.add(" 您的本周胜率：<font color=#FF0000>"+ amountVO.getWeekWinPer() + "</font>\n");
            message.add("您的所有来源收支如下：\n");
            Map<String,String> sourceAmt =amountVO.getSourceAmt();
            Map<String,String> sourcePer = amountVO.getSourceWinPer();
            for(String key:sourceAmt.keySet()){
                String amt = sourceAmt.get(key);
                if(Double.valueOf(amt) >= 0){
                    amt = "<font color=#FF0000>"+ amt +"</font>";
                }else {
                    amt = "<font color=#00BB00>"+ amt +"</font>";
                }
                message.add("- " + key + "," + amt + "," + sourcePer.get(key));
            }
            message.add("\n");
            message.add("您的最近五笔记录如下：\n");
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


    private DingtalkMessage selectWeekAmountCommand(String command,CallbackRequest request){
        MarkdownMessage message = new MarkdownMessage();

        message.setTitle(request.getSenderNick() + "**盈亏记录**");
        String nick;

        if("董佳晖".equals(request.getSenderNick())){
            nick = null;
        }else {
            nick = request.getSenderNick();
        }

        WeekMonthsAmountVO weekMonths = gableAmountService.getWeekMouthsLogs(nick);
        message.add("# **"+ request.getSenderNick() +"周盈亏记录**");
        message.add("<font color=#FF0000>如果为空即没有记录相关数据</font>\n");
        message.add(" 您的本周盈亏金额：<font color=#FF0000>"+ weekMonths.getWeekWinAmount() + "</font>\n");
        message.add(" 您的本周盈亏胜率：<font color=#FF0000>"+ weekMonths.getWeekPer() + "</font>\n");
        message.add(" 您的上周盈亏金额：<font color=#FF0000>"+ weekMonths.getLastOneWeekAmount() + "</font>\n");
        message.add(" 您的上周胜率：<font color=#FF0000>"+ weekMonths.getLastOneWeekPer() + "</font>\n");
        message.add(" 您的前两周盈亏金额：<font color=#FF0000>"+ weekMonths.getLastTwoWeekAmount() + "</font>\n");
        message.add(" 您的前两周胜率：<font color=#FF0000>"+ weekMonths.getLastTwoWeekPer() + "</font>\n");
        message.add(" 您的前三周盈亏金额：<font color=#FF0000>"+ weekMonths.getLastThreeWeekAmount() + "</font>\n");
        message.add(" 您的前三周胜率：<font color=#FF0000>"+ weekMonths.getLastThreeWeekPer() + "</font>\n");
        message.add(" 您的前四周盈亏金额：<font color=#FF0000>"+ weekMonths.getLastFourWeekAmount() + "</font>\n");
        message.add(" 您的前四周胜率：<font color=#FF0000>"+ weekMonths.getLastFourWeekPer() + "</font>\n");
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
        callbackRequest.setSenderNick("蔡阳");
        textBean.setContent("查询周盈亏[]");
        DingdingServiceImpl dingdingService = new DingdingServiceImpl();
        dingdingService.command(callbackRequest);
    }

}
