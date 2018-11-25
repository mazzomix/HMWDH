CREATE DATABASE  IF NOT EXISTS `hmwdh` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `hmwdh`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: hmwdh
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `kunde_sonderwuensche_fenster_aussentueren`
--

DROP TABLE IF EXISTS `kunde_sonderwuensche_fenster_aussentueren`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kunde_sonderwuensche_fenster_aussentueren` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kunden_id` int(11) DEFAULT NULL,
  `sonderwuensche_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `kunde_sonderwünsche_fenster_außentüren_id_uindex` (`id`),
  KEY `sonderwünsche_fenster_außentüren_id_fk` (`sonderwünsche_id`),
  KEY `kunde_kundenNummer_fk` (`kunden_id`),
  CONSTRAINT `kunde_kundenNummer_fk` FOREIGN KEY (`kunden_id`) REFERENCES `kunde` (`id`),
  CONSTRAINT `sonderwünsche_fenster_außentüren_id_fk` FOREIGN KEY (`sonderwuensche_id`) REFERENCES `sonderwuensche_fenster_aussentueren` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde_sonderwuensche_fenster_aussentueren`
--

LOCK TABLES `kunde_sonderwuensche_fenster_aussentueren` WRITE;
/*!40000 ALTER TABLE `kunde_sonderwuensche_fenster_aussentueren` DISABLE KEYS */;
/*!40000 ALTER TABLE `kunde_sonderwuensche_fenster_aussentueren` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-16 10:53:09
