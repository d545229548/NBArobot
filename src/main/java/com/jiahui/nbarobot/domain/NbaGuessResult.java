package com.jiahui.nbarobot.domain;

import java.util.Date;

/**
 * @author dongjiahui
 */
public class NbaGuessResult {
    private Integer id;

    /**
     * 爬取来的比赛id，作为比赛唯一id来源，为了区分爬取平台，前面id加上来源
     * 网易后面 + 001
     */
    private Integer matchId;

    private String guestTeamName;

    private String guestScore;

    private String homeTeamName;

    private String homeScore;

    private Date matchDate;

    private String guessResult;

    private String realResult;

    /**
     * 比赛盘口
     */
    private String code;

    private Date gmtCreate;

    private Date gmtUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getGuestTeamName() {
        return guestTeamName;
    }

    public void setGuestTeamName(String guestTeamName) {
        this.guestTeamName = guestTeamName == null ? null : guestTeamName.trim();
    }

    public String getGuestScore() {
        return guestScore;
    }

    public void setGuestScore(String guestScore) {
        this.guestScore = guestScore == null ? null : guestScore.trim();
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName == null ? null : homeTeamName.trim();
    }

    public String getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(String homeScore) {
        this.homeScore = homeScore == null ? null : homeScore.trim();
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getGuessResult() {
        return guessResult;
    }

    public void setGuessResult(String guessResult) {
        this.guessResult = guessResult == null ? null : guessResult.trim();
    }

    public String getRealResult() {
        return realResult;
    }

    public void setRealResult(String realResult) {
        this.realResult = realResult == null ? null : realResult.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}