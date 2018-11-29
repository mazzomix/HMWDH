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
-- Table structure for table `sonderwuensche_fliesen`
--

DROP TABLE IF EXISTS `sonderwuensche_fliesen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sonderwuensche_fliesen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wunsch` varchar(255) DEFAULT NULL,
  `preis` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sonderwünsche_fliesen_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sonderwuensche_fliesen`
--

LOCK TABLES `sonderwuensche_fliesen` WRITE;
/*!40000 ALTER TABLE `sonderwuensche_fliesen` DISABLE KEYS */;
INSERT INTO `sonderwuensche_fliesen` VALUES (1,'Keine Fliesen im Küchenbereich des EG',-590),(2,'Keine Fliesen im Bad des OG',-1870),(3,'Mehrpreis bei großformatige Fliesen im\r\nKüchenbereich des EG',170),(4,'Mehrpreis bei großformatige Fliesen im Bad des OG',190),(5,'Fliesen im Bad des DG',2190),(6,'Mehrpreis bei großformatige Fliesen im Bad des DG',190);
/*!40000 ALTER TABLE `sonderwuensche_fliesen` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-30  0:06:40
