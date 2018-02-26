-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: power_broker
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `attendances`
--

DROP TABLE IF EXISTS `attendances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendances` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(100) NOT NULL,
  `client_name` varchar(50) DEFAULT NULL,
  `station_id` bigint(20) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `task_name` varchar(50) DEFAULT NULL,
  `task_content` varchar(2000) DEFAULT NULL,
  `task_begin_at` timestamp NULL DEFAULT NULL,
  `task_end_at` timestamp NULL DEFAULT NULL,
  `register_at` timestamp NULL DEFAULT NULL,
  `register_by` bigint(20) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` bigint(20) DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` bigint(20) DEFAULT NULL,
  `delete_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendances`
--

LOCK TABLES `attendances` WRITE;
/*!40000 ALTER TABLE `attendances` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_details`
--

DROP TABLE IF EXISTS `client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) NOT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT '43200',
  `refresh_token_validity` int(11) DEFAULT '2592000',
  `additional_information` varchar(4096) DEFAULT NULL,
  `auto_approve` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_details`
--

LOCK TABLES `client_details` WRITE;
/*!40000 ALTER TABLE `client_details` DISABLE KEYS */;
INSERT INTO `client_details` VALUES (1,'foo','power-broker','foosecret','read|write|trust','authorization_code|refresh_token|password|implicit',NULL,NULL,43200,2592000,NULL,NULL),(2,'oss-pc','power-broker','9XdtrahvxPzkbeqAGqpHUxFbTKKjRDJy','read|write|trust','password|refresh_token',NULL,NULL,43200,2592000,NULL,NULL),(3,'bss-pc','power-broker','3%C64Gs3Ahc9XJbrAxR@RHWVg%bEJQbC','read|write|trust','password|refresh_token',NULL,NULL,43200,2592000,NULL,NULL);
/*!40000 ALTER TABLE `client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enterprises`
--

DROP TABLE IF EXISTS `enterprises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enterprises` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `short_name` varchar(50) DEFAULT NULL,
  `legal_representative` varchar(50) DEFAULT NULL,
  `property` varchar(50) DEFAULT NULL,
  `scale` varchar(50) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` bigint(20) DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` bigint(20) DEFAULT NULL,
  `delete_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enterprises`
--

LOCK TABLES `enterprises` WRITE;
/*!40000 ALTER TABLE `enterprises` DISABLE KEYS */;
INSERT INTO `enterprises` VALUES (1,'a','a','zx','a','','a型','不错',NULL,'2016-10-14 10:40:12',NULL,'2016-10-20 05:29:58',NULL,'2016-10-14 10:40:12',1,1),(6,'c','c','zx2','c','好2','大型2','不错2',NULL,'2016-10-17 11:04:38',NULL,'2016-10-31 09:11:07',NULL,'2016-10-17 11:04:38',1,0),(7,'c','d','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-19 05:48:13',NULL,'2016-10-20 05:29:58',NULL,'2016-10-19 05:48:13',1,0),(8,'中兴电力2','中兴3','a;slkdjf;alksdjf;lkajsdf','中兴','好2','大型2','不错2',NULL,'2016-10-31 10:11:37',NULL,'2016-10-31 10:29:59',NULL,'2016-10-31 10:11:37',1,1),(9,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:38',NULL,'2016-10-31 10:11:38',NULL,'2016-10-31 10:11:38',1,0),(10,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:38',NULL,'2016-10-31 10:11:38',NULL,'2016-10-31 10:11:38',1,0),(11,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',1,0),(12,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',1,0),(13,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',1,0),(14,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',1,0),(15,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',1,0),(16,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',NULL,'2016-10-31 10:11:39',1,0),(17,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(18,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(19,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(20,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(21,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(22,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(23,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',NULL,'2016-10-31 10:11:40',1,0),(24,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',1,0),(25,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',1,0),(26,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',1,0),(27,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',1,0),(28,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',NULL,'2016-10-31 10:11:41',1,0),(29,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',1,0),(30,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',1,0),(31,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',1,0),(32,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',1,0),(33,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',1,0),(34,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',NULL,'2016-10-31 10:11:42',1,0),(35,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',1,0),(36,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',1,0),(37,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',1,0),(38,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',1,0),(39,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',1,0),(40,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',NULL,'2016-10-31 10:11:43',1,0),(41,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',1,0),(42,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',1,0),(43,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',1,0),(44,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',1,0),(45,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',1,0),(46,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',NULL,'2016-10-31 10:11:44',1,0),(47,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(48,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(49,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(50,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(51,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(52,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(53,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',NULL,'2016-10-31 10:11:45',1,0),(54,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:46',NULL,'2016-10-31 10:11:46',NULL,'2016-10-31 10:11:46',1,0),(55,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:46',NULL,'2016-10-31 10:11:46',NULL,'2016-10-31 10:11:46',1,0),(56,'中兴电力2','中兴2','zx2','中兴2','好2','大型2','不错2',NULL,'2016-10-31 10:11:46',NULL,'2016-10-31 10:11:46',NULL,'2016-10-31 10:11:46',1,0);
/*!40000 ALTER TABLE `enterprises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navs`
--

DROP TABLE IF EXISTS `navs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `link` varchar(60) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` bigint(20) DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` bigint(20) DEFAULT NULL,
  `delete_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navs`
--

LOCK TABLES `navs` WRITE;
/*!40000 ALTER TABLE `navs` DISABLE KEYS */;
INSERT INTO `navs` VALUES (1,'首页','home-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(2,'基础维护','setting-icon','/bss/maintain',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(3,'运行值班巡逻','calendar-alt-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(4,'设备缺陷管理','sliders-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(5,'维保管理','wrench-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(6,'电试管理','activity-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(7,'查询统计','graph-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(8,'运维分析管理','news-icon','/bss/home',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(9,'工时管理','clock-icon','/bss/attendance',NULL,'2016-11-01 09:44:43',NULL,'2016-11-01 16:35:38',NULL,'2016-11-01 09:44:43',1,0),(10,'系统管理','settings-alt-icon','/bss/admin',NULL,'2016-11-01 09:44:43',NULL,'2016-11-02 09:28:10',NULL,'2016-11-01 09:44:43',1,0);
/*!40000 ALTER TABLE `navs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `power_stations`
--

DROP TABLE IF EXISTS `power_stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power_stations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_code` varchar(10) DEFAULT NULL,
  `client_name` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `response_area` varchar(10) DEFAULT NULL,
  `industry_class` varchar(10) DEFAULT NULL,
  `voltage` varchar(10) DEFAULT NULL,
  `capacity` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `province` int(11) DEFAULT '0',
  `city` int(11) DEFAULT '0',
  `district` int(11) DEFAULT '0',
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `create_by` bigint(20) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` bigint(20) DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_by` bigint(20) DEFAULT NULL,
  `delete_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) DEFAULT '1',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `power_stations`
--

LOCK TABLES `power_stations` WRITE;
/*!40000 ALTER TABLE `power_stations` DISABLE KEYS */;
INSERT INTO `power_stations` VALUES (1,'第一个客户好','非常好的客户','第一个配电站',NULL,'',NULL,'220kV','2000mhA',NULL,NULL,NULL,NULL,NULL,0,NULL,'2016-11-02 14:47:56',NULL,'2016-11-02 14:47:56',NULL,'2016-11-02 14:47:56',1,0);
/*!40000 ALTER TABLE `power_stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'OSS_ADMIN'),(2,'OSS_USER'),(3,'BSS_ADMIN'),(4,'BSS_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sidebars`
--

DROP TABLE IF EXISTS `sidebars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sidebars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `link` varchar(60) DEFAULT NULL,
  `nav_id` bigint(20) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` bigint(20) DEFAULT NULL,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` bigint(20) DEFAULT NULL,
  `delete_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sidebars`
--

LOCK TABLES `sidebars` WRITE;
/*!40000 ALTER TABLE `sidebars` DISABLE KEYS */;
INSERT INTO `sidebars` VALUES (1,'单位信息','admin/enterprises',10,NULL,'2016-11-02 00:51:57',NULL,'2016-11-02 06:43:08',NULL,'2016-11-02 00:51:57',1,1),(2,'设备库录入','admin/devices',10,NULL,'2016-11-02 09:25:06',NULL,'2016-11-02 09:26:39',NULL,'2016-11-02 09:25:06',1,1),(3,'变配电站信息','maintain/powerStations',2,NULL,'2016-11-02 14:16:19',NULL,'2016-11-02 14:16:19',NULL,'2016-11-02 14:16:19',1,1);
/*!40000 ALTER TABLE `sidebars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'william','wu'),(2,'admin','aa'),(3,'user1','1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,3),(3,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-16 22:30:51
