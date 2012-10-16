-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27-log
-- Versão do PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `bd_questoes`
--
CREATE DATABASE `bd_questoes` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bd_questoes`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `escolhas`
--

CREATE TABLE IF NOT EXISTS `escolhas` (
  `id_escolhas` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuarios` int(11) NOT NULL,
  `id_questionarios` int(11) NOT NULL,
  `id_perguntas` int(11) NOT NULL,
  `id_respostas` int(11) NOT NULL,
  `id_pesos` int(11) NOT NULL,
  PRIMARY KEY (`id_escolhas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Extraindo dados da tabela `escolhas`
--

INSERT INTO `escolhas` (`id_escolhas`, `id_usuarios`, `id_questionarios`, `id_perguntas`, `id_respostas`, `id_pesos`) VALUES
(1, 0, 0, 1, 3, 1),
(2, 0, 0, 1, 4, 4),
(3, 0, 0, 1, 8, 8),
(4, 0, 0, 1, 5, 5),
(5, 0, 0, 1, 5, 5),
(6, 0, 0, 1, 5, 5),
(7, 0, 0, 1, 2, 2),
(8, 0, 0, 1, 9, 9),
(9, 0, 0, 1, 19, 19),
(10, 9, 0, 1, 7, 7),
(11, 9, 0, 1, 3, 3),
(12, 9, 0, 5, 19, 19),
(13, 9, 0, 1, 4, 4),
(14, 9, 0, 2, 6, 6),
(15, 9, 0, 4, 15, 3),
(16, 9, 0, 2, 6, 3),
(17, 9, 5, 3, 9, 3),
(18, 9, 5, 1, 3, 3),
(19, 9, 5, 1, 4, 5),
(20, 9, 5, 2, 6, 3),
(21, 9, 5, 3, 11, 3),
(22, 9, 5, 2, 6, 3),
(23, 9, 5, 3, 10, 2),
(24, 9, 5, 1, 3, 3),
(25, 9, 5, 4, 16, 5),
(26, 9, 0, 1, 2, 2),
(27, 9, 0, 4, 14, 2),
(28, 0, 0, 4, 13, 1),
(29, 0, 0, 2, 5, 1),
(30, 0, 0, 2, 5, 1),
(31, 0, 0, 1, 2, 2),
(32, 0, 0, 1, 2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `perguntas`
--

CREATE TABLE IF NOT EXISTS `perguntas` (
  `id_perguntas` int(11) NOT NULL AUTO_INCREMENT,
  `id_questionarios` int(11) NOT NULL,
  `perguntas` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_perguntas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `perguntas`
--

INSERT INTO `perguntas` (`id_perguntas`, `id_questionarios`, `perguntas`) VALUES
(1, 0, 'Qual o seu nivel de conhecimento em java?'),
(2, 0, 'Qual o seu conhecimento em Logica de ProgramaÃ§Ã£o?'),
(3, 0, 'Ha quanto tempo esta voce atua na area?'),
(4, 0, 'Possui alguma certificaÃ§Ã£o em TI?'),
(5, 0, 'Possui conhecimento em Ingles?');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pesos`
--

CREATE TABLE IF NOT EXISTS `pesos` (
  `id_pesos` int(11) NOT NULL AUTO_INCREMENT,
  `id_perguntas` int(11) NOT NULL,
  `id_respostas` int(11) NOT NULL,
  `id_questionarios` int(11) NOT NULL,
  `pesos` float NOT NULL,
  PRIMARY KEY (`id_pesos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `pesos`
--

INSERT INTO `pesos` (`id_pesos`, `id_perguntas`, `id_respostas`, `id_questionarios`, `pesos`) VALUES
(1, 1, 1, 0, 1),
(2, 1, 2, 0, 2),
(3, 1, 3, 0, 3),
(4, 1, 4, 0, 5),
(5, 2, 5, 0, 1),
(6, 2, 6, 0, 3),
(7, 2, 7, 0, 5),
(8, 2, 8, 0, 10),
(9, 3, 9, 0, 3),
(10, 3, 10, 0, 2),
(11, 3, 11, 0, 3),
(12, 3, 12, 0, 5),
(13, 4, 13, 0, 1),
(14, 4, 14, 0, 2),
(15, 4, 15, 0, 3),
(16, 4, 16, 0, 5),
(17, 5, 17, 0, 2),
(18, 5, 18, 0, 3),
(19, 5, 19, 0, 5),
(20, 5, 20, 0, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `questionarios`
--

CREATE TABLE IF NOT EXISTS `questionarios` (
  `id_questionarios` int(11) NOT NULL,
  `id_usuarios` int(11) NOT NULL,
  `nome_questionario` text CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `questionarios`
--

INSERT INTO `questionarios` (`id_questionarios`, `id_usuarios`, `nome_questionario`) VALUES
(0, 0, 'Questionario para seleção de candidatos.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `respostas`
--

CREATE TABLE IF NOT EXISTS `respostas` (
  `id_respostas` int(11) NOT NULL AUTO_INCREMENT,
  `id_perguntas` int(11) NOT NULL,
  `id_questionarios` int(11) NOT NULL,
  `respostas` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_respostas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `respostas`
--

INSERT INTO `respostas` (`id_respostas`, `id_perguntas`, `id_questionarios`, `respostas`) VALUES
(1, 1, 0, 'Nenhum'),
(2, 1, 0, 'Basico'),
(3, 1, 0, 'Intermediario'),
(4, 1, 0, 'AvanÃ§ado'),
(5, 2, 0, 'Nenhum'),
(6, 2, 0, 'Basico '),
(7, 2, 0, 'Intermediario'),
(8, 2, 0, 'AvanÃ§ado'),
(9, 3, 0, 'Menos de 1 ano'),
(10, 3, 0, 'De 2 a 3 anos'),
(11, 3, 0, 'De 4 a 5 anos'),
(12, 3, 0, '5 ou mais anos'),
(13, 4, 0, 'Nenhuma'),
(14, 4, 0, '1 a 3'),
(15, 4, 0, '4 a 5'),
(16, 4, 0, '5 ou mais'),
(17, 5, 0, 'Nenhum'),
(18, 5, 0, 'Basico'),
(19, 5, 0, 'Intermediario'),
(20, 5, 0, 'Fluente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuarios` int(11) NOT NULL,
  `nome` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_questionarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id_usuarios`, `nome`, `email`, `id_questionarios`) VALUES
(0, 'Leonardo Feitosa', 'ffeitosa.leonardo@gmail.com', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
