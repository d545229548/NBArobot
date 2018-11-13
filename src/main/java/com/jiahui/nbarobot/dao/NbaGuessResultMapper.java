package com.jiahui.nbarobot.dao;

import com.jiahui.nbarobot.domain.NbaGuessResult;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dongjiahui
 */
@Mapper
public interface NbaGuessResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NbaGuessResult record);

    int insertSelective(NbaGuessResult record);

    NbaGuessResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NbaGuessResult record);

    int updateByPrimaryKey(NbaGuessResult record);
}