/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : eatledb

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2012-09-16 13:23:13
*/

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', 'sys_mgr', 'sys_mgr', '系统管理', '', '0');
INSERT INTO `t_menu` VALUES ('2', 'user_mgr', 'user_mgr', '用户管理', '', '1');
INSERT INTO `t_menu` VALUES ('3', 'account_mgr', 'account_mgr', '账号管理', 'system/useradmin/account/showIndex.htm', '2');
INSERT INTO `t_menu` VALUES ('4', 'role_mgr', 'role_mgr', '角色管理', 'system/useradmin/role/showIndex.htm', '2');
INSERT INTO `t_menu` VALUES ('7', 'base_data', 'base_data', '基础数据', '', '1');
INSERT INTO `t_menu` VALUES ('8', 'func_mgr', 'func_mgr', '功能设置', 'system/menu/showIndex.htm', '7');
INSERT INTO `t_menu` VALUES ('9', 'priv_mgr', 'priv_mgr', '权限管理', 'system/useradmin/priv/showIndex.htm', '2');


-- ----------------------------
-- Records of t_privilege
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('1', '系统管理权限', '系统管理', 'sys_mgr', null, '0', null);
INSERT INTO `t_privilege` VALUES ('2', '用户管理权限', '用户管理', 'user_mgr', null, '0', '1');
INSERT INTO `t_privilege` VALUES ('3', '基础数据权限', '基础数据', 'base_data', '', null, null);
INSERT INTO `t_privilege` VALUES ('4', '权限管理权限', '权限管理', 'priv_mgr', null, '0', '2');
INSERT INTO `t_privilege` VALUES ('5', '功能设置权限', '功能设置', 'func_mgr', '', '0', '3');
INSERT INTO `t_privilege` VALUES ('6', '执行权限搜索', null, 'zxqxss', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('7', '添加权限展示', null, 'tjqxzs', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('8', '执行权限添加', null, 'zxqxtj', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('9', '角色管理权限', '角色管理', 'role_mgr', null, '0', '2');
INSERT INTO `t_privilege` VALUES ('10', '执行角色搜索', null, 'zxjsss', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('11', '添加角色展示', null, 'tjjszs', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('12', '执行角色添加', null, 'zxjstj', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('13', '执行角色删除', null, 'zxjssc', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('14', '修改角色展示', null, 'xgjszs', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('15', '执行角色修改', null, 'zxjsxg', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('16', '权限分配展示', null, 'qxfpzs', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('17', '执行权限分配', null, 'zxqxfp', null, '0', '9');
INSERT INTO `t_privilege` VALUES ('18', '子权限列表展示', null, 'zqxlbzs', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('19', '执行权限删除', null, 'zxqxsc', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('20', '修改权限展示', null, 'xgqxzs', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('21', '执行权限修改', null, 'zxqxxg', null, '0', '4');
INSERT INTO `t_privilege` VALUES ('22', '账号管理权限', '账号管理', 'account_mgr', null, '0', '2');
INSERT INTO `t_privilege` VALUES ('23', '执行账号搜索', null, 'zxzhss', null, '0', '22');
INSERT INTO `t_privilege` VALUES ('24', '添加账号展示', null, 'tjzhzs', null, '0', '22');
INSERT INTO `t_privilege` VALUES ('25', '执行账号添加', null, 'zxzhtj', null, '0', '22');
INSERT INTO `t_privilege` VALUES ('26', '执行账号删除', null, 'zxzhsc', null, '0', '22');
INSERT INTO `t_privilege` VALUES ('27', '修改账号展示', null, 'xgzhzs', null, '0', '22');
INSERT INTO `t_privilege` VALUES ('28', '执行账号修改', null, 'zxzhxg', null, '0', '22');
INSERT INTO `t_privilege` VALUES ('29', '执行功能修改', null, 'zxgnxg', null, '0', '5');
INSERT INTO `t_privilege` VALUES ('30', '修改功能展示', null, 'xggnzs', null, '0', '5');
INSERT INTO `t_privilege` VALUES ('31', '执行功能删除', null, 'zxgnsc', null, '0', '5');
INSERT INTO `t_privilege` VALUES ('32', '执行功能添加', '', 'zxgntj', '', null, null);
INSERT INTO `t_privilege` VALUES ('33', '添加功能展示', null, 'tjgnzs', null, '0', '5');
INSERT INTO `t_privilege` VALUES ('34', '导出账号Excel', null, 'dzzhexcel', null, '0', '22');

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('2', '超级管理员', '负责对系统的维护');
INSERT INTO `t_role` VALUES ('3', '编辑员', '餐厅的编辑员负责对菜单进行管理');
INSERT INTO `t_role` VALUES ('6', '商家', '餐厅老板管理自己的餐厅');
INSERT INTO `t_role` VALUES ('13', '营业员', '餐厅的营业员负责查看实时订单');


-- ----------------------------
-- Records of t_role_privilege
-- ----------------------------
INSERT INTO `t_role_privilege` VALUES ('1', '2', '1');
INSERT INTO `t_role_privilege` VALUES ('2', '2', '2');
INSERT INTO `t_role_privilege` VALUES ('3', '2', '3');
INSERT INTO `t_role_privilege` VALUES ('4', '2', '4');
INSERT INTO `t_role_privilege` VALUES ('5', '2', '5');
INSERT INTO `t_role_privilege` VALUES ('6', '2', '6');
INSERT INTO `t_role_privilege` VALUES ('7', '2', '7');
INSERT INTO `t_role_privilege` VALUES ('8', '2', '8');
INSERT INTO `t_role_privilege` VALUES ('9', '2', '9');
INSERT INTO `t_role_privilege` VALUES ('10', '2', '10');
INSERT INTO `t_role_privilege` VALUES ('11', '2', '11');
INSERT INTO `t_role_privilege` VALUES ('12', '2', '12');
INSERT INTO `t_role_privilege` VALUES ('13', '2', '13');
INSERT INTO `t_role_privilege` VALUES ('14', '2', '14');
INSERT INTO `t_role_privilege` VALUES ('15', '2', '15');
INSERT INTO `t_role_privilege` VALUES ('16', '2', '16');
INSERT INTO `t_role_privilege` VALUES ('17', '2', '17');
INSERT INTO `t_role_privilege` VALUES ('18', '2', '18');
INSERT INTO `t_role_privilege` VALUES ('19', '2', '19');
INSERT INTO `t_role_privilege` VALUES ('20', '2', '20');
INSERT INTO `t_role_privilege` VALUES ('21', '2', '21');
INSERT INTO `t_role_privilege` VALUES ('22', '2', '22');
INSERT INTO `t_role_privilege` VALUES ('23', '2', '23');
INSERT INTO `t_role_privilege` VALUES ('24', '2', '24');
INSERT INTO `t_role_privilege` VALUES ('25', '2', '25');
INSERT INTO `t_role_privilege` VALUES ('26', '2', '26');
INSERT INTO `t_role_privilege` VALUES ('27', '2', '27');
INSERT INTO `t_role_privilege` VALUES ('28', '2', '28');
INSERT INTO `t_role_privilege` VALUES ('29', '2', '29');
INSERT INTO `t_role_privilege` VALUES ('30', '2', '30');
INSERT INTO `t_role_privilege` VALUES ('31', '2', '31');
INSERT INTO `t_role_privilege` VALUES ('32', '2', '32');
INSERT INTO `t_role_privilege` VALUES ('33', '2', '33');
INSERT INTO `t_role_privilege` VALUES ('34', '2', '34');
INSERT INTO `t_role_privilege` VALUES ('45', '3', '3');
INSERT INTO `t_role_privilege` VALUES ('93', '6', '1');
INSERT INTO `t_role_privilege` VALUES ('94', '6', '2');
INSERT INTO `t_role_privilege` VALUES ('95', '6', '4');
INSERT INTO `t_role_privilege` VALUES ('96', '6', '6');
INSERT INTO `t_role_privilege` VALUES ('97', '6', '7');
INSERT INTO `t_role_privilege` VALUES ('98', '6', '8');
INSERT INTO `t_role_privilege` VALUES ('99', '6', '18');
INSERT INTO `t_role_privilege` VALUES ('100', '6', '19');
INSERT INTO `t_role_privilege` VALUES ('101', '6', '20');
INSERT INTO `t_role_privilege` VALUES ('102', '6', '21');
INSERT INTO `t_role_privilege` VALUES ('103', '6', '9');
INSERT INTO `t_role_privilege` VALUES ('104', '6', '10');
INSERT INTO `t_role_privilege` VALUES ('105', '6', '11');
INSERT INTO `t_role_privilege` VALUES ('106', '6', '12');
INSERT INTO `t_role_privilege` VALUES ('107', '6', '13');
INSERT INTO `t_role_privilege` VALUES ('108', '6', '14');
INSERT INTO `t_role_privilege` VALUES ('109', '6', '15');
INSERT INTO `t_role_privilege` VALUES ('110', '6', '16');
INSERT INTO `t_role_privilege` VALUES ('111', '6', '17');
INSERT INTO `t_role_privilege` VALUES ('112', '6', '22');
INSERT INTO `t_role_privilege` VALUES ('113', '6', '23');
INSERT INTO `t_role_privilege` VALUES ('114', '6', '24');
INSERT INTO `t_role_privilege` VALUES ('115', '6', '25');
INSERT INTO `t_role_privilege` VALUES ('116', '6', '26');
INSERT INTO `t_role_privilege` VALUES ('117', '6', '27');
INSERT INTO `t_role_privilege` VALUES ('118', '6', '28');
INSERT INTO `t_role_privilege` VALUES ('119', '6', '34');
INSERT INTO `t_role_privilege` VALUES ('120', '6', '3');
INSERT INTO `t_role_privilege` VALUES ('121', '6', '5');
INSERT INTO `t_role_privilege` VALUES ('122', '6', '29');
INSERT INTO `t_role_privilege` VALUES ('123', '6', '30');
INSERT INTO `t_role_privilege` VALUES ('124', '6', '31');
INSERT INTO `t_role_privilege` VALUES ('125', '6', '32');
INSERT INTO `t_role_privilege` VALUES ('126', '6', '33');
INSERT INTO `t_role_privilege` VALUES ('127', '13', '4');
INSERT INTO `t_role_privilege` VALUES ('128', '13', '6');
INSERT INTO `t_role_privilege` VALUES ('129', '13', '7');
INSERT INTO `t_role_privilege` VALUES ('130', '13', '9');
INSERT INTO `t_role_privilege` VALUES ('131', '13', '10');
INSERT INTO `t_role_privilege` VALUES ('132', '3', '1');
INSERT INTO `t_role_privilege` VALUES ('133', '3', '2');
INSERT INTO `t_role_privilege` VALUES ('134', '3', '4');
INSERT INTO `t_role_privilege` VALUES ('135', '3', '6');
INSERT INTO `t_role_privilege` VALUES ('136', '3', '7');
INSERT INTO `t_role_privilege` VALUES ('137', '3', '8');
INSERT INTO `t_role_privilege` VALUES ('138', '3', '18');
INSERT INTO `t_role_privilege` VALUES ('139', '3', '19');
INSERT INTO `t_role_privilege` VALUES ('140', '3', '20');
INSERT INTO `t_role_privilege` VALUES ('141', '3', '21');
INSERT INTO `t_role_privilege` VALUES ('142', '3', '9');
INSERT INTO `t_role_privilege` VALUES ('143', '3', '10');
INSERT INTO `t_role_privilege` VALUES ('144', '3', '11');
INSERT INTO `t_role_privilege` VALUES ('145', '3', '12');
INSERT INTO `t_role_privilege` VALUES ('146', '3', '13');
INSERT INTO `t_role_privilege` VALUES ('147', '3', '14');
INSERT INTO `t_role_privilege` VALUES ('148', '3', '15');
INSERT INTO `t_role_privilege` VALUES ('149', '3', '16');
INSERT INTO `t_role_privilege` VALUES ('150', '3', '17');
INSERT INTO `t_role_privilege` VALUES ('151', '3', '22');
INSERT INTO `t_role_privilege` VALUES ('152', '3', '23');
INSERT INTO `t_role_privilege` VALUES ('153', '3', '24');
INSERT INTO `t_role_privilege` VALUES ('154', '3', '25');
INSERT INTO `t_role_privilege` VALUES ('155', '3', '26');
INSERT INTO `t_role_privilege` VALUES ('156', '3', '27');
INSERT INTO `t_role_privilege` VALUES ('157', '3', '28');
INSERT INTO `t_role_privilege` VALUES ('158', '3', '34');
INSERT INTO `t_role_privilege` VALUES ('159', '3', '5');
INSERT INTO `t_role_privilege` VALUES ('160', '3', '29');
INSERT INTO `t_role_privilege` VALUES ('161', '3', '30');
INSERT INTO `t_role_privilege` VALUES ('162', '3', '31');
INSERT INTO `t_role_privilege` VALUES ('163', '3', '32');
INSERT INTO `t_role_privilege` VALUES ('164', '3', '33');


-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('4', '谭绍清', '123', '453674398@qq.com', '1', '3');
INSERT INTO `t_user` VALUES ('5', '谭又中', '123', '453674398@qq.com', '1', '2');
INSERT INTO `t_user` VALUES ('6', '周星星', '123', 'zxx@zxx.com', '1', '13');
INSERT INTO `t_user` VALUES ('7', '向滔', '123', 'xiangtao@xt.com', '1', '2');
