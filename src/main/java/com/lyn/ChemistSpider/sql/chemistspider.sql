/*
Navicat MySQL Data Transfer

Source Server         : lyn
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : chemistspider

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-21 01:11:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `productName` varchar(200) NOT NULL,
  `productPrice` varchar(50) DEFAULT NULL,
  `retailPrice` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `productId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productName` (`productName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
