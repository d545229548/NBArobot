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

 Date: 03/01/2019 17:07:39 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `nba_guess_result`
-- ----------------------------
DROP TABLE IF EXISTS `nba_guess_result`;
CREATE TABLE `nba_guess_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) DEFAULT NULL COMMENT '比赛id',
  `guest_team_name` varchar(255) DEFAULT NULL COMMENT '客队名称',
  `guest_score` int(11) DEFAULT NULL COMMENT '客队比分',
  `home_team_name` varchar(255) DEFAULT NULL COMMENT '主队名称',
  `home_score` varchar(255) DEFAULT NULL COMMENT '主队比分',
  `match_date` date DEFAULT NULL COMMENT '比赛时间',
  `guess_result` varchar(255) DEFAULT NULL COMMENT '竞赛-比赛结果 1 主胜 0 客队胜利',
  `real_result` varchar(255) DEFAULT NULL COMMENT '真实-比赛结果 1 主胜 0 客队胜利 -1 比赛延迟或者无结果',
  `code` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
