-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Jun-2019 às 09:47
-- Versão do servidor: 10.3.15-MariaDB
-- versão do PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `transporte`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `uf` char(2) NOT NULL,
  `validacao` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `uf`, `validacao`) VALUES
(1, 'Ceres', 'GO', 1),
(3, 'Rialma', 'GO', 0),
(4, 'Santa Isabel', 'GO', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE `horario` (
  `id` int(11) NOT NULL,
  `horario_saida` time NOT NULL,
  `horario_regresso` time NOT NULL,
  `id_turno` int(11) NOT NULL,
  `validacao` int(11) NOT NULL DEFAULT 0,
  `id_rota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `instituicao` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `validacao` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `instituicao`
--

INSERT INTO `instituicao` (`id`, `nome`, `endereco`, `telefone`, `id_cidade`, `validacao`) VALUES
(1, 'IF Goiano', 'Meio do Mato', '3307-1111', 1, 1),
(3, 'Facer', 'Av. Brasil', '3307-1313', 1, 1),
(4, 'UniEvangelica', 'Lugar Nenhum', '1222-3331', 1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `onibus`
--

CREATE TABLE `onibus` (
  `id` int(11) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `cor` varchar(45) NOT NULL,
  `motorista` varchar(45) NOT NULL,
  `mensalidade` decimal(4,2) NOT NULL,
  `validacao` int(11) NOT NULL DEFAULT 0,
  `telefone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `ponto` (
  `id` int(11) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `validacao` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ponto`
--

INSERT INTO `ponto` (`id`, `endereco`, `validacao`) VALUES
(1, 'ponto1', 1),
(2, 'ponto2', 1),
(3, 'ponto3', 1),
(4, 'ponto4', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota`
--

CREATE TABLE `rota` (
  `id` int(11) NOT NULL,
  `inicio` varchar(45) NOT NULL,
  `fim` varchar(45) NOT NULL,
  `id_onibus` int(11) NOT NULL,
  `identificador` int(11) NOT NULL DEFAULT 0,
  `validacao` int(11) NOT NULL DEFAULT 0,
  `percurso` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `rota`
--

INSERT INTO `rota` (`id`, `inicio`, `fim`, `id_onibus`, `identificador`, `validacao`, `percurso`) VALUES
(1, 'Santa Isabel', 'IF Goiano', 1, 1, 1, 'De la pra ca'),
(2, 'Itapaci', 'UEG', 2, 1, 1, 'De ca pra la'),
(3, 'Rialma', 'Facer', 2, 2, 2, 'Daqui pra li');

--
-- Acionadores `rota`
--
DELIMITER $$
CREATE TRIGGER `identifica_rota` BEFORE INSERT ON `rota` FOR EACH ROW BEGIN
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

CREATE TABLE `rota_has_instituicao` (
  `Id` int(11) NOT NULL,
  `id_rota` int(11) NOT NULL,
  `id_instituicao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `rota_has_instituicao`
--

INSERT INTO `rota_has_instituicao` (`Id`, `id_rota`, `id_instituicao`) VALUES
(1, 2, 1),
(3, 1, 3),
(5, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota_has_ponto`
--

CREATE TABLE `rota_has_ponto` (
  `id` int(11) NOT NULL,
  `id_rota` int(11) NOT NULL,
  `id_ponto` int(11) NOT NULL,
  `ordem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `rota_has_ponto`
--

INSERT INTO `rota_has_ponto` (`id`, `id_rota`, `id_ponto`, `ordem`) VALUES
(1, 1, 1, 1),
(2, 1, 3, 2),
(3, 1, 4, 3),
(5, 2, 1, 2),
(6, 2, 3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turno`
--

CREATE TABLE `turno` (
  `id` int(11) NOT NULL,
  `turno` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `turno`
--

INSERT INTO `turno` (`id`, `turno`) VALUES
(1, 'Matutino'),
(2, 'Vespertino'),
(3, 'Noturno');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_horario_turno1_idx` (`id_turno`),
  ADD KEY `rota_idx` (`id_rota`);

--
-- Índices para tabela `instituicao`
--
ALTER TABLE `instituicao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_instituicao_cidade1_idx` (`id_cidade`);

--
-- Índices para tabela `onibus`
--
ALTER TABLE `onibus`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `ponto`
--
ALTER TABLE `ponto`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `rota`
--
ALTER TABLE `rota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idOnibus_idx` (`id_onibus`);

--
-- Índices para tabela `rota_has_instituicao`
--
ALTER TABLE `rota_has_instituicao`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `fk_rota_has_instituicao_instituicao1_idx` (`id_instituicao`),
  ADD KEY `fk_rota_has_instituicao_rota1_idx` (`id_rota`);

--
-- Índices para tabela `rota_has_ponto`
--
ALTER TABLE `rota_has_ponto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_rota_has_ponto_ponto1_idx` (`id_ponto`),
  ADD KEY `fk_rota_has_ponto_rota1_idx` (`id_rota`);

--
-- Índices para tabela `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `horario`
--
ALTER TABLE `horario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `instituicao`
--
ALTER TABLE `instituicao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `onibus`
--
ALTER TABLE `onibus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `ponto`
--
ALTER TABLE `ponto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `rota`
--
ALTER TABLE `rota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `rota_has_instituicao`
--
ALTER TABLE `rota_has_instituicao`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `rota_has_ponto`
--
ALTER TABLE `rota_has_ponto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `turno`
--
ALTER TABLE `turno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para despejos de tabelas
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
