package com.jiahui.nbarobot.domain.dingding;

import lombok.Data;

/**
 * @author dongjiahui
 */
@Data
public class CallbackRequest {
    /**
     * msgtype : text
     * text : {"content":"我就是我, 是不一样的烟火"}
     * createAt : 1487561654123
     * conversationType : 2
     * conversationId : 12345
     * conversationTitle : 钉钉群
     * senderId : dingtalk1235
     * senderNick : 星星
     * senderStaffId : 075263
     * isAdmin : false
     * context : 用户自定义上下文
     * chatbotCorpId : test
     * chatbotUserId : XXX
     */

    private String msgtype;
    private TextBean text;
    private Long createAt;
    private Integer conversationType;
    private String conversationId;
    private String conversationTitle;
    private String senderId;
    private String senderNick;
    private String senderStaffId;
    private Boolean isAdmin;
    private String context;
    private String chatbotCorpId;
    private String chatbotUserId;

    @Data
    public static class TextBean {
        /**
         * content : 我就是我, 是不一样的烟火
         */

        private String content;

    }



}
