package com.jiahui.nbarobot.controller;

import cn.hutool.json.JSONUtil;
import com.jiahui.nbarobot.dao.NbaGuessResultMapper;
import com.jiahui.nbarobot.dao.gamble.amount.UserWinLoseInfoMapper;
import com.jiahui.nbarobot.service.NeteaseNbaDataCopyService;
import com.jiahui.nbarobot.service.gambleservice.amount.GableAmountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongjiahui
 */
@RestController
public class TestController {

    @Resource
    private NeteaseNbaDataCopyService nbaDataCopyService;
    @Resource
    private GableAmountService gableAmountService;
    @Resource
    private UserWinLoseInfoMapper userWinLoseInfoMapper;

    @RequestMapping("/test")
    public String test(String nick){
        gableAmountService.getWeekMouthsLogs(nick);
        return JSONUtil.toJsonStr("测试下");
    }

    @RequestMapping("/test1")
    public String test1(){
        nbaDataCopyService.copyNeteaseNbaResultMath();
        nbaDataCopyService.copyNeteaseNbaStartMath();
        return "2eee23223322";
    }



}
