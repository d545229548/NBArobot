package com.jiahui.nbarobot.domain.seven;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongjiahui
 */
@NoArgsConstructor
@Data
public class SevenNbaMatchResult {


    /**
     * version : 2019-03-21
     * timestamp : 2019-03-22 13:34:53
     */

    private List<List<String>> contest;
    private List<List<String>> matchs;
}
