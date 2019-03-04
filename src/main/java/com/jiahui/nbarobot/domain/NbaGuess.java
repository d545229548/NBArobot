package com.jiahui.nbarobot.domain;

import java.util.Date;

public class NbaGuess {
    private Integer id;

    private Integer matchId;

    private Integer homePoints;

    private Integer guestPoints;

    private Date gmtCreate;

    private Date gmtUpdate;

    private String gusesResult;

    private String win;

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

    public Integer getHomePoints() {
        return homePoints;
    }

    public void setHomePoints(Integer homePoints) {
        this.homePoints = homePoints;
    }

    public Integer getGuestPoints() {
        return guestPoints;
    }

    public void setGuestPoints(Integer guestPoints) {
        this.guestPoints = guestPoints;
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

    public String getGusesResult() {
        return gusesResult;
    }

    public void setGusesResult(String gusesResult) {
        this.gusesResult = gusesResult == null ? null : gusesResult.trim();
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win == null ? null : win.trim();
    }
}