/*
MySQL Backup
Source Server Version: 5.1.32
Source Database: eatledb
Date: 2012-9-6 17:24:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_advert`
-- ----------------------------
DROP TABLE IF EXISTS `t_advert`;
CREATE TABLE `t_advert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '图片URL',
  `pic_width` int(5) DEFAULT NULL COMMENT '图片宽度',
  `pic_height` int(5) DEFAULT NULL COMMENT '图片高度',
  `show_text` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '展示（说明）文本',
  `link_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '链接地址',
  `issue_time` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='广告位信息表';

-- ----------------------------
--  Table structure for `t_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '地区/区县名称',
  `city_id` bigint(20) NOT NULL COMMENT '城市ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_area_t_city` (`city_id`),
  CONSTRAINT `FK_t_area_t_city` FOREIGN KEY (`city_id`) REFERENCES `t_city` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地区/区县表';

-- ----------------------------
--  Table structure for `t_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '城市名称',
  `prov_id` bigint(20) NOT NULL COMMENT '省份ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_city_t_province` (`prov_id`),
  CONSTRAINT `FK_t_city_t_province` FOREIGN KEY (`prov_id`) REFERENCES `t_province` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='城市表';

-- ----------------------------
--  Table structure for `t_community`
-- ----------------------------
DROP TABLE IF EXISTS `t_community`;
CREATE TABLE `t_community` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comm_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '社区名称',
  `type` smallint(2) DEFAULT '0' COMMENT '社区类型(0:学校,1:住宅小区,2:办公楼宇)',
  `addr` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '详细地址',
  `dist_id` bigint(20) NOT NULL COMMENT '地段 / 片区ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_community_t_distinct` (`dist_id`),
  CONSTRAINT `FK_t_community_t_distinct` FOREIGN KEY (`dist_id`) REFERENCES `t_distinct` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='住宅小区/办公楼宇/学校表';

-- ----------------------------
--  Table structure for `t_comm_merc`
-- ----------------------------
DROP TABLE IF EXISTS `t_comm_merc`;
CREATE TABLE `t_comm_merc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comm_id` bigint(20) DEFAULT NULL COMMENT '社区/楼宇/学校ID',
  `merc_id` bigint(20) DEFAULT NULL COMMENT '商家ID',
  `send_rate` smallint(2) DEFAULT NULL COMMENT '商家到楼宇对应的送餐价格',
  PRIMARY KEY (`id`),
  KEY `FK_t_comm_merc_t_community` (`comm_id`),
  KEY `FK_t_comm_merc_t_merchant` (`merc_id`),
  CONSTRAINT `FK_t_comm_merc_t_community` FOREIGN KEY (`comm_id`) REFERENCES `t_community` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_t_comm_merc_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='社区/楼宇/学校与商家关联，以及商家到各个社区/楼宇/学校送餐的配送价格关联表';

-- ----------------------------
--  Table structure for `t_convert_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_convert_goods`;
CREATE TABLE `t_convert_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '兑换商品名称',
  `goods_describe` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '兑换商品描述',
  `pic_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片URL',
  `total` bigint(10) NOT NULL DEFAULT '0' COMMENT '兑换商品总量',
  `surplus` bigint(10) DEFAULT '0' COMMENT '兑换商品剩余量',
  `score` bigint(10) DEFAULT NULL COMMENT '兑换商品所需积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='可以兑换的商品表';

-- ----------------------------
--  Table structure for `t_convert_records`
-- ----------------------------
DROP TABLE IF EXISTS `t_convert_records`;
CREATE TABLE `t_convert_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL,
  `convert_count` int(5) DEFAULT NULL,
  `convert_time` datetime DEFAULT NULL,
  `customer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_convert_records_t_convert_goods` (`goods_id`),
  KEY `FK_t_convert_records_t_customer` (`customer_id`),
  CONSTRAINT `FK_t_convert_records_t_convert_goods` FOREIGN KEY (`goods_id`) REFERENCES `t_convert_goods` (`id`),
  CONSTRAINT `FK_t_convert_records_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='积分兑换商品记录';

-- ----------------------------
--  Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '真是姓名（用于积分兑换商品邮寄）',
  `type` smallint(2) DEFAULT '2' COMMENT '用户类型（固定是顾客）',
  `phone_num` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话（用于积分兑换商品邮寄）',
  `home_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '住所地址（用于积分兑换商品邮寄）',
  `send_addr` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '收货地址',
  `post_code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码（用于积分兑换商品邮寄）',
  `score` bigint(10) DEFAULT '0' COMMENT '剩余积分',
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `pwd` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `comm_id` bigint(20) NOT NULL COMMENT '所在社区/楼宇/学校',
  PRIMARY KEY (`id`),
  KEY `FK_t_customer_t_community` (`comm_id`),
  CONSTRAINT `FK_t_customer_t_community` FOREIGN KEY (`comm_id`) REFERENCES `t_community` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顾客（消费者）信息表';

-- ----------------------------
--  Table structure for `t_distinct`
-- ----------------------------
DROP TABLE IF EXISTS `t_distinct`;
CREATE TABLE `t_distinct` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dist_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '地段 / 片区名称',
  `area_id` bigint(20) NOT NULL COMMENT '地区/区县ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_distinct_t_area` (`area_id`),
  CONSTRAINT `FK_t_distinct_t_area` FOREIGN KEY (`area_id`) REFERENCES `t_area` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地段 / 片区表';

-- ----------------------------
--  Table structure for `t_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text COLLATE utf8_bin COMMENT '反馈建议内容',
  `email` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电子邮件',
  `identify_type` smallint(2) DEFAULT NULL COMMENT '反馈者身份类型（0：商家，1：顾客）',
  `identify_id` smallint(2) DEFAULT NULL COMMENT '身份ID',
  `sub_time` datetime DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='反馈建议表';

-- ----------------------------
--  Table structure for `t_join_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_join_info`;
CREATE TABLE `t_join_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `send_place` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '送餐地点',
  `shop_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '商店名称',
  `shop_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商店地址',
  `link_man` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `link_tel` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `link_email` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人电子邮件',
  `link_qq` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人QQ',
  `sub_time` datetime DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='加盟联系信息表';

-- ----------------------------
--  Table structure for `t_leave_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_message`;
CREATE TABLE `t_leave_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '留言标题',
  `content` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '留言内容',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '留言者ID（为空则为游客所留）',
  `leave_time` datetime NOT NULL COMMENT '留言时间',
  `reply_id` bigint(20) DEFAULT NULL COMMENT '回复别人的评论的ID（为空则代表不是回复，是发表）',
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_leave_message_t_merchant` (`merc_id`),
  KEY `FK_t_leave_message_t_customer` (`customer_id`),
  CONSTRAINT `FK_t_leave_message_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_t_leave_message_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='顾客（消费者）给商家的留言表';

-- ----------------------------
--  Table structure for `t_leave_remark`
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_remark`;
CREATE TABLE `t_leave_remark` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grade_service` smallint(2) DEFAULT NULL COMMENT '服务态度评论等级（0：很差，1：差，2：一般，3：好，4：很好）',
  `grade_quality` smallint(2) DEFAULT NULL COMMENT '菜品质量评论等级（0：很差，1：差，2：一般，3：好，4：很好）',
  `grade_send` smallint(2) DEFAULT NULL COMMENT '送餐速度评论等级（0：很慢，1：慢，2：一般，3：快，4：很快）',
  `content` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '评论者（为空则为游客所评论）',
  `leave_time` datetime DEFAULT NULL COMMENT '评论时间',
  `merc_id` bigint(20) DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_leave_remark_t_customer` (`customer_id`),
  KEY `FK_t_leave_remark_t_merchant` (`merc_id`),
  CONSTRAINT `FK_t_leave_remark_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_t_leave_remark_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顾客（消费者）给商家的评论表';

-- ----------------------------
--  Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identify_type` smallint(2) DEFAULT NULL COMMENT '身份类型（0：管理员，1：商家，2：顾客）',
  `identify_id` smallint(2) DEFAULT NULL COMMENT '身份ID',
  `login_ip` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '登录IP',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='登录日志表';

-- ----------------------------
--  Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rel` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'DWZ框架的超链接rel属性值',
  `action` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '动作指令',
  `menu_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '菜单链接',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统菜单表';

-- ----------------------------
--  Table structure for `t_menu_catagory`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_catagory`;
CREATE TABLE `t_menu_catagory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cata_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `cata_describe` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '分类描述',
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_menu_catagory_t_merchant` (`merc_id`) USING BTREE,
  CONSTRAINT `FK_t_menu_catagory_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='点菜单分类表';

-- ----------------------------
--  Table structure for `t_menu_list`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_list`;
CREATE TABLE `t_menu_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '菜名',
  `feature` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '菜品特征（0：招牌菜，1：特色菜，2：麻辣，3：新菜品）',
  `describe` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '简介/描述',
  `pic_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '图片URL',
  `price` int(5) NOT NULL COMMENT '单价',
  `spec_price` int(5) DEFAULT NULL COMMENT '特价价格',
  `is_spec_price` smallint(2) DEFAULT NULL COMMENT '是否是特价菜品（0：是，1：不是）',
  `score` int(5) DEFAULT '0' COMMENT '赠送积分',
  `cata_id` bigint(20) NOT NULL COMMENT '菜单分类ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_menu_list_t_menu_catagory` (`cata_id`),
  CONSTRAINT `FK_t_menu_list_t_menu_catagory` FOREIGN KEY (`cata_id`) REFERENCES `t_menu_catagory` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='点菜单表';

-- ----------------------------
--  Table structure for `t_merchant`
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant`;
CREATE TABLE `t_merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `merc_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '商家姓名',
  `merc_ID_NO` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '商家身份证号码',
  `merc_tel` varchar(15) COLLATE utf8_bin NOT NULL COMMENT '商家电话',
  `merc_qq` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '商家QQ',
  `merc_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商家住所地址',
  `shop_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '店铺名称',
  `shop_type` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺主营产品类型标志集（多个标示，分隔）（标识与表t_shop_type同步）',
  `shop_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺地址',
  `shop_logo_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商店标志图片URL',
  `shop_tel` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '订餐电话',
  `busi_hour` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '营业时间',
  `send_type` smallint(2) NOT NULL COMMENT '送餐类型（0：在线，1：电话）',
  `send_rate` smallint(2) DEFAULT NULL COMMENT '配送费',
  `send_explain` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '送餐说明',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `dist_id` bigint(20) DEFAULT NULL COMMENT '地段/片区ID',
  `join_date` datetime DEFAULT NULL COMMENT '加入时间',
  PRIMARY KEY (`id`),
  KEY `FK_t_merchant_t_distinct` (`dist_id`),
  KEY `FK_t_merchant_t_user` (`user_id`),
  CONSTRAINT `FK_t_merchant_t_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_t_merchant_t_distinct` FOREIGN KEY (`dist_id`) REFERENCES `t_distinct` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家信息表';

-- ----------------------------
--  Table structure for `t_merc_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_merc_notice`;
CREATE TABLE `t_merc_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(200) COLLATE utf8_bin DEFAULT '' COMMENT '内容',
  `merc_id` bigint(20) DEFAULT NULL COMMENT '商家ID',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`),
  KEY `FK_t_merc_notice_t_merchant` (`merc_id`),
  CONSTRAINT `FK_t_merc_notice_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家公告表';

-- ----------------------------
--  Table structure for `t_merc_pv`
-- ----------------------------
DROP TABLE IF EXISTS `t_merc_pv`;
CREATE TABLE `t_merc_pv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  `customer_id` bigint(20) NOT NULL,
  `access_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_merc_pv_t_merchant` (`merc_id`),
  KEY `FK_merc_pv_t_customer` (`customer_id`),
  CONSTRAINT `FK_merc_pv_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_merc_pv_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商家访问量信息';

-- ----------------------------
--  Table structure for `t_order_lib`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_lib`;
CREATE TABLE `t_order_lib` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_num` bigint(20) NOT NULL COMMENT '订单号',
  `menu_id` bigint(20) NOT NULL COMMENT '菜品ID',
  `merc_id` bigint(20) NOT NULL COMMENT '商家（卖家）',
  `customer_id` bigint(20) NOT NULL COMMENT '顾客（买家）',
  `comm_id` bigint(20) DEFAULT NULL COMMENT '社区/楼宇/学校ID',
  `trade_count` bigint(10) DEFAULT NULL COMMENT '买/卖数量',
  `trade_money` bigint(10) DEFAULT NULL COMMENT '交易金额',
  `trade_time` datetime DEFAULT NULL COMMENT '交易时间',
  `trade_state` smallint(2) DEFAULT NULL COMMENT '该交易当前状态（0：完成，1：未完成）',
  PRIMARY KEY (`id`),
  KEY `FK_t_order_lib_t_menu_list` (`menu_id`),
  KEY `FK_t_order_lib_t_merchant` (`merc_id`),
  KEY `FK_t_order_lib_t_customer` (`customer_id`),
  KEY `FK_t_order_lib_t_community` (`comm_id`),
  CONSTRAINT `FK_t_order_lib_t_community` FOREIGN KEY (`comm_id`) REFERENCES `t_community` (`id`),
  CONSTRAINT `FK_t_order_lib_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_t_order_lib_t_menu_list` FOREIGN KEY (`menu_id`) REFERENCES `t_menu_list` (`id`),
  CONSTRAINT `FK_t_order_lib_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='订单表';

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
  `p_id` bigint(20) DEFAULT NULL COMMENT '父权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
--  Table structure for `t_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prov_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '省份/州名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='省份表';

-- ----------------------------
--  Table structure for `t_recommend_merc`
-- ----------------------------
DROP TABLE IF EXISTS `t_recommend_merc`;
CREATE TABLE `t_recommend_merc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺名称',
  `shop_tel` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺电话',
  `shop_addr` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '店铺地址',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '顾客ID',
  `sub_time` datetime DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`id`),
  KEY `FK_recommend_merc_t_customer` (`customer_id`),
  CONSTRAINT `FK_recommend_merc_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='顾客推荐商家信息表';

-- ----------------------------
--  Table structure for `t_recruit_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_recruit_info`;
CREATE TABLE `t_recruit_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '职位名称',
  `job_duty` text COLLATE utf8_bin COMMENT '工作职责',
  `job_seniority` int(5) DEFAULT NULL COMMENT '工作年限',
  `sex` smallint(2) DEFAULT NULL COMMENT '性别（0：不限，1：男，2：女）',
  `age` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '年龄范围',
  `education` smallint(2) DEFAULT NULL COMMENT '学历（0：不限，1：小学，2：初中，3：高中/中专，4：大专，5：本科，6：研究生，7：硕士，8：博士）',
  `link_tel` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `sub_time` datetime DEFAULT NULL COMMENT '发布时间',
  `deadline` datetime DEFAULT NULL,
  `merc_id` bigint(20) NOT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`),
  KEY `FK_t_recruit_info_t_merchant` (`merc_id`),
  CONSTRAINT `FK_t_recruit_info_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='人才招聘信息表';

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

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
  KEY `role_id` (`role_id`),
  CONSTRAINT `FK_t_role_privlege_t_privilege` FOREIGN KEY (`priv_id`) REFERENCES `t_privilege` (`id`),
  CONSTRAINT `FK_t_role_privlege_t_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色与权限关联表';

-- ----------------------------
--  Table structure for `t_service_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_service_info`;
CREATE TABLE `t_service_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serv_mobile` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客服移动电话',
  `serv_tel` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客服电话',
  `serv_qq` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客服QQ',
  `serv_email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客服邮件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='客户服务信息表';

-- ----------------------------
--  Table structure for `t_shop_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_type`;
CREATE TABLE `t_shop_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '类型名称',
  `type_identify` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '类型标示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商店主要经营类型字典表';

-- ----------------------------
--  Table structure for `t_system_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_notice`;
CREATE TABLE `t_system_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '系统公告标题',
  `content` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '系统公告内容',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '管理员ID',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统公告表';

-- ----------------------------
--  Table structure for `t_to_employ`
-- ----------------------------
DROP TABLE IF EXISTS `t_to_employ`;
CREATE TABLE `t_to_employ` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '应聘者姓名',
  `email` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `link_tel` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `resume_text` text COLLATE utf8_bin COMMENT '文本简历内容',
  `resume_url` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '文档简历URL',
  `sub_time` datetime DEFAULT NULL COMMENT '提交时间',
  `merc_id` bigint(20) DEFAULT NULL,
  `recruit_id` bigint(20) NOT NULL COMMENT '招聘信息ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '顾客ID（为空则为游客应聘）',
  PRIMARY KEY (`id`),
  KEY `FK_t_to_employ_t_customer` (`customer_id`),
  KEY `FK_t_to_employ_t_merchant` (`merc_id`),
  KEY `FK_t_to_employ_t_recruit_info` (`recruit_id`),
  CONSTRAINT `FK_t_to_employ_t_recruit_info` FOREIGN KEY (`recruit_id`) REFERENCES `t_recruit_info` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_t_to_employ_t_customer` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FK_t_to_employ_t_merchant` FOREIGN KEY (`merc_id`) REFERENCES `t_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='应聘记录信息表';

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
  KEY `role_id` (`role_id`),
  CONSTRAINT `FK_t_user_t_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_privilege` VALUES ('1','系统管理','系统管理','','系统管理','1',NULL), ('2','商家管理','商家管理','32421321','','1',NULL), ('3','11','22','33','4','1','3'), ('6','dd','fdsf','fdsfd','fdsf','1','3'), ('8','fdafd','fdsa','fdsa','fdsa','1','6'), ('9','账号管理','账号管理','account','','1','1'), ('10','资讯管理','资讯管理','','资讯管理','1',NULL), ('11','222','333','333','33','1','1'), ('13','333','2332','32323','3323','1','1'), ('14','11','11','11','11','1','1'), ('15','fdsa','fdd','dds','ss','1','1'), ('16','11','dsads','dsad','dsad','1','1'), ('17','323hhhhhhhhhhh','333hhhhhhhhhhhh','hhhhhhhhhhhhhh','hhhhhhhhhhhhh','1','1'), ('18','房价开始','房价开始','房价开始','房价开始',NULL,'1'), ('19','fuckyou','fuckyou','fuckyou','fuckyou','1','1'), ('20','222ggggggggggg','23323','32323','33','1','1'), ('21','zzzzzzzzz','zzz','zz','zz','1','1'), ('22','bbbbbb','bbbb','bbbbbbbb','bbbbbbb','1','1'), ('23','423','32','43','324','1','10'), ('35','32123很发达','3232','3232','3232','1',NULL), ('36','32123很发达','3232','3232','3232','1',NULL), ('37','干撒','432','32','32332',NULL,NULL), ('39','高乎视低','恶趣味','打算','阿斯达',NULL,NULL), ('41','6好的','6','6','6',NULL,NULL), ('42','框架','5','5','5',NULL,NULL), ('43','555','5555','555','5555',NULL,NULL), ('44','哈哈哈','呵呵','和','和',NULL,NULL), ('45','66','66666','66666666','66666666666666',NULL,NULL), ('51','TTT','TTT','TTT','TTT',NULL,'39'), ('52','111','111','111','111',NULL,NULL), ('53','111','111','111','111',NULL,NULL), ('54','WWW','WWW','WWW','WWW',NULL,'39'), ('55','DDD','DDD','DDD','DDD',NULL,'39'), ('56','SSS','SSS','SSS','SSS','1','39'), ('57','FFF','FFF','FFF','FFF',NULL,'39'), ('58','GGG','GGG','GGG','GGG','1','39'), ('59','JJJ','JJJ','JJJ','',NULL,NULL), ('60','JJJ','JJJ','JJJ','',NULL,NULL), ('61','21','C','C','C',NULL,NULL), ('62','21','C','C','C',NULL,NULL), ('63','21','C','C','C',NULL,NULL), ('64','000','000','000','000',NULL,NULL), ('65','777','777','777','777',NULL,NULL), ('66','00','00','00','00',NULL,NULL), ('67','7','7777','7','7',NULL,NULL), ('68','5','5','5','5',NULL,NULL), ('69','32','321','321','',NULL,NULL), ('70','2132','','','',NULL,NULL), ('71','22222222222222','','','',NULL,NULL), ('72','1111111111111111111','','','',NULL,NULL), ('73','大厦快乐','','','',NULL,NULL), ('74','AAAAAAAAAA','AAA','AAA','AAA',NULL,'73'), ('75','BBBBBB','BBBB','BBBB','BBBB',NULL,'73'), ('76','2','S','','',NULL,'73'), ('77','999','','','',NULL,NULL), ('78','SSS','SSS','SSS','SSS',NULL,'60'), ('79','===','==','','',NULL,'36'), ('80','435','','','',NULL,'41'), ('81',']]]','','','',NULL,'39'), ('82','NNNNNNNNNN','NNN','NNN','NN',NULL,'41'), ('83','GHHH','HHH','HHH','HHH',NULL,'41'), ('84','PPP','PPP','PPP','PPP',NULL,'59'), ('85','OOO','OOO','OOO','OOO',NULL,'59'), ('86','LLL','LLL','LLL','LLL',NULL,'53'), ('87','HHH','HHH','HHH','HHH',NULL,'53'), ('88','MMM','MMM','MMM','MMM',NULL,'77'), ('89','44','44','44','44',NULL,'77'), ('90','YYY','YYY','YYY','YYY',NULL,'77'), ('91','543','543','543','534',NULL,NULL), ('92','·','·','·','',NULL,'36'), ('93','423','423','23','432',NULL,'36'), ('94','44','423','44','4',NULL,'36'), ('95','KKK','KKK','KKK','KKK',NULL,'53'), ('96','DDDDDDD','D','D','D',NULL,NULL), ('97','QWQ','QWQ','QWQ','QWQ',NULL,'96'), ('98','6','','','',NULL,'96'), ('99','555','111','1111','1',NULL,'9'), ('100','AAAAAAAAAA','AA','','',NULL,'99'), ('101','aaa','','','',NULL,'99'), ('102','-','','','',NULL,'101'), ('103','`','','','',NULL,'102'), ('104','Z','','','',NULL,'103'), ('105','2313','','','',NULL,'104'), ('106','21424','','','',NULL,'105'), ('107','321231','','','',NULL,'106'), ('108','321','','','',NULL,'107'), ('109','21231','','','',NULL,'108');
INSERT INTO `t_province` VALUES ('1','四川'), ('2','广东'), ('3','河南'), ('4','山西'), ('5','云南'), ('6','贵州'), ('7','甘肃'), ('8','广西'), ('9','西藏'), ('10','新疆'), ('11','内蒙古'), ('12','辽宁'), ('13','吉林'), ('14','黑龙江'), ('15','浙江'), ('16','江苏'), ('17','河北'), ('22','青海'), ('23','福建'), ('24','陕西'), ('25','湖南'), ('26','湖北'), ('27','直辖市');
INSERT INTO `t_role` VALUES ('2','超级管理员','我是超级管理员'), ('3','编辑员',''), ('6','张慧华','旁观者'), ('8','张慧华','12'), ('11','张慧华32','32');
INSERT INTO `t_user` VALUES ('1','张慧华','555555555','333','2',NULL), ('2','谭绍清','123','fff','2',NULL), ('4','谭绍清','123','453674398@qq.com','1',NULL), ('5','谭又中','123','453674398@qq.com','1','2'), ('8','来来来','321432432','','2',NULL), ('10','121','21',NULL,'1',NULL), ('13','21','3212',NULL,'2',NULL), ('19','2223','4	谭绍清	123456	453674398@qq.com	1	21','','2',NULL), ('20','33','332',NULL,'1',NULL), ('21','3232','33',NULL,'2',NULL), ('22','3232','32',NULL,'1',NULL), ('23','佛挡杀佛','3232','','1',NULL), ('24','432','876',NULL,'1',NULL), ('25','324','432',NULL,'2',NULL), ('27','佛挡杀佛','123','','2',NULL), ('28','发擦伤','23232','','2',NULL), ('29','发擦伤','23232','','2',NULL), ('30','公司的','24','421','2',NULL), ('31','范德萨','23','','2',NULL), ('32','张慧华332','23','','2',NULL), ('33','111','123','1','2',NULL), ('34','66','66','66','2',NULL), ('35','77','77','77','2',NULL), ('36','0','0','0','2',NULL);
