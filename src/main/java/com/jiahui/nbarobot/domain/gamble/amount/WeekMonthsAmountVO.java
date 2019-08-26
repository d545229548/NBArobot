package com.jiahui.nbarobot.domain.gamble.amount;

import lombok.Data;

/**
 * @author dongjiahui
 * 最近五周记录
 * 最近五月记录
 */
@Data
public class WeekMonthsAmountVO {

    /**
    本周赢额
     */
    private Double weekWinAmount;

    private String weekPer;

    private Double lastOneWeekAmount;

    private String lastOneWeekPer;

    private Double lastTwoWeekAmount;

    private String lastTwoWeekPer;

    private Double lastThreeWeekAmount;

    private String lastThreeWeekPer;

    private Double lastFourWeekAmount;

    private String lastFourWeekPer;

    private Double monthsWinAmount;

    private String monthsWinPer;

    private Double lastOneMonthsAmount;

    private String lastOneMonthsPer;

    private Double lastTwoMonthsAmount;

    private String lastTwoMonthsPer;

    private Double lastThreeMonthsAmount;

    private String lastThreeMonthsPer;

    private Double lastFourMonthsAmount;

    private String lastFourMonthsPer;

}
