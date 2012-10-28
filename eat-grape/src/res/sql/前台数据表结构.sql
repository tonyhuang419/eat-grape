/*
MySQL Backup
Source Server Version: 5.1.32
Source Database: eatledb
Date: 2012-10-28 14:43:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `t_advert`
-- ----------------------------
DROP TABLE IF EXISTS `t_advert`;
CREATE TABLE `t_advert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(200) DEFAULT NULL COMMENT 'ͼƬURL',
  `pic_width` smallint(6) DEFAULT NULL COMMENT 'ͼƬ',
  `pic_height` smallint(6) DEFAULT NULL COMMENT 'ͼƬ߶',
  `show_text` varchar(100) DEFAULT NULL COMMENT 'չʾ˵ı',
  `link_url` varchar(200) DEFAULT NULL COMMENT 'ӵַ',
  `issue_time` datetime DEFAULT NULL COMMENT 'ʱ',
  `alt_text` varchar(100) DEFAULT NULL COMMENT 'ALTʾϢ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='λϢ';

-- ----------------------------
--  Table structure for `t_friendship_link`
-- ----------------------------
DROP TABLE IF EXISTS `t_friendship_link`;
CREATE TABLE `t_friendship_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(20) DEFAULT NULL COMMENT '',
  `link_url` varchar(200) DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ǰ̨Ϣ';

-- ----------------------------
--  Table structure for `t_front_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_front_menu`;
CREATE TABLE `t_front_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '˵',
  `url` varchar(200) DEFAULT NULL COMMENT '˵URL',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '˵ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ǰ̨˵';

-- ----------------------------
--  Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identify_type` smallint(6) DEFAULT NULL COMMENT 'ͣ0̼ң1˿ͣ2Ա',
  `identify_id` int(11) DEFAULT NULL COMMENT 'ID',
  `login_ip` varchar(30) DEFAULT NULL COMMENT '¼IP',
  `login_time` datetime DEFAULT NULL COMMENT '¼ʱ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='½־';

-- ----------------------------
--  Table structure for `t_service_information`
-- ----------------------------
DROP TABLE IF EXISTS `t_service_information`;
CREATE TABLE `t_service_information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serve_mobile` varchar(50) DEFAULT NULL COMMENT 'ͷƶ绰',
  `serve_tel` varchar(50) DEFAULT NULL COMMENT 'ͷ绰',
  `serve_qq` varchar(100) DEFAULT NULL COMMENT 'ͷQQ',
  `serve_email` varchar(100) DEFAULT NULL COMMENT 'ͷʼ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ͻϢ';

-- ----------------------------
--  Table structure for `t_system_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_system_notice`;
CREATE TABLE `t_system_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT 'ϵͳ',
  `content` text COMMENT 'ϵͳ',
  `user_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  `send_time` datetime DEFAULT NULL COMMENT 'ʱ',
  `target` smallint(6) DEFAULT NULL COMMENT '֪ͨĿ꣺(0̼ң1ǰ̨)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
