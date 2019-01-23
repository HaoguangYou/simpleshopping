/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50703
 Source Host           : localhost:3306
 Source Schema         : simple_shopping

 Target Server Type    : MySQL
 Target Server Version : 50703
 File Encoding         : 65001

 Date: 23/01/2019 11:10:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for broad
-- ----------------------------
DROP TABLE IF EXISTS `broad`;
CREATE TABLE `broad`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `broadId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of broad
-- ----------------------------
INSERT INTO `broad` VALUES (1, 'x001', '小米手机', '1', '移动电子端', '优惠机');
INSERT INTO `broad` VALUES (2, 'h001', '红米', '1', '移动电子端', '优惠机');
INSERT INTO `broad` VALUES (3, 'p001', '平板*笔记本', '1', '家用电器', NULL);
INSERT INTO `broad` VALUES (4, 'd001', '电视', '1', '家用电子', NULL);
INSERT INTO `broad` VALUES (5, 'htt6', '盒子*影音', '1', '家用电子', NULL);
INSERT INTO `broad` VALUES (6, 'L001', '路由器', '1', '配件', NULL);
INSERT INTO `broad` VALUES (7, 'z001', '智能硬件', '1', '配件', NULL);
INSERT INTO `broad` VALUES (8, 'f001', '服务', '1', '售后', NULL);
INSERT INTO `broad` VALUES (9, 's001', '社区', '1', '社交', NULL);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `broadId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `manufacturer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '00001001', '小米007', 'x001', '1', '小厂', '$555', './image/liebiao_xiaomint2.jpg', '值');
INSERT INTO `goods` VALUES (2, '00002001', '大米009', 'x001', '1', '大厂', '$666', './image/liebiao_xiaomint2.jpg', '超值');

-- ----------------------------
-- Table structure for goodsdetails
-- ----------------------------
DROP TABLE IF EXISTS `goodsdetails`;
CREATE TABLE `goodsdetails`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `barCode ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `specification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `creationTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goodsdetails
-- ----------------------------
INSERT INTO `goodsdetails` VALUES (1, '00001001', '123456', '全网通版 6GB+64GB  2499元', '100', 'V200', '七彩虹', '9090-11-29', '变焦双摄，4 轴防抖 / 骁龙835 旗舰处理器，6GB 大内存，最大可选128GB 闪存 / 5.15\" 护眼屏 / 四曲面玻璃/陶瓷机身', 'image/007.jpg');

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `gdid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `start` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `creationTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `payFreight` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES (4, '1', '4', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (5, '1', '2', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (6, '1', '', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (7, '1', '7', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (8, '1', '7', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (9, '1', '2', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (10, '1', '7', '1', NULL, '1', '4', NULL, NULL, NULL);
INSERT INTO `shoppingcart` VALUES (11, '1', '7', '1', NULL, '1', '4', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '黑名单-1,注销0,普通1,vip2',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '喜羊羊', '123', '张三', '12580', '广东', '男', '15', '0');
INSERT INTO `user` VALUES (2, '唐三', '123', '李四', '10086', '厦门', '男', '18', '2');
INSERT INTO `user` VALUES (4, '牧神', '123', NULL, '10000', NULL, NULL, NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
