package com.jiahui.nbarobot.service;


import com.jiahui.nbarobot.domain.utils.ResultVO;

/**
 * @author dongjiahui
 */
public interface NbaDataCopyService {

    /**
     * 爬取网易数据数据进数据库
     * @return 1 爬取成功 0 爬取失败
     */
    ResultVO copyNeteaseNbaMath();

}
