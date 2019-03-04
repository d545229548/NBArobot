package com.jiahui.nbarobot.domain.netease;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongjiahui
 */
@NoArgsConstructor
@Data
public class NeteaseNbaMatchReport {

    /**
     * code : 200
     * data : {"event":{"guestEvent":[{"title":"明尼苏达森林狼最近八场比赛赢下了六场比赛盘口，盘路表现出色","upDown":0,"url":""},{"title":"明尼苏达森林狼连续九场比赛得分超过110分，进攻表现出色且稳定","upDown":0,"url":""},{"title":"明尼苏达森林狼上场比赛不敌步行者，遭遇连败","upDown":1,"url":""},{"title":"明尼苏达森林狼本赛季客场仅赢下过九场，比起球队出色的主场表现，客战表现的不佳是制约球队战绩排名提升的主要原因","upDown":1,"url":""},{"title":"明尼苏达森林狼目前距离西部第八名已经有五个胜场的差距，晋级季后赛的希望已经越来越渺茫","upDown":1,"url":""}],"homeEvent":[{"title":"华盛顿奇才本赛季主场胜率接近七成，主场表现尚可","upDown":0,"url":""},{"title":"华盛顿奇才最近六次主场面对森林狼赢下了四次，面对对手主场优势还是较为明显","upDown":0,"url":""},{"title":"华盛顿奇才上场比赛不敌凯尔特人，最近六场比赛输掉了五场","upDown":1,"url":""},{"title":"华盛顿奇才最近四场比赛输掉了三场比赛盘口，盘路表现不佳","upDown":1,"url":""},{"title":"华盛顿奇才本赛季场均失分超过117分，球队防守能力糟糕","upDown":1,"url":""}]},"injure":{"guestInjure":[{"onPlay":"未知能否上阵","part":"跟腱","playerId":2073,"playerName":"罗尔-邓","position":"小前锋"},{"onPlay":"预计缺阵","part":"足踝","playerId":13040,"playerName":"罗伯特-科温顿","position":"小前锋"}],"homeInjure":[{"onPlay":"预计缺阵","part":"背部","playerId":2068,"playerName":"德怀特-霍华德","position":"中锋"},{"onPlay":"赛季报销","part":"脚部","playerId":11127,"playerName":"约翰-沃尔","position":"控球后卫"}]},"matchBaseInfo":{"guestTeamId":182,"guestTeamName":"森林狼","homeTeamId":153,"homeTeamName":"奇才","lotteryCategoryId":2,"matchInfoId":351902},"matchInfoId":351902}
     * message : 操作成功
     */

    private int code;
    private DataBean data;
    private String message;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * event : {"guestEvent":[{"title":"明尼苏达森林狼最近八场比赛赢下了六场比赛盘口，盘路表现出色","upDown":0,"url":""},{"title":"明尼苏达森林狼连续九场比赛得分超过110分，进攻表现出色且稳定","upDown":0,"url":""},{"title":"明尼苏达森林狼上场比赛不敌步行者，遭遇连败","upDown":1,"url":""},{"title":"明尼苏达森林狼本赛季客场仅赢下过九场，比起球队出色的主场表现，客战表现的不佳是制约球队战绩排名提升的主要原因","upDown":1,"url":""},{"title":"明尼苏达森林狼目前距离西部第八名已经有五个胜场的差距，晋级季后赛的希望已经越来越渺茫","upDown":1,"url":""}],"homeEvent":[{"title":"华盛顿奇才本赛季主场胜率接近七成，主场表现尚可","upDown":0,"url":""},{"title":"华盛顿奇才最近六次主场面对森林狼赢下了四次，面对对手主场优势还是较为明显","upDown":0,"url":""},{"title":"华盛顿奇才上场比赛不敌凯尔特人，最近六场比赛输掉了五场","upDown":1,"url":""},{"title":"华盛顿奇才最近四场比赛输掉了三场比赛盘口，盘路表现不佳","upDown":1,"url":""},{"title":"华盛顿奇才本赛季场均失分超过117分，球队防守能力糟糕","upDown":1,"url":""}]}
         * injure : {"guestInjure":[{"onPlay":"未知能否上阵","part":"跟腱","playerId":2073,"playerName":"罗尔-邓","position":"小前锋"},{"onPlay":"预计缺阵","part":"足踝","playerId":13040,"playerName":"罗伯特-科温顿","position":"小前锋"}],"homeInjure":[{"onPlay":"预计缺阵","part":"背部","playerId":2068,"playerName":"德怀特-霍华德","position":"中锋"},{"onPlay":"赛季报销","part":"脚部","playerId":11127,"playerName":"约翰-沃尔","position":"控球后卫"}]}
         * matchBaseInfo : {"guestTeamId":182,"guestTeamName":"森林狼","homeTeamId":153,"homeTeamName":"奇才","lotteryCategoryId":2,"matchInfoId":351902}
         * matchInfoId : 351902
         */

        private EventBean event;
        private InjureBean injure;
        private MatchBaseInfoBean matchBaseInfo;
        private int matchInfoId;

        @NoArgsConstructor
        @Data
        public static class EventBean {
            private List<GuestEventBean> guestEvent;
            private List<HomeEventBean> homeEvent;

            @NoArgsConstructor
            @Data
            public static class GuestEventBean {
                /**
                 * title : 明尼苏达森林狼最近八场比赛赢下了六场比赛盘口，盘路表现出色
                 * upDown : 0
                 * url :
                 */

                private String title;
                private int upDown;
                private String url;
            }

            @NoArgsConstructor
            @Data
            public static class HomeEventBean {
                /**
                 * title : 华盛顿奇才本赛季主场胜率接近七成，主场表现尚可
                 * upDown : 0
                 * url :
                 */

                private String title;
                private int upDown;
                private String url;
            }
        }

        @NoArgsConstructor
        @Data
        public static class InjureBean {
            private List<GuestInjureBean> guestInjure;
            private List<HomeInjureBean> homeInjure;

            @NoArgsConstructor
            @Data
            public static class GuestInjureBean {
                /**
                 * onPlay : 未知能否上阵
                 * part : 跟腱
                 * playerId : 2073
                 * playerName : 罗尔-邓
                 * position : 小前锋
                 */

                private String onPlay;
                private String part;
                private int playerId;
                private String playerName;
                private String position;
            }

            @NoArgsConstructor
            @Data
            public static class HomeInjureBean {
                /**
                 * onPlay : 预计缺阵
                 * part : 背部
                 * playerId : 2068
                 * playerName : 德怀特-霍华德
                 * position : 中锋
                 */

                private String onPlay;
                private String part;
                private int playerId;
                private String playerName;
                private String position;
            }
        }

        @NoArgsConstructor
        @Data
        public static class MatchBaseInfoBean {
            /**
             * guestTeamId : 182
             * guestTeamName : 森林狼
             * homeTeamId : 153
             * homeTeamName : 奇才
             * lotteryCategoryId : 2
             * matchInfoId : 351902
             */

            private int guestTeamId;
            private String guestTeamName;
            private int homeTeamId;
            private String homeTeamName;
            private int lotteryCategoryId;
            private int matchInfoId;
        }
    }
}
