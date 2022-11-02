-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20221031.25fe766a26
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 02, 2022 alle 16:29
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_app`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `liste`
--

CREATE TABLE `liste` (
  `id` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  `amis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `liste`
--

INSERT INTO `liste` (`id`, `user`, `amis`) VALUES
(1, 'toto', 'jnfzeofnzeo\r\n'),
(2, 'thrhtr', 'htrhrt');

-- --------------------------------------------------------

--
-- Struttura della tabella `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `login`
--

INSERT INTO `login` (`id`, `user`, `password`) VALUES
(1, 'toto', 'toto'),
(2, 'fre', 'gresgs'),
(3, 'root', 'root'),
(4, 'hy(t', 'h(hy('),
(5, 'kikiiiii', 'ioiuio'),
(6, 'kikiiiii', 'ioiuio'),
(7, 'kikiiiii', 'ioiuio'),
(8, 'kifrefrefrefgergkiiiii', 'feferg'),
(9, 'Usernamefr', 'Passwordgergr'),
(10, 'frekjfglzn', 'flnr'),
(11, 'fliorghjr', 'flijzelfzfg'),
(12, 'frefev', 'frnoe'),
(13, 'lulu', 'lulu'),
(14, 'lulu', 'lulu'),
(15, 'freg', 'regnke'),
(16, 'klfnerklfnlkrevglkrnvgknvelv', 'vlrjeknbkbkrnelkrbnrlb'),
(17, 'zefr', 'freege'),
(18, 'test', 'test'),
(19, 'ufgezuifezku', 'fuhbzeuiguz'),
(21, 'dzadz', 'dezdezfezf'),
(22, 'fregqeg', 'gresgsegrt'),
(23, '', 'dfgdggsdrg'),
(24, 'gfdgwgwdggdf', 'gvdfgdg'),
(25, 'lulu', 'lulu'),
(26, 'lulu', 'lulu');

-- --------------------------------------------------------

--
-- Struttura della tabella `msginfo`
--

CREATE TABLE `msginfo` (
  `id` int(11) NOT NULL,
  `msg` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `request`
--

CREATE TABLE `request` (
  `user` varchar(255) NOT NULL,
  `nbAmi` int(11) NOT NULL,
  `name_amis` varchar(255) NOT NULL COMMENT 'Amis'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `liste`
--
ALTER TABLE `liste`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `msginfo`
--
ALTER TABLE `msginfo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `liste`
--
ALTER TABLE `liste`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT per la tabella `msginfo`
--
ALTER TABLE `msginfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
