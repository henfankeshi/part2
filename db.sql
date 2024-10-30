/*
SQLyog Ultimate v11.3 (64 bit)
MySQL - 5.7.32-log : Database - manhuayueduxitong
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manhuayueduxitong` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `manhuayueduxitong`;

/*Table structure for table `config` */

DROP TABLE IF EXISTS `config`;

CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='配置文件';

/*Data for the table `config` */

insert  into `config`(`id`,`name`,`value`) values (1,'轮播图1','http://localhost:8080/manhuayueduxitong/upload/config1.jpg'),(2,'轮播图2','http://localhost:8080/manhuayueduxitong/upload/config2.jpg'),(3,'轮播图3','http://localhost:8080/manhuayueduxitong/upload/config3.jpg');

/*Table structure for table `dictionary` */

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) DEFAULT NULL COMMENT '字段名',
  `code_index` int(11) DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int(11) DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='字典';

/*Data for the table `dictionary` */

insert  into `dictionary`(`id`,`dic_code`,`dic_name`,`code_index`,`index_name`,`super_id`,`beizhu`,`create_time`) values (1,'sex_types','性别类型',1,'男',NULL,NULL,'2022-04-21 15:23:34'),(2,'sex_types','性别类型',2,'女',NULL,NULL,'2022-04-21 15:23:34'),(3,'shangxia_types','上下架',1,'上架',NULL,NULL,'2022-04-21 15:23:34'),(4,'shangxia_types','上下架',2,'下架',NULL,NULL,'2022-04-21 15:23:34'),(5,'manhua_types','漫画类型',1,'漫画类型1',NULL,NULL,'2022-04-21 15:23:34'),(6,'manhua_types','漫画类型',2,'漫画类型2',NULL,NULL,'2022-04-21 15:23:34'),(7,'manhua_types','漫画类型',3,'漫画类型3',NULL,NULL,'2022-04-21 15:23:34'),(8,'manhua_types','漫画类型',4,'漫画类型4',NULL,NULL,'2022-04-21 15:23:34'),(9,'manhua_collection_types','收藏表类型',1,'收藏',NULL,NULL,'2022-04-21 15:23:34'),(10,'manhua_collection_types','收藏表类型',2,'赞',NULL,NULL,'2022-04-21 15:23:34'),(11,'manhua_collection_types','收藏表类型',3,'踩',NULL,NULL,'2022-04-21 15:23:34'),(12,'zhangjie_collection_types','收藏表类型',1,'收藏',NULL,NULL,'2022-04-21 15:23:34'),(13,'gonggao_types','公告类型',1,'公告类型1',NULL,NULL,'2022-04-21 15:23:34'),(14,'gonggao_types','公告类型',2,'公告类型2',NULL,NULL,'2022-04-21 15:23:34'),(15,'manhua_types','漫画类型',5,'漫画类型5',NULL,'','2022-04-21 16:40:56');

/*Table structure for table `gonggao` */

DROP TABLE IF EXISTS `gonggao`;

CREATE TABLE `gonggao` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `gonggao_name` varchar(200) DEFAULT NULL COMMENT '公告名称 Search111  ',
  `gonggao_photo` varchar(200) DEFAULT NULL COMMENT '公告图片 ',
  `gonggao_types` int(11) NOT NULL COMMENT '公告类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '公告发布时间 ',
  `gonggao_content` text COMMENT '公告详情 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='公告';

/*Data for the table `gonggao` */

insert  into `gonggao`(`id`,`gonggao_name`,`gonggao_photo`,`gonggao_types`,`insert_time`,`gonggao_content`,`create_time`) values (1,'公告名称1','http://localhost:8080/manhuayueduxitong/upload/gonggao1.jpg',2,'2022-04-21 15:25:48','公告详情1','2022-04-21 15:25:48'),(2,'公告名称2','http://localhost:8080/manhuayueduxitong/upload/gonggao2.jpg',1,'2022-04-21 15:25:48','公告详情2','2022-04-21 15:25:48'),(3,'公告名称3','http://localhost:8080/manhuayueduxitong/upload/gonggao3.jpg',1,'2022-04-21 15:25:48','公告详情3','2022-04-21 15:25:48'),(4,'公告名称4','http://localhost:8080/manhuayueduxitong/upload/gonggao4.jpg',2,'2022-04-21 15:25:48','公告详情4','2022-04-21 15:25:48'),(5,'公告名称5','http://localhost:8080/manhuayueduxitong/upload/gonggao5.jpg',1,'2022-04-21 15:25:48','公告详情5','2022-04-21 15:25:48');

