package com.jiahui.nbarobot.service.impl.gambleservice.amount;

import com.jiahui.nbarobot.dao.gamble.amount.UserWinLoseInfoMapper;
import com.jiahui.nbarobot.domain.gamble.amount.AmountDTO;
import com.jiahui.nbarobot.domain.gamble.amount.AmountVO;
import com.jiahui.nbarobot.domain.gamble.amount.UserWinLoseInfo;
import com.jiahui.nbarobot.service.gambleservice.amount.GableAmountService;
import com.jiahui.nbarobot.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public AmountVO getAmount(){
        AmountVO amountVO = new AmountVO();
        List<UserWinLoseInfo> allLogs = userWinLoseInfoMapper.getAllLogs();
        List<UserWinLoseInfo> weekLogs = userWinLoseInfoMapper.getByDate(DateUtil.getFirstDayOfWeek(new Date()),new Date());
        List<UserWinLoseInfo> monthsLogs = userWinLoseInfoMapper.getByDate(DateUtil.getCurrentMonthFirstDay(),new Date());
        List<UserWinLoseInfo> lastFiveLogs = userWinLoseInfoMapper.getLastLogs(5);
        amountVO.setLogs(lastFiveLogs);
        amountVO.setWinAmount(calculate(allLogs).getWinAmount());
        amountVO.setWinPer(calculate(allLogs).getWinPer());
        amountVO.setWeekWinAmount(calculate(weekLogs).getWinAmount());
        amountVO.setWeekWinPer(calculate(weekLogs).getWinPer());
        amountVO.setMonthsWinAmount(calculate(monthsLogs).getWinAmount());
        amountVO.setMonthsWinPer(calculate(monthsLogs).getWinPer());
        return amountVO;
    }

    /**
     * 计算胜率，金额
     * @return 结果
     */
    private AmountDTO calculate(List<UserWinLoseInfo> logs){
        Double amount = 0.0;
        Integer win = 0;
        for(UserWinLoseInfo log:logs){
            amount += log.getAmt();
            if("win".equals(log.getResult())){
                win += 1;
            }
        }
        AmountDTO amountDTO = new AmountDTO();
        amountDTO.setWinAmount(amount);
        //取百分比
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float)win/(float)logs.size()*100);

        amountDTO.setWinPer(result+"%");
        return amountDTO;

    }



}
