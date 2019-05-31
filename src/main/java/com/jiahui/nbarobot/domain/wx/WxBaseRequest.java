package com.jiahui.nbarobot.domain.wx;

import lombok.Data;

/**
 * 微信登录返回的基本信息
 */
@Data
public class WxBaseRequest {


    String skey;

    String wxsid;

    String wxuin;

    String passTicket;

    String isgrayscale;
}
