/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost
 Source Database       : NBA_robot

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : utf-8

 Date: 03/20/2019 20:26:22 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `nba_guess`
-- ----------------------------
DROP TABLE IF EXISTS `nba_guess`;
CREATE TABLE `nba_guess` (
  `id` int(11) NOT NULL,
  `match_id` int(11) DEFAULT NULL,
  `home_ points` int(11) DEFAULT NULL COMMENT '主队分析得分',
  `guest_ points` int(11) DEFAULT NULL COMMENT '客队分析得分',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  `guses_result` varchar(255) DEFAULT NULL COMMENT 'W 主胜利 L 客胜',
  `win` varchar(255) DEFAULT NULL COMMENT '1 猜对了 -1 猜错了',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
--  Table structure for `nba_guess_point_log`
-- ----------------------------
DROP TABLE IF EXISTS `nba_guess_point_log`;
CREATE TABLE `nba_guess_point_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) DEFAULT NULL,
  `point` varchar(255) DEFAULT NULL COMMENT '积分变化',
  `type` varchar(255) DEFAULT NULL COMMENT '积分变化类型',
  `desc` varchar(255) DEFAULT NULL COMMENT '基本变化简介',
  `source_id` int(11) DEFAULT NULL COMMENT '积分变化来源',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
--  Records of `nba_guess_point_log`
-- ----------------------------
BEGIN;
INSERT INTO `nba_guess_point_log` VALUES ('11', '351886001', '10', '2', '波特兰开拓者近期赢盘能力出众，已经连续六场赢下比赛盘口', '1', '2019-03-04 16:44:21', null), ('12', '351886001', '10', '2', '波特兰开拓者最近七场比赛有六场得分在110分及以上，进攻端的出色表现是球队近期战绩快速提升的主要原因', '1', '2019-03-04 16:44:21', null), ('13', '351886001', '10', '2', '波特兰开拓者本赛季场均可以拿下47.7个篮板，排名联盟前三，球队对于篮板球的冲抢和保护做得十分到位', '1', '2019-03-04 16:44:21', null), ('14', '351886001', '-10', '2', '波特兰开拓者上场比赛不敌猛龙，五连胜遭到终结', '1', '2019-03-04 16:44:21', null), ('15', '351886001', '-10', '2', '波特兰开拓者本赛季客场比赛胜率低于五成，相比较他们超过七成的主场胜率，客战表现的低迷是制约球队战绩以及排名更进一步的主要因素', '1', '2019-03-04 16:44:21', null), ('16', '351886001', '10', '1', '夏洛特黄蜂上场比赛战胜篮网，终结了此前的三连败', '1', '2019-03-04 16:44:21', null), ('17', '351886001', '10', '1', '夏洛特黄蜂本赛季主场胜率超过六成，球队本赛季的大多数胜利都是在主场取得的', '1', '2019-03-04 16:44:21', null), ('18', '351886001', '-10', '1', '夏洛特黄蜂近期盘路表现不佳，最近十场比赛他们输掉了其中的七场比赛盘口', '1', '2019-03-04 16:44:21', null), ('19', '351886001', '-10', '1', '夏洛特黄蜂已经连续六场比赛失分在110分及以上，防守端表现不佳是球队近期战绩排名滑落的主要原因', '1', '2019-03-04 16:44:21', null), ('20', '351886001', '-10', '1', '夏洛特黄蜂最近四次面对开拓者均没能取得胜利，其中包括本赛季客场31分劣势不敌对手的那场比赛', '1', '2019-03-04 16:44:21', null);
COMMIT;

-- ----------------------------
--  Table structure for `nba_match_result`
-- ----------------------------
DROP TABLE IF EXISTS `nba_match_result`;
CREATE TABLE `nba_match_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) DEFAULT NULL COMMENT '比赛id',
  `guest_team_name` varchar(255) DEFAULT NULL COMMENT '客队名称',
  `guest_score` int(11) DEFAULT NULL COMMENT '客队比分',
  `home_team_name` varchar(255) DEFAULT NULL COMMENT '主队名称',
  `home_score` varchar(255) DEFAULT NULL COMMENT '主队比分',
  `match_date` datetime DEFAULT NULL COMMENT '比赛时间',
  `guess_result` varchar(255) DEFAULT NULL COMMENT '竞赛-比赛结果 1 主胜 0 客队胜利',
  `real_result` varchar(255) DEFAULT NULL COMMENT '真实-比赛结果 1 主胜 0 客队胜利 -1 比赛延迟或者无结果',
  `code` varchar(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
--  Records of `nba_match_result`
-- ----------------------------
BEGIN;
INSERT INTO `nba_match_result` VALUES ('30', '351217001', '雄鹿', '131', '湖人', '120', '2019-03-01 00:00:00', null, 'L', '5.5', '2019-03-02 11:41:30', '2019-03-02 11:41:30'), ('31', '351216001', '快船', '116', '国王', '109', '2019-03-01 00:00:00', null, 'L', '-3.5', '2019-03-02 11:41:30', '2019-03-02 11:41:30'), ('32', '351214001', '奇才', '96', '凯尔特人', '107', '2019-03-01 00:00:00', null, 'W', '-9.5', '2019-03-02 11:41:30', '2019-03-02 11:41:30'), ('33', '351213001', '开拓者', '117', '猛龙', '119', '2019-03-01 00:00:00', null, 'L', '-5.5', '2019-03-02 11:41:30', '2019-03-02 11:41:30'), ('42', '351759001', '魔术', '117', '步行者', '112', '2019-03-03 08:00:00', null, 'L', '-3.5', '2019-03-04 12:55:27', '2019-03-04 12:55:27'), ('43', '351760001', '篮网', '88', '热火', '117', '2019-03-03 08:30:00', null, 'W', '-3.5', '2019-03-04 12:55:27', '2019-03-04 12:55:27'), ('44', '351764001', '雷霆', '102', '马刺', '116', '2019-03-03 09:30:00', null, 'W', '-4.5', '2019-03-04 12:55:27', '2019-03-04 12:55:27'), ('45', '351767001', '雄鹿', '111', '爵士', '115', '2019-03-03 10:00:00', null, 'L', '-4.5', '2019-03-04 12:55:27', '2019-03-04 12:55:27'), ('46', '351919001', '老鹰', '113', '热火', '114', '2019-03-05 08:30:00', null, 'L', '-3.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('47', '351918001', '独行侠', '88', '篮网', '127', '2019-03-05 08:30:00', null, 'W', '-6.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('48', '351921001', '掘金', '69', '马刺', '83', '2019-03-05 09:30:00', null, 'W', '-1.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('49', '351925001', '快船', null, '湖人', null, '2019-03-05 11:30:00', null, null, '-3.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('50', '351902001', '森林狼', '121', '奇才', '135', '2019-03-04 07:00:00', null, 'W', '-1.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('51', '351901001', '猛龙', '107', '活塞', '112', '2019-03-04 07:00:00', null, 'W', '4.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('52', '351897001', '火箭', '115', '凯尔特人', '104', '2019-03-04 04:30:00', null, 'L', '-2.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('53', '351886001', '开拓者', '118', '黄蜂', '108', '2019-03-04 02:00:00', null, 'L', '2.5', '2019-03-05 11:07:58', '2019-03-05 11:07:58'), ('54', '352534001', '公牛', null, '步行者', null, '2019-03-06 08:00:00', null, null, '-8.5', '2019-03-05 11:07:58', null), ('55', '352535001', '魔术', null, '76人', null, '2019-03-06 08:00:00', null, null, '-4.5', '2019-03-05 11:07:58', null), ('56', '352536001', '火箭', null, '猛龙', null, '2019-03-06 09:00:00', null, null, '-3.5', '2019-03-05 11:07:58', null), ('57', '352541001', '凯尔特人', null, '勇士', null, '2019-03-06 11:30:00', null, null, '-7.5', '2019-03-05 11:07:58', null);
COMMIT;

-- ----------------------------
--  Table structure for `nba_player_data`
-- ----------------------------
DROP TABLE IF EXISTS `nba_player_data`;
CREATE TABLE `nba_player_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_name` varchar(255) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `season` varchar(255) DEFAULT NULL,
  `assistsPg` varchar(255) DEFAULT NULL COMMENT '场均助攻',
  `blocksPg` varchar(255) DEFAULT NULL COMMENT '场均盖帽',
  `defRebsPg` varchar(255) DEFAULT NULL COMMENT '场均防守篮板',
  `offRebsPg` varchar(255) DEFAULT NULL,
  `pointsPg` varchar(255) DEFAULT NULL COMMENT '场均得分',
  `stealsPg` varchar(255) DEFAULT NULL COMMENT '场均抢断',
  `turnoversPg` varchar(255) DEFAULT NULL COMMENT '场均失误',
  `foulsPg` varchar(255) DEFAULT NULL COMMENT '场均犯规',
  `fgpct` varchar(255) DEFAULT NULL COMMENT '场均命中率',
  `minsPg` varchar(255) DEFAULT NULL COMMENT '场均分钟',
  `games` varchar(255) DEFAULT NULL COMMENT '赛季比赛',
  `gamesStarted` varchar(255) DEFAULT NULL COMMENT '赛季先发',
  `efficiency` varchar(255) DEFAULT NULL COMMENT '效率值',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
--  Records of `nba_player_data`
-- ----------------------------
BEGIN;
INSERT INTO `nba_player_data` VALUES ('1', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('2', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('3', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('4', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('5', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `nba_team_player_status`
-- ----------------------------
DROP TABLE IF EXISTS `nba_team_player_status`;
CREATE TABLE `nba_team_player_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) DEFAULT NULL,
  `best_player_id` varchar(255) DEFAULT NULL,
  `second_player_id` varchar(255) DEFAULT NULL,
  `third_player_id` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  `best_player_name` varchar(255) DEFAULT NULL,
  `second_player_name` varchar(255) DEFAULT NULL,
  `third_player_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
