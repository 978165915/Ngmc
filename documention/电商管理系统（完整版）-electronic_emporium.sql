/*
SQLyog v10.2 
MySQL - 5.7.13 : Database - electronic_emporium
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`electronic_emporium` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `electronic_emporium`;

/*Table structure for table `carousel` */

DROP TABLE IF EXISTS `carousel`;

CREATE TABLE `carousel` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `carDesc` varchar(150) DEFAULT NULL COMMENT '轮播图描述',
  `imgpath` varchar(150) DEFAULT NULL COMMENT '轮播图图片名',
  `createtime` varchar(150) DEFAULT NULL COMMENT '创建时间',
  `categoryid` int(10) DEFAULT NULL COMMENT '商品类型',
  PRIMARY KEY (`id`),
  KEY `typeidFK` (`categoryid`),
  CONSTRAINT `typeidFK` FOREIGN KEY (`categoryid`) REFERENCES `good_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `carousel` */

insert  into `carousel`(`id`,`carDesc`,`imgpath`,`createtime`,`categoryid`) values (1,'时向生活温馨生活','1.jpg','2019-6-8',4);
insert  into `carousel`(`id`,`carDesc`,`imgpath`,`createtime`,`categoryid`) values (2,'高端家电品质享受','2.jpg','2019-6-9',5);
insert  into `carousel`(`id`,`carDesc`,`imgpath`,`createtime`,`categoryid`) values (3,'万锅来潮先吃为敬','3.jpg','2019-6-10',3);
insert  into `carousel`(`id`,`carDesc`,`imgpath`,`createtime`,`categoryid`) values (4,'i7处理器镇店之宝','4.jpg','2019-6-11',2);
insert  into `carousel`(`id`,`carDesc`,`imgpath`,`createtime`,`categoryid`) values (5,'超清音质玩嗨你我','5.jpg','2019-6-12',6);

/*Table structure for table `good_type` */

DROP TABLE IF EXISTS `good_type`;

CREATE TABLE `good_type` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '类型编号',
  `typename` varchar(50) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `good_type` */

insert  into `good_type`(`id`,`typename`) values (1,'手机');
insert  into `good_type`(`id`,`typename`) values (2,'电脑');
insert  into `good_type`(`id`,`typename`) values (3,'生鲜');
insert  into `good_type`(`id`,`typename`) values (4,'水果');
insert  into `good_type`(`id`,`typename`) values (5,'电器');
insert  into `good_type`(`id`,`typename`) values (6,'配件');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `typeid` int(20) DEFAULT NULL COMMENT '类型id',
  `imgpath` varchar(50) DEFAULT NULL COMMENT '商品图片路径',
  `price` decimal(7,2) DEFAULT NULL COMMENT '商品价格',
  `goodsDesc` varchar(1000) DEFAULT NULL COMMENT '商品描述',
  `createTime` datetime DEFAULT NULL COMMENT '商品上架时间',
  PRIMARY KEY (`id`),
  KEY `id_fk` (`typeid`),
  CONSTRAINT `typeid_fk` FOREIGN KEY (`typeid`) REFERENCES `good_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (1,'Apple MacBook Pro',2,'2018110101.jpg','9999.00','15.4英寸笔记本电脑 银色(Core i7 处理器/16GB内存/256GB SSD闪存/Retina屏 MJLQ2CH/A)','2019-08-30 10:00:27');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (2,'Apple iPhone 8',1,'2018110102.jpg','5688.00','Apple iPhone 8 (A1863) 64GB 金色 移动联通电信4G手机','2019-08-30 10:04:06');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (3,'三星 Galaxy S8',1,'2018110103.jpg','5688.00','三星 Galaxy S8（SM-G9500）4GB+64GB 谜夜黑（加勒比海盗定制版）移动联通电信4G手机 双卡双待','2019-08-30 10:04:59');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (4,'联想（ThinkPad）',2,'2018110104.jpg','4899.00','联想（ThinkPad） E470c（20H3A001CD）14英寸笔记本电脑（i5-6200U 8G 256G SSD 2G独显 Win10）黑色','2019-08-30 10:04:59');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (5,'佳能（Canon）',6,'2018110105.jpg','5989.00','佳能（Canon）EOS 800D 单反套机 （EF-S 18-55mm f/4-5.6 IS STM 镜头）','2019-08-30 10:07:43');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (6,'森海塞尔（Sennheiser）',6,'2018110106.jpg','699.00','森海塞尔（Sennheiser）MOMENTUM In-Ear Wireless 馒头蓝牙入耳式耳机 黑色','2019-08-30 10:08:43');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (7,'360 智能摄像机',6,'2018110107.jpg','199.00','360 智能摄像机 小水滴1080P版 网络wifi家用监控高清摄像头 高清夜视 双向通话 远程监控 哑白','2019-08-30 10:11:35');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (8,'华为 Mate 9',1,'2018110108.jpg','4899.00','华为 Mate 9 4GB+64GB版 摩卡金 移动联通电信4G手机 双卡双待','2019-08-30 10:12:13');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (9,'HUAWEI WATCH 2',6,'2018110109.jpg','1999.00','HUAWEI WATCH 2 华为第二代智能运动手表4G版 独立SIM卡通话 GPS心率FIRSTBEAT运动指导 NFC支付 碳晶黑','2019-08-30 10:13:02');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (10,'康乐欣 越南红心火龙果',4,'2018110110.jpg','34.90','康乐欣 越南红心火龙果 5个装 单果330-400g 进口水果','2019-08-30 10:31:09');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (11,'陕西徐香绿心猕猴桃',4,'2018110111.jpg','49.90','陕西徐香绿心猕猴桃 5斤装 单果约70-90g 新鲜水果','2019-08-30 10:32:48');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (12,'泰国活冻黑虎虾（大号）',3,'2018110112.jpg','62.90','海外直采 泰国活冻黑虎虾（大号） 400g 16-20只/盒 原装进口','2019-08-30 10:34:49');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (13,'美威 智利原味三文鱼排',3,'2018110113.jpg','59.90','美威 智利原味三文鱼排（大西洋鲑）240g/袋 4片装 BAP认证 富含Ω3 海鲜水产','2019-08-30 10:36:12');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (14,'海尔 KFR-72LW/07UDP21AU1',5,'2018110114.jpg','7599.00','海尔（Haier） 3匹变频立式空调柜机 一级能效 自清洁 智能 静音空调KFR-72LW/07UDP21AU1','2019-08-30 10:38:28');
insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (15,'格力 KFR-72LW/NhZbB1W',5,'2018110115.jpg','6999.00','格力（GREE）3匹 云锦 一级能效 变频冷暖 静音 立柜式 客厅圆柱空调柜机KFR-72LW/NhZbB1W 京鱼座智能产品','2019-08-30 10:39:35');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `orderid` int(50) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `userid` int(20) DEFAULT NULL COMMENT '用户id',
  `total` varchar(50) DEFAULT NULL COMMENT '小计',
  `paytype` int(2) DEFAULT NULL COMMENT '支付类型1、在线支付2、货到付款',
  `status` int(10) DEFAULT NULL COMMENT '状态1未付款2、已付款',
  `shipname` varchar(20) DEFAULT NULL COMMENT '物流名称',
  `shipcode` varchar(20) DEFAULT NULL COMMENT '物流单号',
  `createtime` datetime DEFAULT NULL COMMENT '订单创建时间',
  `closetime` datetime DEFAULT NULL COMMENT '订单关闭时间',
  PRIMARY KEY (`orderid`),
  KEY `user_id` (`userid`),
  CONSTRAINT `user_id` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`orderid`,`userid`,`total`,`paytype`,`status`,`shipname`,`shipcode`,`createtime`,`closetime`) values (1,1,'23',1,1,'菜鸟','1010','2019-09-10 11:22:14','2019-09-18 11:22:24');
insert  into `order`(`orderid`,`userid`,`total`,`paytype`,`status`,`shipname`,`shipcode`,`createtime`,`closetime`) values (2,2,'35',1,2,'顺丰','46464','2019-09-11 15:15:29',NULL);
insert  into `order`(`orderid`,`userid`,`total`,`paytype`,`status`,`shipname`,`shipcode`,`createtime`,`closetime`) values (3,3,'689',2,2,'中通','498645468','2019-09-12 15:16:11',NULL);
insert  into `order`(`orderid`,`userid`,`total`,`paytype`,`status`,`shipname`,`shipcode`,`createtime`,`closetime`) values (4,4,'525',3,1,'百世','4684546','2019-09-18 15:18:17',NULL);

/*Table structure for table `order_goods_detail` */

DROP TABLE IF EXISTS `order_goods_detail`;

