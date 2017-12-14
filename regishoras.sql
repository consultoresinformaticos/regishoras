-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: regishoras
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(45) DEFAULT NULL,
  `departamento` int(11) NOT NULL,
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  `fech_alta` datetime DEFAULT NULL,
  `fech_modificacion` datetime DEFAULT NULL,
  `activo` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ciudad_departamento1_idx` (`departamento`),
  KEY `fk_usu_alta_idx` (`usu_alta`),
  KEY `fk_usu_modficacion_idx` (`usu_modificacion`),
  CONSTRAINT `fk_ciu_departamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ciu_usu_alta` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ciu_usu_modficacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'ASUNCIÓN',1,NULL,NULL,NULL,NULL,1),(2,'Villarica',2,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departamento` varchar(45) NOT NULL,
  `activo` int(1) DEFAULT NULL,
  `fec_alta` datetime DEFAULT NULL,
  `fech_modificacion` datetime DEFAULT NULL,
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usu_alta_idx` (`usu_alta`),
  KEY `fk_usu_modificacion_idx` (`usu_modificacion`),
  CONSTRAINT `fk_dep_usu_alta` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dep_usu_modificacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'CENTRAL',1,NULL,NULL,NULL,NULL),(2,'Guairá',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca_laboral`
--

DROP TABLE IF EXISTS `marca_laboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca_laboral` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `motivo` varchar(200) NOT NULL,
  `usuario` int(11) NOT NULL,
  `sucursal` int(11) NOT NULL,
  `det_motivo` text,
  `fec_marcacion` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_marca_laboral_marca_motivo1_idx` (`motivo`),
  KEY `fk_marca_laboral_usuario1_idx` (`usuario`),
  KEY `fk_marca_laboral_sucursal1_idx` (`sucursal`),
  CONSTRAINT `fk_marca_laboral_marca_motivo1` FOREIGN KEY (`motivo`) REFERENCES `marca_motivo` (`motivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_marca_laboral_sucursal1` FOREIGN KEY (`sucursal`) REFERENCES `sucursal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_marca_laboral_usuario1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca_laboral`
--

LOCK TABLES `marca_laboral` WRITE;
/*!40000 ALTER TABLE `marca_laboral` DISABLE KEYS */;
/*!40000 ALTER TABLE `marca_laboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca_motivo`
--

DROP TABLE IF EXISTS `marca_motivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca_motivo` (
  `motivo` varchar(200) NOT NULL,
  `fec_alta` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `usu_alta` int(1) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  `activo` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`motivo`),
  KEY `usu_alta_idx` (`usu_alta`),
  KEY `usu_modificacion_idx` (`usu_modificacion`),
  CONSTRAINT `fk_mar_usu_alta` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mar_usu_modificacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca_motivo`
--

LOCK TABLES `marca_motivo` WRITE;
/*!40000 ALTER TABLE `marca_motivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `marca_motivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pantalla`
--

DROP TABLE IF EXISTS `pantalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pantalla` (
  `pantalla` varchar(100) NOT NULL,
  `fec_alta` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `activo` int(11) NOT NULL DEFAULT '1',
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`pantalla`),
  KEY `fk_pantalla_usuario1_idx` (`usu_alta`),
  KEY `fk_pantalla_usuario2_idx` (`usu_modificacion`),
  CONSTRAINT `fk_pantalla_usuario1` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pantalla_usuario2` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pantalla`
--

LOCK TABLES `pantalla` WRITE;
/*!40000 ALTER TABLE `pantalla` DISABLE KEYS */;
/*!40000 ALTER TABLE `pantalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presona`
--

DROP TABLE IF EXISTS `presona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `fec_nac` date NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ciudad_id` int(11) NOT NULL,
  `fech_alta` datetime DEFAULT NULL,
  `fech_modificacion` datetime DEFAULT NULL,
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  `activo` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_presona_ciudad1_idx` (`ciudad_id`),
  KEY `fk_usu_alta_idx` (`usu_alta`),
  KEY `fk_usu_mocificacion_idx` (`usu_modificacion`),
  CONSTRAINT `fk_per_usu_alta` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_per_usu_mocificacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_presona_ciudad` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presona`
--

LOCK TABLES `presona` WRITE;
/*!40000 ALTER TABLE `presona` DISABLE KEYS */;
INSERT INTO `presona` VALUES (1,'Admin','Administrator','2016-07-17',NULL,'erodriguez@consultoresinformaticos.com.py',NULL,1,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `presona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `rol` varchar(20) NOT NULL,
  `fec_alta` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `activo` int(1) NOT NULL DEFAULT '1',
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`rol`),
  UNIQUE KEY `rol_UNIQUE` (`rol`),
  KEY `fk_rol_usuario1_idx` (`usu_alta`),
  KEY `fk_rol_usuario2_idx` (`usu_modificacion`),
  CONSTRAINT `fk_rol_usu_alta` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_usu_modificacion` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES ('admin',NULL,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_pantalla`
--

DROP TABLE IF EXISTS `rol_pantalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol_pantalla` (
  `rol` varchar(20) NOT NULL,
  `pantalla` varchar(100) NOT NULL,
  `operacion` varchar(10) NOT NULL,
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  `fech_alta` datetime DEFAULT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`rol`,`pantalla`),
  KEY `fk_rol_has_pantalla_pantalla1_idx` (`pantalla`),
  KEY `fk_rol_has_pantalla_rol1_idx` (`rol`),
  KEY `fk_rol_pantalla_usuario1_idx` (`usu_alta`),
  KEY `fk_rol_pantalla_usuario2_idx` (`usu_modificacion`),
  CONSTRAINT `fk_rol_has_pantalla_pantalla1` FOREIGN KEY (`pantalla`) REFERENCES `pantalla` (`pantalla`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_pantalla_rol1` FOREIGN KEY (`rol`) REFERENCES `rol` (`rol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_pantalla_usuario1` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_pantalla_usuario2` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_pantalla`
--

LOCK TABLES `rol_pantalla` WRITE;
/*!40000 ALTER TABLE `rol_pantalla` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol_pantalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `ciudad` int(11) NOT NULL,
  `activo` int(1) NOT NULL DEFAULT '1',
  `fec_alta` datetime DEFAULT NULL,
  `fech_modificacion` datetime DEFAULT NULL,
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sucursal_ciudad1_idx` (`ciudad`),
  KEY `fk_usu_alta_idx` (`usu_alta`),
  KEY `fk_usu_modificacion_idx` (`usu_modificacion`),
  CONSTRAINT `fk_suc_usu_alta` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_suc_usu_modificacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sucursal_ciudad` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fec_alta` datetime NOT NULL,
  `fec_modificacion` datetime DEFAULT NULL,
  `usu_alta` int(11) DEFAULT NULL,
  `usu_modificacion` int(11) DEFAULT NULL,
  `activo` int(1) NOT NULL DEFAULT '1',
  `presona` int(11) NOT NULL,
  `rol` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_usuario_presona_idx` (`presona`),
  KEY `fk_usuario_rol1_idx` (`rol`),
  KEY `fk_usu_modificacion_idx` (`usu_modificacion`),
  KEY `fk_usu_alta_idx` (`usu_alta`),
  CONSTRAINT `fk_usu_usu_alta` FOREIGN KEY (`usu_alta`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usu_usu_modificacion` FOREIGN KEY (`usu_modificacion`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_presona` FOREIGN KEY (`presona`) REFERENCES `presona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin','2017-03-22 10:56:07',NULL,NULL,NULL,1,1,'admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-26 19:07:49
