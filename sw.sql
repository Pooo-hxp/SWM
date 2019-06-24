/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50045
Source Host           : 127.0.0.1:3306
Source Database       : sw

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2019-06-01 15:49:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for banklist
-- ----------------------------
DROP TABLE IF EXISTS `banklist`;
CREATE TABLE `banklist` (
  `StaffName` varchar(50) character set utf8 collate utf8_bin default NULL,
  `IDNum` varchar(18) character set utf8 collate utf8_bin NOT NULL,
  `BankName` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `Unit` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `Money` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`IDNum`),
  CONSTRAINT `银行清单级联` FOREIGN KEY (`IDNum`) REFERENCES `staffinfo` (`IDNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of banklist
-- ----------------------------
INSERT INTO `banklist` VALUES ('邓丽君', '412724198805051234', '工商银行', '郑州商学院', '4100');
INSERT INTO `banklist` VALUES ('贾斯丁比伯', '412724199905051234', '招商银行', '郑州商学院', '5100');
INSERT INTO `banklist` VALUES ('罗伯特', '412724199906061234', '农业银行', '郑州商学院', '6900');
INSERT INTO `banklist` VALUES ('托尼屎大颗', '412724199906091234', '工商银行', '郑州商学院', '4300');
INSERT INTO `banklist` VALUES ('迈克尔', '412789458754121232', '光大银行', '郑州商学院', '5400');

-- ----------------------------
-- Table structure for changetable
-- ----------------------------
DROP TABLE IF EXISTS `changetable`;
CREATE TABLE `changetable` (
  `StaffNum` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `ChangeName` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `DeptName` varchar(50) character set utf8 collate utf8_bin default NULL,
  `ChangeFont` varchar(50) character set utf8 collate utf8_bin default NULL,
  `State` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`StaffNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of changetable
-- ----------------------------
INSERT INTO `changetable` VALUES ('100002', '会计系', '外语系', '调入', '待审核');
INSERT INTO `changetable` VALUES ('100003', '外语系', '机械系', '调入', '待审核');
INSERT INTO `changetable` VALUES ('100004', '外语系', '中文系', '调入', '待审核');

-- ----------------------------
-- Table structure for checkinfo
-- ----------------------------
DROP TABLE IF EXISTS `checkinfo`;
CREATE TABLE `checkinfo` (
  `StaffNum` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `Sleep` varchar(50) character set utf8 collate utf8_bin default NULL,
  `OverTime` varchar(50) character set utf8 collate utf8_bin default NULL,
  `Payroll` varchar(50) character set utf8 collate utf8_bin default NULL,
  `Money` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`StaffNum`),
  CONSTRAINT `checkinfo_ibfk_1` FOREIGN KEY (`StaffNum`) REFERENCES `staffinfo` (`StaffNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of checkinfo
-- ----------------------------
INSERT INTO `checkinfo` VALUES ('100000', '3', '4', '4000', '4500');
INSERT INTO `checkinfo` VALUES ('100001', '1', '5', '6000', '6900');
INSERT INTO `checkinfo` VALUES ('100002', '1', '6', '4000', '5100');
INSERT INTO `checkinfo` VALUES ('100003', '0', '2', '5000', '5400');
INSERT INTO `checkinfo` VALUES ('100004', '3', '2', '4000', '4100');

-- ----------------------------
-- Table structure for depeinfo
-- ----------------------------
DROP TABLE IF EXISTS `depeinfo`;
CREATE TABLE `depeinfo` (
  `DeptNum` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `DeptName` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `Total` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`DeptNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of depeinfo
-- ----------------------------
INSERT INTO `depeinfo` VALUES ('00', '信工系', '1');
INSERT INTO `depeinfo` VALUES ('01', '会计系', '1');
INSERT INTO `depeinfo` VALUES ('02', '外语系', '1');
INSERT INTO `depeinfo` VALUES ('03', '机械系', '1');
INSERT INTO `depeinfo` VALUES ('04', '中文系', '1');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `StaffJob` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `Payroll` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`StaffJob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('主任', '6000');
INSERT INTO `job` VALUES ('副主任', '5000');
INSERT INTO `job` VALUES ('教师', '4000');

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `List` int(11) NOT NULL auto_increment,
  `StaffNum` varchar(50) collate utf8_bin default NULL,
  `StaffName` varchar(50) collate utf8_bin default NULL,
  `Txt` varchar(255) collate utf8_bin NOT NULL default '',
  `DateTime` varchar(50) collate utf8_bin default NULL,
  PRIMARY KEY  (`List`,`Txt`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES ('1', '100002', '贾斯丁比伯', '这是一个测试的纯文本内容', '5月14日21时42分31秒');
INSERT INTO `msg` VALUES ('2', '100004', '邓丽君', '这是图片测试<img src=\"img/chiya.gif\" />', '5月14日21时45分21秒');
INSERT INTO `msg` VALUES ('3', '666666', '人事部', '请申请调动部门通过的教师，在六月之前来相应部门报道；', '5月14日21时48分2秒');
INSERT INTO `msg` VALUES ('4', '888888', '财政部', '因遭遇国家法定节假日，本月工资发放延后三天；', '5月14日21时49分31秒');
INSERT INTO `msg` VALUES ('5', '100004', '邓丽君', '测试同用户文本', '5月14日21时55分11秒');
INSERT INTO `msg` VALUES ('6', '888888', '财政部', 'k靠', '5月26日21时58分35秒');
INSERT INTO `msg` VALUES ('7', '666666', '人事部', '今天来测试一下词组过滤，我**<img src=\"img/daxiao.gif\">，你妈**了<img src=\"img/weixiao.gif\">', '5月30日16时9分11秒');
INSERT INTO `msg` VALUES ('8', '666666', '人事部', '对对对？？？<img src=\"img/deyi.gif\">', '5月30日16时9分42秒');
INSERT INTO `msg` VALUES ('9', '666666', '人事部', '是撒测试啊<img src=\"img/chiya.gif\">', '5月30日16时9分59秒');
INSERT INTO `msg` VALUES ('37', '666666', '人事部', 'hi，发一句心情吧~<img src=\"img/chiya.gif\">', '5月30日19时57分7秒');
INSERT INTO `msg` VALUES ('39', '666666', '人事部', 'hi，发一句心情吧~<img src=\"img/chiya.gif\">', '5月30日19时58分44秒');
INSERT INTO `msg` VALUES ('44', '100000', '托尼屎大颗', 'hi，发一句心情吧~<img src=\"img/chiya.gif\">', '5月31日21时45分4秒');
INSERT INTO `msg` VALUES ('45', '100000', '托尼屎大颗', '今天是儿童节，祝同事们节**快乐<img src=\"img/wuzuixiao.gif\">', '6月1日12时58分39秒');
INSERT INTO `msg` VALUES ('46', '888888', '财政部', '财政部祝大家节**快乐<img src=\"img/zilian.gif\">', '6月1日15时21分15秒');
INSERT INTO `msg` VALUES ('47', '888888', '财政部', '财政部祝大家节**快乐<img src=\"img/zilian.gif\">', '6月1日15时21分15秒');

-- ----------------------------
-- Table structure for payroll
-- ----------------------------
DROP TABLE IF EXISTS `payroll`;
CREATE TABLE `payroll` (
  `StaffNum` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `Payroll` varchar(50) character set utf8 collate utf8_bin default NULL,
  `Deduction` varchar(50) character set utf8 collate utf8_bin default NULL,
  `Bonus` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`StaffNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of payroll
-- ----------------------------
INSERT INTO `payroll` VALUES ('100000', '4000', '300', '600');
INSERT INTO `payroll` VALUES ('100001', '6000', '100', '1000');
INSERT INTO `payroll` VALUES ('100002', '4000', '100', '1200');
INSERT INTO `payroll` VALUES ('100003', '5000', '0', '400');
INSERT INTO `payroll` VALUES ('100004', '4000', '300', '400');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `RoleID` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `RoleName` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', '职工');
INSERT INTO `role` VALUES ('1', '人事部');
INSERT INTO `role` VALUES ('2', '财政部');

-- ----------------------------
-- Table structure for staffinfo
-- ----------------------------
DROP TABLE IF EXISTS `staffinfo`;
CREATE TABLE `staffinfo` (
  `StaffNum` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `StaffName` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `StaffSex` varchar(50) character set utf8 collate utf8_bin default NULL,
  `StaffJob` varchar(50) character set utf8 collate utf8_bin default NULL,
  `IDNum` varchar(18) character set utf8 collate utf8_bin default NULL,
  `DeptNum` varchar(50) character set utf8 collate utf8_bin default NULL,
  `DeptName` varchar(50) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`StaffNum`),
  KEY `职工表参考部门表` (`DeptNum`),
  KEY `IDNum` (`IDNum`),
  CONSTRAINT `职工表参考部门表` FOREIGN KEY (`DeptNum`) REFERENCES `depeinfo` (`DeptNum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of staffinfo
-- ----------------------------
INSERT INTO `staffinfo` VALUES ('100000', '托尼屎大颗', '男', '教师', '412724199906091234', '00', '信工系');
INSERT INTO `staffinfo` VALUES ('100001', '罗伯特', '男', '主任', '412724199906061234', '01', '会计系');
INSERT INTO `staffinfo` VALUES ('100002', '贾斯丁比伯', '男', '教师', '412724199905051234', '02', '外语系');
INSERT INTO `staffinfo` VALUES ('100003', '迈克尔', '男', '副主任', '412789458754121232', '03', '机械系');
INSERT INTO `staffinfo` VALUES ('100004', '邓丽君', '女', '教师', '412724198805051234', '04', '中文系');
INSERT INTO `staffinfo` VALUES ('666666', '人事部', '男', '管理员', '412789499954121232', '00', '人事部');
INSERT INTO `staffinfo` VALUES ('888888', '财政部', '男', '管理员', '412666458754121232', '00', '财政部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `StaffNum` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `password` varchar(50) character set utf8 collate utf8_bin NOT NULL,
  `RoleID` varchar(50) collate utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('100000', 'zhigong123', '0');
INSERT INTO `user` VALUES ('100001', 'zhigong456', '0');
INSERT INTO `user` VALUES ('100002', 'zhigong789', '0');
INSERT INTO `user` VALUES ('100003', 'zhigong147', '0');
INSERT INTO `user` VALUES ('100004', 'zhigong258', '0');
INSERT INTO `user` VALUES ('100005', 'zhigong369', '0');
INSERT INTO `user` VALUES ('666666', 'renshibu123', '1');
INSERT INTO `user` VALUES ('888888', 'caizhengbu123', '2');
