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
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `idutente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `ruolo` varchar(45) NOT NULL,
  `stato` tinyint NOT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`idutente`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Ammini','Stratore','Amministratore@gmail.com','$2a$12$Y99pY1glPm7QKFXGnADxu.eY30ZWGuZnE4.yFIU6WVTDDmTQyziLy','ADMIN',1,12312),(2,'Lorenzo','M','Lorenzo@gmail.com','$2a$12$dicPUINRFcBZ/xKYtZaHMe.awjt/1pE3IqrIAvhtnZX2eNgZgz5D.','USER',0,67.59),(3,'Andrea','C','Andrea@gmail.com','$2a$12$dicPUINRFcBZ/xKYtZaHMe.awjt/1pE3IqrIAvhtnZX2eNgZgz5D.','USER',0,70),(4,'Antonio','V','Antonio@gmail.com','$2a$12$dicPUINRFcBZ/xKYtZaHMe.awjt/1pE3IqrIAvhtnZX2eNgZgz5D.','USER',0,90),(5,'Alessio','Y','Alessio@gmail.com','$2a$12$dicPUINRFcBZ/xKYtZaHMe.awjt/1pE3IqrIAvhtnZX2eNgZgz5D.','USER',0,8000),(6,'Angelo','R','Angelo@gmail.com','$2a$12$dicPUINRFcBZ/xKYtZaHMe.awjt/1pE3IqrIAvhtnZX2eNgZgz5D.','USER',1,55),(7,'Antonio','Varlese','antonio.test@gmail.com','$2a$10$FJnVC.sUO0mLpXymbfwU2ebmXTGcp305zP6JTr1KBAclz56dhWK/y','USER',1,205.5);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
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
