/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.22-community-nt-log : Database - mr_caption
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mr_caption` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mr_caption`;

/*Table structure for table `caption` */

DROP TABLE IF EXISTS `caption`;

CREATE TABLE `caption` (
  `id` varchar(40) NOT NULL COMMENT '数据库主键',
  `order_no` int(11) default NULL COMMENT '这条字幕在电影中的顺序',
  `movie_id` varchar(40) default NULL COMMENT '关联电影的Id',
  `chinese` varchar(200) default NULL COMMENT '整个句子的中文释义',
  `english` varchar(255) default NULL COMMENT '整个句子的英文释义',
  `start_time` int(11) default NULL COMMENT '这个句子的开始时间，单位以毫秒计算，电影开始时候是0，到这个时间',
  `end_time` int(11) default NULL COMMENT '这个句子的结束时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` varchar(40) NOT NULL COMMENT '数据库主键',
  `movie_id` varchar(40) default NULL COMMENT '电影的编号',
  `movie_name` varchar(50) default NULL COMMENT '电影的名字',
  `movie_time` int(11) default NULL COMMENT '电影的时长，单位毫秒',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `package` */

DROP TABLE IF EXISTS `package`;

CREATE TABLE `package` (
  `id` varchar(40) NOT NULL COMMENT '数据库主键',
  `caption_id` varchar(40) default NULL COMMENT '关联关系，关联到caption',
  `chinese` varchar(255) default NULL COMMENT '单个pack的中文释义',
  `english` varchar(255) default NULL COMMENT '单个pack的英文释义',
  `start_time` int(11) default NULL COMMENT '单个pack的startTime，毫秒单位',
  `end_time` int(11) default NULL COMMENT '单个Pack的endTime',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `word` */

DROP TABLE IF EXISTS `word`;

CREATE TABLE `word` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `english` varchar(50) default NULL COMMENT '英文',
  `chinese` varchar(255) default NULL COMMENT '中文',
  `word_type` varchar(10) default NULL COMMENT '类型，动词，名词等',
  `sound_mark` varchar(50) default NULL COMMENT '音标',
  `type` varchar(10) default NULL COMMENT '类型，如基础，基本，进阶，高级等',
  `weight` tinyint(4) default NULL COMMENT '权重，单词的重要程度',
  `example` varchar(255) default NULL COMMENT '示例（啊~ 为什么会有这个）',
  PRIMARY KEY  (`id`),
  KEY `english` (`english`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
