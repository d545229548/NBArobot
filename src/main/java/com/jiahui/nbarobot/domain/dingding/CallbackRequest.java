package com.jiahui.nbarobot.domain.dingding;

/**
 * @author dongjiahui
 */
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
    private long createAt;
    private int conversationType;
    private String conversationId;
    private String conversationTitle;
    private String senderId;
    private String senderNick;
    private String senderStaffId;
    private boolean isAdmin;
    private String context;
    private String chatbotCorpId;
    private String chatbotUserId;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public TextBean getText() {
        return text;
    }

    public void setText(TextBean text) {
        this.text = text;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public int getConversationType() {
        return conversationType;
    }

    public void setConversationType(int conversationType) {
        this.conversationType = conversationType;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationTitle() {
        return conversationTitle;
    }

    public void setConversationTitle(String conversationTitle) {
        this.conversationTitle = conversationTitle;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderNick() {
        return senderNick;
    }

    public void setSenderNick(String senderNick) {
        this.senderNick = senderNick;
    }

    public String getSenderStaffId() {
        return senderStaffId;
    }

    public void setSenderStaffId(String senderStaffId) {
        this.senderStaffId = senderStaffId;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getChatbotCorpId() {
        return chatbotCorpId;
    }

    public void setChatbotCorpId(String chatbotCorpId) {
        this.chatbotCorpId = chatbotCorpId;
    }

    public String getChatbotUserId() {
        return chatbotUserId;
    }

    public void setChatbotUserId(String chatbotUserId) {
        this.chatbotUserId = chatbotUserId;
    }

    public static class TextBean {
        /**
         * content : 我就是我, 是不一样的烟火
         */

        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    @Override
    public String toString() {
        return "CallbackRequest{" +
                "msgtype='" + msgtype + '\'' +
                ", text=" + text +
                ", createAt=" + createAt +
                ", conversationType=" + conversationType +
                ", conversationId='" + conversationId + '\'' +
                ", conversationTitle='" + conversationTitle + '\'' +
                ", senderId='" + senderId + '\'' +
                ", senderNick='" + senderNick + '\'' +
                ", senderStaffId='" + senderStaffId + '\'' +
                ", isAdmin=" + isAdmin +
                ", context='" + context + '\'' +
                ", chatbotCorpId='" + chatbotCorpId + '\'' +
                ", chatbotUserId='" + chatbotUserId + '\'' +
                '}';
    }

}
