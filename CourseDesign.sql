/*
 Navicat Premium Data Transfer

 Source Server         : t1
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : CourseDesign

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/05/2021 13:28:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `level` int(15) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `begintime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `sign_begintime` datetime DEFAULT NULL,
  `sign_endtime` datetime DEFAULT NULL,
  `nums` int(11) DEFAULT '0',
  `status` varchar(255) DEFAULT NULL COMMENT 'open,close,show',
  `permittedmajors` varchar(255) DEFAULT NULL,
  `maxgrade` int(11) DEFAULT '4',
  `manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exam_ibfk_1` (`manager_id`),
  CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
BEGIN;
INSERT INTO `exam` VALUES (1, 'CET', 4, '英语四级', '英语四级的等待', '2021-04-22 12:00:00', '2021-04-22 14:00:00', '2021-04-18 19:26:33', '2021-04-20 19:26:37', 6, 'open', 'all', 4, 2);
INSERT INTO `exam` VALUES (2, 'CET', 6, '英语六级', '英语六级我的味道', '2021-04-22 12:00:00', '2021-04-22 14:00:00', '2021-04-18 19:26:33', '2021-04-20 19:26:37', 6, 'open', 'all', 4, 2);
COMMIT;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `QQ` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES (1, 'root', 'root', 'Admin', '5432', '2345', 'waleiwa@qiqi.com');
INSERT INTO `manager` VALUES (2, 'kriw', '23', '长秋', '2345', '5432', 'li@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` int(11) NOT NULL DEFAULT '0',
  `place` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_ibfk_1` (`exam_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
BEGIN;
INSERT INTO `room` VALUES (1, 30, 'A1-033', 'free', NULL);
INSERT INTO `room` VALUES (2, 50, 'B2-233', 'free', NULL);
INSERT INTO `room` VALUES (3, 30, 'A1-154', 'free', NULL);
INSERT INTO `room` VALUES (4, 20, 'B2-102', 'free', NULL);
INSERT INTO `room` VALUES (5, 30, 'C1-112', 'free', NULL);
INSERT INTO `room` VALUES (6, 45, 'B2-106', 'free', NULL);
INSERT INTO `room` VALUES (7, 10, 'A1-103', 'free', NULL);
INSERT INTO `room` VALUES (8, 10, 'A2-222', 'free', NULL);
INSERT INTO `room` VALUES (9, 45, 'A3-303', 'free', NULL);
INSERT INTO `room` VALUES (10, 40, 'A3-313', 'free', NULL);
INSERT INTO `room` VALUES (11, 10, 'A1-321', 'free', NULL);
COMMIT;

-- ----------------------------
-- Table structure for signRelation
-- ----------------------------
DROP TABLE IF EXISTS `signRelation`;
CREATE TABLE `signRelation` (
  `student_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `signtime` datetime DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`) USING BTREE,
  KEY `exam_id` (`exam_id`),
  CONSTRAINT `signrelation_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `signrelation_ibfk_2` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '登陆系统使用的用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL COMMENT '真实姓名',
  `age` int(11) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `classorder` int(11) DEFAULT NULL,
  `gender` varchar(10) NOT NULL,
  `grade` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, 'zsf', 'zsf', '太极张三丰', 20, '太极', 1, '男', 1, NULL);
INSERT INTO `student` VALUES (2, 'kriw', '23', 'DoctorP', 20, '软件工程', 1, '男', 3, NULL);
INSERT INTO `student` VALUES (3, 'kuroneko', '123', 'KuroNeko', 20, '软件工程', 1, '女', 3, NULL);
INSERT INTO `student` VALUES (4, 'testman1', '1', 'TestMan1', 18, 'Test', 1, '男', 1, NULL);
INSERT INTO `student` VALUES (5, 'testman2', '2', 'TestMan2', 18, 'Test', 1, '女', 1, NULL);
INSERT INTO `student` VALUES (6, 'dsx', 'dsx', '埃斯蒂尼安', 19, '武术', 2, '男', 2, NULL);
INSERT INTO `student` VALUES (7, 'majo', 'majo', '雅・修特拉', 19, '魔术', 1, '女', 2, NULL);
INSERT INTO `student` VALUES (8, 'alise', 'alise', '阿莉塞', 19, '魔术', 2, '女', 2, NULL);
INSERT INTO `student` VALUES (9, 'ningja', 'ningja', '夕雾', 19, '武术', 1, '女', 2, NULL);
INSERT INTO `student` VALUES (10, 'lin', 'lin', 'Suvve', 20, '软件工程', 3, '女', 3, NULL);
INSERT INTO `student` VALUES (11, 'TestMan3', '333', 'TestManV', 19, '软件工程', 3, '男', 2, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
