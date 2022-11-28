-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: matchday
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventi`
--

DROP TABLE IF EXISTS `eventi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventi` (
  `ideventi` int NOT NULL AUTO_INCREMENT,
  `squadra_casa` varchar(45) NOT NULL,
  `squadra_ospite` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `risultato` char(1) NOT NULL,
  `fk_quote` int NOT NULL,
  PRIMARY KEY (`ideventi`),
  KEY `fk_quote_idx` (`fk_quote`),
  CONSTRAINT `fk_quote` FOREIGN KEY (`fk_quote`) REFERENCES `quote` (`idquote`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventi`
--

LOCK TABLES `eventi` WRITE;
/*!40000 ALTER TABLE `eventi` DISABLE KEYS */;
INSERT INTO `eventi` VALUES (1,'Roma','Lazio','2022-11-28 09:37:00','calcio','-',2),(2,'Lakers','Chicago Bulls','2022-11-28 09:37:00','basket','-',3),(3,'Napoli','Frosinone','2022-11-28 09:37:00','calcio','-',1),(4,'Roma','Formia','2022-11-28 09:33:00','pallavolo','-',4),(5,'Lazio','Latina','2022-11-28 09:37:00','pallavolo','-',5),(6,'Inter','Palermo','2022-11-28 11:44:00','calcio','-',6),(7,'Torino','Grosseto','2022-11-28 11:44:00','pallavolo','-',7),(8,'Cavaliers','Spurs','2022-11-28 11:45:00','basket','-',8),(9,'Juventus','Verona','2022-11-28 12:10:00','calcio','-',9),(10,'Warriors','Celtics','2022-11-28 14:09:00','basket','-',10),(11,'Nets','Raptors','2022-11-28 14:11:00','basket','-',11),(12,'Suns','Bulls','2022-11-28 14:11:00','basket','-',12),(13,'Mavericks','Bucks','2022-11-28 14:12:00','basket','-',13),(14,'Perugia','Monza','2022-11-28 14:13:00','pallavolo','-',14),(15,'Trentino','Siena','2022-11-28 14:14:00','pallavolo','-',15),(16,'Milano','Cisterna','2022-11-28 14:14:00','pallavolo','-',16),(17,'Bologna','Sassuolo','2022-11-28 14:19:00','calcio','-',17),(18,'Monza','Salernitana','2022-11-28 14:19:00','calcio','-',18),(19,'Milan','Fiorentina','2022-11-28 14:20:00','calcio','-',19),(20,'Carrarese','Real San Patrizio','2022-11-28 14:42:00','calcio','-',20),(21,'Real Formia','Penitro','2022-11-28 14:52:00','calcio','-',21);
/*!40000 ALTER TABLE `eventi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-28 14:56:31
