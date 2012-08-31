/*
MySQL Backup
Source Server Version: 5.1.32
Source Database: eatledb
Date: 2012-8-31 09:56:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '菜单链接',
  `parent_id` bigint(20) DEFAULT '1' COMMENT '父菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统菜单表';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1','系统管理',NULL,'0'), ('2','用户管理',NULL,'1'), ('3','账号管理','system/account/showIndex.htm?navTabId=account','2'), ('4','角色管理','system/role/showIndex.htm?navTabId=role','2'), ('5','权限管理','system/priv/showIndex.htm?navTabId=priv','2'), ('6','商家管理',NULL,'0'), ('7','咨询管理',NULL,'0'), ('8','功能管理','','1');
