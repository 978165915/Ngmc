/*
SQLyog v10.2 
MySQL - 5.7.13 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `carousel` (
	`id` int (10),
	`carDesc` varchar (150),
	`imgpath` varchar (150),
	`createtime` varchar (150),
	`categoryid` int (10)
); 
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('111','111','111','111','0');
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('222','222','222','222','0');
insert into `carousel` (`id`, `carDesc`, `imgpath`, `createtime`, `categoryid`) values('223',NULL,NULL,NULL,'0');
