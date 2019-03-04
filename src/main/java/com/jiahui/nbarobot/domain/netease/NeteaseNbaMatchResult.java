package com.jiahui.nbarobot.domain.netease;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongjiahui
 */
@Data
public class NeteaseNbaMatchResult {


    /**
     * code : 200
     * data : {"matchCount":10,"matchList":[{"favPushStatus":1,"guestScore":108,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_11.jpg","teamId":214,"teamName":"76人"},"hasFilterOdds":2,"hasLive":0,"homeScore":104,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_17.jpg","teamId":161,"teamName":"雷霆"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350345,"matchStatus":3,"matchTime":"09:00","play":{"concede":"-7.5","playCode":"HHDA","playId":93117,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236490,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236489,"playItemName":"主"}]},"refund":0,"threadCount":19,"time":1551402000000},{"favPushStatus":1,"guestScore":118,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_10.jpg","teamId":157,"teamName":"热火"},"hasFilterOdds":2,"hasLive":0,"homeScore":121,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_28.jpg","teamId":135,"teamName":"火箭"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350344,"matchStatus":3,"matchTime":"09:00","play":{"concede":"-9.5","playCode":"HHDA","playId":93123,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236502,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236501,"playItemName":"主"}]},"refund":0,"threadCount":18,"time":1551402000000},{"favPushStatus":1,"guestScore":96,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_25.jpg","teamId":130,"teamName":"勇士"},"hasFilterOdds":2,"hasLive":0,"homeScore":103,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_15.jpg","teamId":210,"teamName":"魔术"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350341,"matchStatus":3,"matchTime":"08:00","play":{"concede":"6.5","playCode":"HHDA","playId":93114,"playItemList":[{"odds":1.76,"playItemCode":"L","playItemId":236484,"playItemName":"客"},{"odds":1.64,"playItemCode":"W","playItemId":236483,"playItemName":"主"}]},"refund":0,"threadCount":22,"time":1551398400000},{"favPushStatus":1,"guestScore":115,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_18.jpg","teamId":182,"teamName":"森林狼"},"hasFilterOdds":2,"hasLive":0,"homeScore":122,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_13.jpg","teamId":205,"teamName":"步行者"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350340,"matchStatus":3,"matchTime":"08:00","play":{"concede":"-3.5","playCode":"HHDA","playId":93120,"playItemList":[{"odds":1.76,"playItemCode":"L","playItemId":236496,"playItemName":"客"},{"odds":1.64,"playItemCode":"W","playItemId":236495,"playItemName":"主"}]},"refund":0,"threadCount":19,"time":1551398400000},{"favPushStatus":1,"guestScore":99,"guestTeam":{"teamIcon":"https://nos.netease.com/relottery/match/basketball/2_71.jpg","teamId":206,"teamName":"帕纳辛纳科斯"},"hasFilterOdds":2,"hasLive":0,"homeScore":80,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_773.jpg","teamId":1582,"teamName":"格兰卡纳"},"leagueMatch":{"leagueId":91,"leagueName":"EURO"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350334,"matchStatus":3,"matchTime":"04:00","play":{"concede":"5.5","playCode":"HHDA","playId":93111,"playItemList":[{"odds":1.64,"playItemCode":"L","playItemId":236478,"playItemName":"客"},{"odds":1.76,"playItemCode":"W","playItemId":236477,"playItemName":"主"}]},"refund":0,"threadCount":2,"time":1551384000000},{"favPushStatus":1,"guestScore":66,"guestTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_59.jpg","teamId":208,"teamName":"伊斯坦布尔埃菲斯"},"hasFilterOdds":2,"hasLive":0,"homeScore":84,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_70.jpg","teamId":299,"teamName":"费内巴切"},"leagueMatch":{"leagueId":91,"leagueName":"EURO"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350329,"matchStatus":3,"matchTime":"01:45","play":{"concede":"-8.5","playCode":"HHDA","playId":93108,"playItemList":[{"odds":1.76,"playItemCode":"L","playItemId":236472,"playItemName":"客"},{"odds":1.64,"playItemCode":"W","playItemId":236471,"playItemName":"主"}]},"refund":0,"threadCount":3,"time":1551375900000},{"favPushStatus":1,"guestScore":105,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_24.jpg","teamId":141,"teamName":"快船"},"hasFilterOdds":2,"hasLive":0,"homeScore":111,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_21.jpg","teamId":101,"teamName":"爵士"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350082,"matchStatus":3,"matchTime":"10:00","play":{"concede":"-9.5","playCode":"HHDA","playId":93096,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236448,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236447,"playItemName":"主"}]},"refund":0,"threadCount":18,"time":1551319200000},{"favPushStatus":1,"guestScore":101,"guestTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_13.jpg","teamId":205,"teamName":"步行者"},"hasFilterOdds":2,"hasLive":0,"homeScore":110,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_27.jpg","teamId":117,"teamName":"独行侠"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350081,"matchStatus":3,"matchTime":"09:30","play":{"concede":"1.5","playCode":"HHDA","playId":93099,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236454,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236453,"playItemName":"主"}]},"refund":0,"threadCount":21,"time":1551317400000},{"favPushStatus":1,"guestScore":97,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_20.jpg","teamId":102,"teamName":"开拓者"},"hasFilterOdds":2,"hasLive":0,"homeScore":92,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_3.jpg","teamId":140,"teamName":"凯尔特人"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350079,"matchStatus":3,"matchTime":"09:00","play":{"concede":"-2.5","playCode":"HHDA","playId":93093,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236442,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236441,"playItemName":"主"}]},"refund":0,"threadCount":21,"time":1551315600000},{"favPushStatus":1,"guestScore":125,"guestTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_16.jpg","teamId":153,"teamName":"奇才"},"hasFilterOdds":2,"hasLive":0,"homeScore":116,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_5.jpg","teamId":176,"teamName":"篮网"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350076,"matchStatus":3,"matchTime":"08:30","play":{"concede":"-5.5","playCode":"HHDA","playId":93090,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236436,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236435,"playItemName":"主"}]},"refund":0,"threadCount":18,"time":1551313800000}]}
     * message : 操作成功
     */

