/*
MySQL Backup
Source Server Version: 5.1.32
Source Database: eatledb
Date: 2012-10-28 12:24:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_convert_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_convert_goods`;
CREATE TABLE `t_convert_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `describe` varchar(200) DEFAULT NULL,
  `pic_url` varchar(200) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `surplus` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='可以兑换的商品';

-- ----------------------------
--  Table structure for `t_convert_records`
-- ----------------------------
DROP TABLE IF EXISTS `t_convert_records`;
CREATE TABLE `t_convert_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'һƷID',
  `convert_count` int(11) DEFAULT NULL COMMENT 'һ',
  `convert_time` datetime DEFAULT NULL COMMENT 'һʱ',
  `cost_score` int(11) DEFAULT NULL COMMENT 'ѻ',
  `customer_id` bigint(20) DEFAULT NULL COMMENT 'һߣ˿ͣID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ֶһƷ¼';

-- ----------------------------
--  Table structure for `t_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text COMMENT '',
  `email` varchar(40) DEFAULT NULL COMMENT 'ϵʼ',
  `identify_type` smallint(6) DEFAULT NULL COMMENT 'ͣ0̼ң1˿ͣ2Ա',
  `identify_id` int(11) DEFAULT NULL COMMENT 'ID',
  `sub_time` datetime DEFAULT NULL COMMENT 'ύʱ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='';

-- ----------------------------
--  Table structure for `t_join_information`
-- ----------------------------
DROP TABLE IF EXISTS `t_join_information`;
CREATE TABLE `t_join_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_place` text COMMENT 'Ͳ͵ص',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '̵',
  `shop_addr` varchar(100) DEFAULT NULL COMMENT '̵ַ',
  `link_man` varchar(20) DEFAULT NULL,
  `link_tel` varchar(15) DEFAULT NULL COMMENT 'ϵ绰',
  `link_email` varchar(40) DEFAULT NULL COMMENT 'ϵ˵ʼ',
  `link_qq` varchar(15) DEFAULT NULL COMMENT 'ϵQQ',
  `sub_time` datetime DEFAULT NULL COMMENT 'ύʱ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ϵϢ';

-- ----------------------------
--  Table structure for `t_menu_feature`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_feature`;
CREATE TABLE `t_menu_feature` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `feature` varchar(20) DEFAULT NULL COMMENT 'Ա',
  `image_url` varchar(200) DEFAULT NULL COMMENT 'ԱʶͼƬURL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ʒֵ';

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
) ENGINE=MyISAM AUTO_INCREMENT=146 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
--  Table structure for `t_recommend_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `t_recommend_merchant`;
CREATE TABLE `t_recommend_merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) DEFAULT NULL COMMENT '',
  `shop_tel` varchar(15) DEFAULT NULL COMMENT '绰',
  `shop_addr` varchar(200) DEFAULT NULL COMMENT 'ַ',
  `sub_time` datetime DEFAULT NULL COMMENT 'ύʱ',
  `customer_id` bigint(20) DEFAULT NULL COMMENT 'Ƽ˿ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='˿Ƽ̼Ϣ';

-- ----------------------------
--  Table structure for `t_send_remark`
-- ----------------------------
DROP TABLE IF EXISTS `t_send_remark`;
CREATE TABLE `t_send_remark` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `word` varchar(50) DEFAULT NULL COMMENT 'ע',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='еͲͱעֵ';

-- ----------------------------
--  Table structure for `t_shop_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_type`;
CREATE TABLE `t_shop_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL COMMENT '',
  `type_identify` varchar(10) DEFAULT NULL COMMENT 'ͱʶ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='̵ҪӪֵ';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('1','系统管理','系统管理','admin/system','','1',NULL), ('2','权限系统管理','权限系统管理','admin/system/useradmin','','1','1'), ('118','系统信息','系统信息','admin/system/systemdata/systeminfo/showIndex.htm','','1','117'), ('4','权限管理权限','权限管理','admin/system/useradmin/priv/showIndex.htm','','1','2'), ('5','功能设置权限','功能设置','func_mgr','','1','3'), ('6','执行权限搜索',NULL,'zxqxss',NULL,'0','4'), ('7','添加权限展示','','tjqxzs','xx',NULL,'4'), ('8','执行权限添加',NULL,'zxqxtj',NULL,'0','4'), ('9','角色管理权限','角色管理','admin/system/useradmin/role/showIndex.htm','','1','2'), ('10','执行角色搜索',NULL,'zxjsss',NULL,'0','9'), ('11','添加角色展示',NULL,'tjjszs',NULL,'0','9'), ('12','执行角色添加',NULL,'zxjstj',NULL,'0','9'), ('13','执行角色删除',NULL,'zxjssc',NULL,'0','9'), ('14','修改角色展示',NULL,'xgjszs',NULL,'0','9'), ('15','执行角色修改',NULL,'zxjsxg',NULL,'0','9'), ('16','权限分配展示',NULL,'qxfpzs',NULL,'0','9'), ('17','执行权限分配',NULL,'zxqxfp',NULL,'0','9'), ('18','子权限列表展示',NULL,'zqxlbzs',NULL,'0','4'), ('19','执行权限删除',NULL,'zxqxsc',NULL,'0','4'), ('20','修改权限展示',NULL,'xgqxzs',NULL,'0','4'), ('21','执行权限修改',NULL,'zxqxxg',NULL,'0','4'), ('22','账号管理权限','账号管理','admin/system/useradmin/account/showIndex.htm','','1','2'), ('23','执行账号搜索',NULL,'zxzhss',NULL,'0','22'), ('24','添加账号展示',NULL,'tjzhzs',NULL,'0','22'), ('25','执行账号添加',NULL,'zxzhtj',NULL,'0','22'), ('26','执行账号删除',NULL,'zxzhsc',NULL,'0','22'), ('27','修改账号展示',NULL,'xgzhzs',NULL,'0','22'), ('28','执行账号修改',NULL,'zxzhxg',NULL,'0','22'), ('117','系统数据管理','系统数据管理','admin/system/systemdata','','1','1'), ('34','导出账号Excel',NULL,'dzzhexcel',NULL,'0','22'), ('110','基础数据','基础数据','admin/foundation','','1',NULL), ('111','区域数据管理','区域数据管理','admin/foundation/place/district/showIndex.htm','','1','120'), ('112','学校数据管理','学校数据管理','admin/foundation/place/school/showIndex.htm','','1','120'), ('113','社区数据管理','社区数据管理','admin/foundation/place/community/showIndex.htm','','1','120'), ('114','商家管理','商家管理','admin/merchant','','1',NULL), ('115','订单管理','订单管理','admin/order','','1',NULL), ('116','顾客管理','顾客管理','admin/customer','','1',NULL), ('119','系统日志','系统日志','admin/system/systemdata/systemlog/showIndex.htm','','1','117'), ('120','区域/学校/社区','区域/学校/社区','admin/foundation/place','','1','110'), ('145','登陆日志','登陆日志','admin/system/systemdata/loginlog/showIndex.htm','','1','117'), ('141','兑换物品管理','兑换物品管理','duihuanwupinguanli','','1','140'), ('125','商家列表','商家列表','admin/merchant/list/showIndex.htm','','1','114'), ('126','前台数据管理','前台数据管理','qiantaishuju','','1','1'), ('127','导航管理','导航管理','daohangguanli','','1','126'), ('128','系统公告','系统公告','xitonggonggao','','1','126'), ('129','广告管理','广告管理','guanggaoguanli','','1','126'), ('130','友情链接','友情链接','youqinglianjie','','1','126'), ('131','客服信息','客服信息','kefuxinxi','','1','126'), ('132','业务发展数据','业务发展数据','yewufazhanshuju','','1','110'), ('133','系统数据字典','系统数据字典','xitongshujuzidian','','1','110'), ('134','加盟审核信息','加盟审核信息','jiamengshenhe','','1','132'), ('135','顾客推荐信息','顾客推荐信息','guketuijian','','1','132'), ('136','反馈建议信息','反馈建议信息','fankuijianyi','','1','132'), ('137','餐厅主营类型','餐厅主营类型','cantingzhuyingleixing','','1','133'), ('138','送餐备注短语','送餐备注短语','songcanbeizhuduanyu','','1','133'), ('139','菜品特性描述','菜品特性描述','caipintexingmiaoshu','','1','133'), ('140','积分商城数据','积分商城数据','jifenshangchengshuju','','1','110'), ('142','历史兑换记录','历史兑换记录','lishiduihuanjilu','','1','140');
