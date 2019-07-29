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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        UserWinLoseInfo userWinLoseInfo = new UserWinLoseInfo();
        Map count = userWinLoseInfoMapper.getCount(userWinLoseInfo);
        List<String> sources = userWinLoseInfoMapper.getAllSource();
        Map<String,String> sourceAmt = new HashMap<>();
        Map<String,String> sourceWinPer = new HashMap<>();

        for(String source :sources){
            AmountDTO s;
            userWinLoseInfo.setSource(source);
            Map<String,String> sourceCount = userWinLoseInfoMapper.getCount(userWinLoseInfo);
            s = calculate(sourceCount);
            sourceAmt.put(source,s.getWinAmount().toString());
            sourceWinPer.put(source,s.getWinPer());
        }

        amountVO.setSourceAmt(sourceAmt);
        amountVO.setSourceWinPer(sourceWinPer);



        List<UserWinLoseInfo> weekLogs = userWinLoseInfoMapper.getByDate(DateUtil.getFirstDayOfWeek(new Date()),new Date());
        List<UserWinLoseInfo> monthsLogs = userWinLoseInfoMapper.getByDate(DateUtil.getCurrentMonthFirstDay(),new Date());
        List<UserWinLoseInfo> lastFiveLogs = userWinLoseInfoMapper.getLastLogs(5);
        amountVO.setLogs(lastFiveLogs);
        AmountDTO all = calculate(count);
        AmountDTO week = calculate(weekLogs);
        AmountDTO months = calculate(monthsLogs);
        amountVO.setWinAmount(all.getWinAmount());
        amountVO.setWinPer(all.getWinPer());
        amountVO.setWeekWinAmount(week.getWinAmount());
        amountVO.setWeekWinPer(week.getWinPer());
        amountVO.setMonthsWinAmount(months.getWinAmount());
        amountVO.setMonthsWinPer(months.getWinPer());
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
        String result;
        if(logs.size() == 0){
            result = "0.0";
        }else {
            result = numberFormat.format((float)win/(float)logs.size()*100);
        }

        amountDTO.setWinPer(result+"%");
        return amountDTO;

    }

    private AmountDTO calculate(Map count){
        AmountDTO amountDTO = new AmountDTO();
        amountDTO.setWinAmount((Double)(count.get("amt")));
        //取百分比
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);

        Integer win =Integer.parseInt(count.get("win").toString());
        Integer lost = Integer.parseInt(count.get("lost").toString());
        Integer total = win + lost;
        amountDTO.setWinPer(String.format("%s %% (%d/%d)",numberFormat.format((float)win/(float)total*100),win,lost));
        return amountDTO;
    }



}
