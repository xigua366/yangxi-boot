/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : yangxi_boot_sample

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/04/2021 11:12:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_school
-- ----------------------------
DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) NOT NULL COMMENT '租户id',
  `app_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '接入方id',
  `name` varchar(255) NOT NULL COMMENT '学校名称',
  `address` varchar(255) NOT NULL COMMENT '学校地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_school
-- ----------------------------
BEGIN;
INSERT INTO `t_school` VALUES (1, 'abc', 0, '广州一中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (2, 'abc', 0, '广州二中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (3, 'abc', 0, '广州三中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (4, 'abc', 0, '广州四中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (5, 'abc', 0, '广州五中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (6, 'abc', 0, '广州六中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (7, 'abc', 0, '广州七中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (8, 'abc', 0, '广州八中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (9, 'abc', 0, '广州九中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (10, 'abc', 0, '广州十中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (11, 'abc', 0, '广州十一中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (12, 'abc', 0, '广州十二中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (13, 'abc', 0, '广州十三中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
INSERT INTO `t_school` VALUES (14, 'abc', 0, '广州十四中', '黄埔大道', NULL, '2021-03-02 10:01:40', '2021-03-02 10:01:42');
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(32) NOT NULL COMMENT '租户id',
  `app_id` bigint(20) NOT NULL COMMENT '接入方id',
  `school_id` bigint(20) NOT NULL COMMENT '学校ID',
  `name` varchar(64) NOT NULL COMMENT '姓名',
  `age` smallint(6) NOT NULL COMMENT '年龄',
  `sex` tinyint(255) NOT NULL COMMENT '性别 1:男 2:女',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (1, 'abc', 0, 1, '张三', 10, 1, 'test', '2021-02-27 19:13:30', '2021-02-27 19:13:32');
INSERT INTO `t_student` VALUES (3, 'abc', 0, 1, 'zhangsan', 10, 1, NULL, '2021-03-03 05:24:28', '2021-03-03 05:24:28');
INSERT INTO `t_student` VALUES (4, 'abc', 0, 1, 'zhangsan', 10, 1, NULL, '2021-03-03 05:45:42', '2021-03-03 05:45:42');
INSERT INTO `t_student` VALUES (5, 'abc', 0, 1, 'zhangsan', 10, 1, NULL, '2021-03-03 05:57:46', '2021-03-03 05:57:46');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL COMMENT '手机号',
  `pwd` varchar(64) NOT NULL COMMENT '密码',
  `name` varchar(64) NOT NULL COMMENT '昵称',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `slogan` varchar(255) DEFAULT NULL COMMENT '签名',
  `sex` smallint(1) DEFAULT NULL COMMENT '性别',
  `mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `secret` varchar(255) DEFAULT NULL COMMENT '盐',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '13812345543', '$1$jTSk8DPo$6A.wgghBysRC.3EoY1H8C0', '韦小宝', NULL, NULL, NULL, NULL, '$1$jTSk8DPo', NULL, '2021-03-30 02:30:16', '2021-03-30 02:30:16');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
