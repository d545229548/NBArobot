package com.jiahui.nbarobot.service.impl.emoticonsevice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiahui.nbarobot.service.emoticonservice.EmoticonService;
import com.jiahui.nbarobot.utils.HttpRequestUtil;
import com.jiahui.nbarobot.utils.ShellUtil;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author didi
 */
@Service
public class EmoticonServiceImpl implements EmoticonService {

    @Override
    public String makeImg(String content) {
        String param = "types=maker&id=60&str1="+ content +"&str2=hei";
        String[] cmds = {"curl","--data-binary",param,"https://www.52doutu.cn/api/"};
        JSONObject jsonObject = JSON.parseObject(ShellUtil.execCurl(cmds));
        return jsonObject.getString("url");
    }



    public static void main(String[] args){
        EmoticonServiceImpl service = new EmoticonServiceImpl();
        System.out.println(service.makeImg(""));
    }

}
