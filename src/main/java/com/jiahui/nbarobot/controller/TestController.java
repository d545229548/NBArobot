package com.jiahui.nbarobot.controller;

import cn.hutool.json.JSONUtil;
import com.jiahui.nbarobot.dao.NbaGuessResultMapper;
import com.jiahui.nbarobot.service.NeteaseNbaDataCopyService;
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
    private NbaGuessResultMapper nbaGuessResultMapper;

    @RequestMapping("/test")
    public String test(){
        nbaDataCopyService.copyNeteaseNbaMatchReport(351886001);
        return JSONUtil.toJsonStr("测试下");
    }

    @RequestMapping("/test1")
    public String test1(){
        nbaDataCopyService.copyNeteaseNbaResultMath();
        nbaDataCopyService.copyNeteaseNbaStartMath();
        return "2eee23223322";
    }

}
