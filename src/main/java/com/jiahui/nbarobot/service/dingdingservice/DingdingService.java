package com.jiahui.nbarobot.service.dingdingservice;

import com.jiahui.nbarobot.domain.dingding.CallbackRequest;
import com.jiahui.nbarobot.domain.dingding.DingtalkMessage;

public interface DingdingService {


    /**
     * 通过发送的语言分析意图，然后回消息
     * 取名ai
     * @return 钉钉消息接口
     */
    DingtalkMessage ai(CallbackRequest request);
}
