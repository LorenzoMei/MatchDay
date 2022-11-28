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
-- Table structure for table `schedina_eventi`
--

DROP TABLE IF EXISTS `schedina_eventi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedina_eventi` (
  `idschedinaeventi` int NOT NULL AUTO_INCREMENT,
  `fk_schedina` int NOT NULL,
  `fk_eventi` int NOT NULL,
  `giocata` char(1) NOT NULL,
  PRIMARY KEY (`idschedinaeventi`,`fk_schedina`,`fk_eventi`),
  KEY `fk_schedina_idx` (`fk_schedina`),
  KEY `fk_eventi_idx` (`fk_eventi`),
  CONSTRAINT `fk_eventi` FOREIGN KEY (`fk_eventi`) REFERENCES `eventi` (`ideventi`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_schedina` FOREIGN KEY (`fk_schedina`) REFERENCES `schedina` (`idschedina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedina_eventi`
--

LOCK TABLES `schedina_eventi` WRITE;
/*!40000 ALTER TABLE `schedina_eventi` DISABLE KEYS */;
INSERT INTO `schedina_eventi` VALUES (1,1,1,'1'),(2,1,3,'X'),(3,2,2,'2'),(4,3,6,'X'),(5,3,7,'2'),(6,3,8,'1');
/*!40000 ALTER TABLE `schedina_eventi` ENABLE KEYS */;
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
