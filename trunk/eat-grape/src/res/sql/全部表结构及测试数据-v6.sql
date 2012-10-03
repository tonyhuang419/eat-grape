/*
MySQL Backup
Source Server Version: 5.0.90
Source Database: eatledb
Date: 2012/10/3 14:03:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_advert`
-- ----------------------------
DROP TABLE IF EXISTS `t_advert`;
CREATE TABLE `t_advert` (
  `id` bigint(20) NOT NULL auto_increment,
  `pic_url` varchar(200) collate utf8_bin NOT NULL COMMENT '图片URL',
  `pic_width` int(5) default NULL COMMENT '图片宽度',
  `pic_height` int(5) default NULL COMMENT '图片高度',
  `show_text` varchar(100) collate utf8_bin default NULL COMMENT '展示（说明）文本',
  `link_url` varchar(200) collate utf8_bin default NULL COMMENT '链接地址',
  `issue_time` datetime default NULL COMMENT '发布时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='广告位信息表';

-- ----------------------------
--  Table structure for `t_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` bigint(20) NOT NULL auto_increment,
  `area_name` varchar(50) collate utf8_bin default '' COMMENT '地区/区县名称',
  `city_id` bigint(20) NOT NULL COMMENT '城市ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_area_t_city` (`city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地区/区县表';

-- ----------------------------
--  Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL auto_increment,
  `city_name` varchar(50) collate utf8_bin default '' COMMENT '城市名称',
  `prov_id` bigint(20) NOT NULL COMMENT '省份ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_city_t_province` (`prov_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='城市表';

-- ----------------------------
--  Table structure for `t_community`
-- ----------------------------
DROP TABLE IF EXISTS `t_community`;
CREATE TABLE `t_community` (
  `id` bigint(20) NOT NULL auto_increment,
  `comm_name` varchar(50) collate utf8_bin default NULL COMMENT '社区名称',
  `type` smallint(2) default '0' COMMENT '社区类型(0:学校,1:住宅小区,2:办公楼宇)',
  `addr` varchar(200) collate utf8_bin default '' COMMENT '详细地址',
  `dist_id` bigint(20) NOT NULL COMMENT '地段 / 片区ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_community_t_distinct` (`dist_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='住宅小区/办公楼宇/学校表';

-- ----------------------------
--  Table structure for `t_comm_merc`
-- ----------------------------
DROP TABLE IF EXISTS `t_comm_merc`;
CREATE TABLE `t_comm_merc` (
  `id` bigint(20) NOT NULL auto_increment,
  `comm_id` bigint(20) default NULL COMMENT '社区/楼宇/学校ID',
  `merc_id` bigint(20) default NULL COMMENT '商家ID',
  `send_rate` smallint(2) default NULL COMMENT '商家到楼宇对应的送餐价格',
  PRIMARY KEY  (`id`),
  KEY `FK_t_comm_merc_t_community` (`comm_id`),
  KEY `FK_t_comm_merc_t_merchant` (`merc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='社区/楼宇/学校与商家关联，以及商家到各个社区/楼宇/学校送餐的配送价格关联表';

-- ----------------------------
--  Table structure for `t_convert_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_convert_goods`;
CREATE TABLE `t_convert_goods` (
  `id` bigint(20) NOT NULL auto_increment,
  `goods_name` varchar(50) collate utf8_bin NOT NULL COMMENT '兑换商品名称',
  `goods_describe` varchar(200) collate utf8_bin default NULL COMMENT '兑换商品描述',
  `pic_url` varchar(200) collate utf8_bin default NULL COMMENT '图片URL',
  `total` bigint(10) NOT NULL default '0' COMMENT '兑换商品总量',
  `surplus` bigint(10) default '0' COMMENT '兑换商品剩余量',
  `score` bigint(10) default NULL COMMENT '兑换商品所需积分',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='可以兑换的商品表';

-- ----------------------------
--  Table structure for `t_convert_records`
-- ----------------------------
DROP TABLE IF EXISTS `t_convert_records`;
CREATE TABLE `t_convert_records` (
  `id` bigint(20) NOT NULL auto_increment,
  `goods_id` bigint(20) NOT NULL,
  `convert_count` int(5) default NULL,
  `convert_time` datetime default NULL,
  `customer_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_t_convert_records_t_convert_goods` (`goods_id`),
  KEY `FK_t_convert_records_t_customer` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='积分兑换商品记录';

-- ----------------------------
--  Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '真是姓名（用于积分兑换商品邮寄）',
  `type` smallint(2) default '2' COMMENT '用户类型（固定是顾客）',
  `phone_num` varchar(15) collate utf8_bin default NULL COMMENT '联系电话（用于积分兑换商品邮寄）',
  `home_addr` varchar(200) collate utf8_bin default NULL COMMENT '住所地址（用于积分兑换商品邮寄）',
  `send_addr` varchar(200) collate utf8_bin NOT NULL COMMENT '收货地址',
  `post_code` varchar(10) collate utf8_bin default NULL COMMENT '邮政编码（用于积分兑换商品邮寄）',
  `score` bigint(10) default '0' COMMENT '剩余积分',
  `user_name` varchar(20) collate utf8_bin NOT NULL COMMENT '用户名',
  `pwd` varchar(50) collate utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(40) collate utf8_bin default NULL COMMENT '电子邮件',
  `comm_id` bigint(20) NOT NULL COMMENT '所在社区/楼宇/学校',
  PRIMARY KEY  (`id`),
  KEY `FK_t_customer_t_community` (`comm_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顾客（消费者）信息表';

-- ----------------------------
--  Table structure for `t_distinct`
-- ----------------------------
DROP TABLE IF EXISTS `t_distinct`;
CREATE TABLE `t_distinct` (
  `id` bigint(20) NOT NULL auto_increment,
  `dist_name` varchar(50) collate utf8_bin default '' COMMENT '地段 / 片区名称',
  `area_id` bigint(20) NOT NULL COMMENT '地区/区县ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_distinct_t_area` (`area_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地段 / 片区表';

-- ----------------------------
--  Table structure for `t_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `id` bigint(20) NOT NULL auto_increment,
  `content` text collate utf8_bin COMMENT '反馈建议内容',
  `email` varchar(40) collate utf8_bin default NULL COMMENT '联系电子邮件',
  `identify_type` smallint(2) default NULL COMMENT '反馈者身份类型（0：商家，1：顾客）',
  `identify_id` smallint(2) default NULL COMMENT '身份ID',
  `sub_time` datetime default NULL COMMENT '提交时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='反馈建议表';

-- ----------------------------
--  Table structure for `t_join_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_join_info`;
CREATE TABLE `t_join_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `send_place` varchar(500) collate utf8_bin default NULL COMMENT '送餐地点',
  `shop_name` varchar(50) collate utf8_bin default NULL COMMENT '商店名称',
  `shop_addr` varchar(200) collate utf8_bin default NULL COMMENT '商店地址',
  `link_man` varchar(20) collate utf8_bin default NULL COMMENT '联系人',
  `link_tel` varchar(15) collate utf8_bin default NULL COMMENT '联系电话',
  `link_email` varchar(40) collate utf8_bin default NULL COMMENT '联系人电子邮件',
  `link_qq` varchar(15) collate utf8_bin default NULL COMMENT '联系人QQ',
  `sub_time` datetime default NULL COMMENT '提交时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='加盟联系信息表';

-- ----------------------------
--  Table structure for `t_leave_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_message`;
CREATE TABLE `t_leave_message` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(50) collate utf8_bin default NULL COMMENT '留言标题',
  `content` varchar(200) collate utf8_bin NOT NULL COMMENT '留言内容',
  `customer_id` bigint(20) default NULL COMMENT '留言者ID（为空则为游客所留）',
  `leave_time` datetime NOT NULL COMMENT '留言时间',
  `reply_id` bigint(20) default NULL COMMENT '回复别人的评论的ID（为空则代表不是回复，是发表）',
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_leave_message_t_merchant` (`merc_id`),
  KEY `FK_t_leave_message_t_customer` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='顾客（消费者）给商家的留言表';

-- ----------------------------
--  Table structure for `t_leave_remark`
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_remark`;
CREATE TABLE `t_leave_remark` (
  `id` bigint(20) NOT NULL auto_increment,
  `grade_service` smallint(2) default NULL COMMENT '服务态度评论等级（0：很差，1：差，2：一般，3：好，4：很好）',
  `grade_quality` smallint(2) default NULL COMMENT '菜品质量评论等级（0：很差，1：差，2：一般，3：好，4：很好）',
  `grade_send` smallint(2) default NULL COMMENT '送餐速度评论等级（0：很慢，1：慢，2：一般，3：快，4：很快）',
  `content` varchar(200) collate utf8_bin default NULL COMMENT '评论内容',
  `customer_id` bigint(20) default NULL COMMENT '评论者（为空则为游客所评论）',
  `leave_time` datetime default NULL COMMENT '评论时间',
  `merc_id` bigint(20) default NULL COMMENT '商家ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_leave_remark_t_customer` (`customer_id`),
  KEY `FK_t_leave_remark_t_merchant` (`merc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顾客（消费者）给商家的评论表';

-- ----------------------------
--  Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` bigint(20) NOT NULL auto_increment,
  `identify_type` smallint(2) default NULL COMMENT '身份类型（0：管理员，1：商家，2：顾客）',
  `identify_id` smallint(2) default NULL COMMENT '身份ID',
  `login_ip` varchar(30) collate utf8_bin default NULL COMMENT '登录IP',
  `login_time` datetime default NULL COMMENT '登录时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='登录日志表';

-- ----------------------------
--  Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL auto_increment,
  `rel` varchar(20) collate utf8_bin NOT NULL default '' COMMENT 'DWZ框架的超链接rel属性值',
  `action` varchar(200) collate utf8_bin default '' COMMENT '动作指令',
  `menu_name` varchar(100) collate utf8_bin NOT NULL default '' COMMENT '菜单名称',
  `url` varchar(100) collate utf8_bin default '' COMMENT '菜单链接',
  `parent_id` bigint(20) default '0' COMMENT '父菜单ID',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统菜单表';

-- ----------------------------
--  Table structure for `t_menu_catagory`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_catagory`;
CREATE TABLE `t_menu_catagory` (
  `id` bigint(20) NOT NULL auto_increment,
  `cata_name` varchar(50) collate utf8_bin default NULL COMMENT '分类名称',
  `cata_describe` varchar(200) collate utf8_bin default NULL COMMENT '分类描述',
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_menu_catagory_t_merchant` USING BTREE (`merc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='点菜单分类表';

-- ----------------------------
--  Table structure for `t_menu_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_list`;
CREATE TABLE `t_menu_list` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(50) collate utf8_bin NOT NULL COMMENT '菜名',
  `feature` varchar(20) collate utf8_bin default NULL COMMENT '菜品特征（0：招牌菜，1：特色菜，2：麻辣，3：新菜品）',
  `describe` varchar(200) collate utf8_bin default NULL COMMENT '简介/描述',
  `pic_url` varchar(200) collate utf8_bin default NULL COMMENT '图片URL',
  `price` int(5) NOT NULL COMMENT '单价',
  `spec_price` int(5) default NULL COMMENT '特价价格',
  `is_spec_price` smallint(2) default NULL COMMENT '是否是特价菜品（0：是，1：不是）',
  `score` int(5) default '0' COMMENT '赠送积分',
  `cata_id` bigint(20) NOT NULL COMMENT '菜单分类ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_menu_list_t_menu_catagory` (`cata_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='点菜单表';

-- ----------------------------
--  Table structure for `t_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant`;
CREATE TABLE `t_merchant` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_id` bigint(20) default NULL COMMENT '用户ID',
  `merc_name` varchar(20) collate utf8_bin NOT NULL COMMENT '商家姓名',
  `merc_ID_NO` varchar(40) collate utf8_bin default NULL COMMENT '商家身份证号码',
  `merc_tel` varchar(15) collate utf8_bin NOT NULL COMMENT '商家电话',
  `merc_qq` varchar(15) collate utf8_bin default NULL COMMENT '商家QQ',
  `merc_addr` varchar(200) collate utf8_bin default NULL COMMENT '商家住所地址',
  `shop_name` varchar(50) collate utf8_bin NOT NULL COMMENT '店铺名称',
  `shop_type` varchar(20) collate utf8_bin default NULL COMMENT '店铺主营产品类型标志集（多个标示，分隔）（标识与表t_shop_type同步）',
  `shop_addr` varchar(200) collate utf8_bin default NULL COMMENT '店铺地址',
  `shop_logo_url` varchar(200) collate utf8_bin default NULL COMMENT '商店标志图片URL',
  `shop_tel` varchar(15) collate utf8_bin default NULL COMMENT '订餐电话',
  `busi_hour` varchar(50) collate utf8_bin default NULL COMMENT '营业时间',
  `send_type` smallint(2) NOT NULL COMMENT '送餐类型（0：在线，1：电话）',
  `send_rate` smallint(2) default NULL COMMENT '配送费',
  `send_explain` varchar(200) collate utf8_bin default '' COMMENT '送餐说明',
  `last_login_time` datetime default NULL COMMENT '上次登录时间',
  `dist_id` bigint(20) default NULL COMMENT '地段/片区ID',
  `join_date` datetime default NULL COMMENT '加入时间',
  PRIMARY KEY  (`id`),
  KEY `FK_t_merchant_t_distinct` (`dist_id`),
  KEY `FK_t_merchant_t_user` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家信息表';

-- ----------------------------
--  Table structure for `t_merc_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_merc_notice`;
CREATE TABLE `t_merc_notice` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(100) collate utf8_bin NOT NULL default '' COMMENT '标题',
  `content` varchar(200) collate utf8_bin default '' COMMENT '内容',
  `merc_id` bigint(20) default NULL COMMENT '商家ID',
  `send_time` datetime default NULL COMMENT '发送时间',
  PRIMARY KEY  (`id`),
  KEY `FK_t_merc_notice_t_merchant` (`merc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家公告表';

-- ----------------------------
--  Table structure for `t_merc_pv`
-- ----------------------------
DROP TABLE IF EXISTS `t_merc_pv`;
CREATE TABLE `t_merc_pv` (
  `id` bigint(20) NOT NULL auto_increment,
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  `customer_id` bigint(20) NOT NULL,
  `access_time` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_merc_pv_t_merchant` (`merc_id`),
  KEY `FK_merc_pv_t_customer` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家访问量信息';

-- ----------------------------
--  Table structure for `t_order_lib`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_lib`;
CREATE TABLE `t_order_lib` (
  `id` bigint(20) NOT NULL auto_increment,
  `order_num` bigint(20) NOT NULL COMMENT '订单号',
  `menu_id` bigint(20) NOT NULL COMMENT '菜品ID',
  `merc_id` bigint(20) NOT NULL COMMENT '商家（卖家）',
  `customer_id` bigint(20) NOT NULL COMMENT '顾客（买家）',
  `comm_id` bigint(20) default NULL COMMENT '社区/楼宇/学校ID',
  `trade_count` bigint(10) default NULL COMMENT '买/卖数量',
  `trade_money` bigint(10) default NULL COMMENT '交易金额',
  `trade_time` datetime default NULL COMMENT '交易时间',
  `trade_state` smallint(2) default NULL COMMENT '该交易当前状态（0：完成，1：未完成）',
  PRIMARY KEY  (`id`),
  KEY `FK_t_order_lib_t_menu_list` (`menu_id`),
  KEY `FK_t_order_lib_t_merchant` (`merc_id`),
  KEY `FK_t_order_lib_t_customer` (`customer_id`),
  KEY `FK_t_order_lib_t_community` (`comm_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='订单表';

-- ----------------------------
--  Table structure for `t_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `id` bigint(20) NOT NULL auto_increment,
  `priv_name` varchar(50) collate utf8_bin NOT NULL COMMENT '权限名称',
  `meue_name` varchar(100) collate utf8_bin default NULL COMMENT '菜单名称',
  `action` varchar(200) collate utf8_bin default NULL COMMENT '动作指令',
  `description` varchar(200) collate utf8_bin default NULL COMMENT '权限描述',
  `is_show` tinyint(4) default '0' COMMENT '是否显示',
  `pid` bigint(20) default NULL COMMENT '父权限ID',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
--  Table structure for `t_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `id` bigint(20) NOT NULL auto_increment,
  `prov_name` varchar(50) collate utf8_bin default '' COMMENT '省份/州名称',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='省份表';

-- ----------------------------
--  Table structure for `t_recommend_merc`
-- ----------------------------
DROP TABLE IF EXISTS `t_recommend_merc`;
CREATE TABLE `t_recommend_merc` (
  `id` bigint(20) NOT NULL auto_increment,
  `shop_name` varchar(50) collate utf8_bin default NULL COMMENT '店铺名称',
  `shop_tel` varchar(15) collate utf8_bin default NULL COMMENT '店铺电话',
  `shop_addr` varchar(200) collate utf8_bin default NULL COMMENT '店铺地址',
  `customer_id` bigint(20) default NULL COMMENT '顾客ID',
  `sub_time` datetime default NULL COMMENT '提交时间',
  PRIMARY KEY  (`id`),
  KEY `FK_recommend_merc_t_customer` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顾客推荐商家信息表';

-- ----------------------------
--  Table structure for `t_recruit_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_recruit_info`;
CREATE TABLE `t_recruit_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `job_name` varchar(100) collate utf8_bin default NULL COMMENT '职位名称',
  `job_duty` text collate utf8_bin COMMENT '工作职责',
  `job_seniority` int(5) default NULL COMMENT '工作年限',
  `sex` smallint(2) default NULL COMMENT '性别（0：不限，1：男，2：女）',
  `age` varchar(20) collate utf8_bin default NULL COMMENT '年龄范围',
  `education` smallint(2) default NULL COMMENT '学历（0：不限，1：小学，2：初中，3：高中/中专，4：大专，5：本科，6：研究生，7：硕士，8：博士）',
  `link_tel` varchar(15) collate utf8_bin default NULL COMMENT '联系电话',
  `sub_time` datetime default NULL COMMENT '发布时间',
  `deadline` datetime default NULL,
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY  (`id`),
  KEY `FK_t_recruit_info_t_merchant` (`merc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='人才招聘信息表';

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_name` varchar(20) collate utf8_bin NOT NULL COMMENT '角色名称',
  `description` varchar(100) collate utf8_bin default NULL COMMENT '角色描述',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

-- ----------------------------
--  Table structure for `t_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_privilege`;
CREATE TABLE `t_role_privilege` (
  `id` bigint(20) NOT NULL auto_increment,
  `role_id` bigint(20) default NULL COMMENT '角色ID',
  `priv_id` bigint(20) default NULL COMMENT '权限ID',
  PRIMARY KEY  (`id`),
  KEY `priv_id` (`priv_id`),
  KEY `role_id` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色与权限关联表';

-- ----------------------------
--  Table structure for `t_service_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_service_info`;
CREATE TABLE `t_service_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `serv_mobile` varchar(100) collate utf8_bin default NULL COMMENT '客服移动电话',
  `serv_tel` varchar(100) collate utf8_bin default NULL COMMENT '客服电话',
  `serv_qq` varchar(100) collate utf8_bin default NULL COMMENT '客服QQ',
  `serv_email` varchar(100) collate utf8_bin default NULL COMMENT '客服邮件',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户服务信息表';

-- ----------------------------
--  Table structure for `t_shop_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_type`;
CREATE TABLE `t_shop_type` (
  `id` bigint(20) NOT NULL auto_increment,
  `type_name` varchar(20) collate utf8_bin default NULL COMMENT '类型名称',
  `type_identify` varchar(10) collate utf8_bin default NULL COMMENT '类型标示',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商店主要经营类型字典表';

-- ----------------------------
--  Table structure for `t_system_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_notice`;
CREATE TABLE `t_system_notice` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(100) collate utf8_bin default NULL COMMENT '系统公告标题',
  `content` varchar(200) collate utf8_bin default NULL COMMENT '系统公告内容',
  `admin_id` bigint(20) default NULL COMMENT '管理员ID',
  `send_time` datetime default NULL COMMENT '发送时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统公告表';

-- ----------------------------
--  Table structure for `t_to_employ`
-- ----------------------------
DROP TABLE IF EXISTS `t_to_employ`;
CREATE TABLE `t_to_employ` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin default NULL COMMENT '应聘者姓名',
  `email` varchar(40) collate utf8_bin default NULL COMMENT '电子邮件',
  `link_tel` varchar(15) collate utf8_bin default NULL COMMENT '联系电话',
  `resume_text` text collate utf8_bin COMMENT '文本简历内容',
  `resume_url` varchar(200) collate utf8_bin default NULL COMMENT '文档简历URL',
  `sub_time` datetime default NULL COMMENT '提交时间',
  `merc_id` bigint(20) default NULL,
  `recruit_id` bigint(20) NOT NULL COMMENT '招聘信息ID',
  `customer_id` bigint(20) default NULL COMMENT '顾客ID（为空则为游客应聘）',
  PRIMARY KEY  (`id`),
  KEY `FK_t_to_employ_t_customer` (`customer_id`),
  KEY `FK_t_to_employ_t_merchant` (`merc_id`),
  KEY `FK_t_to_employ_t_recruit_info` (`recruit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应聘记录信息表';

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `user_name` varchar(20) collate utf8_bin NOT NULL COMMENT '用户名',
  `pwd` varchar(50) collate utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(40) collate utf8_bin default NULL COMMENT '电子邮件',
  `type` tinyint(4) NOT NULL COMMENT '用户类型（0：管理员，1：商家）',
  `role_id` bigint(20) default NULL COMMENT '角色ID',
  PRIMARY KEY  (`id`),
  KEY `role_id` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1','sys_mgr','sys_mgr','系统管理','','0'), ('2','user_mgr','user_mgr','用户管理','','1'), ('3','account_mgr','account_mgr','账号管理','system/useradmin/account/showIndex.htm','2'), ('4','role_mgr','role_mgr','角色管理','system/useradmin/role/showIndex.htm','2'), ('7','base_data','base_data','基础数据','','1'), ('8','func_mgr','func_mgr','功能设置','system/menu/showIndex.htm','7'), ('9','priv_mgr','priv_mgr','权限管理','system/useradmin/priv/showIndex.htm','2');
INSERT INTO `t_privilege` VALUES ('1','系统管理权限','系统管理','sys_mgr',NULL,'0',NULL), ('2','用户管理权限','用户管理','user_mgr','','1','1'), ('3','基础数据权限','基础数据','base_data','','1',NULL), ('4','权限管理权限','权限管理','priv_mgr',NULL,'0','2'), ('5','功能设置权限','功能设置','func_mgr','','0','3'), ('6','执行权限搜索',NULL,'zxqxss',NULL,'0','4'), ('7','添加权限展示',NULL,'tjqxzs',NULL,'0','4'), ('8','执行权限添加',NULL,'zxqxtj',NULL,'0','4'), ('9','角色管理权限','角色管理','role_mgr',NULL,'0','2'), ('10','执行角色搜索',NULL,'zxjsss',NULL,'0','9'), ('11','添加角色展示',NULL,'tjjszs',NULL,'0','9'), ('12','执行角色添加',NULL,'zxjstj',NULL,'0','9'), ('13','执行角色删除',NULL,'zxjssc',NULL,'0','9'), ('14','修改角色展示',NULL,'xgjszs',NULL,'0','9'), ('15','执行角色修改',NULL,'zxjsxg',NULL,'0','9'), ('16','权限分配展示',NULL,'qxfpzs',NULL,'0','9'), ('17','执行权限分配',NULL,'zxqxfp',NULL,'0','9'), ('18','子权限列表展示',NULL,'zqxlbzs',NULL,'0','4'), ('19','执行权限删除',NULL,'zxqxsc',NULL,'0','4'), ('20','修改权限展示',NULL,'xgqxzs',NULL,'0','4'), ('21','执行权限修改',NULL,'zxqxxg',NULL,'0','4'), ('22','账号管理权限','账号管理','account_mgr',NULL,'0','2'), ('23','执行账号搜索',NULL,'zxzhss',NULL,'0','22'), ('24','添加账号展示',NULL,'tjzhzs',NULL,'0','22'), ('25','执行账号添加',NULL,'zxzhtj',NULL,'0','22'), ('26','执行账号删除',NULL,'zxzhsc',NULL,'0','22'), ('27','修改账号展示',NULL,'xgzhzs',NULL,'0','22'), ('28','执行账号修改',NULL,'zxzhxg',NULL,'0','22'), ('29','执行功能修改',NULL,'zxgnxg',NULL,'0','5'), ('30','修改功能展示',NULL,'xggnzs',NULL,'0','5'), ('31','执行功能删除',NULL,'zxgnsc',NULL,'0','5'), ('32','执行功能添加','','zxgntj','',NULL,NULL), ('33','添加功能展示',NULL,'tjgnzs',NULL,'0','5'), ('34','导出账号Excel',NULL,'dzzhexcel',NULL,'0','22');
INSERT INTO `t_province` VALUES ('1','四川'), ('2','广东'), ('3','河南'), ('4','山西'), ('5','云南'), ('6','贵州'), ('7','甘肃'), ('8','广西'), ('9','西藏'), ('10','新疆'), ('11','内蒙古'), ('12','辽宁'), ('13','吉林'), ('14','黑龙江'), ('15','浙江'), ('16','江苏'), ('17','河北'), ('22','青海'), ('23','福建'), ('24','陕西'), ('25','湖南'), ('26','湖北'), ('27','直辖市');
INSERT INTO `t_role` VALUES ('2','超级管理员','负责对系统的维护'), ('3','编辑员','餐厅的编辑员负责对菜单进行管理'), ('6','商家','餐厅老板管理自己的餐厅'), ('13','营业员','餐厅的营业员负责查看实时订单');
INSERT INTO `t_role_privilege` VALUES ('1','2','1'), ('2','2','2'), ('3','2','3'), ('4','2','4'), ('5','2','5'), ('6','2','6'), ('7','2','7'), ('8','2','8'), ('9','2','9'), ('10','2','10'), ('11','2','11'), ('12','2','12'), ('13','2','13'), ('14','2','14'), ('15','2','15'), ('16','2','16'), ('17','2','17'), ('18','2','18'), ('19','2','19'), ('20','2','20'), ('21','2','21'), ('22','2','22'), ('23','2','23'), ('24','2','24'), ('25','2','25'), ('26','2','26'), ('27','2','27'), ('28','2','28'), ('29','2','29'), ('30','2','30'), ('31','2','31'), ('32','2','32'), ('33','2','33'), ('34','2','34'), ('45','3','3'), ('93','6','1'), ('94','6','2'), ('95','6','4'), ('96','6','6'), ('97','6','7'), ('98','6','8'), ('99','6','18'), ('100','6','19'), ('101','6','20'), ('102','6','21'), ('103','6','9'), ('104','6','10'), ('105','6','11'), ('106','6','12'), ('107','6','13'), ('108','6','14'), ('109','6','15'), ('110','6','16'), ('111','6','17'), ('112','6','22'), ('113','6','23'), ('114','6','24'), ('115','6','25'), ('116','6','26'), ('117','6','27'), ('118','6','28'), ('119','6','34'), ('120','6','3'), ('121','6','5'), ('122','6','29'), ('123','6','30'), ('124','6','31'), ('125','6','32'), ('126','6','33'), ('127','13','4'), ('128','13','6'), ('129','13','7'), ('130','13','9'), ('131','13','10'), ('132','3','1'), ('133','3','2'), ('134','3','4'), ('135','3','6'), ('136','3','7'), ('137','3','8'), ('138','3','18'), ('139','3','19'), ('140','3','20'), ('141','3','21'), ('142','3','9'), ('143','3','10'), ('144','3','11'), ('145','3','12'), ('146','3','13'), ('147','3','14'), ('148','3','15'), ('149','3','16'), ('150','3','17'), ('151','3','22'), ('152','3','23'), ('153','3','24'), ('154','3','25'), ('155','3','26'), ('156','3','27'), ('157','3','28');
INSERT INTO `t_role_privilege` VALUES ('158','3','34'), ('159','3','5'), ('160','3','29'), ('161','3','30'), ('162','3','31'), ('163','3','32'), ('164','3','33');
INSERT INTO `t_user` VALUES ('4','谭绍清','123','453674398@qq.com','1','3'), ('5','谭又中','123','453674398@qq.com','1','2'), ('6','周星星','123','zxx@zxx.com','1','13'), ('7','xt','1','xiangtao@xt.com','1','2');
