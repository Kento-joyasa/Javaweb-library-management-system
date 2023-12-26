/*
SQLyog Professional v12.5.1 (64 bit)
MySQL - 5.7.29 : Database - books_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books_management` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `books_management`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL,
  `book_author` varchar(20) DEFAULT NULL,
  `book_price` varchar(20) DEFAULT NULL,
  `book_desc` varchar(40) DEFAULT NULL,
  `book_type_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `book_type_id` (`book_type_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`book_type_id`) REFERENCES `books_type` (`book_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`book_id`,`book_name`,`book_author`,`book_price`,`book_desc`,`book_type_id`) values 
(1,'C程序设计','123','10','C语言书籍',1),
(2,'C++ Primer Plus','321','12','C++书籍',1),
(3,'保护环境','1234','12','保护环境书籍',2),
(4,'abc','abc123','aaaaa',' asddfgg ',1);

/*Table structure for table `books_type` */

DROP TABLE IF EXISTS `books_type`;

CREATE TABLE `books_type` (
  `book_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_type_name` varchar(20) NOT NULL,
  `book_type_desc` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`book_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `books_type` */

insert  into `books_type`(`book_type_id`,`book_type_name`,`book_type_desc`) values 
(1,'computer','Computer Books'),
(2,'environment','Environmental books'),
(3,'mathematics','Mathematics books'),
(4,' 123123','abc12345');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`password`) values 
(1,'root','123456'),
(2,'zhangsan','123456'),
(10,'123123a\'da','asdas'),
(13,'asda1','asda');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