/*Table structure for table `manhua` */

DROP TABLE IF EXISTS `manhua`;

CREATE TABLE `manhua` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `manhua_name` varchar(200) DEFAULT NULL COMMENT '漫画名称  Search111 ',
  `manhua_uuid_number` varchar(200) DEFAULT NULL COMMENT '漫画编号  Search111 ',
  `manhua_photo` varchar(200) DEFAULT NULL COMMENT '漫画照片',
  `manhua_types` int(11) DEFAULT NULL COMMENT '漫画类型 Search111',
  `manhua_clicknum` int(11) DEFAULT NULL COMMENT '漫画热度 ',
  `manhua_content` text COMMENT '漫画介绍 ',
  `shangxia_types` int(11) DEFAULT NULL COMMENT '是否上架 ',
  `manhua_delete` int(11) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='漫画';

/*Data for the table `manhua` */

insert  into `manhua`(`id`,`yonghu_id`,`manhua_name`,`manhua_uuid_number`,`manhua_photo`,`manhua_types`,`manhua_clicknum`,`manhua_content`,`shangxia_types`,`manhua_delete`,`create_time`) values (1,2,'漫画名称1','165052594846592','http://localhost:8080/manhuayueduxitong/upload/manhua1.jpg',3,366,'漫画介绍1',1,1,'2022-04-21 15:25:48'),(2,1,'漫画名称2','165052594846633','http://localhost:8080/manhuayueduxitong/upload/manhua2.jpg',4,224,'漫画介绍2',1,1,'2022-04-21 15:25:48'),(3,3,'漫画名称3','165052594846630','http://localhost:8080/manhuayueduxitong/upload/manhua3.jpg',1,444,'漫画介绍3',1,1,'2022-04-21 15:25:48'),(4,1,'漫画名称4','165052594846649','http://localhost:8080/manhuayueduxitong/upload/manhua4.jpg',2,263,'漫画介绍4',1,1,'2022-04-21 15:25:48'),(5,3,'漫画名称5','165052594846663','http://localhost:8080/manhuayueduxitong/upload/manhua5.jpg',4,306,'漫画介绍5',1,1,'2022-04-21 15:25:48');

/*Table structure for table `manhua_collection` */

DROP TABLE IF EXISTS `manhua_collection`;

CREATE TABLE `manhua_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `manhua_id` int(11) DEFAULT NULL COMMENT '漫画',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `manhua_collection_types` int(11) DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='漫画收藏';

/*Data for the table `manhua_collection` */

insert  into `manhua_collection`(`id`,`manhua_id`,`yonghu_id`,`manhua_collection_types`,`insert_time`,`create_time`) values (1,1,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(2,2,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(3,3,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(4,4,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(5,5,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(6,4,1,1,'2022-04-21 16:39:21','2022-04-21 16:39:21');

/*Table structure for table `manhua_liuyan` */

DROP TABLE IF EXISTS `manhua_liuyan`;

CREATE TABLE `manhua_liuyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `manhua_id` int(11) DEFAULT NULL COMMENT '漫画',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `manhua_liuyan_text` text COMMENT '留言内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '留言时间',
  `reply_text` text COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='漫画留言';

/*Data for the table `manhua_liuyan` */

insert  into `manhua_liuyan`(`id`,`manhua_id`,`yonghu_id`,`manhua_liuyan_text`,`insert_time`,`reply_text`,`update_time`,`create_time`) values (1,1,1,'留言内容1','2022-04-21 15:25:48','回复信息1','2022-04-21 15:25:48','2022-04-21 15:25:48'),(2,2,2,'留言内容2','2022-04-21 15:25:48','回复信息2','2022-04-21 15:25:48','2022-04-21 15:25:48'),(3,3,3,'留言内容3','2022-04-21 15:25:48','回复信息3','2022-04-21 15:25:48','2022-04-21 15:25:48'),(4,4,3,'留言内容4','2022-04-21 15:25:48','回复信息4','2022-04-21 15:25:48','2022-04-21 15:25:48'),(5,5,2,'留言内容5','2022-04-21 15:25:48','回复信息5','2022-04-21 15:25:48','2022-04-21 15:25:48'),(6,1,1,'阿萨德撒打电话','2022-04-21 16:39:05',NULL,NULL,'2022-04-21 16:39:05');

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='token表';

/*Data for the table `token` */

