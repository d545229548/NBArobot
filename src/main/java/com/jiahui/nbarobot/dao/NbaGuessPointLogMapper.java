package com.jiahui.nbarobot.dao;

import com.jiahui.nbarobot.domain.NbaGuessPointLog;

/**
 * @author dongjiahui
 */
public interface NbaGuessPointLogMapper {
    int insert(NbaGuessPointLog record);

    int insertSelective(NbaGuessPointLog record);
}