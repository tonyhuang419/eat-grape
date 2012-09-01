/*
MySQL Backup
Source Server Version: 5.1.32
Source Database: eatledb
Date: 2012-9-1 22:05:26
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统菜单表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1','',NULL,'系统管理',NULL,'0'), ('2','',NULL,'用户管理',NULL,'1'), ('3','account',NULL,'账号管理','system/useradmin/account/showIndex.htm?navTabId=account','2'), ('4','role',NULL,'角色管理','system/useradmin/role/showIndex.htm?navTabId=role','2'), ('5','priv',NULL,'权限管理','system/useradmin/priv/showIndex.htm?navTabId=priv','2'), ('6','',NULL,'商家管理',NULL,'0'), ('7','',NULL,'咨询管理',NULL,'0'), ('8','',NULL,'功能管理','','1'), ('9','',NULL,'商家管理_1','XXX','6'), ('10','',NULL,'商家管理_1_1','','9'), ('11','',NULL,'商家管理_1_2','','9'), ('12','',NULL,'商家管理_1_2_1','','11'), ('13','',NULL,'商家管理_2','','6'), ('14','',NULL,'商家管理_2_1','','13'), ('15','',NULL,'商家管理_1_2_1_1','','12'), ('16','',NULL,'资讯管理_1','','7'), ('17','',NULL,'资讯管理_1_1','','16'), ('18','',NULL,'资讯管理_1_2','','16'), ('19','',NULL,'资讯管理_1_2_1','','18'), ('20','',NULL,'资讯管理_1_1_1','','17'), ('21','',NULL,'资讯管理_1_2_2','','18');
