package com.jiahui.nbarobot.service;


import com.jiahui.nbarobot.domain.utils.ResultVO;

/**
 * @author dongjiahui
 */
public interface NbaDataCopyService {

    /**
     * 爬取网易数据比赛数据进数据库
     * @param url 比赛数据url
     *            1. 目前区分比赛开始数据 和 比赛结果数据
     * @return 爬去结果
     */
    ResultVO copyNeteaseNbaMath(String url);

    /**
     * 爬取网易NBA比赛结果
     * @return ResultVO
     */
    ResultVO copyNeteaseNbaResultMath();

    /**
     * 爬取网易NBA比赛初始值及盘口
     * @return ResultVO
     */
    ResultVO copyNeteaseNbaStartMath();

}
