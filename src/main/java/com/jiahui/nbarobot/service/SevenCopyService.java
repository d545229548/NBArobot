package com.jiahui.nbarobot.service;

/**
 * @author dongjiahui
 * 7m比分网数据爬取，效果比网易好
 */
public interface SevenCopyService {

    /**
     * 爬取比赛赛果
     * @param date 日期
     */
    void copyMatchResult(String date);


    /**
     * 爬取比赛初盘
     * @param date 日期
     */
    void copyMatchStart(String date);
}
