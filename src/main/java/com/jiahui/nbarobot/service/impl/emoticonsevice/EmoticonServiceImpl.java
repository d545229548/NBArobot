package com.jiahui.nbarobot.service.impl.emoticonsevice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiahui.nbarobot.service.emoticonservice.EmoticonService;
import com.jiahui.nbarobot.utils.ShellUtil;
import org.springframework.stereotype.Service;


/**
 * @author didi
 */
@Service
public class EmoticonServiceImpl implements EmoticonService {

    @Override
    public String makeImg(String content,Integer id) {
        if(id == null){
            id = 60;
        }
        String param = "types=maker&id="+id+"&str1="+ content +"&str2=hei";
        String[] cmds = {"curl","--data-binary",param,"https://www.52doutu.cn/api/"};
        JSONObject jsonObject = JSON.parseObject(ShellUtil.execCurl(cmds));
        return jsonObject.getString("url");
    }



    public static void main(String[] args){
        EmoticonServiceImpl service = new EmoticonServiceImpl();

    }

}
