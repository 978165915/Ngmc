/*
SQLyog v10.2
MySQL - 5.7.13
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `carousel` (
	`id` int (10) COMMENT '轮播图编号',
	`carDesc` varchar (150) COMMENT '轮播广告描述',
	`imgpath` varchar (150) COMMENT '轮播图路径',
	`createtime` varchar (150) COMMENT '用户创建时间',
	`categoryid` int (10) COMMENT '类别编号'
	 PRIMARY KEY (`id`)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;;
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('1','时向生活温馨生活','1.jpg','2019-6-8','4');
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('2','高端家电品质享受','2.jpg','2019-6-9','5');
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('3','万锅来潮先吃为敬','3.jpg','2019-6-10','3');
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('4','i7处理器镇店之宝','4.jpg','2019-6-11','2');
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('5','超清音质玩嗨你我','5.jpg','2019-6-12','6');