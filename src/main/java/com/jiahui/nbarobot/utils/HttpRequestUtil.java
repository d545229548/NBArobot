package com.jiahui.nbarobot.utils;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.domain.utils.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author dongjiahui
 */
public class HttpRequestUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);
    private static String contType ="application/json;charset=UTF-8";
    private static String accept = "*/*";
    private static String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0)" +
            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36";



    public static String get(String url){
        String result= HttpRequest.get(url)
                .header("Content-Type",contType)
                .header("Accept",accept)
                .header("User-Agent",userAgent)
                .execute().body();
        logger.info("get接口 {} 的返回值为 {}",url,result);
        return result;

    }


    public static String post(String url,Map paramMap){
        String result= HttpRequest.post(url)
                .header("Content-Type",contType)
                .header("Accept",accept)
                .header("User-Agent",userAgent)
                .form(paramMap)
                .execute().body();
        logger.info("post接口 {} 的返回值为 {} 入参为 {}",url,result,paramMap.toString());
        return result;

    }

    /**
     * 爬取公共方法
     * @param url url
     * @param o 转换的javabean
     * @param type 1 get 2 post
     * @return 结果
     */
    public static ResultVO copy(String url, Object o,Integer type,Map paramMap){
        ResultVO resultVO = new ResultVO();
        String result;
        if(type == 1){
            result = HttpRequestUtil.get(url);
        }else {
            result = HttpRequestUtil.post(url,paramMap);
        }
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
