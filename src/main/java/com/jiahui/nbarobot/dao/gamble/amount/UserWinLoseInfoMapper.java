package com.jiahui.nbarobot.dao.gamble.amount;

import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author dongjiahui
 */
public interface UserWinLoseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWinLoseInfo record);

    int insertSelective(UserWinLoseInfo record);

    UserWinLoseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWinLoseInfo record);

    int updateByPrimaryKey(UserWinLoseInfo record);

    List<UserWinLoseInfo> getAllLogs();

    List<UserWinLoseInfo> getLastLogs(Integer n);

    List<UserWinLoseInfo> getByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    Map<String,String> getCount(UserWinLoseInfo record);

    List<String> getAllSource();
}
