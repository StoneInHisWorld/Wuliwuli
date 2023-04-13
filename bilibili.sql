# Host: 127.0.0.1  (Version: 5.7.28)
# Date: 2021-01-05 22:23:09
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

DROP DATABASE IF EXISTS `bilibili`;
CREATE DATABASE `bilibili` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bilibili`;

#
# Source for table "danmu"
#

DROP TABLE IF EXISTS `danmu`;
CREATE TABLE `danmu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vid` int(11) DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dsize` int(11) DEFAULT NULL,
  `color` int(255) DEFAULT NULL,
  `dtime` float(11,0) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

#
# Data for table "danmu"
#

INSERT INTO `danmu` VALUES (1,42,'hh',0,16777215,11,0),(2,13,'qqq',0,16777215,10,0),(3,13,'eeee',0,16777215,17,0),(4,30,'112',0,16777215,0,0),(5,3,'1212',0,16777215,0,0),(6,3,'222',0,16777215,4,0),(7,3,'sss',0,16777215,9,0),(8,3,'ddd',0,6610199,17,2),(9,3,'enene',0,15024726,126,1),(10,3,'ee',0,15024726,9,1),(11,3,'rr',0,3788031,16,0),(12,3,'test',0,3788031,16,2),(13,30,'wewq',0,16777215,5,0),(14,30,'www',0,16777215,11,0),(15,34,'好看',0,16777215,16,0),(16,3,'ddd',0,16777215,9,0),(17,3,'ddjjkk',0,3788031,49,2),(18,3,'fffff',0,16777215,10,0),(19,3,'ffff',0,16777215,6,0),(20,3,'eeee',0,13959417,29,2),(21,11,'还行吧',0,16777215,143,0),(22,11,'good',0,15024726,156,0),(23,12,'wod',0,16777215,4,0),(24,30,'嘿嘿',0,16777215,0,0),(25,40,'222',0,16777215,5,0),(26,40,'我讨逆猴子',0,16777215,6,0),(27,40,'我套你猴子',0,16777215,17,0),(28,12,'u夫嘎斯了会法术力fha',0,16777215,0,0),(29,27,'1111',0,16777215,0,0),(30,14,'11111',0,16777215,3,0),(31,65,'11111',0,3788031,41,2),(32,56,'1121121',0,16777215,6,0),(33,48,'66666',0,16777215,7,0),(34,48,'wuhu',0,16769331,20,1),(35,48,'didi',0,16769331,32,2);

#
# Source for table "message"
#

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageID` varchar(32) NOT NULL,
  `messagevideoID` varchar(32) NOT NULL,
  `messageuserID` varchar(32) NOT NULL,
  `messageuserName` varchar(32) NOT NULL,
  `message` text NOT NULL,
  `messageTime` varchar(32) NOT NULL,
  PRIMARY KEY (`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "message"
#

