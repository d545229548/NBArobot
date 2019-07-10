package com.jiahui.nbarobot.domain.gamble.amount;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author dongjiahui
 */
@Data
public class AmountVO {

    /**
     * 最近五笔盈亏记录
     */
    private List<UserWinLoseInfo> logs;

    private Double winAmount;

    private String winPer;

    private Double weekWinAmount;

    private String weekWinPer;

    private Double monthsWinAmount;

    private String monthsWinPer;

    private String message;

    private Map<String,String> sourceAmt;

    private Map<String,String> sourceWinPer;


}
