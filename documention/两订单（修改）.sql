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
USE `electronic_emporium`;

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `orderid` int(50) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户id',
  `total` decimal(10,2) DEFAULT NULL COMMENT '小计',
  `paytype` int(2) DEFAULT NULL COMMENT '支付类型1、在线支付2、货到付款',
  `status` int(10) DEFAULT NULL COMMENT '状态1未付款2、已付款',
  `shipname` varchar(20) DEFAULT NULL COMMENT '物流名称',
  `shipcode` varchar(20) DEFAULT NULL COMMENT '物流单号',
  `createtime` datetime DEFAULT NULL COMMENT '订单创建时间',
  `closetime` datetime DEFAULT NULL COMMENT '订单关闭时间',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`orderid`,`userid`,`total`,`paytype`,`status`,`shipname`,`shipcode`,`createtime`,`closetime`) values (1,1,'23.00',1,1,'菜鸟','1010','2019-09-10 11:22:14','2019-09-18 11:22:24'),(2,2,'35.00',1,2,'顺丰','46464','2019-09-11 15:15:29',NULL),(3,3,'689.00',2,2,'中通','498645468','2019-09-12 15:16:11',NULL),(4,4,'525.00',3,1,'百世','4684546','2019-09-18 15:18:17',NULL),(5,5,'37224.00',1,2,'德邦','46546','2019-09-20 15:18:26','2019-09-28 15:19:45'),(6,6,'27242.00',2,3,'申通','5465435','2019-09-12 15:18:48','2019-09-13 15:19:49'),(7,7,'65465465.00',3,4,'圆通','46456','2019-09-07 15:18:53',NULL),(8,8,'51145.00',1,2,'韵达','416541518','2019-09-30 15:18:57',NULL),(9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `order_goods_detail` */

DROP TABLE IF EXISTS `order_goods_detail`;

CREATE TABLE `order_goods_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `itemid` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `orderid` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  `total` decimal(10,2) DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`id`),
  KEY `order_id` (`orderid`),
  KEY `total` (`total`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `order_goods_detail` */

insert  into `order_goods_detail`(`id`,`itemid`,`orderid`,`price`,`num`,`total`) values (1,'1','1','9999.00',10,'99990.00'),(2,'2','1','5688.00',1,'5688.00'),(3,'2','2','5688.00',1,'5688.00'),(4,'3','2','5688.00',10,'56880.00'),(5,'3','2','5688.00',1,'5688.00'),(6,'5','4','5989.00',10,'56890.00'),(7,'5','6','5989.00',1,'5989.00'),(8,'5','5','5989.00',1,'5989.00'),(9,'6','4','699.00',1,'699.00'),(10,'7','6','199.00',1,'199.00'),(11,'8','3','4899.00',1,'4899.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
