package com.jiahui.nbarobot.service.gambleservice.amount;

import com.jiahui.nbarobot.domain.gamble.amount.AmountVO;
import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import com.jiahui.nbarobot.domain.gamble.amount.WeekMonthsAmountVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongjiahui
 */
public interface GableAmountService {

    /**
     * 添加盈亏记录
     * @param info 记录
     * @return 结果
     */
    int addLog(UserWinLoseInfo info);


    /**
     * 获取统计结果
     * @return 结果
     */
    AmountVO getAmount();

    /**
     * 根据姓名获取周、月记录
     * @param nick 姓名
     * @return 结果
     */
    WeekMonthsAmountVO getWeekMouthsLogs(String nick);


}