insert  into `token`(`id`,`userid`,`username`,`tablename`,`role`,`token`,`addtime`,`expiratedtime`) values (1,6,'admin','users','管理员','lpwudb790vd9k2mrckochmpy25vim23e','2022-04-21 15:32:06','2022-04-21 17:46:00'),(2,1,'a1','yonghu','用户','4w3f7v2gjthx4qe5cqu140f08kivhprm','2022-04-21 15:36:07','2022-04-21 17:41:28'),(3,3,'a3','yonghu','用户','18k1tpyhtmuyok9eeyzvlkk3cbdrbhuk','2022-04-21 16:42:46','2022-04-21 17:42:46');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员';

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`role`,`addtime`) values (6,'admin','admin','管理员','2022-05-02 14:51:13');

/*Table structure for table `yonghu` */

DROP TABLE IF EXISTS `yonghu`;

CREATE TABLE `yonghu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) DEFAULT NULL COMMENT '账户',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `yonghu_name` varchar(200) DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_phone` varchar(200) DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `sex_types` int(11) DEFAULT NULL COMMENT '性别',
  `yonghu_email` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户';

/*Data for the table `yonghu` */

insert  into `yonghu`(`id`,`username`,`password`,`yonghu_name`,`yonghu_phone`,`yonghu_id_number`,`yonghu_photo`,`sex_types`,`yonghu_email`,`create_time`) values (1,'a1','123456','用户姓名1','17703786901','410224199610232001','http://localhost:8080/manhuayueduxitong/upload/yonghu1.jpg',1,'1@qq.com','2022-04-21 15:25:48'),(2,'a2','123456','用户姓名2','17703786902','410224199610232002','http://localhost:8080/manhuayueduxitong/upload/yonghu2.jpg',2,'2@qq.com','2022-04-21 15:25:48'),(3,'a3','123456','用户姓名3','17703786903','410224199610232003','http://localhost:8080/manhuayueduxitong/upload/yonghu3.jpg',1,'3@qq.com','2022-04-21 15:25:48');

/*Table structure for table `zhangjie` */

DROP TABLE IF EXISTS `zhangjie`;

CREATE TABLE `zhangjie` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `manhua_id` int(11) DEFAULT NULL COMMENT '漫画',
  `zhangjie_name` varchar(200) DEFAULT NULL COMMENT '章节名称  Search111 ',
  `zhangjie_content` text COMMENT '章节内容',
  `shangxia_types` int(11) DEFAULT NULL COMMENT '是否上架 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show2 nameShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='章节';

/*Data for the table `zhangjie` */

insert  into `zhangjie`(`id`,`manhua_id`,`zhangjie_name`,`zhangjie_content`,`shangxia_types`,`create_time`) values (1,1,'章节名称1','章节内容1',1,'2022-04-21 15:25:48'),(2,2,'章节名称2','<p>章节内容2</p><p>saaga<img src=\"http://localhost:8080/manhuayueduxitong/upload/1650530541758.jpg\"></p><p>saaa的撒化生寺</p>',1,'2022-04-21 15:25:48'),(3,3,'章节名称3','章节内容3',1,'2022-04-21 15:25:48'),(4,4,'章节名称4','章节内容4',1,'2022-04-21 15:25:48'),(5,5,'章节名称5','章节内容5',1,'2022-04-21 15:25:48'),(6,1,'章节名称2','章节内容2',1,'2022-04-21 15:25:48'),(7,1,'章节名称3','章节内容3',1,'2022-04-21 15:25:48'),(8,1,'章节名称4','章节内容4',1,'2022-04-21 15:25:48'),(9,1,'章节名称5','章节内容5',1,'2022-04-21 15:25:48');

/*Table structure for table `zhangjie_collection` */

DROP TABLE IF EXISTS `zhangjie_collection`;

CREATE TABLE `zhangjie_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zhangjie_id` int(11) DEFAULT NULL COMMENT '章节',
  `yonghu_id` int(11) DEFAULT NULL COMMENT '用户',
  `zhangjie_collection_types` int(11) DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='章节收藏';

/*Data for the table `zhangjie_collection` */

insert  into `zhangjie_collection`(`id`,`zhangjie_id`,`yonghu_id`,`zhangjie_collection_types`,`insert_time`,`create_time`) values (1,1,1,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(2,2,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(3,3,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(4,4,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48'),(5,5,2,1,'2022-04-21 15:25:48','2022-04-21 15:25:48');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
