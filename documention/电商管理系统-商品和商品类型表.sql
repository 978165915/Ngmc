/*
SQLyog v10.2 
MySQL - 5.5.34 : Database - electronic_emporium
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`electronic_emporium` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `electronic_emporium`;

/*Table structure for table `good_type` */

DROP TABLE IF EXISTS `good_type`;

CREATE TABLE `good_type` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) DEFAULT NULL COMMENT '类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
