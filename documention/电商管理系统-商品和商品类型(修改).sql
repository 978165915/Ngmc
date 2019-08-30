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

/*Table structure for table `good_type` */

DROP TABLE IF EXISTS `good_type`;

CREATE TABLE `good_type` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `good_type` */

insert  into `good_type`(`id`,`typename`) values (1,'手机'),(2,'电脑'),(3,'生鲜'),(4,'水果'),(5,'电器'),(6,'配件');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `typeid` int(20) DEFAULT NULL COMMENT '商品名称',
  `imgpath` varchar(50) DEFAULT NULL COMMENT '商品图片路径',
  `price` decimal(7,2) DEFAULT NULL COMMENT '商品价格',
  `goodsDesc` varchar(1000) DEFAULT NULL COMMENT '商品描述',
  `createTime` datetime DEFAULT NULL COMMENT '商品上架时间',
  PRIMARY KEY (`id`),
  KEY `id_fk` (`typeid`),
  CONSTRAINT `id_fk` FOREIGN KEY (`typeid`) REFERENCES `good_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`) values (1,'Apple MacBook Pro',2,'2018110101.jpg','9999.00','15.4英寸笔记本电脑 银色(Core i7 处理器/16GB内存/256GB SSD闪存/Retina屏 MJLQ2CH/A)','2019-08-30 10:00:27'),(2,'Apple iPhone 8',1,'2018110102.jpg','5688.00','Apple iPhone 8 (A1863) 64GB 金色 移动联通电信4G手机','2019-08-30 10:04:06'),(3,'三星 Galaxy S8',1,'2018110103.jpg','5688.00','三星 Galaxy S8（SM-G9500）4GB+64GB 谜夜黑（加勒比海盗定制版）移动联通电信4G手机 双卡双待','2019-08-30 10:04:59'),(4,'联想（ThinkPad）',2,'2018110104.jpg','4899.00','联想（ThinkPad） E470c（20H3A001CD）14英寸笔记本电脑（i5-6200U 8G 256G SSD 2G独显 Win10）黑色','2019-08-30 10:04:59'),(5,'佳能（Canon）',6,'2018110105.jpg','5989.00','佳能（Canon）EOS 800D 单反套机 （EF-S 18-55mm f/4-5.6 IS STM 镜头）','2019-08-30 10:07:43'),(6,'森海塞尔（Sennheiser）',6,'2018110106.jpg','699.00','森海塞尔（Sennheiser）MOMENTUM In-Ear Wireless 馒头蓝牙入耳式耳机 黑色','2019-08-30 10:08:43'),(7,'360 智能摄像机',6,'2018110107.jpg','199.00','360 智能摄像机 小水滴1080P版 网络wifi家用监控高清摄像头 高清夜视 双向通话 远程监控 哑白','2019-08-30 10:11:35'),(8,'华为 Mate 9',1,'2018110108.jpg','4899.00','华为 Mate 9 4GB+64GB版 摩卡金 移动联通电信4G手机 双卡双待','2019-08-30 10:12:13'),(9,'HUAWEI WATCH 2',6,'2018110109.jpg','1999.00','HUAWEI WATCH 2 华为第二代智能运动手表4G版 独立SIM卡通话 GPS心率FIRSTBEAT运动指导 NFC支付 碳晶黑','2019-08-30 10:13:02'),(10,'康乐欣 越南红心火龙果',4,'2018110110.jpg','34.90','康乐欣 越南红心火龙果 5个装 单果330-400g 进口水果','2019-08-30 10:31:09'),(11,'陕西徐香绿心猕猴桃',4,'2018110111.jpg','49.90','陕西徐香绿心猕猴桃 5斤装 单果约70-90g 新鲜水果','2019-08-30 10:32:48'),(12,'泰国活冻黑虎虾（大号）',3,'2018110112.jpg','62.90','海外直采 泰国活冻黑虎虾（大号） 400g 16-20只/盒 原装进口','2019-08-30 10:34:49'),(13,'美威 智利原味三文鱼排',3,'2018110113.jpg','59.90','美威 智利原味三文鱼排（大西洋鲑）240g/袋 4片装 BAP认证 富含Ω3 海鲜水产','2019-08-30 10:36:12'),(14,'海尔 KFR-72LW/07UDP21AU1',5,'2018110114.jpg','7599.00','海尔（Haier） 3匹变频立式空调柜机 一级能效 自清洁 智能 静音空调KFR-72LW/07UDP21AU1','2019-08-30 10:38:28'),(15,'格力 KFR-72LW/NhZbB1W',5,'2018110115.jpg','6999.00','格力（GREE）3匹 云锦 一级能效 变频冷暖 静音 立柜式 客厅圆柱空调柜机KFR-72LW/NhZbB1W 京鱼座智能产品','2019-08-30 10:39:35');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
