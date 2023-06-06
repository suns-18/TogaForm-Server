/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : togaform

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 06/06/2023 16:54:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `stop_time` datetime NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creation_date` datetime NULL DEFAULT NULL,
  `last_updated_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last_updated_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', '2023-06-06 16:22:33', '2023-06-06 16:22:38', '1', '1', '2023-06-06 16:22:49', '1', '2023-06-06 16:22:53');
INSERT INTO `users` VALUES (2, 'Shoko', 'J3ToyZypjw', '2021-12-31 03:18:49', '2023-03-12 10:55:36', '1', '1', '2020-09-30 08:51:58', '1', '2021-11-09 00:25:11');
INSERT INTO `users` VALUES (3, 'Yanning', 'ESs5cjvuch', '2020-11-10 19:21:23', '2021-12-25 23:46:12', '1', '1', '2020-07-09 16:55:08', '1', '2023-01-14 06:18:31');
INSERT INTO `users` VALUES (4, 'Zoey', 'L5KoMAhHnO', '2022-06-29 09:16:12', '2023-06-03 11:26:48', '1', '1', '2020-11-08 21:28:18', '1', '2021-08-29 10:11:05');

SET FOREIGN_KEY_CHECKS = 1;
