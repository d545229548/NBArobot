package com.jiahui.nbarobot.dao;

import com.jiahui.nbarobot.domain.NbaGuess;

/**
 * @author dongjiahui
 */
public interface NbaGuessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NbaGuess record);

    int insertSelective(NbaGuess record);

    NbaGuess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NbaGuess record);

    int updateByPrimaryKey(NbaGuess record);
}