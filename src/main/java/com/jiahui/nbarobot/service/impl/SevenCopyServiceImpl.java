package com.jiahui.nbarobot.service.impl;

import com.jiahui.nbarobot.domain.NbaGuessResult;
import com.jiahui.nbarobot.domain.seven.SevenNbaMatchResult;
import com.jiahui.nbarobot.domain.utils.ResultVO;
import com.jiahui.nbarobot.service.SevenCopyService;
import com.jiahui.nbarobot.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongjiahui
 */
@Service(value = "SevenCopyService")
public class SevenCopyServiceImpl implements SevenCopyService{

    @Override
    public void copyMatchResult(String date){
        date = "2019-03-21";
        SevenNbaMatchResult sevenNbaMatchResult = new SevenNbaMatchResult();
        String url = "https://mobi.7m.com.cn/bdata/result/" + date + "/gb.json";
        String oddsUrl = "https://mobi.7m.com.cn/bdata/result/"+ date +"/odds1.json";
        ResultVO resultVO = HttpRequestUtil.copy(url,sevenNbaMatchResult);
        sevenNbaMatchResult = (SevenNbaMatchResult) resultVO.getData();
        for(List<String> match:sevenNbaMatchResult.getMatchs()){
            NbaGuessResult nbaGuessResult = new NbaGuessResult();
            //加上 002 区分来源为 7m比分网
            nbaGuessResult.setMatchId(Integer.parseInt(match.get(0)) * 1000 + 2);


        }




    }

    @Override
    public void copyMatchStart(String date){

    }



}
