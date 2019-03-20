package com.jiahui.nbarobot.controller;

import com.jiahui.nbarobot.service.NbaDataCopyService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongjiahui
 */
@RestController
@EnableScheduling
public class EaseCopyController {

    @Resource
    private NbaDataCopyService nbaDataCopyService;

    @Scheduled(cron = "0 0 3 * * ?")
    public void copyNeteaseNbaStartMath(){
        nbaDataCopyService.copyNeteaseNbaResultMath();
    }

    @Scheduled(cron = "0 0 18 * * ?")
    public void copyNeteaseNbaResultMath(){
        nbaDataCopyService.copyNeteaseNbaResultMath();
    }
}
