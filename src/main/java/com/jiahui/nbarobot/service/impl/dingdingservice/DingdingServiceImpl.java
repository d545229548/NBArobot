package com.jiahui.nbarobot.service.impl.dingdingservice;

import com.jiahui.nbarobot.dao.WeekQuestionMapper;
import com.jiahui.nbarobot.domain.WeekQuestion;
import com.jiahui.nbarobot.domain.dingding.CallbackRequest;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;
import com.jiahui.nbarobot.domain.dingding.TextMessage;
import com.jiahui.nbarobot.service.dingdingservice.DingdingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



/**
 * @author dongjiahui
 */
@Service(value = " DingdingService")
public class DingdingServiceImpl implements DingdingService{

    @Resource
    private WeekQuestionMapper weekQuestionMapper;

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
        else {
            message = new TextMessage(request.getSenderNick() + "我没听懂你的意思,所以你是🐷");
        }
        return message;

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
