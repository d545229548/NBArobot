package com.jiahui.nbarobot.domain.dingding;

import com.alibaba.fastjson.JSON;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jiahui.dong
 * @date 2018/10/29
 */
public class TextMessage implements DingtalkMessage {

    private String text;
    private List<String> atMobiles;
    private boolean isAtAll;

    public TextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAtMobiles() {
        return this.atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public boolean isAtAll() {
        return this.isAtAll;
    }

    public void setIsAtAll(boolean isAtAll) {
        this.isAtAll = isAtAll;
    }

    @Override
    public String toJsonString() {
        HashMap items = new HashMap();
        items.put("msgtype", "text");
        Map<String, String> textContent = new HashMap();
        if(StringUtils.isBlank(this.text)) {
            throw new IllegalArgumentException("text should not be blank");
        } else {
            textContent.put("content", this.text);
            items.put("text", textContent);
            HashMap atItems = new HashMap();
            if(this.atMobiles != null && !this.atMobiles.isEmpty()) {
                atItems.put("atMobiles", this.atMobiles);
            }

            if(this.isAtAll) {
                atItems.put("isAtAll", Boolean.valueOf(this.isAtAll));
            }

            items.put("at", atItems);
            return JSON.toJSONString(items);
        }
    }
}
