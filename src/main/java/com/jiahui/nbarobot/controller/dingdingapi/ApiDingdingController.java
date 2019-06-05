package com.jiahui.nbarobot.controller.dingdingapi;


import com.jiahui.nbarobot.domain.dingding.CallbackRequest;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;
import com.jiahui.nbarobot.domain.dingding.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dongjiahui
 */
@Controller
@RequestMapping(value = "/api/robot")
public class ApiDingdingController {

    Logger logger = LoggerFactory.getLogger(ApiDingdingController.class);

    @RequestMapping(value = "/qc",produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String qc(CallbackRequest request){

        logger.info("qc 接收到机器人信息:" +request.toString());
        DingtalkMessage message = new TextMessage("李月芹是🐷");
        return message.toJsonString();
    }
}
