CREATE DATABASE  IF NOT EXISTS `sat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `sat`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sat
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aluno` (
  `USUARIO_ID` int(11) NOT NULL,
  `TURMA_ID` int(11) NOT NULL,
  PRIMARY KEY (`USUARIO_ID`),
  KEY `TURMA_ID` (`TURMA_ID`),
  CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `aluno_ibfk_2` FOREIGN KEY (`TURMA_ID`) REFERENCES `turma` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (9,2),(10,2),(11,2),(12,2),(13,2),(14,3),(15,3),(16,3),(17,3),(18,3),(19,4),(20,4),(21,4),(23,4),(24,4);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aula` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` text NOT NULL,
  `DATA` date NOT NULL,
  `TURMA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `TURMA_ID` (`TURMA_ID`),
  CONSTRAINT `aula_ibfk_1` FOREIGN KEY (`TURMA_ID`) REFERENCES `turma` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletim`
--

DROP TABLE IF EXISTS `boletim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletim` (
  `ALUNO_ID` int(11) NOT NULL,
  `MODULO_ID` int(11) NOT NULL,
  `NOTA` int(11) NOT NULL,
  PRIMARY KEY (`ALUNO_ID`,`MODULO_ID`),
  KEY `MODULO_ID` (`MODULO_ID`),
  CONSTRAINT `boletim_ibfk_1` FOREIGN KEY (`ALUNO_ID`) REFERENCES `aluno` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `boletim_ibfk_2` FOREIGN KEY (`MODULO_ID`) REFERENCES `modulo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletim`
--

LOCK TABLES `boletim` WRITE;
/*!40000 ALTER TABLE `boletim` DISABLE KEYS */;
INSERT INTO `boletim` VALUES (9,1,0),(9,2,0),(9,3,0),(9,4,0),(9,5,0),(10,1,0),(10,2,0),(10,3,0),(10,4,0),(10,5,0),(11,1,0),(11,2,0),(11,3,0),(11,4,0),(11,5,0),(12,1,0),(12,2,0),(12,3,0),(12,4,0),(12,5,0),(13,1,0),(13,2,0),(13,3,0),(13,4,0),(13,5,0),(14,1,0),(14,2,0),(14,3,0),(14,4,0),(14,5,0),(15,1,0),(15,2,0),(15,3,0),(15,4,0),(15,5,0),(16,1,0),(16,2,0),(16,3,0),(16,4,0),(16,5,0),(17,1,0),(17,2,0),(17,3,0),(17,4,0),(17,5,0),(18,1,0),(18,2,0),(18,3,0),(18,4,0),(18,5,0),(19,1,0),(19,2,0),(19,3,0),(19,4,0),(19,5,0),(20,1,0),(20,2,0),(20,3,0),(20,4,0),(20,5,0),(21,1,0),(21,2,0),(21,3,0),(21,4,0),(21,5,0),(23,1,0),(23,2,0),(23,3,0),(23,4,0),(23,5,0),(24,1,0),(24,2,0),(24,3,0),(24,4,0),(24,5,0);
/*!40000 ALTER TABLE `boletim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contato` (
  `PESSOA_ID` int(11) NOT NULL,
  `EMAIL` varchar(200) NOT NULL,
  `TELEFONE` varchar(25) NOT NULL,
  PRIMARY KEY (`PESSOA_ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  CONSTRAINT `contato_ibfk_1` FOREIGN KEY (`PESSOA_ID`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (5,'andersonzz2025@gmail.com','(84) 98893-3332'),(6,'andersonzz2015@gmail.com','(84) 98893-3332'),(7,'andersonzz2020@gmail.com','(84) 98893-3332'),(8,'andersonzz2021@gmail.com','(84) 98893-3332'),(9,'andersonzz2016@gmail.com','(84) 98893-3332'),(10,'andersonzz1000@gmail.com','(84) 98893-3332'),(11,'andersonzz1001@gmail.com','(84) 98893-3332'),(12,'andersonzz1002@gmail.com','(84) 98893-3332'),(13,'andersonzz1005@gmail.com','(84) 98893-3332'),(14,'andersonzz1006@gmail.com','(84) 98893-3332'),(15,'andersonzz1007@gmail.com','(84) 98893-3332'),(16,'andersonzz1010@gmail.com','(84) 98893-3332'),(17,'andersonzz1011@gmail.com','(84) 98893-3332'),(18,'andersonzz1012@gmail.com','(84) 98893-3332'),(21,'andersonzz1020@gmail.com','(84) 98893-3332'),(23,'andersonzz1022@gmail.com','(84) 98893-3332'),(24,'andersonzz1028@gmail.com','(84) 98893-3332'),(25,'andersonzz1030@gmail.com','(84) 98893-3332'),(26,'andersonzz999@gmail.com','(84) 98893-3332'),(27,'andersonzz998@gmail.com','(84) 98893-3332'),(28,'paulo@email.com','(84) 93289-4829'),(29,'vrau@vrau.com.br','(84) 92384-9273');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenador`
--

DROP TABLE IF EXISTS `coordenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordenador` (
  `USUARIO_ID` int(11) NOT NULL,
  PRIMARY KEY (`USUARIO_ID`),
  CONSTRAINT `coordenador_ibfk_1` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador`
--

LOCK TABLES `coordenador` WRITE;
/*!40000 ALTER TABLE `coordenador` DISABLE KEYS */;
INSERT INTO `coordenador` VALUES (25),(26);
/*!40000 ALTER TABLE `coordenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenador_geral`
--

DROP TABLE IF EXISTS `coordenador_geral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordenador_geral` (
  `COORDENADOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`COORDENADOR_ID`),
  CONSTRAINT `coordenador_geral_ibfk_1` FOREIGN KEY (`COORDENADOR_ID`) REFERENCES `coordenador` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador_geral`
--

LOCK TABLES `coordenador_geral` WRITE;
/*!40000 ALTER TABLE `coordenador_geral` DISABLE KEYS */;
INSERT INTO `coordenador_geral` VALUES (26);
/*!40000 ALTER TABLE `coordenador_geral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordenador_unidade`
--

DROP TABLE IF EXISTS `coordenador_unidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordenador_unidade` (
  `COORDENADOR_ID` int(11) NOT NULL,
  `UNIDADE_ID` int(11) NOT NULL,
  PRIMARY KEY (`COORDENADOR_ID`),
  UNIQUE KEY `UNIDADE_ID` (`UNIDADE_ID`),
  CONSTRAINT `coordenador_unidade_ibfk_1` FOREIGN KEY (`COORDENADOR_ID`) REFERENCES `coordenador` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `coordenador_unidade_ibfk_2` FOREIGN KEY (`UNIDADE_ID`) REFERENCES `unidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordenador_unidade`
--

LOCK TABLES `coordenador_unidade` WRITE;
/*!40000 ALTER TABLE `coordenador_unidade` DISABLE KEYS */;
INSERT INTO `coordenador_unidade` VALUES (25,1);
/*!40000 ALTER TABLE `coordenador_unidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CEP` char(9) NOT NULL,
  `BAIRRO` varchar(200) NOT NULL,
  `LOGRADOURO` varchar(200) NOT NULL,
  `NUMERO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BAIRRO` (`BAIRRO`,`LOGRADOURO`,`NUMERO`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'59104000','IGAPÓ','AVENIDA BACHAREL TOMAZ LANDIM','1590'),(2,'50000000','DUBAI','BUDJI KHALIFA','S/N'),(3,'30000000','CENTRO','AVENIDA RIO BRANCO','33'),(4,'20000000','QUINTAS','RUA DOS PEGAS','667'),(5,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','257'),(6,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','1'),(7,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','2'),(8,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','4'),(9,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','235'),(10,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','234'),(11,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','258'),(12,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','482'),(13,'59291-631','Centro','Rua 31 de Março','379'),(14,'59291-631','Centro','Rua 31 de Março','908'),(16,'59297-482','Santo Antônio do Potengi','Rua Boanerges Mendes da Silva','998');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrutor`
--

DROP TABLE IF EXISTS `instrutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instrutor` (
  `USUARIO_ID` int(11) NOT NULL,
  `UNIDADE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USUARIO_ID`),
  KEY `UNIDADE_ID` (`UNIDADE_ID`),
  CONSTRAINT `instrutor_ibfk_1` FOREIGN KEY (`UNIDADE_ID`) REFERENCES `unidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `instrutor_ibfk_2` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrutor`
--

LOCK TABLES `instrutor` WRITE;
/*!40000 ALTER TABLE `instrutor` DISABLE KEYS */;
INSERT INTO `instrutor` VALUES (6,1),(7,1),(8,1),(22,1);
/*!40000 ALTER TABLE `instrutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITULO` varchar(200) NOT NULL,
  `DESCRICAO` text NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TITULO` (`TITULO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (1,'Sistema Operacional','Aprenda a usar o sistema operacional mas usado e conhecido: Windows'),(2,'Editor de Texto','Aprenda a usar o editor de texto mais conhecido e usado: Microsoft Word'),(3,'Editor de Planilha','Aprenda a usar o editor de planilha mais conhecido e usado: Microsoft Excel'),(4,'Apresentação Eletrônica','Faça suas apresentações eletrônicas com o Microsoft Power Point'),(5,'Internet','Entenda o que é a Internet e como ela funciona');
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(200) NOT NULL,
  `CPF` char(14) NOT NULL,
  `RG` char(11) NOT NULL,
  `DATA_NASCIMENTO` date NOT NULL,
  `DATA_CADASTRO` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `SEXO` enum('MASCULINO','FEMININO','OUTRO') DEFAULT NULL,
  `ENDERECO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CPF` (`CPF`),
  UNIQUE KEY `RG` (`RG`),
  KEY `ENDERECO_ID` (`ENDERECO_ID`),
  CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`ENDERECO_ID`) REFERENCES `endereco` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (5,'Anderson Lucio','804.283.110-24','464.161.818','2001-07-03','2019-11-21 15:08:25','OUTRO',5),(6,'Anderson Lucio','824.961.940-48','524.184.846','2001-07-03','2019-11-21 15:14:31','MASCULINO',6),(7,'Anderson Lucio Santos','880.883.590-15','626.262.962','2002-07-03','2019-11-21 15:15:19','MASCULINO',7),(8,'Lucas do Nascimento Ribeiro Filho','687.669.080-60','654.194.848','2000-07-21','2019-11-21 15:15:55','MASCULINO',13),(9,'Anderson dos Santos Lucio','610.928.890-00','515.418.941','2001-07-03','2019-11-21 15:25:42','MASCULINO',9),(10,'Lucas do Nascimento','865.369.150-20','564.841.321','2001-07-03','2019-11-21 15:26:34','MASCULINO',10),(11,'Humberto','283.053.080-22','694.416.161','2001-07-03','2019-11-21 15:27:26','MASCULINO',10),(12,'Hugo','023.942.280-59','498.461.616','2001-07-03','2019-11-21 15:28:24','MASCULINO',10),(13,'Pierre','468.942.410-15','626.121.518','2001-07-03','2019-11-21 15:29:04','MASCULINO',10),(14,'Islane','968.256.980-01','216.148.484','2001-07-03','2019-11-21 15:29:46','MASCULINO',10),(15,'Allan','729.737.140-87','548.941.185','2001-07-03','2019-11-21 15:30:26','MASCULINO',10),(16,'Julio','996.278.690-82','654.135.184','2001-07-03','2019-11-21 15:30:56','MASCULINO',10),(17,'Renali','123.487.440-74','854.611.561','2001-07-03','2019-11-21 15:31:50','FEMININO',10),(18,'Elissandra','846.532.110-86','561.561.847','2001-07-03','2019-11-21 15:32:30','FEMININO',10),(21,'João Daniel','367.437.660-11','656.211.589','2001-07-03','2019-11-21 15:34:06','MASCULINO',10),(23,'Nathália','129.126.670-46','651.631.561','2001-07-03','2019-11-21 15:38:48','FEMININO',10),(24,'Brayan','988.571.570-32','626.494.111','2001-07-03','2019-11-21 15:39:26','MASCULINO',11),(25,'Guilherme','980.316.850-96','894.121.484','2001-07-03','2019-11-21 15:40:18','MASCULINO',10),(26,'Beatriz','876.645.240-67','216.156.165','2001-07-03','2019-11-21 15:41:09','FEMININO',10),(27,'Hellen','150.463.770-47','894.610.156','2001-07-03','2019-11-21 15:41:40','FEMININO',12),(28,'Paulo Afonso','387.768.640-06','339.999.993','2000-07-23','2019-11-21 18:37:03','MASCULINO',13),(29,'Drazio Vraunelas','832.616.630-81','898.989.899','2000-07-23','2019-11-21 18:39:28','MASCULINO',14);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_aula`
--

DROP TABLE IF EXISTS `registro_aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_aula` (
  `ALUNO_ID` int(11) NOT NULL,
  `AULA_ID` int(11) NOT NULL,
  `PRESENTE` tinyint(1) NOT NULL,
  PRIMARY KEY (`ALUNO_ID`,`AULA_ID`),
  KEY `AULA_ID` (`AULA_ID`),
  CONSTRAINT `registro_aula_ibfk_1` FOREIGN KEY (`ALUNO_ID`) REFERENCES `aluno` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registro_aula_ibfk_2` FOREIGN KEY (`AULA_ID`) REFERENCES `aula` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_aula`
--

LOCK TABLES `registro_aula` WRITE;
/*!40000 ALTER TABLE `registro_aula` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(50) NOT NULL,
  `DATA_INICIO` date NOT NULL,
  `DATA_FIM` date NOT NULL,
  `TURNO` enum('MATUTINO','VESPERTINO','NOTURNO') NOT NULL,
  `INSTRUTOR_ID` int(11) NOT NULL,
  `UNIDADE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODIGO` (`CODIGO`),
  KEY `INSTRUTOR_ID` (`INSTRUTOR_ID`),
  KEY `UNIDADE_ID` (`UNIDADE_ID`),
  CONSTRAINT `turma_ibfk_1` FOREIGN KEY (`INSTRUTOR_ID`) REFERENCES `instrutor` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `turma_ibfk_2` FOREIGN KEY (`UNIDADE_ID`) REFERENCES `unidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (2,'20190401V','2019-01-01','2019-04-01','MATUTINO',8,1),(3,'20190401M','2019-04-01','2019-07-01','MATUTINO',8,1),(4,'20190401N','2019-04-01','2019-07-01','NOTURNO',8,1);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma_modulo`
--

DROP TABLE IF EXISTS `turma_modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turma_modulo` (
  `MODULO_ID` int(11) NOT NULL,
  `TURMA_ID` int(11) NOT NULL,
  PRIMARY KEY (`MODULO_ID`,`TURMA_ID`),
  KEY `TURMA_ID` (`TURMA_ID`),
  CONSTRAINT `turma_modulo_ibfk_1` FOREIGN KEY (`TURMA_ID`) REFERENCES `turma` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `turma_modulo_ibfk_2` FOREIGN KEY (`MODULO_ID`) REFERENCES `modulo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma_modulo`
--

LOCK TABLES `turma_modulo` WRITE;
/*!40000 ALTER TABLE `turma_modulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `turma_modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidade`
--

DROP TABLE IF EXISTS `unidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidade` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(200) NOT NULL,
  `QUANTIDADE_EQUIPAMENTOS` int(11) NOT NULL,
  `ENDERECO_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NOME` (`NOME`),
  KEY `ENDERECO_ID` (`ENDERECO_ID`),
  CONSTRAINT `unidade_ibfk_1` FOREIGN KEY (`ENDERECO_ID`) REFERENCES `endereco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidade`
--

LOCK TABLES `unidade` WRITE;
/*!40000 ALTER TABLE `unidade` DISABLE KEYS */;
INSERT INTO `unidade` VALUES (1,'SANTO ANTÔNIO',30,6),(2,'São Gonçalo do Amarante',20,14);
/*!40000 ALTER TABLE `unidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MATRICULA` varchar(50) NOT NULL,
  `SENHA` varchar(100) NOT NULL,
  `PESSOA_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `MATRICULA` (`MATRICULA`),
  KEY `PESSOA_ID` (`PESSOA_ID`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`PESSOA_ID`) REFERENCES `pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (5,'201944010010005','cavalo2011',5),(6,'201943010006','ifrn.2019',6),(7,'201943010007','ifrn.2019',7),(8,'201943010008','ifrn.2019',8),(9,'201944010020009','ifrn.2019',9),(10,'201944010020010','ifrn.2019',10),(11,'201944010020011','ifrn.2019',11),(12,'201944010020012','ifrn.2019',12),(13,'201944010020013','ifrn.2019',13),(14,'201944010030014','ifrn.2019',14),(15,'201944010030015','ifrn.2019',15),(16,'201944010030016','ifrn.2019',16),(17,'201944010030017','ifrn.2019',17),(18,'201944010030018','ifrn.2019',18),(19,'201944010040019','ifrn.2019',21),(20,'201944010040022','ifrn.2019',23),(21,'201944010040024','ifrn.2019',24),(22,'201943010025','ifrn.2019',25),(23,'201944010040026','ifrn.2019',26),(24,'201944010040027','ifrn.2019',27),(25,'201942010028','12345678',28),(26,'2019410029','12345678',29);
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

-- Dump completed on 2019-11-21 21:10:25
