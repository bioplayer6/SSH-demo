/*
Navicat MySQL Data Transfer

Source Server         : sdzx
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2020-06-10 14:44:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for springuser
-- ----------------------------
DROP TABLE IF EXISTS `springuser`;
CREATE TABLE `springuser` (
  `user_id` varchar(20) NOT NULL,
  `real_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of springuser
-- ----------------------------
INSERT INTO `springuser` VALUES ('bnm123', '班尼路', '852123', '男');
INSERT INTO `springuser` VALUES ('chengwei', '程伟', '7894565', '女');
INSERT INTO `springuser` VALUES ('lina', '丽娜', 'dagu123', '女');
INSERT INTO `springuser` VALUES ('ljy123', '罗基石', '741852963', '女');
INSERT INTO `springuser` VALUES ('lufei', '路飞', 'luoxingyu123', '男');
INSERT INTO `springuser` VALUES ('luluxiu', '鲁鲁修', '1230456', '男');
INSERT INTO `springuser` VALUES ('luluye', '露露叶', '789456', '男');
INSERT INTO `springuser` VALUES ('milu', '咪路', 'qazwsx', '女');
INSERT INTO `springuser` VALUES ('stu12', '李兴', 'asd123', '男');
