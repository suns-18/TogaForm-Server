/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : survey

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 16/06/2023 19:27:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project_info
-- ----------------------------
DROP TABLE IF EXISTS `project_info`;
CREATE TABLE `project_info`  (
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
-- Records of project_info
-- ----------------------------
INSERT INTO `project_info` VALUES ('017141acbf6248fea3a54abc11242795', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('028b57c425f5da70b35f89376dbc4c09', '49c408e31b8a48bd5ffac766c837e070', 'I destroy my enemies when I ma', 'The reason why a great man is great is that he resolves to be a great man. The first step is as good as half over. Remember that failure is an event, not a person.', '49c408e31b8a48bd5ffac766c837e070', '2021-11-30 10:17:06', '49c408e31b8a48bd5ffac766c837e070', '2020-02-23 14:40:44');
INSERT INTO `project_info` VALUES ('034303e9becd43298311dea291401093', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('06af563a64964a4eb49a78a42c57dd6a', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('06f6b36985f24a7abc273d0aa0a10673', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('06fcdc68608c4ba084a2b65b411fc2bf', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('08c8e99473a34ba7a1e472be66a981b0', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('09791b6fc68e4096a42be62637c2c874', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('0aa0da8dd10b4fe790779858af780410', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('0e1cdd7abe404991a38eafb2b686560c', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('0e94e662f2d443939c0963ee30c8d489', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('0edb4ba3990b4ccd8454e5850b008f1b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('13f614a14972aaad81ad230443eff4b2', '0df0adc5cf1b776390b1df52987b1169', 'Navicat provides powerful tool', 'Difficult circumstances serve as a textbook of life for people. You will succeed because most people are lazy. The Navigation pane employs tree structure which allows you to take action upon the datab', '0df0adc5cf1b776390b1df52987b1169', '2022-05-02 13:58:18', '0df0adc5cf1b776390b1df52987b1169', '2020-08-24 07:29:59');
INSERT INTO `project_info` VALUES ('162415b4b1e94f85b7c29b7a3c9f6e14', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('171fba14be39463aabbdc06b15caa234', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('18330a9a8c224359b8c36cfd5738c9a6', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1c6d98765a914e2c8b30398107d0fe68', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1c88f961879b40b69a12f6ec7461d971', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1d7d94b6bc974e5c92d96505c588be7e', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1dbb7e0d51384b2cbdfadb90602c3dd2', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1e4bdddc81064829a3efd05802a7ad64', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1fa85a70c2e04d18994dbc413b0a56a8', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('1fdfcd0c28e44043bacc7449cc2f0038', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('21a3e7a8f87a4879818876e1acc63095', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('238a8ae79f3d4f06b3ad61e0bce80487', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('2a1759b67e634804bb972b521f028246', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('2a1ab34c203841dabad8df12073fb12b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('2cbaa4b917574f33800fb4a6eb27b3ac', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('2d18f659094948f99ce35e2c1945c54a', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('2ec28d76a0fd4f968a922f8eb18275a6', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('30ae4ac27fc7454793231d221fb60d77', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('30da0c018ae64fc9a13edb41f4f47e30', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('357e5f25285e4edaae649d7edc3fa02a', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('3697c089e44f7f29cc42566e5a9a38ce', 'a876251c0797ef86b7ae78fe677826f8', 'How we spend our days is, of c', 'It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. The Synchronize to Database function will give you a full picture of all database differences.', 'a876251c0797ef86b7ae78fe677826f8', '2021-11-05 08:18:34', 'a876251c0797ef86b7ae78fe677826f8', '2022-09-17 21:13:04');
INSERT INTO `project_info` VALUES ('3d5ee190a48c41b18fa89242cec3e1e8', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('4046ec719b624a3293707f95607b5c58', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('40d7f03c437b4b52970a6d687e14c578', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('480483c0dcd6482d8b0e3e40de735311', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('489fd30a07e84a4aa8265f35737565a8', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('4a1efd8918b94307a79c889bd2546fd9', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('4c72c974a6514fe391e244fb24257509', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('4ea47c2da2914050a96158e4edd0b8c7', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('515585a7caf14ea7826d914b79f391d3', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('52349567b921481bb1a4053cccb946c5', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('53b7297fffbc4cfdb6da60313d91895c', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('5619550f66f646c48c3e9ef414f6a1af', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('590017d0b1584c3c87637fde9ff0ab25', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('596caeaae8ec44a4aa955ced455469a0', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('5ae0b544cafd4419b7f69330b3203e6a', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('5d2d596cac72491fab1e0d5fff288e87', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('5ef5dc1747a848af89525d6468a25a9c', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('60a96058d65e40edb5aab29b3dfe48f3', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('65cd96b1f3b37f261524509cdf8fa58c', '990ffb21540feac0b77d9d5e66cc2207', 'Navicat 15 has added support f', 'In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. To successfully establish a new connection to local/remote server - no matter ', '990ffb21540feac0b77d9d5e66cc2207', '2022-01-01 20:16:06', '990ffb21540feac0b77d9d5e66cc2207', '2022-08-09 16:36:07');
INSERT INTO `project_info` VALUES ('66fd9aaa70d6454b97d754737c2de6e3', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('6b8d8d811b1a4ecaaf487d5587e7fc50', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('6c08428ed2e947adabf559170bd0b5d2', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('70f207fb319640bc922fdb3e073cc3ea', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('73535e4d0ef74f34863b03a3498f17bd', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('73dc5a17eec74b2a94f30e64f07e601d', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('771865a718e64ae4ab728ab9dff575eb', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('7cd5edcb71503fed2f0efd522bcd0da5', 'bab202c84b4600c89cfc7c929b0ca120', 'The Synchronize to Database fu', 'Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another.', 'bab202c84b4600c89cfc7c929b0ca120', '2021-05-09 09:41:26', 'bab202c84b4600c89cfc7c929b0ca120', '2021-08-22 22:14:15');
INSERT INTO `project_info` VALUES ('81d64a2e6b52418fb9ef6f0e5feb9069', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('844161d054ec4273a0baf052ede0a7ea', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('847227fe0d324c79a92eaf5fa41936b4', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('853bc97ddc07405290208d81ee72a3d2', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('85c2dd53843745f7a20f3cef834e7e48', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('86ca5a9a48d9400aa7eda7f191660288', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('89df23e5c5544f85a6ea1b5f44452565', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('8f0119a25a5a44ce97d01ad3abc9f273', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('8f4114107dda49759fa7b799fc86b01b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('928e9dec0711404aadbfbec2a6501b7e', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('93228ff4dc804bb4b8e9323136275268', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('93b9da8ec69f4d5fa26d29131ba79e2b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('93f8fbe7247e432f8d6dcaa5f9a72dae', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('94fd1026e7584e3e994671fdfb88690b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('95ac1a388fcc4162963eb6d578ae0bed', NULL, 'wdwd', 'wdwd', '0df0adc5cf1b776390b1df52987b1169', '2023-06-14 10:52:38', '0df0adc5cf1b776390b1df52987b1169', NULL);
INSERT INTO `project_info` VALUES ('97c2987f530c4e398529ea0d25536e76', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('99624f5482f24b9fa80d849a5177b7a3', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('9d4c020f9dee4d24a4476b3b57f4a95d', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('9de443ffae7a4d1cabe467253094db8b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('a36f66db507f44c4a082cf4c522a7054', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('a42a8c555252419fb57d06ef573d0d5d', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('a64f0080c88e825308f259292e4279a0', '9a22828a0fdf44c4491111a2d6c57a3f', 'SSH serves to prevent such vul', 'Navicat Monitor requires a repository to store alerts and metrics for historical analysis. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connec', '9a22828a0fdf44c4491111a2d6c57a3f', '2022-02-03 07:13:47', '9a22828a0fdf44c4491111a2d6c57a3f', '2022-10-26 06:10:37');
INSERT INTO `project_info` VALUES ('a756ffe3030e4eb7ac9152b06c9d60ea', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('a98ea57cffd04c51af705061e9fe75f6', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('aaa4d3dd11b640b98efd198b88d99d98', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ac88e054e9594d46af7c0f7fea658830', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('b3c86cf32cd84a23ac4226c276eaa868', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('b6b30a4f5aae44f5a3568b83f724ae9e', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('b986b1ee43a7466182ab8eeb94c1f360', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('bc338cd3b9f1422ba377423e9b919237', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('be05583abfcb4daab4eeb60b46fa9dfe', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('c16f7d92a3b445c595ff5d13f03a9f0e', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('c29387c90f5f4bc0a4327af19e10a72b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('c2e4c654382881578b7676aa17b04688', '430331db870c632304e5c56c17c0bf63', 'Creativity is intelligence hav', 'To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external editor in Preferences.', '430331db870c632304e5c56c17c0bf63', '2022-01-08 03:24:38', '430331db870c632304e5c56c17c0bf63', '2021-08-09 12:29:33');
INSERT INTO `project_info` VALUES ('c55a2d26111e495cb6f1db49e4303e26', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('c8cac6dc101246248fc9ebe62aa55742', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('c969e06e32e148f5916aba918ed7bdca', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ca60b861e870472cbf6de8e346fc0ab3', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ca834108429542f4a3a0a40a06d58df8', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ccfddeca0c9746dea3dc8a5b03ecb123', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('cd4a037d3c494cd68589db0cb69fa42b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('cdacfa11e0e24e459573652d687cc287', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('cf0f678844c34882af90aa5283955b0f', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('d1661c5159d14ef0a238b744d0108b1f', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('d29db62a55c74e36aedc8df7b74fa25f', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('d4c2bdb9b404ba16afed7e4e1f0ec4ff', '722d2a32954d36fbe4a17075a55ddbb3', 'A man is not old until regrets', 'In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information.', '722d2a32954d36fbe4a17075a55ddbb3', '2021-06-18 03:52:03', '722d2a32954d36fbe4a17075a55ddbb3', '2020-03-13 23:32:30');
INSERT INTO `project_info` VALUES ('d62cf558834f46c9a463499183a4c129', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('d67dff609bfa421ab96d2bd5c25907f2', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('d8a908c9a3904934946db35556f3a736', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('da13ad567afd4d2392dd752e8c310007', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('dc4b4f98350c4fb9a35d7d889f1ded9f', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('dd81e052ad9645469485fc4d86a8eebf', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('dd82c7e8e9674f3e8ca468495b38ce50', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('de75df4a13f740378971b6f29cc419b6', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('e103cf12c8d046ee9f474adf54848f0f', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('e2a5043831bd4de190f3d6db10cb63e1', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('e4e643149a81417b8fb64d6c8b6cbf7b', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('e550d79f86e5450ca95310e53fc3d45e', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('e6005b6bd8d24de0aa5913b9a2b1661d', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('e67ff03908f841c1a7ed1b2693ba44b8', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ea1030d8a1d34b60876a9d148bfa1b4e', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ea47d7fd704440159e0867e70bb357cb', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('eb6363ac9ee44c5583c7d0b6d9d17f54', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ebcfc3e9966247819b07ee4e0b6641fc', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ec6a1c9e92964262b09d29ee5ecf4637', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('f27a20bdefb04c058c38ba47cd19833d', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('f30ef3a27ddc4c1999ceb304a3f82abc', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('f78308d829104f6a89ee3ee57f006b7c', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('f9fee27c7141e11d8768d615ec31f7ed', 'bbfa8aa8450edca6383ed9b5fcc11f57', 'I destroy my enemies when I ma', 'With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way.', 'bbfa8aa8450edca6383ed9b5fcc11f57', '2022-10-06 05:44:57', 'bbfa8aa8450edca6383ed9b5fcc11f57', '2022-09-29 13:09:47');
INSERT INTO `project_info` VALUES ('fc6154131d654b22805a96838769fbbc', NULL, 'test', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('fefb130daf8049ea8bd0506cf982b394', NULL, 'test1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `project_info` VALUES ('ff50f67c06fb4e498ff5d32ecf887100', NULL, 'test', NULL, NULL, NULL, NULL, NULL);

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
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `check_name` CHECK (`username` is not null)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('0df0adc5cf1b776390b1df52987b1169', 'admin', 'admin', '2020-08-27 16:01:31', '2021-06-05 14:07:49', '1', 'admin', '2022-04-07 19:45:26', 'admin', '2021-01-08 05:29:16');
INSERT INTO `user_info` VALUES ('116b29b31a4241ea8df592763bf34f62', 'user2', 'user2', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('1e70b9742d614faf93ec0d43f38bff58', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('22a5caf401e94098951cb3a685701353', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('253f5bb311154f878709f0e332a6bb54', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('2ad91316e7454e19b8d35460e29a963f', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('334cd49558da50a6ed5cf2ca9757b4d5', 'choi86', 'w2oeMj', '2022-05-14 01:33:54', '2023-04-01 05:42:17', '0', 'admin', '2021-09-24 08:08:30', 'admin', '2023-01-30 07:19:39');
INSERT INTO `user_info` VALUES ('3a421e324c4f2450a7a5aca113998bed', 'phillipscarmen6', 'd2ai08', '2021-12-14 06:48:53', '2020-02-03 16:51:07', '0', 'admin', '2022-06-08 16:03:44', 'admin', '2020-10-23 14:48:32');
INSERT INTO `user_info` VALUES ('430331db870c632304e5c56c17c0bf63', 'chankafai', 'iLhzRB', '2021-10-31 23:51:20', '2021-01-08 01:08:41', '1', 'admin', '2022-06-19 10:33:54', 'admin', '2021-06-30 19:39:12');
INSERT INTO `user_info` VALUES ('4333e031196a41cd911959f07dd57d8d', 'user2', 'user2', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('4360305807594abe81a0a9dd8d9087ea', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('45ff4b5c9f22483694d2d5729ff5fa95', 'sanoyu', 'xstgFo', '2020-05-08 04:29:52', '2022-11-21 06:59:32', '1', 'admin', '2022-06-03 14:54:06', 'admin', '2021-09-23 10:17:28');
INSERT INTO `user_info` VALUES ('48a2169e64a84785a2b93aa52a679657', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('49c408e31b8a48bd5ffac766c837e070', 'stewartedna', 'ZUzMy1', '2020-05-24 21:35:50', '2022-07-19 19:58:06', '1', 'admin', '2020-11-30 17:32:07', 'admin', '2020-07-20 15:46:57');
INSERT INTO `user_info` VALUES ('4fa7412f00664b2a91a927158a4e6df8', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('5e94d72bd09249f1939dea30063a8899', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('704ecef7168f7ef27544febf2b7303ff', 'arayuna7', 'ihrocI', '2022-07-12 01:00:37', '2021-04-18 20:18:14', '1', 'admin', '2021-05-02 22:00:56', 'admin', '2021-04-25 00:07:22');
INSERT INTO `user_info` VALUES ('722d2a32954d36fbe4a17075a55ddbb3', 'angelastone', 'W2ZE2U', '2021-05-10 12:54:53', '2022-03-22 03:59:12', '0', 'admin', '2020-10-09 09:26:31', 'admin', '2022-01-10 08:47:11');
INSERT INTO `user_info` VALUES ('8e9ad7aed54946d29f8a2b6f9c637992', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('9018c8cb357333da02a3c4d62e7f1c3c', 'ono3', 'Y0BD2N', '2022-06-22 07:11:42', '2021-02-10 14:16:33', '1', 'admin', '2020-09-24 19:11:20', 'admin', '2021-04-25 17:52:56');
INSERT INTO `user_info` VALUES ('90deb7f8963928569affa2796414c9f6', 'dai07', 'XYCc6X', '2021-01-05 03:20:21', '2020-10-19 07:44:41', '1', 'admin', '2021-08-08 11:42:00', 'admin', '2023-06-03 18:39:08');
INSERT INTO `user_info` VALUES ('98655ba79eb7446c9f74acc3f49ab556', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('990ffb21540feac0b77d9d5e66cc2207', 'kaede', 'DRNXvM', '2020-06-23 02:51:53', '2023-06-14 11:06:10', '0', 'admin', '2023-05-16 17:33:53', 'admin', '2020-04-20 11:57:42');
INSERT INTO `user_info` VALUES ('9a22828a0fdf44c4491111a2d6c57a3f', 'miyazakise', 'DrOW3h', '2022-10-10 23:42:00', '2021-10-12 14:44:31', '1', 'admin', '2020-08-01 07:43:50', 'admin', '2021-09-27 06:07:58');
INSERT INTO `user_info` VALUES ('9f9f7ab0ab324b3c9ae81e223fafd723', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('a2fc41b11c424041ac02d9b8b6ebfec3', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('a63ce26d0fa3cc5806043cc0a44475fe', 'stakuya', 'x8bzIv', '2020-08-31 13:21:42', '2023-01-05 22:45:29', '1', 'admin', '2020-09-23 15:57:17', 'admin', '2022-09-26 09:01:29');
INSERT INTO `user_info` VALUES ('a876251c0797ef86b7ae78fe677826f8', 'yyuna62', 'EBaxUb', '2023-04-21 16:11:47', '2021-07-22 22:32:06', '1', 'admin', '2021-09-08 13:52:02', 'admin', '2023-04-13 04:56:36');
INSERT INTO `user_info` VALUES ('aa00c15904344e4ca342cb60d73b515f', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('b74d24fa0b764395ba78315f9986b290', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('bab202c84b4600c89cfc7c929b0ca120', 'jonathanmend1004', 'lvy4ti', '2022-06-14 07:02:01', '2021-10-07 19:24:29', '0', 'admin', '2021-07-10 13:42:25', 'admin', '2022-04-24 03:50:28');
INSERT INTO `user_info` VALUES ('bbfa8aa8450edca6383ed9b5fcc11f57', 'tssw', 'm74on5', '2020-05-09 19:47:04', '2022-06-14 18:49:12', '0', 'admin', '2021-10-09 10:14:22', 'admin', '2021-09-28 01:58:17');
INSERT INTO `user_info` VALUES ('d16ed656f0664bd88671e1275de049fe', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('d2bf605e2ecd401fa263a4af05b0af62', 'user1', 'user1', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('d30d775d44184184834e35b5b18ef00c', 'user1', 'user1', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('ddd7f60949184fd9b095b24452ac3934', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('dec7b646629443f982bdecc1434e9efe', 'user1', 'user1', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('e0cf3b115766427b805d5be3fc0b29cc', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('e30d781cde5648e2b62e58f63d3a83fb', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('e4e44cb5ecd83db768ed088c7310f16f', 'lokon', 'mEKH19', '2022-09-08 07:58:31', '2022-02-04 22:47:41', '0', 'admin', '2022-03-15 22:55:58', 'admin', '2020-10-29 18:01:38');
INSERT INTO `user_info` VALUES ('f059f4ecbf64c3c945d3fb94c0cfa5ac', 'moriy', 'mAZQDn', '2021-06-12 18:20:39', '2022-08-03 23:55:13', '1', 'admin', '2020-08-21 05:39:03', 'admin', '2020-06-27 07:33:17');
INSERT INTO `user_info` VALUES ('f837cafb8e9848ab8b64b0819677a05c', 'LS', '123', NULL, NULL, '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('fadc81f986f6fddee6aa5274b47ef503', 'kuyf', 'q2iSs6', '2020-11-09 11:08:56', '2022-12-06 08:51:21', '0', 'admin', '2022-09-22 22:06:18', 'admin', '2022-06-30 22:29:47');

SET FOREIGN_KEY_CHECKS = 1;
