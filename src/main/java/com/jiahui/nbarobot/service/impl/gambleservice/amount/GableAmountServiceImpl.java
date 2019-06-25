package com.jiahui.nbarobot.service.impl.gambleservice.amount;

import com.jiahui.nbarobot.dao.gamble.amount.UserWinLoseInfoMapper;
import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import com.jiahui.nbarobot.service.gambleservice.amount.GableAmountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dongjiahui
 */
@Service(value = " GableAmountService")
public class GableAmountServiceImpl implements GableAmountService{

    @Resource
    UserWinLoseInfoMapper userWinLoseInfoMapper;

    @Override
    public int addLog(UserWinLoseInfo info){
        return userWinLoseInfoMapper.insertSelective(info);
    }


}
