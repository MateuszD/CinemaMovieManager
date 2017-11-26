-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Czas generowania: 23 Lis 2017, 22:43
-- Wersja serwera: 5.7.19
-- Wersja PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `cinemaproject_db`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `movies`
--

DROP TABLE IF EXISTS `movies`;
CREATE TABLE IF NOT EXISTS `movies` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_title` varchar(30) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `movie_director` varchar(20) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `movie_genre` varchar(10) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `movie_productiondate` date NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `movies`
--

INSERT INTO `movies` (`movie_id`, `movie_title`, `movie_director`, `movie_genre`, `movie_productiondate`) VALUES
(1, 'Avatar', 'James Cameron', 'Sci-Fi', '2009-12-25'),
(2, 'Terminator 2', 'James Cameron', 'Sci-Fi', '1992-05-05'),
(5, 'Gwiezdne Wojny: Ostatni Jedi', 'Rian Johnson', 'Sci-Fi', '2017-12-14'),
(6, 'Listy do M. 3', 'Tomasz Konecki', 'Obyczajowy', '2017-11-10'),
(8, 'sss', 'ssss', 'aaaa', '2017-11-13');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
