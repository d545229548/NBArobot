package com.jiahui.nbarobot.service.gambleservice.amount;

import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import org.springframework.stereotype.Service;

/**
 * @author dongjiahui
 */
public interface GableAmountService {

    int addLog(UserWinLoseInfo info);
}
