# ************************************************************
# Sequel Pro SQL dump
# Version 3408
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.5.16)
# Database: blog
# Generation Time: 2011-11-04 19:35:01 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tb_clubes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_clubes`;

CREATE TABLE `tb_clubes` (
  `id_clube` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `nome_pop` varchar(300) DEFAULT NULL,
  `fundacao` date DEFAULT NULL,
  PRIMARY KEY (`id_clube`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `tb_clubes` WRITE;
/*!40000 ALTER TABLE `tb_clubes` DISABLE KEYS */;

INSERT INTO `tb_clubes` (`id_clube`, `nome`, `nome_pop`, `fundacao`)
VALUES
	(1,'Barcelona','Barcelona','1900-01-01'),
	(2,'Real Madrid','Real','1900-01-01'),
	(3,'Ajax','Ajax','1905-05-28');

/*!40000 ALTER TABLE `tb_clubes` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
