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

 Date: 22/06/2023 06:03:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enum_answer_type
-- ----------------------------
DROP TABLE IF EXISTS `enum_answer_type`;
CREATE TABLE `enum_answer_type`  (
  `id` int NOT NULL,
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enum_answer_type
-- ----------------------------
INSERT INTO `enum_answer_type` VALUES (1, '单选');
INSERT INTO `enum_answer_type` VALUES (2, '多选');
INSERT INTO `enum_answer_type` VALUES (3, '填空');
INSERT INTO `enum_answer_type` VALUES (4, '矩阵');
INSERT INTO `enum_answer_type` VALUES (5, '量表');

-- ----------------------------
-- Table structure for enum_role
-- ----------------------------
DROP TABLE IF EXISTS `enum_role`;
CREATE TABLE `enum_role`  (
  `id` int NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enum_role
-- ----------------------------
INSERT INTO `enum_role` VALUES (0, '管理员');
INSERT INTO `enum_role` VALUES (1, '教师');
INSERT INTO `enum_role` VALUES (2, '学生');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目表主键',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id（没有用）',
  `project_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `project_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '项目说明',
  `created_by` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `creation_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `last_update_date` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `project_info_user_info_id_fk`(`user_id` ASC) USING BTREE,
  INDEX `project_info_user_info_id_fk2`(`created_by` ASC) USING BTREE,
  INDEX `project_info_user_info_id_fk3`(`last_updated_by` ASC) USING BTREE,
  CONSTRAINT `project_info_user_info_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_info_user_info_id_fk2` FOREIGN KEY (`created_by`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_info_user_info_id_fk3` FOREIGN KEY (`last_updated_by`) REFERENCES `user_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('13f614a14972aaad81ad230443eff4b2', '0df0adc5cf1b776390b1df52987b1169', 'Navicat provides powerful tool', 'Difficult circumstances serve as a textbook of life for people. You will succeed because most people are lazy. The Navigation pane employs tree structure which allows you to take action upon the datab', '0df0adc5cf1b776390b1df52987b1169', '2022-05-02 13:58:18', '0df0adc5cf1b776390b1df52987b1169', '2020-08-24 07:29:59');
INSERT INTO `project` VALUES ('3697c089e44f7f29cc42566e5a9a38ce', 'a876251c0797ef86b7ae78fe677826f8', 'How we spend our days is, of c', 'It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. The Synchronize to Database function will give you a full picture of all database differences.', 'a876251c0797ef86b7ae78fe677826f8', '2021-11-05 08:18:34', 'a876251c0797ef86b7ae78fe677826f8', '2022-09-17 21:13:04');
INSERT INTO `project` VALUES ('65cd96b1f3b37f261524509cdf8fa58c', '990ffb21540feac0b77d9d5e66cc2207', 'Navicat 15 has added support f', 'In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. To successfully establish a new connection to local/remote server - no matter ', '990ffb21540feac0b77d9d5e66cc2207', '2022-01-01 20:16:06', '990ffb21540feac0b77d9d5e66cc2207', '2022-08-09 16:36:07');
INSERT INTO `project` VALUES ('7cd5edcb71503fed2f0efd522bcd0da5', 'bab202c84b4600c89cfc7c929b0ca120', 'The Synchronize to Database fu', 'Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another.', 'bab202c84b4600c89cfc7c929b0ca120', '2021-05-09 09:41:26', 'bab202c84b4600c89cfc7c929b0ca120', '2021-08-22 22:14:15');
INSERT INTO `project` VALUES ('a64f0080c88e825308f259292e4279a0', '9a22828a0fdf44c4491111a2d6c57a3f', 'SSH serves to prevent such vul', 'Navicat Monitor requires a repository to store alerts and metrics for historical analysis. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connec', '9a22828a0fdf44c4491111a2d6c57a3f', '2022-02-03 07:13:47', '9a22828a0fdf44c4491111a2d6c57a3f', '2022-10-26 06:10:37');
INSERT INTO `project` VALUES ('c2e4c654382881578b7676aa17b04688', '430331db870c632304e5c56c17c0bf63', 'Creativity is intelligence hav', 'To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences.', '430331db870c632304e5c56c17c0bf63', '2022-01-08 03:24:38', '430331db870c632304e5c56c17c0bf63', '2021-08-09 12:29:33');
INSERT INTO `project` VALUES ('d4c2bdb9b404ba16afed7e4e1f0ec4ff', '722d2a32954d36fbe4a17075a55ddbb3', 'A man is not old until regrets', 'In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information.', '722d2a32954d36fbe4a17075a55ddbb3', '2021-06-18 03:52:03', '722d2a32954d36fbe4a17075a55ddbb3', '2020-03-13 23:32:30');
INSERT INTO `project` VALUES ('f9fee27c7141e11d8768d615ec31f7ed', 'bbfa8aa8450edca6383ed9b5fcc11f57', 'I destroy my enemies when I ma', 'With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way.', 'bbfa8aa8450edca6383ed9b5fcc11f57', '2022-10-06 05:44:57', 'bbfa8aa8450edca6383ed9b5fcc11f57', '2022-09-29 13:09:47');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户表主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `stop_time` datetime NULL DEFAULT NULL COMMENT '截止时间（时间戳）',
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否启用（1启用，0不启用）',
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `creation_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `last_update_date` datetime NULL DEFAULT NULL COMMENT '最后修改时间',
  `role` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_info_enum_role_id_fk`(`role` ASC) USING BTREE,
  CONSTRAINT `user_info_enum_role_id_fk` FOREIGN KEY (`role`) REFERENCES `enum_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `check_name` CHECK (`username` is not null)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('0df0adc5cf1b776390b1df52987b1169', 'admin', 'admin', '2020-08-27 16:01:31', '2021-06-05 14:07:49', '1', 'admin', '2022-04-07 19:45:26', 'admin', '2021-01-08 05:29:16', 0);
INSERT INTO `user_info` VALUES ('334cd49558da50a6ed5cf2ca9757b4d5', 'choi86', 'w2oeMj', '2022-05-14 01:33:54', '2023-04-01 05:42:17', '0', 'admin', '2021-09-24 08:08:30', 'admin', '2023-01-30 07:19:39', 2);
INSERT INTO `user_info` VALUES ('3a421e324c4f2450a7a5aca113998bed', 'phillipscarmen6', 'd2ai08', '2021-12-14 06:48:53', '2020-02-03 16:51:07', '0', 'admin', '2022-06-08 16:03:44', 'admin', '2020-10-23 14:48:32', 2);
INSERT INTO `user_info` VALUES ('430331db870c632304e5c56c17c0bf63', 'chenkai', 'iLhzRB', '2021-10-31 23:51:20', '2021-01-08 01:08:41', '1', 'admin', '2022-06-19 10:33:54', 'admin', '2021-06-30 19:39:12', 1);
INSERT INTO `user_info` VALUES ('45ff4b5c9f22483694d2d5729ff5fa95', 'sanoyu', 'xstgFo', '2020-05-08 04:29:52', '2022-11-21 06:59:32', '1', 'admin', '2022-06-03 14:54:06', 'admin', '2021-09-23 10:17:28', 1);
INSERT INTO `user_info` VALUES ('49c408e31b8a48bd5ffac766c837e070', 'stewartedna', 'ZUzMy1', '2020-05-24 21:35:50', '2022-07-19 19:58:06', '1', 'admin', '2020-11-30 17:32:07', 'admin', '2020-07-20 15:46:57', 2);
INSERT INTO `user_info` VALUES ('704ecef7168f7ef27544febf2b7303ff', 'arayuna7', 'ihrocI', '2022-07-12 01:00:37', '2021-04-18 20:18:14', '1', 'admin', '2021-05-02 22:00:56', 'admin', '2021-04-25 00:07:22', 2);
INSERT INTO `user_info` VALUES ('722d2a32954d36fbe4a17075a55ddbb3', 'angelastone', 'W2ZE2U', '2021-05-10 12:54:53', '2022-03-22 03:59:12', '0', 'admin', '2020-10-09 09:26:31', 'admin', '2022-01-10 08:47:11', 2);
INSERT INTO `user_info` VALUES ('9018c8cb357333da02a3c4d62e7f1c3c', 'ono3', 'Y0BD2N', '2022-06-22 07:11:42', '2021-02-10 14:16:33', '1', 'admin', '2020-09-24 19:11:20', 'admin', '2021-04-25 17:52:56', 1);
INSERT INTO `user_info` VALUES ('90deb7f8963928569affa2796414c9f6', 'dai07', 'XYCc6X', '2021-01-05 03:20:21', '2020-10-19 07:44:41', '1', 'admin', '2021-08-08 11:42:00', 'admin', '2023-06-03 18:39:08', 1);
INSERT INTO `user_info` VALUES ('990ffb21540feac0b77d9d5e66cc2207', 'a', 'DRNXvM', '2020-06-23 02:51:53', '2023-06-14 11:06:10', '0', 'admin', '2023-05-16 17:33:53', 'admin', '2020-04-20 11:57:42', 2);
INSERT INTO `user_info` VALUES ('9a22828a0fdf44c4491111a2d6c57a3f', 'miyazakise', 'DrOW3h', '2022-10-10 23:42:00', '2021-10-12 14:44:31', '1', 'admin', '2020-08-01 07:43:50', 'admin', '2021-09-27 06:07:58', 2);
INSERT INTO `user_info` VALUES ('a63ce26d0fa3cc5806043cc0a44475fe', 'stakuya', 'x8bzIv', '2020-08-31 13:21:42', '2023-01-05 22:45:29', '1', 'admin', '2020-09-23 15:57:17', 'admin', '2022-09-26 09:01:29', 2);
INSERT INTO `user_info` VALUES ('a876251c0797ef86b7ae78fe677826f8', 'yyuna62', 'EBaxUb', '2023-04-21 16:11:47', '2021-07-22 22:32:06', '1', 'admin', '2021-09-08 13:52:02', 'admin', '2023-04-13 04:56:36', 1);
INSERT INTO `user_info` VALUES ('bab202c84b4600c89cfc7c929b0ca120', 'jonathanmend1004', 'lvy4ti', '2022-06-14 07:02:01', '2021-10-07 19:24:29', '0', 'admin', '2021-07-10 13:42:25', 'admin', '2022-04-24 03:50:28', 2);
INSERT INTO `user_info` VALUES ('bbfa8aa8450edca6383ed9b5fcc11f57', 'tssw', 'm74on5', '2020-05-09 19:47:04', '2022-06-14 18:49:12', '0', 'admin', '2021-10-09 10:14:22', 'admin', '2021-09-28 01:58:17', 1);
INSERT INTO `user_info` VALUES ('e4e44cb5ecd83db768ed088c7310f16f', 'lokon', 'mEKH19', '2022-09-08 07:58:31', '2022-02-04 22:47:41', '0', 'admin', '2022-03-15 22:55:58', 'admin', '2020-10-29 18:01:38', 2);
INSERT INTO `user_info` VALUES ('f059f4ecbf64c3c945d3fb94c0cfa5ac', 'moriy', 'mAZQDn', '2021-06-12 18:20:39', '2022-08-03 23:55:13', '1', 'admin', '2020-08-21 05:39:03', 'admin', '2020-06-27 07:33:17', 1);
INSERT INTO `user_info` VALUES ('fadc81f986f6fddee6aa5274b47ef503', 'kuyf', 'q2iSs6', '2020-11-09 11:08:56', '2022-12-06 08:51:21', '0', 'admin', '2022-09-22 22:06:18', 'admin', '2022-06-30 22:29:47', 2);

SET FOREIGN_KEY_CHECKS = 1;
