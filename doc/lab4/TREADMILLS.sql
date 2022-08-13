/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : sakila

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 18/02/2022 21:40:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for TREADMILLS
-- ----------------------------
DROP TABLE IF EXISTS `TREADMILLS`;
CREATE TABLE `TREADMILLS`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCOUNTID` int(11) NULL DEFAULT NULL,
  `ALTITUDE` int(11) NULL DEFAULT NULL,
  `KCAL` int(11) NULL DEFAULT NULL,
  `MILLS` int(11) NULL DEFAULT NULL,
  `STARTDATE` date NULL DEFAULT NULL,
  `TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USETIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
