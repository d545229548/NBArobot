package com.jiahui.nbarobot.utils;

import cn.hutool.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dongjiahui
 */
public class HttpRequestUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    public static String get(String url){
        String result= HttpRequest.get(url)
                .header("Content-Type","application/json;charset=UTF-8")
                .header("Accept","*/*")
                .header("User-Agent","RelotteryApp/6.8.0 iOS/12.1.2 (iPhone X)")
                .execute().body();
        logger.info("接口 {} 的返回值为 {}",url,result);
        return result;

    }
}
