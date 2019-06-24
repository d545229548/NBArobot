package com.jiahui.nbarobot.dao.gamble.amount;

import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;

public interface UserWinLoseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWinLoseInfo record);

    int insertSelective(UserWinLoseInfo record);

    UserWinLoseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWinLoseInfo record);

    int updateByPrimaryKey(UserWinLoseInfo record);
}