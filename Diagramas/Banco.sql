-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 11-Jun-2019 às 20:48
-- Versão do servidor: 5.7.23
-- versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `transporte`
--
	CREATE DATABASE projeto_transporte;
    USE projeto_transporte;
-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `uf` char(2) NOT NULL,
  `validacao` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `uf`, `validacao`) VALUES
(1, 'Ceres', 'GO', 1),
(2, 'Rialma', 'GO', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

DROP TABLE IF EXISTS `horario`;
CREATE TABLE IF NOT EXISTS `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horario_saida` time NOT NULL,
  `horario_regresso` time NOT NULL,
  `id_turno` int(11) NOT NULL,
  `validacao` int(11) NOT NULL,
  `id_rota` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_horario_turno1_idx` (`id_turno`),
  KEY `rota_idx` (`id_rota`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `horario`
--

INSERT INTO `horario` (`id`, `horario_saida`, `horario_regresso`, `id_turno`, `validacao`, `id_rota`) VALUES
(1, '18:00:00', '22:30:00', 3, 1, 1),
(2, '17:30:00', '22:30:00', 2, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
CREATE TABLE IF NOT EXISTS `instituicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `validacao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_instituicao_cidade1_idx` (`id_cidade`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `instituicao`
--

INSERT INTO `instituicao` (`id`, `nome`, `endereco`, `telefone`, `id_cidade`, `validacao`) VALUES
(1, 'IF Goiano', 'Meio do Mato', '3307-1111', 1, 1),
(2, 'UEG', 'Rua qualquer', '3307-1212', 1, 0),
(3, 'Facer', 'Av. Brasil', '3307-1313', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `onibus`
--

DROP TABLE IF EXISTS `onibus`;
CREATE TABLE IF NOT EXISTS `onibus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(45) NOT NULL,
  `cor` varchar(45) NOT NULL,
  `motorista` varchar(45) NOT NULL,
  `mensalidade` decimal(4,2) NOT NULL,
  `validacao` int(11) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `onibus`
--

INSERT INTO `onibus` (`id`, `placa`, `cor`, `motorista`, `mensalidade`, `validacao`, `telefone`) VALUES
(1, 'abc-1234', 'Cinza', 'Dir', '1.00', 1, '98550-0404'),
(2, 'cba-4321', 'Branco', 'Motora', '99.99', 1, '98550-0001');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ponto`
--

DROP TABLE IF EXISTS `ponto`;
CREATE TABLE IF NOT EXISTS `ponto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(45) NOT NULL,
  `validacao` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ponto`
--

INSERT INTO `ponto` (`id`, `endereco`, `validacao`) VALUES
(1, 'ponto1', 1),
(2, 'ponto2', 1),
(3, 'ponto3', 1),
(4, 'ponto4', 0),
(5, 'ponto5', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota`
--

DROP TABLE IF EXISTS `rota`;
CREATE TABLE IF NOT EXISTS `rota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inicio` varchar(45) NOT NULL,
  `fim` varchar(45) NOT NULL,
  `identificador` int(11) NOT NULL DEFAULT '0',
  `id_onibus` int(11) NOT NULL,
  `validacao` int(11) NOT NULL,
  `percurso` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idOnibus_idx` (`id_onibus`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `rota`
--

INSERT INTO `rota` (`id`, `inicio`, `fim`, `identificador`, `id_onibus`, `validacao`, `percurso`) VALUES
(1, 'Santa Isabel', 'IF Goiano', 1, 1, 1, 'De la pra ca'),
(2, 'Itapaci', 'UEG', 1, 2, 1, 'De ca pra la'),
(3, 'Rialma', 'IF Goiano', 2, 1, 1, 'Setor A, Setor B, Setor C'),
(5, 'Santa Terezinha', 'IF Goiano', 2, 2, 1, 'Santa Terezinha, Itapaci, Rialma, IF Goiano'),
(6, 'Rubiataba', 'IF Goiano', 3, 2, 1, 'Rubiataba, Rialma, UEG(Ceres), IF Goiano'),
(8, 'Rialma', 'IF Goiano', 3, 1, 1, 'Setor 1, Setor 2, Setor 3, IF Goiano');

--
-- Acionadores `rota`
--
DROP TRIGGER IF EXISTS `identifica_rota`;
DELIMITER $$
CREATE TRIGGER `identifica_rota` BEFORE INSERT ON `rota` FOR EACH ROW 
BEGIN
	SET NEW.identificador  = (
		SELECT COUNT(*) FROM rota 
		WHERE id_onibus = NEW.id_onibus
    ) + 1;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota_has_instituicao`
--

DROP TABLE IF EXISTS `rota_has_instituicao`;
CREATE TABLE IF NOT EXISTS `rota_has_instituicao` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `id_rota` int(11) NOT NULL,
  `id_instituicao` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_rota_has_instituicao_instituicao1_idx` (`id_instituicao`),
  KEY `fk_rota_has_instituicao_rota1_idx` (`id_rota`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `rota_has_instituicao`
--

INSERT INTO `rota_has_instituicao` (`Id`, `id_rota`, `id_instituicao`) VALUES
(1, 2, 1),
(2, 2, 2),
(3, 1, 3),
(4, 1, 2),
(5, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota_has_ponto`
--

DROP TABLE IF EXISTS `rota_has_ponto`;
CREATE TABLE IF NOT EXISTS `rota_has_ponto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_rota` int(11) NOT NULL,
  `id_ponto` int(11) NOT NULL,
  `ordem` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rota_has_ponto_ponto1_idx` (`id_ponto`),
  KEY `fk_rota_has_ponto_rota1_idx` (`id_rota`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `rota_has_ponto`
--

INSERT INTO `rota_has_ponto` (`id`, `id_rota`, `id_ponto`, `ordem`) VALUES
(1, 1, 1, 1),
(2, 1, 3, 2),
(3, 1, 4, 3),
(4, 2, 5, 1),
(5, 2, 1, 2),
(6, 2, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turno`
--

DROP TABLE IF EXISTS `turno`;
CREATE TABLE IF NOT EXISTS `turno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `turno`
--

INSERT INTO `turno` (`id`, `turno`) VALUES
(1, 'Matutino'),
(2, 'Vespertino'),
(3, 'Noturno');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_horario_turno1` FOREIGN KEY (`id_turno`) REFERENCES `turno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `rota` FOREIGN KEY (`id_rota`) REFERENCES `rota` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `instituicao`
--
ALTER TABLE `instituicao`
  ADD CONSTRAINT `fk_instituicao_cidade1` FOREIGN KEY (`id_cidade`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rota`
--
ALTER TABLE `rota`
  ADD CONSTRAINT `idOnibus` FOREIGN KEY (`id_onibus`) REFERENCES `onibus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rota_has_instituicao`
--
ALTER TABLE `rota_has_instituicao`
  ADD CONSTRAINT `fk_rota_has_instituicao_instituicao1` FOREIGN KEY (`id_instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rota_has_instituicao_rota1` FOREIGN KEY (`id_rota`) REFERENCES `rota` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rota_has_ponto`
--
ALTER TABLE `rota_has_ponto`
  ADD CONSTRAINT `fk_rota_has_ponto_ponto1` FOREIGN KEY (`id_ponto`) REFERENCES `ponto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_rota_has_ponto_rota1` FOREIGN KEY (`id_rota`) REFERENCES `rota` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