    private int code;
    private DataBean data;
    private String message;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * matchCount : 10
         * matchList : [{"favPushStatus":1,"guestScore":108,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_11.jpg","teamId":214,"teamName":"76人"},"hasFilterOdds":2,"hasLive":0,"homeScore":104,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_17.jpg","teamId":161,"teamName":"雷霆"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350345,"matchStatus":3,"matchTime":"09:00","play":{"concede":"-7.5","playCode":"HHDA","playId":93117,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236490,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236489,"playItemName":"主"}]},"refund":0,"threadCount":19,"time":1551402000000},{"favPushStatus":1,"guestScore":118,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_10.jpg","teamId":157,"teamName":"热火"},"hasFilterOdds":2,"hasLive":0,"homeScore":121,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_28.jpg","teamId":135,"teamName":"火箭"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350344,"matchStatus":3,"matchTime":"09:00","play":{"concede":"-9.5","playCode":"HHDA","playId":93123,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236502,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236501,"playItemName":"主"}]},"refund":0,"threadCount":18,"time":1551402000000},{"favPushStatus":1,"guestScore":96,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_25.jpg","teamId":130,"teamName":"勇士"},"hasFilterOdds":2,"hasLive":0,"homeScore":103,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_15.jpg","teamId":210,"teamName":"魔术"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350341,"matchStatus":3,"matchTime":"08:00","play":{"concede":"6.5","playCode":"HHDA","playId":93114,"playItemList":[{"odds":1.76,"playItemCode":"L","playItemId":236484,"playItemName":"客"},{"odds":1.64,"playItemCode":"W","playItemId":236483,"playItemName":"主"}]},"refund":0,"threadCount":22,"time":1551398400000},{"favPushStatus":1,"guestScore":115,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_18.jpg","teamId":182,"teamName":"森林狼"},"hasFilterOdds":2,"hasLive":0,"homeScore":122,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_13.jpg","teamId":205,"teamName":"步行者"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350340,"matchStatus":3,"matchTime":"08:00","play":{"concede":"-3.5","playCode":"HHDA","playId":93120,"playItemList":[{"odds":1.76,"playItemCode":"L","playItemId":236496,"playItemName":"客"},{"odds":1.64,"playItemCode":"W","playItemId":236495,"playItemName":"主"}]},"refund":0,"threadCount":19,"time":1551398400000},{"favPushStatus":1,"guestScore":99,"guestTeam":{"teamIcon":"https://nos.netease.com/relottery/match/basketball/2_71.jpg","teamId":206,"teamName":"帕纳辛纳科斯"},"hasFilterOdds":2,"hasLive":0,"homeScore":80,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_773.jpg","teamId":1582,"teamName":"格兰卡纳"},"leagueMatch":{"leagueId":91,"leagueName":"EURO"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350334,"matchStatus":3,"matchTime":"04:00","play":{"concede":"5.5","playCode":"HHDA","playId":93111,"playItemList":[{"odds":1.64,"playItemCode":"L","playItemId":236478,"playItemName":"客"},{"odds":1.76,"playItemCode":"W","playItemId":236477,"playItemName":"主"}]},"refund":0,"threadCount":2,"time":1551384000000},{"favPushStatus":1,"guestScore":66,"guestTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_59.jpg","teamId":208,"teamName":"伊斯坦布尔埃菲斯"},"hasFilterOdds":2,"hasLive":0,"homeScore":84,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_70.jpg","teamId":299,"teamName":"费内巴切"},"leagueMatch":{"leagueId":91,"leagueName":"EURO"},"lotteryCategoryId":2,"matchDate":"03/01","matchInfoId":350329,"matchStatus":3,"matchTime":"01:45","play":{"concede":"-8.5","playCode":"HHDA","playId":93108,"playItemList":[{"odds":1.76,"playItemCode":"L","playItemId":236472,"playItemName":"客"},{"odds":1.64,"playItemCode":"W","playItemId":236471,"playItemName":"主"}]},"refund":0,"threadCount":3,"time":1551375900000},{"favPushStatus":1,"guestScore":105,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_24.jpg","teamId":141,"teamName":"快船"},"hasFilterOdds":2,"hasLive":0,"homeScore":111,"homeTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_21.jpg","teamId":101,"teamName":"爵士"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350082,"matchStatus":3,"matchTime":"10:00","play":{"concede":"-9.5","playCode":"HHDA","playId":93096,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236448,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236447,"playItemName":"主"}]},"refund":0,"threadCount":18,"time":1551319200000},{"favPushStatus":1,"guestScore":101,"guestTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_13.jpg","teamId":205,"teamName":"步行者"},"hasFilterOdds":2,"hasLive":0,"homeScore":110,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_27.jpg","teamId":117,"teamName":"独行侠"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350081,"matchStatus":3,"matchTime":"09:30","play":{"concede":"1.5","playCode":"HHDA","playId":93099,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236454,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236453,"playItemName":"主"}]},"refund":0,"threadCount":21,"time":1551317400000},{"favPushStatus":1,"guestScore":97,"guestTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_20.jpg","teamId":102,"teamName":"开拓者"},"hasFilterOdds":2,"hasLive":0,"homeScore":92,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_3.jpg","teamId":140,"teamName":"凯尔特人"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350079,"matchStatus":3,"matchTime":"09:00","play":{"concede":"-2.5","playCode":"HHDA","playId":93093,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236442,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236441,"playItemName":"主"}]},"refund":0,"threadCount":21,"time":1551315600000},{"favPushStatus":1,"guestScore":125,"guestTeam":{"teamIcon":"https://relottery.nosdn.127.net/match/basketball/2_16.jpg","teamId":153,"teamName":"奇才"},"hasFilterOdds":2,"hasLive":0,"homeScore":116,"homeTeam":{"teamIcon":"https://relottery.ws.126.net/match/basketball/2_5.jpg","teamId":176,"teamName":"篮网"},"leagueMatch":{"leagueId":83,"leagueName":"NBA"},"lotteryCategoryId":2,"matchDate":"02/28","matchInfoId":350076,"matchStatus":3,"matchTime":"08:30","play":{"concede":"-5.5","playCode":"HHDA","playId":93090,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236436,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236435,"playItemName":"主"}]},"refund":0,"threadCount":18,"time":1551313800000}]
         */

        private int matchCount;
        private List<MatchListBean> matchList;

        @lombok.NoArgsConstructor
        @lombok.Data
        public static class MatchListBean {
            /**
             * favPushStatus : 1
             * guestScore : 108
             * guestTeam : {"teamIcon":"https://relottery.ws.126.net/match/basketball/2_11.jpg","teamId":214,"teamName":"76人"}
             * hasFilterOdds : 2
             * hasLive : 0
             * homeScore : 104
             * homeTeam : {"teamIcon":"https://relottery.ws.126.net/match/basketball/2_17.jpg","teamId":161,"teamName":"雷霆"}
             * leagueMatch : {"leagueId":83,"leagueName":"NBA"}
             * lotteryCategoryId : 2
             * matchDate : 03/01
             * matchInfoId : 350345
             * matchStatus : 3
             * matchTime : 09:00
             * play : {"concede":"-7.5","playCode":"HHDA","playId":93117,"playItemList":[{"odds":1.7,"playItemCode":"L","playItemId":236490,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236489,"playItemName":"主"}]}
             * refund : 0
             * threadCount : 19
             * time : 1551402000000
             */

            private int favPushStatus;
            private int guestScore;
            private GuestTeamBean guestTeam;
            private int hasFilterOdds;
            private int hasLive;
            private int homeScore;
            private HomeTeamBean homeTeam;
            private LeagueMatchBean leagueMatch;
            private int lotteryCategoryId;
            private String matchDate;
            private int matchInfoId;
            private int matchStatus;
            private String matchTime;
            private PlayBean play;
            private int refund;
            private int threadCount;
            private long time;

            @lombok.NoArgsConstructor
            @lombok.Data
            public static class GuestTeamBean {
                /**
                 * teamIcon : https://relottery.ws.126.net/match/basketball/2_11.jpg
                 * teamId : 214
                 * teamName : 76人
                 */

                private String teamIcon;
                private int teamId;
                private String teamName;
            }

            @lombok.NoArgsConstructor
            @lombok.Data
            public static class HomeTeamBean {
                /**
                 * teamIcon : https://relottery.ws.126.net/match/basketball/2_17.jpg
                 * teamId : 161
                 * teamName : 雷霆
                 */

                private String teamIcon;
                private int teamId;
                private String teamName;
            }

            @lombok.NoArgsConstructor
            @lombok.Data
            public static class LeagueMatchBean {
                /**
                 * leagueId : 83
                 * leagueName : NBA
                 */

                private int leagueId;
                private String leagueName;
            }

            @lombok.NoArgsConstructor
            @lombok.Data
            public static class PlayBean {
                /**
                 * concede : -7.5
                 * playCode : HHDA
                 * playId : 93117
                 * playItemList : [{"odds":1.7,"playItemCode":"L","playItemId":236490,"playItemName":"客"},{"odds":1.7,"playItemCode":"W","playItemId":236489,"playItemName":"主"}]
                 */

                private String concede;
                private String playCode;
                private int playId;
                private List<PlayItemListBean> playItemList;

                @lombok.NoArgsConstructor
                @lombok.Data
                public static class PlayItemListBean {
                    /**
                     * odds : 1.7
                     * playItemCode : L
                     * playItemId : 236490
                     * playItemName : 客
                     */

                    private double odds;
                    private String playItemCode;
                    private int playItemId;
                    private String playItemName;
                }
            }
        }
    }
}