CREATE TABLE `order_goods_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `itemid` int(10) DEFAULT NULL COMMENT '商品编号',
  `orderid` int(10) DEFAULT NULL COMMENT '订单编号',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  `total` decimal(10,0) DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`id`),
  KEY `order_id` (`orderid`),
  KEY `total` (`total`),
  KEY `goodsid_FK` (`itemid`),
  CONSTRAINT `goodsid_FK` FOREIGN KEY (`itemid`) REFERENCES `goods` (`id`),
  CONSTRAINT `orderid_FK` FOREIGN KEY (`orderid`) REFERENCES `order` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `order_goods_detail` */

insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (1,1,1,'1000',1,'1000');
insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (2,2,1,'1000',1,'1000');
insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (3,3,3,'1000',1,'1000');
insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (4,2,2,'1000',1,'1000');
insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (5,3,2,'1000',1,'1000');
insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (6,4,4,'1000',1,'1000');

/*Table structure for table `shopping_car` */

DROP TABLE IF EXISTS `shopping_car`;

CREATE TABLE `shopping_car` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `goods_id` int(10) DEFAULT NULL COMMENT '商品编号',
  `num` int(5) DEFAULT NULL COMMENT '数量',
  `userid` int(10) DEFAULT NULL COMMENT '用户id',
  `create_date` varchar(19) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `shopcar_goodsid_FK` (`goods_id`),
  KEY `shopcar_userid_FK` (`userid`),
  CONSTRAINT `shopcar_goodsid_FK` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `shopcar_userid_FK` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `shopping_car` */

insert  into `shopping_car`(`id`,`goods_id`,`num`,`userid`,`create_date`) values (1,14,1,1,'2019-09-06 11:01:09');
insert  into `shopping_car`(`id`,`goods_id`,`num`,`userid`,`create_date`) values (2,13,1,1,'2019-09-06 11:01:10');
insert  into `shopping_car`(`id`,`goods_id`,`num`,`userid`,`create_date`) values (3,15,1,1,'2019-09-06 11:01:11');
insert  into `shopping_car`(`id`,`goods_id`,`num`,`userid`,`create_date`) values (4,3,1,1,'2019-09-06 11:01:21');
insert  into `shopping_car`(`id`,`goods_id`,`num`,`userid`,`create_date`) values (5,2,2,1,'2019-09-06 11:01:31');

/*Table structure for table `user_address` */

DROP TABLE IF EXISTS `user_address`;

CREATE TABLE `user_address` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userId` int(255) DEFAULT NULL COMMENT '用户主键',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `isDefault` int(2) DEFAULT '0' COMMENT '是否是默认地址（1:是 0否）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `user_address` */

