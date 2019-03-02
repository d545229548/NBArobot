package com.jiahui.nbarobot.domain.utils;

import lombok.Data;

/**
 * @author dongjiahui
 */
@Data
public class ResultVO<T> {

    /**
     * 返回值code
     */
    private Integer code;

    private Boolean success;

    private T data;

    private String message;

}
