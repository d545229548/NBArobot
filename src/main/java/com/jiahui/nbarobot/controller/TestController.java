package com.jiahui.nbarobot.controller;

import com.jiahui.nbarobot.dao.NbaGuessResultMapper;
import com.jiahui.nbarobot.domain.NbaGuessResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongjiahui
 */
@RestController
public class TestController {

    @Resource
    private NbaGuessResultMapper nbaGuessResultMapper;

    @RequestMapping("/test")
    public String test(){
        NbaGuessResult nbaGuessResult = new NbaGuessResult();
        nbaGuessResult.setRealResult("home");
        nbaGuessResult.setCode(1);
        nbaGuessResultMapper.insertSelective(nbaGuessResult);
        return "11";
    }

}
