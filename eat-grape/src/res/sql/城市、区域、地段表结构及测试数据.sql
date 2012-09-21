/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : eatledb

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2012-09-21 22:59:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_distinct`
-- ----------------------------
DROP TABLE IF EXISTS `t_distinct`;
CREATE TABLE `t_distinct` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dist_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '地段 / 片区名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级地区ID（0表示顶级区域，如：四川省）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地段 / 片区表';

-- ----------------------------
-- Records of t_distinct
-- ----------------------------
INSERT INTO `t_distinct` VALUES ('1', '重庆', null);
INSERT INTO `t_distinct` VALUES ('2', '上海', null);
INSERT INTO `t_distinct` VALUES ('3', '北京', null);
INSERT INTO `t_distinct` VALUES ('4', '天津', null);
INSERT INTO `t_distinct` VALUES ('5', '广东', null);
INSERT INTO `t_distinct` VALUES ('6', '广西', null);
INSERT INTO `t_distinct` VALUES ('7', '云南', null);
INSERT INTO `t_distinct` VALUES ('8', '贵州', null);
INSERT INTO `t_distinct` VALUES ('9', '渝中区', '1');
INSERT INTO `t_distinct` VALUES ('10', '江北区', '1');
INSERT INTO `t_distinct` VALUES ('11', '浙江', null);
INSERT INTO `t_distinct` VALUES ('12', '南岸区', '1');
INSERT INTO `t_distinct` VALUES ('13', '渝北区', '1');
INSERT INTO `t_distinct` VALUES ('14', '九龙坡区', '1');
INSERT INTO `t_distinct` VALUES ('15', '大渡口区', '1');
INSERT INTO `t_distinct` VALUES ('16', '北碚区', '1');
INSERT INTO `t_distinct` VALUES ('17', '巴南区', '1');
INSERT INTO `t_distinct` VALUES ('18', '铜梁县', '1');
INSERT INTO `t_distinct` VALUES ('20', '长寿区', '1');
INSERT INTO `t_distinct` VALUES ('21', '万州区', '1');
INSERT INTO `t_distinct` VALUES ('22', '涪陵区', '1');
INSERT INTO `t_distinct` VALUES ('23', '黔江区', '1');
INSERT INTO `t_distinct` VALUES ('24', '江津区', '1');
INSERT INTO `t_distinct` VALUES ('25', '永川区', '1');
INSERT INTO `t_distinct` VALUES ('26', '合川区', '1');
INSERT INTO `t_distinct` VALUES ('28', '万盛区', '1');
INSERT INTO `t_distinct` VALUES ('29', '解放碑', '9');
INSERT INTO `t_distinct` VALUES ('30', '朝天门', '9');
INSERT INTO `t_distinct` VALUES ('31', '七星岗', '9');
INSERT INTO `t_distinct` VALUES ('32', '观音岩', '9');
INSERT INTO `t_distinct` VALUES ('33', '较场口', '9');
INSERT INTO `t_distinct` VALUES ('34', '上清寺', '9');
INSERT INTO `t_distinct` VALUES ('35', '大坪', '9');
INSERT INTO `t_distinct` VALUES ('36', '袁家岗', '9');
INSERT INTO `t_distinct` VALUES ('37', '菜园坝', '9');
INSERT INTO `t_distinct` VALUES ('38', '两路口', '9');
INSERT INTO `t_distinct` VALUES ('39', '文化宫', '9');
INSERT INTO `t_distinct` VALUES ('40', '牛角沱', '9');
INSERT INTO `t_distinct` VALUES ('41', '临江门', '9');
INSERT INTO `t_distinct` VALUES ('42', '洪崖洞', '9');
INSERT INTO `t_distinct` VALUES ('43', '歇台子', '9');
INSERT INTO `t_distinct` VALUES ('44', '观音桥', '10');
INSERT INTO `t_distinct` VALUES ('45', '华新街', '10');
INSERT INTO `t_distinct` VALUES ('46', '五里店', '10');
INSERT INTO `t_distinct` VALUES ('47', '李家坪', '10');
INSERT INTO `t_distinct` VALUES ('48', '红旗河沟', '10');
INSERT INTO `t_distinct` VALUES ('49', '大兴村', '10');
INSERT INTO `t_distinct` VALUES ('50', '大庙', '10');
INSERT INTO `t_distinct` VALUES ('51', '南坪', '12');
INSERT INTO `t_distinct` VALUES ('52', '洋人街', '12');
INSERT INTO `t_distinct` VALUES ('53', '上新街', '12');
INSERT INTO `t_distinct` VALUES ('54', '弹子石', '12');
INSERT INTO `t_distinct` VALUES ('55', '四公里', '12');
INSERT INTO `t_distinct` VALUES ('56', '五公里', '12');
INSERT INTO `t_distinct` VALUES ('57', '六公里', '12');
INSERT INTO `t_distinct` VALUES ('58', '七公里', '12');
INSERT INTO `t_distinct` VALUES ('59', '八公里', '12');
INSERT INTO `t_distinct` VALUES ('60', '会展中心', '12');
INSERT INTO `t_distinct` VALUES ('61', '加州', '13');
INSERT INTO `t_distinct` VALUES ('62', '松树桥', '13');
INSERT INTO `t_distinct` VALUES ('63', '龙湖', '13');
INSERT INTO `t_distinct` VALUES ('64', '软件园', '13');
INSERT INTO `t_distinct` VALUES ('65', '黄泥磅', '13');
INSERT INTO `t_distinct` VALUES ('66', '人和', '13');
INSERT INTO `t_distinct` VALUES ('67', '两路', '13');
INSERT INTO `t_distinct` VALUES ('68', '石桥铺', '14');
INSERT INTO `t_distinct` VALUES ('69', '杨家坪', '14');
INSERT INTO `t_distinct` VALUES ('70', '九宫庙', '15');
INSERT INTO `t_distinct` VALUES ('71', '沙坪坝区', '1');
INSERT INTO `t_distinct` VALUES ('72', '大学城', '71');
INSERT INTO `t_distinct` VALUES ('73', '三峡广场', '71');
INSERT INTO `t_distinct` VALUES ('74', '天星桥', '71');
INSERT INTO `t_distinct` VALUES ('75', '石碾盘', '71');
INSERT INTO `t_distinct` VALUES ('76', '烈士墓', '71');
INSERT INTO `t_distinct` VALUES ('77', '磁器口', '71');
INSERT INTO `t_distinct` VALUES ('78', '小龙坎', '71');
INSERT INTO `t_distinct` VALUES ('79', '山西', null);
INSERT INTO `t_distinct` VALUES ('80', '江苏', null);
INSERT INTO `t_distinct` VALUES ('81', '河南', null);
INSERT INTO `t_distinct` VALUES ('82', '河北', null);
INSERT INTO `t_distinct` VALUES ('83', '安徽', null);
INSERT INTO `t_distinct` VALUES ('84', '湖南', null);
INSERT INTO `t_distinct` VALUES ('85', '湖北', null);
INSERT INTO `t_distinct` VALUES ('86', '甘肃', null);
INSERT INTO `t_distinct` VALUES ('87', '黑龙江', null);
INSERT INTO `t_distinct` VALUES ('88', '陕西', null);
INSERT INTO `t_distinct` VALUES ('89', '西藏', null);
INSERT INTO `t_distinct` VALUES ('90', '新疆', null);
INSERT INTO `t_distinct` VALUES ('91', '辽宁', null);
INSERT INTO `t_distinct` VALUES ('92', '吉林', null);
INSERT INTO `t_distinct` VALUES ('93', '海南', null);
INSERT INTO `t_distinct` VALUES ('94', '宁夏', null);
INSERT INTO `t_distinct` VALUES ('95', '福建', null);
INSERT INTO `t_distinct` VALUES ('96', '四川', null);
INSERT INTO `t_distinct` VALUES ('97', '青海', null);
INSERT INTO `t_distinct` VALUES ('98', '内蒙古', null);
INSERT INTO `t_distinct` VALUES ('99', '香港', null);
INSERT INTO `t_distinct` VALUES ('100', '澳门', null);
INSERT INTO `t_distinct` VALUES ('101', '台湾', null);
INSERT INTO `t_distinct` VALUES ('102', '重庆大学', '72');
INSERT INTO `t_distinct` VALUES ('103', '重庆师范大学', '72');
INSERT INTO `t_distinct` VALUES ('104', '重庆医科大学', '72');
INSERT INTO `t_distinct` VALUES ('105', '重庆电子工程学院', '72');
INSERT INTO `t_distinct` VALUES ('106', '重庆房地产学院', '72');
INSERT INTO `t_distinct` VALUES ('107', '重庆医药高等专科学院', '72');
INSERT INTO `t_distinct` VALUES ('108', '重庆城市管理学院', '72');
INSERT INTO `t_distinct` VALUES ('109', '重庆科技学院', '72');
INSERT INTO `t_distinct` VALUES ('110', '解放军后勤工程学院', '72');
INSERT INTO `t_distinct` VALUES ('111', '重庆警官职业学院', '72');
INSERT INTO `t_distinct` VALUES ('112', '第三军医大学', '72');
INSERT INTO `t_distinct` VALUES ('113', '水星科技大厦', '64');
INSERT INTO `t_distinct` VALUES ('114', '土星科技大厦', '64');
INSERT INTO `t_distinct` VALUES ('115', '火星科技大厦', '64');
INSERT INTO `t_distinct` VALUES ('116', '财富中心', '64');
INSERT INTO `t_distinct` VALUES ('117', '凤凰座', '64');
INSERT INTO `t_distinct` VALUES ('118', '天王星', '64');
INSERT INTO `t_distinct` VALUES ('119', '海王星', '64');
INSERT INTO `t_distinct` VALUES ('120', '金星', '64');
INSERT INTO `t_distinct` VALUES ('121', '木星', '64');
