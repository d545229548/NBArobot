package com.jiahui.nbarobot.service.impl;


import com.jiahui.nbarobot.dao.NbaGuessPointLogMapper;
import com.jiahui.nbarobot.dao.NbaGuessResultMapper;
import com.jiahui.nbarobot.domain.NbaGuessPointLog;
import com.jiahui.nbarobot.domain.NbaGuessResult;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMatchReport;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMatchResult;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMatchReport.DataBean.EventBean.GuestEventBean;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMatchReport.DataBean.EventBean.HomeEventBean;
import com.jiahui.nbarobot.domain.netease.NeteaseNbaMatchResult.DataBean.MatchListBean;
import com.jiahui.nbarobot.domain.utils.ResultVO;
import com.jiahui.nbarobot.service.NeteaseNbaDataCopyService;
import com.jiahui.nbarobot.utils.HttpRequestUtil;
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
public class NeteaseNbaDataCopyServiceImpl implements NeteaseNbaDataCopyService {

    @Resource
    private NbaGuessResultMapper nbaGuessResultMapper;
    @Resource
    private NbaGuessPointLogMapper nbaGuessPointLogMapper;

    /**
     * 情报来源于网易
     */
    private static final Integer NETNASESOURCEID = 1;

    /**
     * 情报type , 1 为主队得分 2 为客队得分
     */
    private static final String REPORTTYPEGUEST = "2";
    private static final String REPORTTYPEHOME = "1";

    private Logger logger = LoggerFactory.getLogger(NeteaseNbaDataCopyServiceImpl.class);



    @Override
    public ResultVO copyNeteaseNbaMath(String url){
        ResultVO resultVO ;
        NeteaseNbaMatchResult neteaseNbaMatchResult = new NeteaseNbaMatchResult();
        resultVO = HttpRequestUtil.copy(url,neteaseNbaMatchResult);
        if(!resultVO.getSuccess()){
            return resultVO;
        }
        neteaseNbaMatchResult = (NeteaseNbaMatchResult) resultVO.getData();
        if(neteaseNbaMatchResult.getCode() != 200){
            resultVO.setSuccess(false);
            resultVO.setMessage("接口返回异常");
        }
        List<MatchListBean> matchListBeans = neteaseNbaMatchResult.getData().getMatchList();
        for(MatchListBean math : matchListBeans){
            //只爬取NBA的比赛
            if("NBA".equals(math.getLeagueMatch().getLeagueName())){
                NbaGuessResult nbaGuessResult = new NbaGuessResult();
                //比赛id后面加上001区分来源
                Integer mathId = math.getMatchInfoId()*1000+1;
                nbaGuessResult.setMatchId(mathId);
                nbaGuessResult.setGuestTeamName(math.getGuestTeam().getTeamName());

                nbaGuessResult.setHomeTeamName(math.getHomeTeam().getTeamName());
                if(math.getPlay()  != null){
                    nbaGuessResult.setCode(math.getPlay().getConcede());
                }

                //这里有层判断，时间大于当前时间，代表没有开赛，就不爬取比分和胜果
                if(math.getTime() < System.currentTimeMillis() && math.getPlay() != null){
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

    @Override
    public ResultVO copyNeteaseNbaMatchReport(Integer matchId){
        ResultVO resultVO ;
        //针对网易的match_id转换下
        String url = "https://hongcai.163.com/api/front/matchInfo/getMatchReport/" + (matchId - 1)/1000;
        NeteaseNbaMatchReport nbaMatchReport = new NeteaseNbaMatchReport();
        resultVO = HttpRequestUtil.copy(url,nbaMatchReport);
        if(!resultVO.getSuccess()){
            return resultVO;
        }
        nbaMatchReport = (NeteaseNbaMatchReport) resultVO.getData();
        if(nbaMatchReport.getCode() != 200 || nbaMatchReport.getData() == null){
            resultVO.setSuccess(false);
            resultVO.setMessage("接口返回异常或者该比赛无情报信息");
        }

        for(GuestEventBean guestEventBean : nbaMatchReport.getData().getEvent().getGuestEvent()){
            NbaGuessPointLog pointLog = new NbaGuessPointLog();
            pointLog.setMatchId(matchId);
            pointLog.setGmtCreate(new Date());
            //type 主队得分 1  客队得分 2
            pointLog.setType(REPORTTYPEGUEST);
            //优势加分，劣势减分
            if(guestEventBean.getUpDown() == 0){
                pointLog.setPoint("10");
            }else if(guestEventBean.getUpDown() == 1){
                pointLog.setPoint("-10");
            }
            pointLog.setDesc(guestEventBean.getTitle());
            //1 表示情报来源于网易，以后用枚举表示
            pointLog.setSourceId(NETNASESOURCEID);
            nbaGuessPointLogMapper.insertSelective(pointLog);
        }
        for(HomeEventBean homeEventBean : nbaMatchReport.getData().getEvent().getHomeEvent()){
            NbaGuessPointLog pointLog = new NbaGuessPointLog();
            pointLog.setMatchId(matchId);
            pointLog.setGmtCreate(new Date());
            //type 主队得分 1  客队得分 2
            pointLog.setType(REPORTTYPEHOME);
            //优势加分，劣势减分
            if(homeEventBean.getUpDown() == 0){
                pointLog.setPoint("10");
            }else if(homeEventBean.getUpDown() == 1){
                pointLog.setPoint("-10");
            }
            pointLog.setDesc(homeEventBean.getTitle());
            //1 表示情报来源于网易，以后用枚举表示
            pointLog.setSourceId(NETNASESOURCEID);
            nbaGuessPointLogMapper.insertSelective(pointLog);
        }

        return resultVO;
    }




}