insert  into `user_address`(`id`,`userId`,`address`,`createTime`,`isDefault`,`remark`) values (11,2,'北京市海淀区大有庄',NULL,0,'朋友家');
insert  into `user_address`(`id`,`userId`,`address`,`createTime`,`isDefault`,`remark`) values (12,2,'北京市海淀区大有庄',NULL,0,'女朋友公司');
insert  into `user_address`(`id`,`userId`,`address`,`createTime`,`isDefault`,`remark`) values (13,9,'北京市西直门大桥芬兰国际大厦',NULL,0,'女朋友地址');
insert  into `user_address`(`id`,`userId`,`address`,`createTime`,`isDefault`,`remark`) values (14,18,'北京市花园路小区',NULL,0,'家里');
insert  into `user_address`(`id`,`userId`,`address`,`createTime`,`isDefault`,`remark`) values (15,18,'北京市海淀区成府路',NULL,0,'公司');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(150) DEFAULT NULL COMMENT '用户名',
  `password` varchar(150) DEFAULT NULL COMMENT '密码',
  `email` varchar(96) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(96) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (1,'aaa1','698d51a19d8a121ce581499d7b701668','ddd1@qq.com','13900000001');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (2,'aaa2','698d51a19d8a121ce581499d7b701668','ddd2@qq.com','13900000002');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (3,'aaa3','698d51a19d8a121ce581499d7b701668','ddd3@qq.com','13900000003');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (4,'aaa4','698d51a19d8a121ce581499d7b701668','ddd4@qq.com','13900000004');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (5,'aaa5','698d51a19d8a121ce581499d7b701668','ddd5@qq.com','13900000005');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (6,'aaa6','698d51a19d8a121ce581499d7b701668','ddd6@qq.com','13900000006');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (7,'aaa7','698d51a19d8a121ce581499d7b701668','ddd7@qq.com','13900000007');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (8,'aaa8','698d51a19d8a121ce581499d7b701668','ddd8@qq.com','13900000008');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (9,'aaa9','698d51a19d8a121ce581499d7b701668','ddd9@qq.com','13900000009');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (10,'aaa10','698d51a19d8a121ce581499d7b701668','ddd10@qq.com','13900000010');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (11,'aaa11','698d51a19d8a121ce581499d7b701668','ddd11@qq.com','13900000011');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (12,'aaa12','698d51a19d8a121ce581499d7b701668','ddd12@qq.com','13900000012');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (13,'aaa13','698d51a19d8a121ce581499d7b701668','ddd13@qq.com','13900000013');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (14,'aaa14','698d51a19d8a121ce581499d7b701668','ddd14@qq.com','13900000014');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (15,'aaa15','698d51a19d8a121ce581499d7b701668','ddd15@qq.com','13900000015');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (16,'aaa16','698d51a19d8a121ce581499d7b701668','ddd16@qq.com','13900000016');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (17,'aaa17','698d51a19d8a121ce581499d7b701668','ddd17@qq.com','13900000017');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (18,'aaa18','698d51a19d8a121ce581499d7b701668','ddd18@qq.com','13900000018');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (19,'aaa19','698d51a19d8a121ce581499d7b701668','ddd19@qq.com','13900000019');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (20,'aaa20','698d51a19d8a121ce581499d7b701668','ddd20@qq.com','13900000020');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (21,'aaa21','698d51a19d8a121ce581499d7b701668','ddd21@qq.com','13900000021');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (22,'aaa22','698d51a19d8a121ce581499d7b701668','ddd22@qq.com','13900000022');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (23,'aaa23','698d51a19d8a121ce581499d7b701668','ddd23@qq.com','13900000023');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (24,'aaa24','698d51a19d8a121ce581499d7b701668','ddd24@qq.com','13900000024');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (25,'aaa25','698d51a19d8a121ce581499d7b701668','ddd25@qq.com','13900000025');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (26,'aaa26','698d51a19d8a121ce581499d7b701668','ddd26@qq.com','13900000026');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (27,'aaa27','698d51a19d8a121ce581499d7b701668','ddd27@qq.com','13900000027');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (28,'aaa28','698d51a19d8a121ce581499d7b701668','ddd28@qq.com','13900000028');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (29,'aaa29','698d51a19d8a121ce581499d7b701668','ddd29@qq.com','13900000029');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (30,'aaa30','698d51a19d8a121ce581499d7b701668','ddd30@qq.com','13900000030');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (31,'aaa31','698d51a19d8a121ce581499d7b701668','ddd31@qq.com','13900000031');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (32,'aaa32','698d51a19d8a121ce581499d7b701668','ddd32@qq.com','13900000032');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (33,'aaa33','698d51a19d8a121ce581499d7b701668','ddd33@qq.com','13900000033');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (34,'aaa34','698d51a19d8a121ce581499d7b701668','ddd34@qq.com','13900000034');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (35,'aaa35','698d51a19d8a121ce581499d7b701668','ddd35@qq.com','13900000035');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (36,'aaa36','698d51a19d8a121ce581499d7b701668','ddd36@qq.com','13900000036');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (37,'aaa37','698d51a19d8a121ce581499d7b701668','ddd37@qq.com','13900000037');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (38,'aaa38','698d51a19d8a121ce581499d7b701668','ddd38@qq.com','13900000038');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (39,'aaa39','698d51a19d8a121ce581499d7b701668','ddd39@qq.com','13900000039');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (40,'aaa40','698d51a19d8a121ce581499d7b701668','ddd40@qq.com','13900000040');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (41,'aaa41','698d51a19d8a121ce581499d7b701668','ddd41@qq.com','13900000041');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (42,'aaa42','698d51a19d8a121ce581499d7b701668','ddd42@qq.com','13900000042');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (43,'aaa43','698d51a19d8a121ce581499d7b701668','ddd43@qq.com','13900000043');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (44,'aaa44','698d51a19d8a121ce581499d7b701668','ddd44@qq.com','13900000044');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (45,'aaa45','698d51a19d8a121ce581499d7b701668','ddd45@qq.com','13900000045');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (46,'aaa46','698d51a19d8a121ce581499d7b701668','ddd46@qq.com','13900000046');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (47,'aaa47','698d51a19d8a121ce581499d7b701668','ddd47@qq.com','13900000047');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (48,'aaa48','698d51a19d8a121ce581499d7b701668','ddd48@qq.com','13900000048');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (49,'aaa49','698d51a19d8a121ce581499d7b701668','ddd49@qq.com','13900000049');
insert  into `userinfo`(`id`,`username`,`password`,`email`,`phone`) values (50,'aaa50','698d51a19d8a121ce581499d7b701668','ddd50@qq.com','13900000050');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
