/*
MySQL Backup
Source Server Version: 5.1.32
Source Database: eatledb
Date: 2012-10-13 13:42:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_community`
-- ----------------------------
DROP TABLE IF EXISTS `t_community`;
CREATE TABLE `t_community` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL COMMENT '社区片区名',
  `pinyin_name` varchar(100) DEFAULT NULL COMMENT '拼音名',
  `hot` int(11) DEFAULT NULL COMMENT '热门度',
  `district_id` bigint(20) DEFAULT NULL COMMENT '区域id',
  PRIMARY KEY (`id`),
  KEY `distinct_id` (`district_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='社区（片区或小区）表';

-- ----------------------------
--  Table structure for `t_community_restaurant`
-- ----------------------------
DROP TABLE IF EXISTS `t_community_restaurant`;
CREATE TABLE `t_community_restaurant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `community_id` bigint(20) DEFAULT NULL COMMENT '/¥ID',
  `restaurant_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='/¥̼ҹԼ̼ҵ/¥Ͳ͵ͼ۸';

-- ----------------------------
--  Table structure for `t_district`
-- ----------------------------
DROP TABLE IF EXISTS `t_district`;
CREATE TABLE `t_district` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL COMMENT '名称',
  `pinyin_name` varchar(100) DEFAULT NULL COMMENT '拼音名',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='省、市、区 表....';

-- ----------------------------
--  Table structure for `t_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant`;
CREATE TABLE `t_merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '̼id',
  `merchant_name` varchar(50) DEFAULT NULL,
  `merchant_phone` varchar(15) DEFAULT NULL,
  `merchant_email` varchar(50) DEFAULT NULL,
  `merchant_address` varchar(100) DEFAULT NULL,
  `merchant_logo_url` varchar(200) DEFAULT NULL,
  `merchant_join_time` date DEFAULT NULL,
  `legal_name` varchar(50) DEFAULT NULL COMMENT '̼ҷ',
  `legal_id_card` varchar(30) DEFAULT NULL,
  `legal_phone` varchar(15) DEFAULT NULL,
  `legal_home_address` varchar(100) DEFAULT NULL COMMENT '̼ҷ˼ͥסַ',
  `legal_address` varchar(100) DEFAULT NULL COMMENT '̼ҷϵַ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='̼ұ';

-- ----------------------------
--  Table structure for `t_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `priv_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `meue_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名称',
  `action` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '动作指令',
  `description` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '权限描述',
  `is_show` tinyint(4) DEFAULT '0' COMMENT '是否显示',
  `pid` bigint(20) DEFAULT NULL COMMENT '父权限ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
--  Table structure for `t_restaurant`
-- ----------------------------
DROP TABLE IF EXISTS `t_restaurant`;
CREATE TABLE `t_restaurant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '',
  `send_meals_speeding` varchar(20) DEFAULT NULL COMMENT 'Ͳٶ',
  `send_up_price` varchar(200) DEFAULT NULL COMMENT 'ͼ',
  `send_meals_description` varchar(200) DEFAULT NULL COMMENT 'Ͳ˵',
  `send_meals_status` smallint(6) DEFAULT NULL COMMENT 'Ͳ״̬(0ȣ1Ϣ2æ3)',
  `business_hours` varchar(100) DEFAULT NULL COMMENT 'Ӫҵʱ',
  `address` varchar(100) DEFAULT NULL COMMENT 'ַ',
  `logo_url` varchar(200) DEFAULT NULL COMMENT 'logo_url',
  `contact_name` varchar(20) DEFAULT NULL COMMENT 'ϵ',
  `contact_phone` varchar(50) DEFAULT NULL COMMENT 'ϵ绰',
  `contact_email` varchar(50) DEFAULT NULL COMMENT 'ϵ',
  `contact_qq` varchar(20) DEFAULT NULL COMMENT 'ϵQQ',
  `merchant_id` bigint(20) DEFAULT NULL COMMENT '̼id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='';

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

-- ----------------------------
--  Table structure for `t_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `priv_id` bigint(20) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`),
  KEY `priv_id` (`priv_id`),
  KEY `role_id` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=185 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色与权限关联表';

-- ----------------------------
--  Table structure for `t_school`
-- ----------------------------
DROP TABLE IF EXISTS `t_school`;
CREATE TABLE `t_school` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `english_name` varchar(100) DEFAULT NULL COMMENT '英文名',
  `hot` int(11) DEFAULT NULL COMMENT '热门度',
  `district_id` bigint(20) DEFAULT NULL COMMENT '区域id',
  PRIMARY KEY (`id`),
  KEY `distinct_id` (`district_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='学校表';

-- ----------------------------
--  Table structure for `t_school_restaurant`
-- ----------------------------
DROP TABLE IF EXISTS `t_school_restaurant`;
CREATE TABLE `t_school_restaurant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `school_id` bigint(20) DEFAULT NULL COMMENT 'ѧУID',
  `restaurant_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ѧУ̼ҹԼ̼ҵѧУͲ͵ͼ۸';

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `pwd` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `type` tinyint(4) NOT NULL COMMENT '用户类型（0：管理员，1：商家）',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_community` VALUES ('4','花果小区','huaguoxiaoqu',NULL,'23'), ('5','金砂水岸','jinshashuian',NULL,'48'), ('6','水星科技大厦','shuixing',NULL,'47');
INSERT INTO `t_district` VALUES ('1','北京市','beijing',NULL), ('2','天津市','tianjin',NULL), ('3','重庆市','chongqing',NULL), ('4','上海市','shanghai',NULL), ('5','湖南省','hunan',NULL), ('6','广东省','guangdong',NULL), ('11','湘潭市','xt','5'), ('8','海淀区','hd','40'), ('9','朝阳区','cy','40'), ('10','长沙市','cs','5'), ('12','株洲市','zz','5'), ('14','广州市','gz','6'), ('15','深圳市','sz','6'), ('39','两路','lianglu','26'), ('17','南山区','nanshanqu','15'), ('19','罗湖','luohu','17'), ('20','江北区','jiangbei','44'), ('23','观音桥','guanyinqiao','20'), ('24','五里店','wulidian','20'), ('25','南岸区','nanan','44'), ('26','渝北区','yubei','44'), ('27','渝中区','yuzhong','44'), ('28','沙坪坝区','shapingba','44'), ('29','北碚区','beibei','44'), ('30','巴南区','banan','44'), ('31','九龙坡区','jiulongpo','44'), ('32','大渡口区','dadukou','44'), ('33','中山市','zhongshan','6'), ('34','汕头市','shantou','6'), ('35','清远市','qingyuan','6'), ('36','韶关市','shaoguan','6'), ('37','大学城','daxuecheng','28'), ('45','北部新区','beibuxinqu','44'), ('40','北京市','beijing','1'), ('42','天津市','tianjin','2'), ('43','上海市','shanghai','4'), ('44','重庆市','chongqing','3'), ('46','两江新区','liangjiangxinqu','44'), ('47','软件园','ruanjianyuan','45'), ('48','北滨路','beibinlu','20'), ('49','浦东区','pudong','43'), ('51','浙江省','zhejiang',NULL), ('52','湖北省','hubei',NULL);
INSERT INTO `t_merchant` VALUES ('1','肯德基',NULL,NULL,NULL,'/logo/logo_merchant/81eef186-938a-4433-a5cd-f97870bd5fb2.jpg','2012-10-01',NULL,NULL,NULL,NULL,NULL), ('2','麦当劳',NULL,NULL,NULL,'/logo/logo_merchant/6fc28511-1292-41a1-b245-dbe5c10e28bc.gif','2012-10-03',NULL,NULL,NULL,NULL,NULL), ('3','乡村基',NULL,NULL,NULL,'/logo/logo_merchant/34eef354-3428-41e9-a2b6-e8e668e70b3f.jpg','2012-10-19',NULL,NULL,NULL,NULL,NULL), ('8','A','A','A','A','/logo/logo_merchant/8abb2e9c-83af-41ed-83c0-9fdf63e7f785.jpg','2012-10-10','A','A','A','A','A'), ('9','W','W','W','W','/logo/logo_merchant/7ec0f67d-89fb-4cbe-9df4-d9b12f3118c6.jpg','2012-10-08','W','W','W','W','W'), ('10','1','1','1','1','/logo/logo_merchant/67b4bb05-9770-44ec-b5e2-654225a71d28.JPG','2012-10-10','1','1','1','1','1');
INSERT INTO `t_privilege` VALUES ('1','系统管理','系统管理','admin/system','','1',NULL), ('2','用户管理权限','用户管理','admin/system/useradmin','','1','1'), ('118','后台用户操作日志','后台用户操作日志','admin/system/systemdata/backendoperatorlog','','1','117'), ('4','权限管理权限','权限管理','admin/system/useradmin/priv/showIndex.htm','','1','2'), ('5','功能设置权限','功能设置','func_mgr','','1','3'), ('6','执行权限搜索',NULL,'zxqxss',NULL,'0','4'), ('7','添加权限展示','','tjqxzs','xx',NULL,'4'), ('8','执行权限添加',NULL,'zxqxtj',NULL,'0','4'), ('9','角色管理权限','角色管理','admin/system/useradmin/role/showIndex.htm','','1','2'), ('10','执行角色搜索',NULL,'zxjsss',NULL,'0','9'), ('11','添加角色展示',NULL,'tjjszs',NULL,'0','9'), ('12','执行角色添加',NULL,'zxjstj',NULL,'0','9'), ('13','执行角色删除',NULL,'zxjssc',NULL,'0','9'), ('14','修改角色展示',NULL,'xgjszs',NULL,'0','9'), ('15','执行角色修改',NULL,'zxjsxg',NULL,'0','9'), ('16','权限分配展示',NULL,'qxfpzs',NULL,'0','9'), ('17','执行权限分配',NULL,'zxqxfp',NULL,'0','9'), ('18','子权限列表展示',NULL,'zqxlbzs',NULL,'0','4'), ('19','执行权限删除',NULL,'zxqxsc',NULL,'0','4'), ('20','修改权限展示',NULL,'xgqxzs',NULL,'0','4'), ('21','执行权限修改',NULL,'zxqxxg',NULL,'0','4'), ('22','账号管理权限','账号管理','admin/system/useradmin/account/showIndex.htm','','1','2'), ('23','执行账号搜索',NULL,'zxzhss',NULL,'0','22'), ('24','添加账号展示',NULL,'tjzhzs',NULL,'0','22'), ('25','执行账号添加',NULL,'zxzhtj',NULL,'0','22'), ('26','执行账号删除',NULL,'zxzhsc',NULL,'0','22'), ('27','修改账号展示',NULL,'xgzhzs',NULL,'0','22'), ('28','执行账号修改',NULL,'zxzhxg',NULL,'0','22'), ('117','系统数据','系统数据','admin/system/systemdata','','1','1'), ('34','导出账号Excel',NULL,'dzzhexcel',NULL,'0','22'), ('110','基础数据','基础数据','admin/foundation','','1',NULL), ('111','区域管理','区域管理','admin/foundation/place/district/showIndex.htm','','1','120'), ('112','学校管理','学校管理','admin/foundation/place/school/showIndex.htm','','1','120'), ('113','社区管理','社区管理','admin/foundation/place/community/showIndex.htm','','1','120'), ('114','商家管理','商家管理','admin/merchant','','1',NULL), ('115','订单管理','订单管理','admin/order','','1',NULL), ('116','顾客管理','顾客管理','admin/customer','','1',NULL), ('119','前台用户操作日志','前台用户操作日志','admin/system/systemdata/frontuseroperatorlog','','1','117'), ('120','区域/学校/社区关联管理','区域/学校/社区','admin/foundation/place','','1','110'), ('125','商家列表','商家列表','admin/merchant/list/showIndex.htm','','1','114');
INSERT INTO `t_restaurant` VALUES ('1','肯德基观音桥分店',NULL,NULL,NULL,NULL,NULL,'江北区观音桥北城天街',NULL,NULL,NULL,NULL,NULL,'1'), ('2','肯德基观音桥分店',NULL,NULL,NULL,NULL,NULL,'江北区观音桥北城天街',NULL,NULL,NULL,NULL,NULL,NULL), ('3','肯德基观音桥分店',NULL,NULL,NULL,NULL,NULL,'江北区观音桥北城天街',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `t_role` VALUES ('2','超级管理员','负责对系统的维护'), ('3','编辑员','餐厅的编辑员负责对菜单进行管理'), ('6','商家','餐厅老板管理自己的餐厅'), ('13','营业员','餐厅的营业员负责查看实时订单'), ('14','xx','xx');
INSERT INTO `t_role_privilege` VALUES ('1','2','1'), ('2','2','2'), ('3','2','3'), ('4','2','4'), ('6','2','6'), ('7','2','7'), ('8','2','8'), ('9','2','9'), ('10','2','10'), ('11','2','11'), ('12','2','12'), ('13','2','13'), ('14','2','14'), ('15','2','15'), ('16','2','16'), ('17','2','17'), ('18','2','18'), ('19','2','19'), ('20','2','20'), ('21','2','21'), ('22','2','22'), ('23','2','23'), ('24','2','24'), ('25','2','25'), ('26','2','26'), ('27','2','27'), ('28','2','28'), ('29','2','29'), ('30','2','30'), ('31','2','31'), ('32','2','32'), ('33','2','33'), ('34','2','34'), ('45','3','3'), ('93','6','1'), ('94','6','2'), ('95','6','4'), ('96','6','6'), ('97','6','7'), ('98','6','8'), ('99','6','18'), ('100','6','19'), ('101','6','20'), ('102','6','21'), ('103','6','9'), ('104','6','10'), ('105','6','11'), ('106','6','12'), ('107','6','13'), ('108','6','14'), ('109','6','15'), ('110','6','16'), ('111','6','17'), ('112','6','22'), ('113','6','23'), ('114','6','24'), ('115','6','25'), ('116','6','26'), ('117','6','27'), ('118','6','28'), ('119','6','34'), ('120','6','3'), ('121','6','5'), ('122','6','29'), ('123','6','30'), ('124','6','31'), ('125','6','32'), ('126','6','33'), ('127','13','4'), ('128','13','6'), ('129','13','7'), ('130','13','9'), ('131','13','10'), ('132','3','1'), ('133','3','2'), ('134','3','4'), ('135','3','6'), ('136','3','7'), ('137','3','8'), ('138','3','18'), ('139','3','19'), ('140','3','20'), ('141','3','21'), ('142','3','9'), ('143','3','10'), ('144','3','11'), ('145','3','12'), ('146','3','13'), ('147','3','14'), ('148','3','15'), ('149','3','16'), ('150','3','17'), ('151','3','22'), ('152','3','23'), ('153','3','24'), ('154','3','25'), ('155','3','26'), ('156','3','27'), ('157','3','28'), ('158','3','34');
INSERT INTO `t_role_privilege` VALUES ('159','3','5'), ('160','3','29'), ('161','3','30'), ('162','3','31'), ('163','3','32'), ('164','3','33'), ('165','2','110'), ('166','2','111'), ('167','2','112'), ('168','2','113'), ('169','14','18'), ('170','15','4'), ('171','15','6'), ('172','15','7'), ('173','15','8'), ('174','15','18'), ('175','15','19'), ('176','15','20'), ('177','15','21'), ('178','2','117'), ('179','2','118'), ('180','2','119'), ('181','2','114'), ('182','2','125'), ('183','2','115'), ('184','2','116');
INSERT INTO `t_school` VALUES ('3','重庆大学','Chongqing University',NULL,'37'), ('4','重庆师范大学','Chongqing Normal University',NULL,'37'), ('7','重庆电子工程学院','Chongqing College Of Electronic Engineering',NULL,'37'), ('8','西南大学','North-West University',NULL,'39');
INSERT INTO `t_user` VALUES ('4','谭绍清','123','453674398@qq.com','1','3'), ('5','谭又中','123','453674398@qq.com','1','2'), ('6','周星星','123','zxx@zxx.com','1','13'), ('7','xt','1','xiangtao@xt.com','1','2');
