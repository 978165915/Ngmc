/*
SQLyog v10.2 
MySQL - 5.7.13 : Database - or
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `or`;

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` varchar(50) NOT NULL COMMENT '订单id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `total` varchar(50) DEFAULT NULL COMMENT '小计',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付类型1、在线支付2、货到付款',
  `status` int(10) DEFAULT NULL COMMENT '状态1未付款2、已付款',
  `ship_name` varchar(20) DEFAULT NULL COMMENT '物流名称',
  `ship_code` varchar(20) DEFAULT NULL COMMENT '物流单号',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `close_time` datetime DEFAULT NULL COMMENT '订单关闭时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `order_goods_detail` */

DROP TABLE IF EXISTS `order_goods_detail`;

CREATE TABLE `order_goods_detail` (
  `id` varchar(20) NOT NULL COMMENT '编号',
  `item_id` varchar(50) DEFAULT NULL COMMENT '商品编号',
  `order_id` varchar(50) DEFAULT NULL COMMENT '订单编号',
  `price` bigint(50) DEFAULT NULL COMMENT '单价',
  `num` int(10) DEFAULT NULL COMMENT '数量',
  `total` bigint(50) DEFAULT NULL COMMENT '小计',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `total` (`total`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_goods_detail` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
