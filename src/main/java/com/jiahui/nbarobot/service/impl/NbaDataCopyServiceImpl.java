package com.jiahui.nbarobot.service.impl;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.dao.NbaGuessResultMapper;
import com.jiahui.nbarobot.domain.NbaGuessResult;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMathResult;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMathResult.DataBean.MatchListBean;
import com.jiahui.nbarobot.domain.utils.ResultVO;
import com.jiahui.nbarobot.service.NbaDataCopyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author dongjiahui
 */
@Service(value = "NbaDataCopyService")
public class NbaDataCopyServiceImpl implements NbaDataCopyService{

    @Resource
    private NbaGuessResultMapper nbaGuessResultMapper;

    private Logger logger = LoggerFactory.getLogger(NbaDataCopyServiceImpl.class);

    @Override
    public ResultVO copyNeteaseNbaMath(String url){
        ResultVO resultVO = new ResultVO();

        String result = HttpRequest.get(url)
                .header("Content-Type","application/json;charset=UTF-8")
                .header("Accept","*/*")
                .header("User-Agent","RelotteryApp/6.8.0 iOS/12.1.2 (iPhone X)")
                .execute().body();
        logger.info("测试网易接口返回信息为 {}",result);
        NeteaseNbaMathResult neteaseNbaMathResult;
        //将json系列成javabean
        try {
            neteaseNbaMathResult = JSON.parseObject(result,NeteaseNbaMathResult.class);

        }catch (Exception e){
            e.printStackTrace();
            resultVO.setSuccess(false);
            resultVO.setMessage("网易接口系列化错误");
            return resultVO;
        }
        if(neteaseNbaMathResult == null || neteaseNbaMathResult.getCode() != 200){
            resultVO.setSuccess(false);
            resultVO.setMessage("网易接口返回错误");
            return resultVO;
        }
        List<MatchListBean> matchListBeans = neteaseNbaMathResult.getData().getMatchList();
        for(MatchListBean math : matchListBeans){
            //只爬取NBA的比赛
            if("NBA".equals(math.getLeagueMatch().getLeagueName())){
                NbaGuessResult nbaGuessResult = new NbaGuessResult();
                //比赛id后面加上001区分来源
                Integer mathId = math.getMatchInfoId()*1000+1;
                nbaGuessResult.setMatchId(mathId);
                nbaGuessResult.setGuestTeamName(math.getGuestTeam().getTeamName());

                nbaGuessResult.setHomeTeamName(math.getHomeTeam().getTeamName());
                nbaGuessResult.setCode(math.getPlay().getConcede());

                //这里有层判断，时间大于当前时间，代表没有开赛，就不爬取比分和胜果
                if(math.getTime() < System.currentTimeMillis()){
                    nbaGuessResult.setGuestScore(String.valueOf(math.getGuestScore()));
                    nbaGuessResult.setHomeScore(String.valueOf(math.getHomeScore()));
                    //主队比分减去客队比分>让分，代表主胜
                    if(math.getHomeScore() + Double.valueOf(math.getPlay().getConcede()) - math.getGuestScore() > 0){
                        nbaGuessResult.setRealResult("W");
                    }else {
                        nbaGuessResult.setRealResult("L");
                    }
                }
                nbaGuessResult.setGmtCreate(new Date());
                nbaGuessResult.setMatchDate(new Date(math.getTime()));
                if(nbaGuessResultMapper.selectByMatchId(mathId) == null){
                    nbaGuessResultMapper.insertSelective(nbaGuessResult);
                }else {
                    nbaGuessResult.setGmtUpdate(new Date());
                    nbaGuessResult.setId(nbaGuessResultMapper.selectByMatchId(mathId).getId());
                    nbaGuessResultMapper.updateByPrimaryKeySelective(nbaGuessResult);
                }

            }

        }
        resultVO.setMessage("爬取成功");
        resultVO.setSuccess(true);
        return resultVO;
    }

    @Override
    public ResultVO copyNeteaseNbaResultMath(){
        return this.copyNeteaseNbaMath(
                "https://hongcai.163.com/api/front/matchInfo/getMatchResultList/2/0/20"
        );
    }

    @Override
    public ResultVO copyNeteaseNbaStartMath(){
        return this.copyNeteaseNbaMath(
                "https://hongcai.163.com/api/front/matchInfo/getRealTimeMatchList/2"
        );
    }

}
