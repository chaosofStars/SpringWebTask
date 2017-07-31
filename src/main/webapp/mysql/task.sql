-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: task
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `price` bigint(20) DEFAULT NULL COMMENT '当前价格',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `icon` blob COMMENT '图片',
  `abstract` varchar(200) DEFAULT NULL COMMENT '摘要',
  `text` blob COMMENT '正文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (3,2500,'小米6','https://img14.360buyimg.com/n0/jfs/t6877/59/884392847/111343/aef09cc5/597ae1b4N07915872.jpg','全网通 6GB+64GB 亮黑色 移动联通电信4G手机 双卡双待','防泼溅、抗水溅功能等防护性能，仅为生活短时间，少量水溅防护。并不支持浸泡或带整机淋水。小米6 并未进行专业防水测试。由于浸入液体而导致的损坏，不在保修范围之内。请勿将手机浸泡或带入水中使用。此外，泼溅防护会因日常磨损而下降，非永久有效。请勿在潮湿状态下为 小米6 充电。'),(4,2999,'华为荣耀9','https://img14.360buyimg.com/n0/jfs/t5701/135/3550974634/316038/775a27ed/593e4e81Nc12ab927.jpg','全网通 尊享版 6GB+128GB 魅海蓝 移动联通电信4G手机 双卡双待','2000万变焦双摄，3D曲面极光玻璃，美得有声有色！荣耀新品齐聚，部分爆款下单立减，点击查看~\r\n来张流量卡!1元500M,限时1元抢，0月租还赠送50元话费！清仓复制链接 http://sep9.cn/u5jmjc');
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码md5加密',
  `nickName` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `userType` tinyint(3) DEFAULT NULL COMMENT '类型，买家0，卖家1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'buyer','37254660e226ea65ce6f1efd54233424','buyer',0),(2,'seller','981c57a5cfb0f868e064904b8745766f','seller',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trx`
--

DROP TABLE IF EXISTS `trx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trx` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contentId` int(11) DEFAULT NULL COMMENT '内容ID',
  `personId` int(11) DEFAULT NULL COMMENT '用户ID',
  `price` int(11) DEFAULT NULL COMMENT '购买价格',
  `num` int(11) NOT NULL,
  `time` bigint(20) DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trx`
--

LOCK TABLES `trx` WRITE;
/*!40000 ALTER TABLE `trx` DISABLE KEYS */;
INSERT INTO `trx` VALUES (11,3,0,1,3,1501436666340),(12,4,0,1,2,1501436666347),(13,3,0,1,4,1501436733482),(14,4,0,1,3,1501437839058),(15,4,0,1,2,1501438112408);
/*!40000 ALTER TABLE `trx` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-31 22:30:45