INSERT INTO `message` VALUES ('09580df42c7f43b8af9e16f65fbfa03a','11','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 16:13:06'),('1846feccdf9244138c7a074941c4ffc0','22','04d416043f084a918bbebd4d0ca45175','1','1','2021-01-03 11:58:36'),('18cd2d570c784a969754b3229689ce74','96','1','1','12312','2021-01-05 22:18:16'),('1bb3f6859ceb4dad92e213cd1590c2f7','27','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 15:54:38'),('1c9f313c686f4734b225767bea76b86d','11','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 16:13:24'),('1f5613ee44f6409cbdd47504fdbad64d','96','1','1','12312','2021-01-05 22:18:12'),('31b1908417324e3f95db9785a525f856','11','04d416043f084a918bbebd4d0ca45175','1','5','2021-01-05 16:36:08'),('32a4c48b463843609864693eb5f88fc7','94','1','1','1','2021-01-05 21:37:59'),('37bcd770a6a84229bb931e44935575e7','14','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 17:12:00'),('3c12467eb5d04767afb5caf1c776b72a','52','1','1','非常对！\n','2021-01-05 21:23:18'),('5c053ff67a5f4b799ef538c07e925eac','10','004bcfc8d4bd407bb1a114785539006f','admin','123','2017-07-19 14:42:49'),('5d9bbb03c1084fd6889824ba1170e880','23','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 16:11:05'),('684c3b94209e40ebb7b9f91e1c24e475','52','1','1','对\n','2021-01-05 21:23:08'),('687a33032b664fac980fa184f9d83272','22','04d416043f084a918bbebd4d0ca45175','1','11','2021-01-03 11:58:43'),('6887ddbf70d549a8b75f90319fab3213','12','04d416043f084a918bbebd4d0ca45175','1','1','2021-01-05 16:05:48'),('852a5a78c1e64f749f3987b27a70fc4c','11','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 16:35:59'),('898d212d0dc843e893b780e92570d116','40','04d416043f084a918bbebd4d0ca45175','1','3','2021-01-04 17:40:31'),('983917738ac14a649e451f1b583c98c1','96','1','1','111','2021-01-05 22:17:36'),('a383465430b94e8186726b5fd8ed1bcc','40','04d416043f084a918bbebd4d0ca45175','1','2222','2021-01-04 17:40:14'),('b37606d62f3a487ca019f23fdef2bf93','3','004bcfc8d4bd407bb1a114785539006f','admin','111','2020-02-13 23:43:24'),('bab2f95987d14cf69eee547b65b6ad07','52','1','1','好！','2021-01-05 21:18:43'),('befb275dc382441390226b13be7e920b','52','1','1','很对！\n','2021-01-05 21:23:13'),('c873e4a97c4e4377be38d2940f26db20','96','1','1','12312','2021-01-05 22:18:15'),('cb6b3d6392da4c4ba4955fa869e4ccc4','13','004bcfc8d4bd407bb1a114785539006f','admin','测试留言','2017-07-19 16:08:34'),('cbb93f36a06c4ce3bbb0052d60f7441e','96','1','1','12312','2021-01-05 22:18:14'),('d4e2718deb744603bb3a41a2838e51b2','14','004bcfc8d4bd407bb1a114785539006f','admin','爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕达按时爱仕','2017-07-26 17:35:38'),('f423a15293dc4cc5929558a294b51e23','11','04d416043f084a918bbebd4d0ca45175','1','111','2021-01-05 16:13:06'),('f889e2c5a6cb4c049c12d5c44ab201bc','22','04d416043f084a918bbebd4d0ca45175','1','wuhy','2021-01-03 11:59:14'),('f8dbf8862352425282f8777fde710811','52','1','1','很好！\n','2021-01-05 21:22:55'),('f9fe9749bc9148cb86defbad7c77b34b','96','1','1','12312','2021-01-05 22:18:18'),('fb63785ac00e44faa7e430bd2f6aa4c1','52','1','1','非常好！\n','2021-01-05 21:23:03'),('fdc18ae5f20a4cecac3162a3debc1a8f','12','04d416043f084a918bbebd4d0ca45175','1','李祎博士','2021-01-05 16:06:08'),('fe7b363604c04aeebb27bb3d5a9f7c32','37','04d416043f084a918bbebd4d0ca45175','1','1','2021-01-04 16:11:30');

#
# Source for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(48) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'1','1'),(2,'2','2');

#
# Source for table "video"
#

DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `videoID` varchar(32) NOT NULL,
  `videoName` varchar(160) DEFAULT NULL,
  `videoImage` text NOT NULL,
  `videoAddress` text,
  `videolookTime` varchar(32) NOT NULL,
  `videoCollection` text,
  `videoLeaving` text,
  `videoTime` varchar(32) NOT NULL,
  `videoState` varchar(32) NOT NULL,
  `videocAtegory` varchar(32) NOT NULL,
  PRIMARY KEY (`videoID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "video"
#

INSERT INTO `video` VALUES ('100','秒懂百科56','/static/videolook/videolookimg/56.jpg','/static/videolook/56.mp4','78','1','1','1:00','1','1'),('101','秒懂百科57','/static/videolook/videolookimg/57.jpg','/static/videolook/57.mp4','79','2','2','1:00','2','2'),('102','秒懂百科58','/static/videolook/videolookimg/58.jpg','/static/videolook/58.mp4','80','2','2','1:00','2','2'),('103','秒懂百科59','/static/videolook/videolookimg/59.jpg','/static/videolook/59.mp4','81','2','2','1:00','2','2'),('104','秒懂百科60','/static/videolook/videolookimg/60.jpg','/static/videolook/60.mp4','82','2','2','1:00','2','2'),('105','秒懂百科61','/static/videolook/videolookimg/61.jpg','/static/videolook/61.mp4','83','2','2','1:00','2','2'),('106','秒懂百科62','/static/videolook/videolookimg/62.jpg','/static/videolook/62.mp4','84','2','2','1:00','2','2'),('107','秒懂百科63','/static/videolook/videolookimg/63.jpg','/static/videolook/63.mp4','85','2','2','1:00','2','2'),('108','秒懂百科64','/static/videolook/videolookimg/64.jpg','/static/videolook/64.mp4','86','2','2','1:00','2','2'),('46','秒懂百科2','/static/videolook/videolookimg/2.jpg','/static/videolook/2.mp4','24','1','1','1:00','1','1'),('47','秒懂百科3','/static/videolook/videolookimg/3.jpg','/static/videolook/3.mp4','25','1','1','1:00','1','1'),('48','秒懂百科4','/static/videolook/videolookimg/4.jpg','/static/videolook/4.mp4','26','1','1','1:00','1','1'),('49','秒懂百科5','/static/videolook/videolookimg/5.jpg','/static/videolook/5.mp4','27','1','1','1:00','1','1'),('50','秒懂百科6','/static/videolook/videolookimg/6.jpg','/static/videolook/6.mp4','28','1','1','1:00','1','1'),('51','秒懂百科7','/static/videolook/videolookimg/7.jpg','/static/videolook/7.mp4','29','1','1','1:00','1','1'),('52','秒懂百科8','/static/videolook/videolookimg/8.jpg','/static/videolook/8.mp4','30','1','1','1:00','1','1'),('53','秒懂百科9','/static/videolook/videolookimg/9.jpg','/static/videolook/9.mp4','31','1','1','1:00','1','1'),('54','秒懂百科10','/static/videolook/videolookimg/10.jpg','/static/videolook/10.mp4','32','1','1','1:00','1','1'),('55','秒懂百科11','/static/videolook/videolookimg/11.jpg','/static/videolook/11.mp4','33','1','1','1:00','1','1'),('56','秒懂百科12','/static/videolook/videolookimg/12.jpg','/static/videolook/12.mp4','34','1','1','1:00','1','1'),('57','秒懂百科13','/static/videolook/videolookimg/13.jpg','/static/videolook/13.mp4','35','1','1','1:00','1','1'),('58','秒懂百科14','/static/videolook/videolookimg/14.jpg','/static/videolook/14.mp4','36','1','1','1:00','1','1'),('59','秒懂百科15','/static/videolook/videolookimg/15.jpg','/static/videolook/15.mp4','37','2','2','1:00','2','2'),('60','秒懂百科16','/static/videolook/videolookimg/16.jpg','/static/videolook/16.mp4','38','2','2','1:00','2','2'),('61','秒懂百科17','/static/videolook/videolookimg/17.jpg','/static/videolook/17.mp4','39','2','2','1:00','2','2'),('62','秒懂百科18','/static/videolook/videolookimg/18.jpg','/static/videolook/18.mp4','40','2','2','1:00','2','2'),('63','秒懂百科19','/static/videolook/videolookimg/19.jpg','/static/videolook/19.mp4','41','2','2','1:00','2','2'),('64','秒懂百科20','/static/videolook/videolookimg/20.jpg','/static/videolook/20.mp4','42','2','2','1:00','2','2'),('65','秒懂百科21','/static/videolook/videolookimg/21.jpg','/static/videolook/21.mp4','43','2','2','1:00','2','2'),('66','秒懂百科22','/static/videolook/videolookimg/22.jpg','/static/videolook/22.mp4','44','2','2','1:00','2','2'),('67','秒懂百科23','/static/videolook/videolookimg/23.jpg','/static/videolook/23.mp4','45','2','2','1:00','2','2'),('68','秒懂百科24','/static/videolook/videolookimg/24.jpg','/static/videolook/24.mp4','46','2','2','1:00','2','2'),('69','秒懂百科25','/static/videolook/videolookimg/25.jpg','/static/videolook/25.mp4','47','2','2','1:00','2','2'),('70','秒懂百科26','/static/videolook/videolookimg/26.jpg','/static/videolook/26.mp4','48','2','2','1:00','2','2'),('71','秒懂百科27','/static/videolook/videolookimg/27.jpg','/static/videolook/27.mp4','49','2','2','1:00','2','2'),('72','秒懂百科28','/static/videolook/videolookimg/28.jpg','/static/videolook/28.mp4','50','2','2','1:00','2','2'),('73','秒懂百科29','/static/videolook/videolookimg/29.jpg','/static/videolook/29.mp4','51','3','3','1:00','3','3'),('74','秒懂百科30','/static/videolook/videolookimg/30.jpg','/static/videolook/30.mp4','52','3','3','1:00','3','3'),('75','秒懂百科31','/static/videolook/videolookimg/31.jpg','/static/videolook/31.mp4','53','3','3','1:00','3','3'),('76','秒懂百科32','/static/videolook/videolookimg/32.jpg','/static/videolook/32.mp4','54','3','3','1:00','3','3'),('77','秒懂百科33','/static/videolook/videolookimg/33.jpg','/static/videolook/33.mp4','55','3','3','1:00','3','3'),('78','秒懂百科34','/static/videolook/videolookimg/34.jpg','/static/videolook/34.mp4','56','3','3','1:00','3','3'),('79','秒懂百科35','/static/videolook/videolookimg/35.jpg','/static/videolook/35.mp4','57','3','3','1:00','3','3'),('80','秒懂百科36','/static/videolook/videolookimg/36.jpg','/static/videolook/36.mp4','58','3','3','1:00','3','3'),('81','秒懂百科37','/static/videolook/videolookimg/37.jpg','/static/videolook/37.mp4','59','3','3','1:00','3','3'),('82','秒懂百科38','/static/videolook/videolookimg/38.jpg','/static/videolook/38.mp4','60','3','3','1:00','3','3'),('83','秒懂百科39','/static/videolook/videolookimg/39.jpg','/static/videolook/39.mp4','61','3','3','1:00','3','3'),('84','秒懂百科40','/static/videolook/videolookimg/40.jpg','/static/videolook/40.mp4','62','3','3','1:00','3','3'),('85','秒懂百科41','/static/videolook/videolookimg/41.jpg','/static/videolook/41.mp4','63','3','3','1:00','3','3'),('86','秒懂百科42','/static/videolook/videolookimg/42.jpg','/static/videolook/42.mp4','64','3','3','1:00','3','3'),('87','秒懂百科43','/static/videolook/videolookimg/43.jpg','/static/videolook/43.mp4','65','1','1','1:00','1','1'),('88','秒懂百科44','/static/videolook/videolookimg/44.jpg','/static/videolook/44.mp4','66','1','1','1:00','1','1'),('89','秒懂百科45','/static/videolook/videolookimg/45.jpg','/static/videolook/45.mp4','67','1','1','1:00','1','1'),('90','秒懂百科46','/static/videolook/videolookimg/46.jpg','/static/videolook/46.mp4','68','1','1','1:00','1','1'),('91','秒懂百科47','/static/videolook/videolookimg/47.jpg','/static/videolook/47.mp4','69','1','1','1:00','1','1'),('92','秒懂百科48','/static/videolook/videolookimg/48.jpg','/static/videolook/48.mp4','70','1','1','1:00','1','1'),('93','秒懂百科49','/static/videolook/videolookimg/49.jpg','/static/videolook/49.mp4','71','1','1','1:00','1','1'),('94','秒懂百科50','/static/videolook/videolookimg/50.jpg','/static/videolook/50.mp4','72','1','1','1:00','1','1'),('95','秒懂百科51','/static/videolook/videolookimg/51.jpg','/static/videolook/51.mp4','73','1','1','1:00','1','1'),('96','秒懂百科52','/static/videolook/videolookimg/52.jpg','/static/videolook/52.mp4','74','1','1','1:00','1','1'),('97','秒懂百科53','/static/videolook/videolookimg/53.jpg','/static/videolook/53.mp4','75','1','1','1:00','1','1'),('98','秒懂百科54','/static/videolook/videolookimg/54.jpg','/static/videolook/54.mp4','76','1','1','1:00','1','1'),('99','秒懂百科55','/static/videolook/videolookimg/55.jpg','/static/videolook/55.mp4','77','1','1','1:00','1','1');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
