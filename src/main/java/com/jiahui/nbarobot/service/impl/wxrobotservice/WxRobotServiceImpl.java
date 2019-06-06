package com.jiahui.nbarobot.service.impl.wxrobotservice;

import com.jiahui.nbarobot.domain.wx.WxBaseRequest;
import com.jiahui.nbarobot.utils.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dongjiahui
 */
public class WxRobotServiceImpl {

    private static Logger logger = LoggerFactory.getLogger(WxRobotServiceImpl.class);

    private static WxBaseRequest wx;

    private String getUuid(){
        String url = "https://login.weixin.qq.com/jslogin";
        Map paramMap = new HashMap(4);
        paramMap.put("appid","wx782c26e4c19acffb");
        paramMap.put("fun","new");
        paramMap.put("lang","zh_CN");
        paramMap.put("_",Long.toString(System.currentTimeMillis()));
        String result = HttpRequestUtil.post(url,paramMap);
        String code = this.findStr("window.QRLogin.code = (\\d+);", result);
        if(code != null && "200".equals(code)){
            return this.findStr("window.QRLogin.uuid = \"(.*)\";", result);
        }
        return null;
    }

    private String getQrCode(String uuid){
        String url = "https://login.weixin.qq.com/qrcode/" + uuid;
        return "";
    }

    private void checkLogin(String uuid){
        String url = "https://login.weixin.qq.com/cgi-bin/mmwebwx-bin/login?"
                +"tip=0&uuid=" + uuid + "&_=" + Long.toString(System.currentTimeMillis());
        String result = HttpRequestUtil.get(url);
        String redirectUrl = this.findStr("window.redirect_uri=\"(\\S+?)\";",result);
        if(redirectUrl == null || Objects.equals(redirectUrl, "")){
            logger.error("检测登录失败");
            return;
        }
        String baseResult = HttpRequestUtil.get(redirectUrl);
        wx = new WxBaseRequest();
        wx.setSkey(this.findStr("<skey>(\\S+)</skey>",baseResult));
        wx.setWxsid(this.findStr("<wxsid>(\\S+)</wxsid>",baseResult));
        wx.setWxuin(this.findStr("<wxuin>(\\S+)</wxuin>",baseResult));
        wx.setPassTicket(this.findStr("<pass_ticket>(\\S+)</pass_ticket>",baseResult));
    }

    private void wxInit(){

        if(wx == null){
           logger.error("检测未有登录数据");
           return;
        }
        String url = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit?pass_ticket="
                + wx.getPassTicket() + "&skey=" + wx.getSkey() + "&r=" + this.r();
        System.out.println(wx.toString());
        System.out.println(url);
        //生成设备号
        String deviceId = "e" + System.currentTimeMillis() + wx.getWxuin().substring(0, 2);
        String baseRequest1 = "{\"Uin\":\"" + wx.getWxuin() + "\",\"Sid\":\"" + wx.getWxsid() + "\"," + "\"Skey\":\""
                + wx.getSkey() + "\",\"DeviceID\":\"" + deviceId + "\"}";
        Map baseRequest = new HashMap(4);
        baseRequest.put("Uin",wx.getWxuin());
        baseRequest.put("Sid",wx.getWxsid());
        baseRequest.put("Skey",wx.getSkey());
        baseRequest.put("DeviceID",deviceId);
        Map paramJson = new HashMap(2);
        paramJson.put("BaseRequest",baseRequest1);
        String result = HttpRequestUtil.post(url,paramJson);
            try {
                Thread.sleep(3000);
                result = HttpRequestUtil.post(url,paramJson);
            }catch (Exception e){
                e.printStackTrace();
            }
        System.out.println(result);

    }





    private String findStr(String regex, String str) {
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * 取反时间戳
     * @return 时间戳
     */
    private String r() {
        // 转换成int后取反，因为js位运算只支持32位
        return Integer.toString(~((int) System.currentTimeMillis()));
    }

    public static void main(String[] args){
        WxRobotServiceImpl wxRobotService = new WxRobotServiceImpl();
        String uuid = wxRobotService.getUuid();
        wxRobotService.checkLogin(uuid);
        wxRobotService.wxInit();

    }

}
