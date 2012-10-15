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

-- --------------------------------------------------------

--
-- Estrutura da tabela `perguntas`
--

CREATE TABLE IF NOT EXISTS `perguntas` (
  `id_perguntas` int(11) NOT NULL AUTO_INCREMENT,
  `perguntas` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_perguntas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `perguntas`
--

INSERT INTO `perguntas` (`id_perguntas`, `perguntas`) VALUES
(1, 'Qual o seu nivel de conhecimento em java?'),
(2, 'Qual o seu conhecimento em Logica de ProgramaÃ§Ã£o?'),
(3, 'Ha quanto tempo esta voce atua na area?'),
(4, 'Possui alguma certificaÃ§Ã£o em TI?'),
(5, 'Possui conhecimento em Ingles?');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pesos`
--

CREATE TABLE IF NOT EXISTS `pesos` (
  `id_pesos` int(11) NOT NULL AUTO_INCREMENT,
  `id_perguntas` int(11) NOT NULL,
  `id_respostas` int(11) NOT NULL,
  `pesos` float NOT NULL,
  PRIMARY KEY (`id_pesos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `pesos`
--

INSERT INTO `pesos` (`id_pesos`, `id_perguntas`, `id_respostas`, `pesos`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 1, 3, 3),
(4, 1, 4, 5),
(5, 2, 5, 1),
(6, 2, 6, 3),
(7, 2, 7, 5),
(8, 2, 8, 10),
(9, 3, 9, 3),
(10, 3, 10, 2),
(11, 3, 11, 3),
(12, 3, 12, 5),
(13, 4, 13, 1),
(14, 4, 14, 2),
(15, 4, 15, 3),
(16, 4, 16, 5),
(17, 5, 17, 2),
(18, 5, 18, 3),
(19, 5, 19, 5),
(20, 5, 20, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `respostas`
--

CREATE TABLE IF NOT EXISTS `respostas` (
  `id_respostas` int(11) NOT NULL AUTO_INCREMENT,
  `id_perguntas` int(11) NOT NULL,
  `respostas` text NOT NULL,
  PRIMARY KEY (`id_respostas`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `respostas`
--

INSERT INTO `respostas` (`id_respostas`, `id_perguntas`, `respostas`) VALUES
(1, 1, 'Nenhum'),
(2, 1, 'Basico'),
(3, 1, 'Intermediario'),
(4, 1, 'AvanÃ§ado'),
(5, 2, 'Nenhum'),
(6, 2, 'Basico '),
(7, 2, 'Intermediario'),
(8, 2, 'AvanÃ§ado'),
(9, 3, 'Menos de 1 ano'),
(10, 3, 'De 2 a 3 anos'),
(11, 3, 'De 4 a 5 anos'),
(12, 3, '5 ou mais anos'),
(13, 4, 'Nenhuma'),
(14, 4, '1 a 3'),
(15, 4, '4 a 5'),
(16, 4, '5 ou mais'),
(17, 5, 'Nenhum'),
(18, 5, 'Basico'),
(19, 5, 'Intermediario'),
(20, 5, 'Fluente');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
