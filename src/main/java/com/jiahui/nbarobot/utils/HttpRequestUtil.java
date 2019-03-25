package com.jiahui.nbarobot.utils;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.domain.utils.ResultVO;
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

    /**
     * 爬取公共方法
     * @param url url
     * @param o 转换的javabean
     * @return 结果
     */
    public static ResultVO copy(String url, Object o){
        ResultVO resultVO = new ResultVO();

        String result = HttpRequestUtil.get(url);
        //将json系列成javabean
        try {
            o = JSON.parseObject(result,o.getClass());
            resultVO.setSuccess(true);
            resultVO.setMessage("系列化成功");
            resultVO.setData(o);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(url + "接口系列化错误");
            resultVO.setSuccess(false);
            resultVO.setMessage("接口系列化错误");
            return resultVO;
        }
        if(o == null){
            resultVO.setSuccess(false);
            resultVO.setMessage("接口返回错误");
        }
        return resultVO;
    }
}
