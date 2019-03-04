package com.jiahui.nbarobot.controller;

import cn.hutool.json.JSONUtil;
import com.jiahui.nbarobot.dao.NbaGuessResultMapper;
import com.jiahui.nbarobot.domain.NbaGuessResult;
import com.jiahui.nbarobot.service.NbaDataCopyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongjiahui
 */
@RestController
public class TestController {

    @Resource
    private NbaDataCopyService nbaDataCopyService;
    @Resource
    private NbaGuessResultMapper nbaGuessResultMapper;

    @RequestMapping("/test")
    public String test(){
        nbaDataCopyService.copyNeteaseNbaMatchReport(351886001);
        return JSONUtil.toJsonStr("测试下");
    }

    @RequestMapping("/test1")
    public String test1(){
        NbaGuessResult nbaGuessResult = new NbaGuessResult();
        nbaGuessResult.setCode("323");
        nbaGuessResultMapper.insertSelective(nbaGuessResult);
        return "2eee23223322";
    }

}
