CREATE DATABASE  IF NOT EXISTS `practica2sd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `practica2sd`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: practica2sd
-- ------------------------------------------------------
-- Server version	5.5.24-log

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
-- Table structure for table `cine`
--

DROP TABLE IF EXISTS `cine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cine` (
  `idcine` int(11) NOT NULL AUTO_INCREMENT,
  `cineNombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcine`),
  UNIQUE KEY `cineNombre_UNIQUE` (`cineNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cine`
--

LOCK TABLES `cine` WRITE;
/*!40000 ALTER TABLE `cine` DISABLE KEYS */;
INSERT INTO `cine` VALUES (5,'Cinemex Galerías'),(1,'Cinepolis Azcapotzalco'),(4,'Cinepolis Plaza Carso'),(2,'Cinepolis Torres Lindavista'),(6,'Cinepolis Town Center El Rosario'),(3,'Cinepolis Vía Vallejo');
/*!40000 ALTER TABLE `cine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `idciudad` int(11) NOT NULL AUTO_INCREMENT,
  `ciudadNombre` varchar(45) DEFAULT NULL,
  `ciudadClima` varchar(45) DEFAULT NULL,
  `divisas_iddivisas` int(11) NOT NULL,
  `ciudadTimeZone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idciudad`),
  UNIQUE KEY `ciudadNombre_UNIQUE` (`ciudadNombre`),
  KEY `fk_ciudad_divisas_idx` (`divisas_iddivisas`),
  CONSTRAINT `fk_ciudad_divisas` FOREIGN KEY (`divisas_iddivisas`) REFERENCES `divisas` (`iddivisas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Paris','19',3,'Europe/Paris'),(2,'Ciudad de Mexico','17',2,'America/Mexico_City'),(3,'Tokio','30',1,'Asia/Tokyo'),(4,'Nueva York','24',1,'America/New_York'),(5,'Viena','19',3,'Europa/Vienna'),(6,'Los Angeles','18',1,'America/Los_Angeles'),(7,'Londres','16',4,'Europe/London'),(8,'Hong Kong','28',1,'Asia/Hong_Kong'),(9,'Seoul','27',1,'Asia/Seoul'),(10,'Singapur','32',1,'Asia/Singapore');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costo`
--

DROP TABLE IF EXISTS `costo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costo` (
  `idcosto` int(11) NOT NULL AUTO_INCREMENT,
  `costoCosto` varchar(45) DEFAULT NULL,
  `teatro_idteatro` int(11) NOT NULL,
  `obra_idobra` int(11) NOT NULL,
  PRIMARY KEY (`idcosto`),
  KEY `fk_costo_teatro1_idx` (`teatro_idteatro`),
  KEY `fk_costo_obra1_idx` (`obra_idobra`),
  CONSTRAINT `fk_costo_obra1` FOREIGN KEY (`obra_idobra`) REFERENCES `obra` (`idobra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_costo_teatro1` FOREIGN KEY (`teatro_idteatro`) REFERENCES `teatro` (`idteatro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costo`
--

LOCK TABLES `costo` WRITE;
/*!40000 ALTER TABLE `costo` DISABLE KEYS */;
INSERT INTO `costo` VALUES (1,'50',1,1),(2,'70',2,1);
/*!40000 ALTER TABLE `costo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `divisas`
--

DROP TABLE IF EXISTS `divisas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `divisas` (
  `iddivisas` int(11) NOT NULL AUTO_INCREMENT,
  `divisasNombre` varchar(45) DEFAULT NULL,
  `divisasValorDolar` double DEFAULT NULL,
  PRIMARY KEY (`iddivisas`),
  UNIQUE KEY `divisasNombre_UNIQUE` (`divisasNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divisas`
--

LOCK TABLES `divisas` WRITE;
/*!40000 ALTER TABLE `divisas` DISABLE KEYS */;
INSERT INTO `divisas` VALUES (1,'USD',1),(2,'MXN',18.58),(3,'EUR',0.89),(4,'GBP',0.76);
/*!40000 ALTER TABLE `divisas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `espaciofis`
--

DROP TABLE IF EXISTS `espaciofis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `espaciofis` (
  `idespaciofis` int(11) NOT NULL AUTO_INCREMENT,
  `espaciofisNombre` varchar(45) DEFAULT NULL,
  `espaciofisUbicacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idespaciofis`),
  UNIQUE KEY `espaciofisNombre_UNIQUE` (`espaciofisNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `espaciofis`
--

LOCK TABLES `espaciofis` WRITE;
/*!40000 ALTER TABLE `espaciofis` DISABLE KEYS */;
INSERT INTO `espaciofis` VALUES (1,'Biblioteca','Edificio \"I\". En la plaza COSEI.'),(2,'H-202','Edificio \"H\". 2er. Piso'),(3,'2P','Edificio \"P\". 1er. Piso'),(4,'Coordinacion CBI','Edificio \"H\". 1er. Piso'),(5,'Cubículo P','Edificio \"HO\". Planta baja.'),(6,'Area de nuevas tecnologias','Edificio \"HP\". Planta baja.');
/*!40000 ALTER TABLE `espaciofis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarios` (
  `idhorarios` int(11) NOT NULL AUTO_INCREMENT,
  `horariosInicio` time DEFAULT NULL,
  `horariosFin` time DEFAULT NULL,
  `cine_idcine` int(11) NOT NULL,
  `pelicula_idpelicula` int(11) NOT NULL,
  PRIMARY KEY (`idhorarios`),
  KEY `fk_horarios_cine1_idx` (`cine_idcine`),
  KEY `fk_horarios_pelicula1_idx` (`pelicula_idpelicula`),
  CONSTRAINT `fk_horarios_cine1` FOREIGN KEY (`cine_idcine`) REFERENCES `cine` (`idcine`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_horarios_pelicula1` FOREIGN KEY (`pelicula_idpelicula`) REFERENCES `pelicula` (`idpelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'15:35:00','18:00:00',1,1),(2,'13:20:00','15:16:00',1,1);
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impartir`
--

DROP TABLE IF EXISTS `impartir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `impartir` (
  `idimpartir` int(11) NOT NULL AUTO_INCREMENT,
  `uea_iduea` int(11) NOT NULL,
  `profesor_idprofesor` int(11) NOT NULL,
  PRIMARY KEY (`idimpartir`,`uea_iduea`,`profesor_idprofesor`),
  KEY `fk_impartir_uea1_idx` (`uea_iduea`),
  KEY `fk_impartir_profesor1_idx` (`profesor_idprofesor`),
  CONSTRAINT `fk_impartir_profesor1` FOREIGN KEY (`profesor_idprofesor`) REFERENCES `profesor` (`idprofesor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_impartir_uea1` FOREIGN KEY (`uea_iduea`) REFERENCES `uea` (`iduea`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impartir`
--

LOCK TABLES `impartir` WRITE;
/*!40000 ALTER TABLE `impartir` DISABLE KEYS */;
INSERT INTO `impartir` VALUES (1,1,1),(2,2,1);
/*!40000 ALTER TABLE `impartir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `museo`
--

DROP TABLE IF EXISTS `museo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `museo` (
  `idmuseo` int(11) NOT NULL AUTO_INCREMENT,
  `museoNombre` varchar(45) DEFAULT NULL,
  `museoHorario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmuseo`),
  UNIQUE KEY `museoNombre_UNIQUE` (`museoNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museo`
--

LOCK TABLES `museo` WRITE;
/*!40000 ALTER TABLE `museo` DISABLE KEYS */;
INSERT INTO `museo` VALUES (1,'Museo Nacional de Antropología','Martes a Domingo de 9 a 19 h'),(2,'Museo Casa Estudio Diego Rivera y Frida Kahlo','Martes a Domingo de 10:00 a 18:00 h'),(3,'Museo del Templo Mayor','Martes a Domingo de 09:00 a 17:00 h');
/*!40000 ALTER TABLE `museo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra`
--

DROP TABLE IF EXISTS `obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obra` (
  `idobra` int(11) NOT NULL AUTO_INCREMENT,
  `obraNombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idobra`),
  UNIQUE KEY `obraNombre_UNIQUE` (`obraNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra`
--

LOCK TABLES `obra` WRITE;
/*!40000 ALTER TABLE `obra` DISABLE KEYS */;
INSERT INTO `obra` VALUES (1,'Tartufo');
/*!40000 ALTER TABLE `obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelicula` (
  `idpelicula` int(11) NOT NULL AUTO_INCREMENT,
  `peliculaNombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpelicula`),
  UNIQUE KEY `peliculaNombre_UNIQUE` (`peliculaNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (6,'Ben-Hur'),(2,'El club de las madres rebeldes'),(4,'El engaño del siglo'),(3,'El poder de la moda'),(5,'No estamos solos'),(1,'Un secreto entre nosotros');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `idprofesor` int(11) NOT NULL AUTO_INCREMENT,
  `profesorNombre` varchar(45) DEFAULT NULL,
  `profesorTel` varchar(45) DEFAULT NULL,
  `profesorCorreo` varchar(45) DEFAULT NULL,
  `espaciofis_idespaciofis` int(11) NOT NULL,
  PRIMARY KEY (`idprofesor`),
  UNIQUE KEY `profesorNombre_UNIQUE` (`profesorNombre`),
  KEY `fk_profesor_espaciofis1_idx` (`espaciofis_idespaciofis`),
  CONSTRAINT `fk_profesor_espaciofis1` FOREIGN KEY (`espaciofis_idespaciofis`) REFERENCES `espaciofis` (`idespaciofis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Fort Chavez Liliana','53189401','fcl@azc.uam.mx',2),(2,'Puerta Huerta Jose Pedro Antonio','53189071','phjpa@azc.uam.mx',3),(3,'Suverza Ramirez Hector','53189116','srh@azc.uam.mx',4),(4,'Arredondo Vega José Javier','53189189 ext. 5507','avjj@azc.uam.mx',5),(5,'Gamez Alatorre Rosalba','53189366','gar@azc.uam.mx',6);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teatro`
--

DROP TABLE IF EXISTS `teatro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teatro` (
  `idteatro` int(11) NOT NULL AUTO_INCREMENT,
  `teatroNombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idteatro`),
  UNIQUE KEY `teatroNombre_UNIQUE` (`teatroNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teatro`
--

LOCK TABLES `teatro` WRITE;
/*!40000 ALTER TABLE `teatro` DISABLE KEYS */;
INSERT INTO `teatro` VALUES (2,'Blanquita'),(1,'Hidalgo');
/*!40000 ALTER TABLE `teatro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uea`
--

DROP TABLE IF EXISTS `uea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uea` (
  `iduea` int(11) NOT NULL AUTO_INCREMENT,
  `ueaNombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduea`),
  UNIQUE KEY `ueaNombre_UNIQUE` (`ueaNombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uea`
--

LOCK TABLES `uea` WRITE;
/*!40000 ALTER TABLE `uea` DISABLE KEYS */;
INSERT INTO `uea` VALUES (2,'Mate'),(1,'Sistemas Distribuidos');
/*!40000 ALTER TABLE `uea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-01 23:55:50
