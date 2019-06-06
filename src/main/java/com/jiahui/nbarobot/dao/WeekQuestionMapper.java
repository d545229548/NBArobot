package com.jiahui.nbarobot.dao;

import com.jiahui.nbarobot.domain.WeekQuestion;

public interface WeekQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeekQuestion record);

    int insertSelective(WeekQuestion record);

    WeekQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeekQuestion record);

    int updateByPrimaryKey(WeekQuestion record);

    WeekQuestion selectLastQuestion();
}
