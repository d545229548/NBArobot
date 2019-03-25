package com.jiahui.nbarobot.domain.seven;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongjiahui
 */
@NoArgsConstructor
@Data
public class SevenNbaMatchOdds {


    /**
     * version : 2019-03-21
     * com : 1
     * timestamp : 2019-03-22 16:29:59
     */

    private String com;
    private List<List<String>> odds;
}
