-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Okt 06. 15:06
-- Kiszolgáló verziója: 10.4.24-MariaDB
-- PHP verzió: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `nb-java`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `contact`
--

INSERT INTO `contact` (`id`, `name`, `email`, `message`, `created_at`) VALUES
(1, 'mi van', 'mivanitt@gmail.com', 'szia\r\n', '2023-09-29 15:01:04'),
(13, 'adasdaads', 'dsadassadaad@gmail.com', 'asdaddadadadadasa', '2023-09-29 15:42:01'),
(14, 'adsdaadda', 'adadadadad@gmail.com', 'adadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.comadadadadad@gmail.com', '2023-09-29 15:42:51'),
(15, 'adsaddad', 'dadadsdasdasads@gmail.com', 'dasasdsdadsadasdasdasdasdsa', '2023-09-29 15:44:20'),

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `klub`
--

CREATE TABLE `klub` (
  `id` int(11) NOT NULL,
  `csapatnev` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `klub`
--

INSERT INTO `klub` (`id`, `csapatnev`) VALUES
(1, 'Vasas FC'),
(2, 'Ferencvárosi TC'),
(3, 'Puskás Akadémia FC'),
(4, 'Debreceni VSC'),
(5, 'Budapest Honvéd FC'),
(6, 'Szombathelyi Haladás'),
(7, 'Paksi FC'),
(8, 'Mezőkövesd Zsóry FC'),
(9, 'Diósgyőri VTK'),
(10, 'Újpest FC'),
(11, 'Balmazújváros FC'),
(12, 'Videoton FC');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `labdarugo`
--

CREATE TABLE `labdarugo` (
  `id` int(11) NOT NULL,
  `mezszam` int(11) DEFAULT NULL,
  `klubid` int(11) DEFAULT NULL,
  `posztid` int(11) DEFAULT NULL,
  `utonev` varchar(255) DEFAULT NULL,
  `vezeteknev` varchar(255) DEFAULT NULL,
  `szulido` varchar(255) DEFAULT NULL,
  `magyar` varchar(255) DEFAULT NULL,
  `kulfoldi` varchar(255) DEFAULT NULL,
  `ertek` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `labdarugo`
--

INSERT INTO `labdarugo` (`id`, `mezszam`, `klubid`, `posztid`, `utonev`, `vezeteknev`, `szulido`, `magyar`, `kulfoldi`, `ertek`) VALUES
(1, 18, 11, 4, 'Attila', 'Haris', '1997-01-23', '-1', '0', '150'),
(2, 31, 6, 12, 'Márió', 'Németh', '1995-05-01', '-1', '0', '300'),
(3, 77, 4, 2, 'Aleksandar', 'Jovanovic', '1984-10-26', '0', '-1', '300'),
(4, 14, 4, 8, 'Krisztián', 'Kuti', '1992-12-04', '-1', '0', '100'),
(5, 9, 3, 10, 'Ulysse', 'Diallo', '1992-10-26', '0', '-1', '250'),
(6, 12, 3, 4, 'Balázs', 'Balogh', '1990-06-11', '-1', '0', '400'),
(7, 33, 3, 7, 'Gábor', 'Molnár', '1994-05-16', '-1', '0', '400'),
(8, 7, 7, 1, 'Tamás', 'Báló', '1984-01-12', '-1', '0', '100'),
(9, 17, 12, 4, 'Máté', 'Pátkai', '1988-03-06', '-1', '0', '750'),
(10, 10, 8, 4, 'Bence', 'Iszlai', '1990-05-29', '-1', '0', '300'),
(11, 28, 2, 12, 'Joseph', 'Paintsil', '1998-02-01', '0', '-1', '400'),
(12, 12, 6, 6, 'Bence', 'Kiss', '1999-07-01', '-1', '0', '150'),
(13, 1, 9, 9, 'Erik', 'Bukrán', '1996-12-06', '-1', '0', '75'),
(14, 71, 11, 2, 'Ádám', 'Orovecz', '1997-10-23', '-1', '0', '50'),
(15, 23, 11, 7, 'Ádám', 'Kovács', '1991-04-14', '-1', '0', '150'),
(16, 27, 1, 7, 'Benedek', 'Murka', '1997-09-10', '-1', '0', '250'),
(17, 19, 9, 8, 'Tibor', 'Nagy', '1991-08-14', '-1', '0', '150'),
(18, 22, 7, 12, 'Áron', 'Fejős', '1997-04-17', '-1', '0', '50'),
(19, 56, 11, 10, 'Miklós', 'Belényesi', '1983-05-15', '-1', '0', '50'),
(20, 1, 3, 9, 'Balázs', 'Tóth', '1997-09-04', '-1', '0', '50'),
(21, 6, 4, 8, 'Balázs', 'Bényei', '1990-01-10', '-1', '0', '250'),
(22, 21, 6, 3, 'Tamás', 'Kiss', '2000-11-24', '-1', '0', '50'),
(23, 25, 4, 10, 'Haris', 'Tabakovic', '1994-06-20', '0', '-1', '250'),
(24, 14, 10, 6, 'Alassane', 'Diallo', '1995-02-19', '0', '-1', '200'),
(25, 94, 7, 10, 'Bence', 'Daru', '1994-06-05', '-1', '0', '125'),
(26, 99, 8, 12, 'Márk', 'Murai', '1996-07-15', '-1', '0', '25'),
(27, 40, 1, 10, 'István', 'Ferenczi', '1977-09-14', '-1', '0', '50'),
(28, 3, 6, 8, 'Dávid', 'Tóth', '1998-07-09', '-1', '0', '100'),
(29, 4, 9, 11, 'Márk', 'Tamás', '1993-10-28', '-1', '0', '300'),
(30, 74, 12, 9, 'Ádám', 'Kovácsik', '1991-04-04', '-1', '0', '450'),
(31, 17, 10, 13, 'Viktor', 'Angelov', '1994-03-27', '0', '-1', '150'),
(32, 31, 12, 5, 'Dávid', 'Barczi', '1989-02-01', '-1', '0', '200'),
(33, 26, 11, 5, 'Sándor', 'Vajda', '1991-12-14', '-1', '-1', '200'),
(34, 30, 7, 1, 'János', 'Szabó', '1989-07-11', '-1', '0', '350'),
(35, 25, 12, 1, 'Krisztián', 'Tamás', '1995-04-18', '-1', '0', '150'),
(36, 6, 11, 11, 'Krisztián', 'Póti', '1988-05-28', '-1', '0', '100'),
(37, 14, 8, 10, 'Lazar', 'Veselinovic', '1986-08-04', '0', '-1', '300'),
(38, 9, 9, 10, 'Patrik', 'Bacsa', '1992-06-03', '-1', '0', '150'),
(39, 1, 11, 9, 'Gergő', 'Szécsi', '1989-02-07', '-1', '0', '75'),
(40, 2, 5, 11, 'Dávid', 'Bobál', '1995-08-31', '-1', '0', '450'),
(41, 2, 8, 8, 'Dániel', 'Farkas', '1993-01-13', '-1', '-1', '225'),
(42, 87, 9, 11, 'Róbert', 'Tucsa', '1998-03-17', '-1', '0', '50'),
(43, 29, 2, 10, 'Tamás', 'Priskin', '1986-09-27', '-1', '0', '500'),
(44, 55, 11, 6, 'István', 'Bódis', '1997-01-19', '-1', '0', '100'),
(45, 97, 2, 7, 'Roland', 'Varga', '1990-01-23', '-1', '0', '1000'),
(46, 16, 5, 6, 'Zsolt', 'Pölöskei', '1991-02-19', '-1', '0', '250'),
(47, 5, 12, 8, 'Attila', 'Fiola', '1990-02-17', '-1', '0', '700'),
(48, 13, 6, 8, 'Kristóf', 'Polgár', '1996-11-28', '-1', '0', '200'),
(49, 42, 4, 7, 'Norbert', 'Könyves', '1989-06-10', '-1', '-1', '250'),
(50, 23, 1, 4, 'Máté', 'Vida', '1996-03-08', '-1', '0', '700'),
(51, 86, 10, 10, 'Soma', 'Novothny', '1994-06-16', '-1', '0', '400'),
(52, 4, 1, 11, 'Kire', 'Ristevski', '1990-10-22', '0', '-1', '700'),
(53, 1, 7, 9, 'Péter', 'Molnár', '1983-12-14', '0', '-1', '200'),
(54, 28, 10, 6, 'Obinna', 'Nwobodo', '1996-11-29', '0', '-1', '150'),
(55, 55, 12, 11, 'Bence', 'Tóth', '1998-05-25', '-1', '0', '250'),
(56, 86, 5, 1, 'Zsolt', 'Laczkó', '1986-12-18', '-1', '0', '300'),
(57, 10, 10, 7, 'Donát', 'Zsótér', '1996-01-06', '-1', '0', '300'),
(58, 13, 2, 10, 'Dániel', 'Böde', '1986-10-21', '-1', '0', '600'),
(59, 90, 8, 9, 'Tomas', 'Tujvel', '1983-09-19', '0', '-1', '175'),
(60, 17, 8, 11, 'Róbert', 'Pillár', '1991-05-27', '0', '-1', '200'),
(61, 20, 5, 4, 'Mihály', 'Csábi', '1995-03-25', '-1', '0', '75'),
(62, 6, 6, 11, 'Stef', 'Wils', '1982-08-02', '0', '-1', '225'),
(63, 31, 2, 9, 'Ádám', 'Holczer', '1988-03-28', '-1', '0', '150'),
(64, 1, 10, 9, 'Filip', 'Pajovic', '1993-07-30', '0', '-1', '300'),
(65, 30, 9, 6, '', 'Nono', '1993-03-30', '0', '-1', '350'),
(66, 94, 9, 8, 'Gábor', 'Eperjesi', '1994-01-12', '-1', '0', '200'),
(67, 30, 2, 12, 'Rui', 'Pedro', '1988-07-02', '0', '-1', '750'),
(68, 10, 4, 10, 'Tibor', 'Tisza', '1984-11-10', '-1', '0', '200'),
(69, 20, 3, 11, 'Vilmos', 'Vanczák', '1983-06-20', '-1', '0', '200'),
(70, 16, 6, 12, 'Barnabás', 'Rácz', '1996-04-26', '-1', '0', '250'),
(71, 90, 2, 9, 'Dénes', 'Dibusz', '1990-11-16', '-1', '0', '750'),
(72, 8, 12, 4, 'Anel', 'Hadzic', '1989-08-16', '0', '-1', '800'),
(73, 23, 7, 8, 'András', 'Vági', '1988-12-25', '-1', '0', '200'),
(74, 24, 8, 3, 'Tamás', 'Cseri', '1988-01-15', '-1', '0', '175'),
(75, 28, 3, 6, 'Stipe', 'Bacelic-Grgic', '1988-02-16', '0', '-1', '300'),
(76, 9, 8, 10, 'Csanád', 'Novák', '1994-09-24', '-1', '0', '200'),
(77, 18, 5, 9, 'András', 'Horváth', '1988-02-23', '-1', '0', '150'),
(78, 20, 1, 4, 'Márk', 'Kleisz', '1998-07-02', '-1', '0', '400'),
(79, 44, 3, 9, 'Branislav', 'Danilovic', '1988-06-24', '0', '-1', '300'),
(80, 33, 4, 4, 'Richárd', 'Csősz', '1997-04-22', '-1', '0', '50'),
(81, 92, 5, 10, 'Kristóf', 'Herjeczki', '1998-06-29', '-1', '0', '100'),
(82, 91, 2, 10, 'Balázs', 'Lovrencsics', '1991-08-30', '-1', '0', '200'),
(83, 20, 9, 6, 'Attila', 'Busai', '1989-01-21', '-1', '0', '250'),
(84, 8, 9, 4, 'Bálint', 'Oláh', '1994-12-02', '-1', '0', '150'),
(85, 15, 9, 4, 'Barnabás', 'Tóth', '1994-07-28', '-1', '0', '150'),
(86, 22, 10, 1, 'Dávid', 'Mohl', '1985-04-28', '-1', '0', '250'),
(87, 69, 11, 10, 'Roland', 'Vólent', '1992-09-23', '-1', '0', '75'),
(88, 3, 1, 4, 'Manjrekar', 'James', '1993-08-05', '0', '-1', '200'),
(89, 10, 12, 12, 'István', 'Kovács', '1992-03-27', '-1', '0', '400'),
(90, 66, 5, 9, 'Attila', 'Berla', '1999-04-08', '-1', '0', '50'),
(91, 8, 1, 10, 'Martin', 'Ádám', '1994-11-06', '-1', '0', '300'),
(92, 11, 2, 12, 'István', 'Bognár', '1991-05-06', '-1', '0', '300'),
(93, 16, 10, 4, 'Anton', 'Jönsson Salétros', '1996-04-12', '0', '-1', '250'),
(94, 22, 12, 1, '', 'Stopira', '1988-05-20', '0', '-1', '750'),
(95, 66, 6, 9, 'Dániel', 'Rózsa', '1984-11-24', '-1', '0', '200'),
(96, 39, 8, 11, 'Dávid', 'Hudák', '1993-03-21', '0', '-1', '275'),
(97, 9, 1, 2, 'Botond', 'Király', '1994-10-26', '-1', '0', '150'),
(98, 15, 8, 12, 'Marek', 'Strestik', '1987-02-01', '-1', '-1', '350'),
(99, 7, 1, 1, 'Szilveszter', 'Hangya', '1994-01-02', '-1', '0', '600'),
(100, 24, 4, 4, 'Danilo', 'Sekulic', '1990-04-18', '0', '-1', '350'),
(101, 3, 2, 10, 'Norbert', 'Kundrák', '1999-05-18', '-1', '0', '100'),
(102, 9, 5, 10, 'Márton', 'Eppel', '1991-10-26', '-1', '0', '650'),
(103, 14, 3, 11, 'Jonathan', 'Heris', '1990-09-03', '0', '-1', '600'),
(104, 19, 10, 11, 'Mijusko', 'Bojovic', '1988-08-09', '0', '-1', '300'),
(105, 14, 2, 11, 'Zsombor', 'Takács', '1999-02-22', '-1', '0', '50'),
(106, 96, 7, 11, 'Bence', 'Lenzsér', '1996-04-09', '-1', '0', '350'),
(107, 8, 3, 6, 'Dávid', 'Márkvárt', '1994-09-20', '-1', '0', '300'),
(108, 23, 2, 3, 'Lukács', 'Bőle', '1990-03-27', '-1', '0', '800'),
(109, 7, 10, 7, 'Krisztián', 'Simon', '1991-06-10', '-1', '0', '150'),
(110, 5, 7, 11, 'Zsolt', 'Gévay', '1987-11-19', '-1', '0', '225'),
(111, 11, 6, 10, 'David', 'Williams', '1988-02-26', '0', '-1', '450'),
(112, 39, 7, 3, 'László', 'Bartha', '1987-02-09', '-1', '0', '300'),
(113, 4, 4, 4, 'Ioan', 'Filip', '1989-05-20', '0', '-1', '350'),
(114, 17, 9, 4, 'Miklós', 'Kitl', '1997-06-01', '-1', '0', '125'),
(115, 28, 7, 12, 'Márk', 'Nikházi', '1989-02-02', '-1', '0', '200'),
(116, 10, 11, 7, 'Ervin', 'Zsiga', '1991-07-11', '-1', '-1', '125'),
(117, 5, 10, 11, 'Róbert', 'Litauszki', '1990-03-15', '-1', '0', '400'),
(118, 9, 6, 10, 'Miroslav', 'Grumic', '1984-06-29', '-1', '-1', '100'),
(119, 19, 3, 9, 'Lajos', 'Hegedüs', '1987-12-19', '-1', '0', '300'),
(120, 10, 7, 7, 'Zsolt', 'Haraszti', '1991-11-04', '-1', '0', '225'),
(121, 70, 4, 7, 'Kevin', 'Nagy', '1995-09-11', '-1', '0', '100'),
(122, 92, 6, 10, 'Myke', '', '1992-10-30', '0', '-1', '200'),
(123, 4, 2, 4, 'Stefan', 'Spirovski', '1990-08-23', '0', '-1', '600'),
(124, 4, 11, 11, 'Adrián', 'Rus', '1996-03-18', '-1', '-1', '150'),
(125, 26, 7, 12, 'Lajos', 'Bertus', '1990-09-26', '-1', '0', '300'),
(126, 16, 2, 11, '', 'Leandro', '1982-03-19', '-1', '-1', '150'),
(127, 8, 4, 6, 'Dániel', 'Tőzsér', '1985-05-12', '-1', '0', '700'),
(128, 35, 6, 1, 'Predrag', 'Bosnjak', '1985-11-13', '-1', '-1', '300'),
(129, 14, 1, 10, 'Bálint', 'Gaál', '1991-07-14', '-1', '0', '250'),
(130, 17, 2, 12, 'Kornél', 'Csernik', '1998-07-02', '-1', '0', '100'),
(131, 16, 4, 10, 'Péter', 'Bíró', '1997-07-04', '-1', '0', '50'),
(132, 99, 4, 5, 'Bence', 'Sós', '1994-05-10', '-1', '0', '300'),
(133, 36, 5, 11, 'Botond', 'Baráth', '1992-04-21', '-1', '0', '350'),
(134, 98, 6, 12, 'Máté', 'Tóth', '1998-06-20', '-1', '0', '250'),
(135, 13, 1, 6, 'Zsombor', 'Berecz', '1995-12-13', '-1', '0', '800'),
(136, 3, 8, 1, 'Dominik', 'Fótyik', '1990-06-16', '-1', '0', '125'),
(137, 23, 10, 9, 'Dávid', 'Banai', '1994-05-09', '-1', '0', '150'),
(138, 16, 8, 2, 'István', 'Csirmaz', '1995-05-04', '-1', '0', '125'),
(139, 90, 1, 9, 'Dániel', 'Póser', '1990-01-12', '-1', '0', '100'),
(140, 5, 9, 11, 'Zoltán', 'Lipták', '1984-12-10', '-1', '0', '350'),
(141, 79, 6, 5, 'Péter', 'Halmosi', '1979-09-25', '-1', '0', '100'),
(142, 30, 11, 5, 'Aladár', 'Virág', '1983-02-19', '-1', '0', '50'),
(143, 77, 7, 8, 'Dávid', 'Kulcsár', '1988-02-25', '-1', '0', '250'),
(144, 33, 12, 4, 'József', 'Varga', '1988-06-06', '-1', '0', '500'),
(145, 49, 12, 3, 'Krisztián', 'Géresi', '1994-06-14', '-1', '0', '350'),
(146, 88, 11, 9, 'László', 'Horváth', '1988-02-23', '-1', '0', '150'),
(147, 70, 1, 13, 'Tamás', 'Kulcsár', '1982-10-13', '-1', '0', '150'),
(148, 26, 10, 12, 'Dániel', 'Nagy', '1991-03-15', '-1', '0', '300'),
(149, 1, 1, 9, 'Gergely', 'Nagy', '1994-05-27', '-1', '0', '300'),
(150, 13, 4, 1, 'Szabolcs', 'Barna', '1996-04-27', '-1', '0', '75'),
(151, 41, 8, 11, 'Attila', 'Szalai', '1998-01-20', '-1', '0', '100'),
(152, 12, 1, 10, 'Nikolaos', 'Vergos', '1996-01-13', '0', '-1', '250'),
(153, 13, 11, 6, 'Dávid', 'Sigér', '1990-11-30', '-1', '0', '175'),
(154, 7, 2, 11, 'Bence', 'Batik', '1993-11-08', '-1', '0', '300'),
(155, 23, 12, 11, 'Roland', 'Juhász', '1983-07-01', '-1', '0', '500'),
(156, 21, 8, 12, 'Jakub', 'Brasen', '1989-05-02', '0', '-1', '250'),
(157, 24, 3, 11, 'Patrik', 'Poór', '1993-11-25', '-1', '0', '350'),
(158, 10, 9, 10, 'Roland', 'Ugrai', '1992-11-13', '-1', '0', '400'),
(159, 26, 8, 1, 'Dániel', 'Vadnai', '1989-02-19', '-1', '0', '200'),
(160, 7, 5, 10, 'Davide', 'Lanzafame', '1987-02-09', '0', '-1', '1200'),
(161, 7, 6, 10, 'Patrik', 'Pinte', '1997-01-06', '0', '-1', '125'),
(162, 27, 10, 4, 'Bence', 'Pávkovics', '1997-03-27', '-1', '0', '200'),
(163, 99, 12, 3, 'Asmir', 'Suljic', '1991-09-11', '-1', '-1', '700'),
(164, 7, 11, 8, 'Yuri', 'Gabovda', '1989-05-06', '0', '-1', '300'),
(165, 11, 4, 5, 'János', 'Ferenczi', '1991-04-03', '-1', '0', '200'),
(166, 77, 5, 6, 'Gergő', 'Nagy', '1993-01-07', '-1', '0', '350'),
(167, 71, 3, 8, 'Attila', 'Osváth', '1995-12-10', '-1', '0', '300'),
(168, 33, 6, 11, 'Szilárd', 'Devecseri', '1990-02-13', '-1', '0', '175'),
(169, 32, 10, 9, 'Zoltán', 'Kovács', '1984-10-29', '-1', '0', '125'),
(170, 23, 6, 8, 'Szabolcs', 'Schimmer', '1984-02-24', '-1', '0', '125'),
(171, 49, 10, 2, 'Branko', 'Pauljevic', '1989-06-12', '-1', '-1', '200'),
(172, 23, 4, 13, 'Dániel', 'Bereczki', '1995-06-02', '-1', '0', '75'),
(173, 13, 8, 8, 'Pál', 'Lázár', '1988-03-11', '-1', '0', '150'),
(174, 23, 9, 1, 'Dávid', 'Forgács', '1995-09-29', '-1', '0', '100'),
(175, 8, 5, 8, 'Patrick', 'Ikenne-King', '1991-10-29', '0', '-1', '400'),
(176, 17, 11, 7, 'Máté', 'Schmid', '1996-07-08', '-1', '0', '50'),
(177, 44, 12, 10, 'Marko', 'Scepovic', '1991-05-23', '0', '-1', '1200'),
(178, 21, 12, 10, 'Ezekiel', 'Henty', '1993-05-13', '0', '-1', '1100'),
(179, 21, 4, 3, 'Kevin', 'Varga', '1996-03-30', '-1', '0', '250'),
(180, 4, 6, 1, 'Gábor', 'Jánvári', '1990-04-25', '-1', '0', '100'),
(181, 7, 12, 13, 'Danko', 'Lazovic', '1983-05-17', '0', '-1', '500'),
(182, 15, 3, 4, 'Patrick', 'Mevoungou', '1986-02-15', '0', '-1', '200'),
(183, 23, 8, 4, 'Paul', 'Keita', '1992-06-23', '0', '-1', '300'),
(184, 98, 5, 10, 'Bálint', 'Tömösvári', '1998-06-14', '-1', '0', '150'),
(185, 87, 7, 9, 'István', 'Verpecz', '1987-02-04', '-1', '0', '150'),
(186, 5, 2, 1, 'Marcos', 'Pedroso', '1993-10-04', '0', '-1', '900'),
(187, 20, 12, 11, 'Attila', 'Mocsi', '2000-05-29', '-1', '0', '100'),
(188, 99, 5, 9, 'Dávid', 'Gróf', '1989-04-17', '-1', '0', '350'),
(189, 14, 6, 7, 'Zoltán', 'Medgyes', '1995-07-23', '-1', '0', '175'),
(190, 5, 5, 10, 'Gergely', 'Bobál', '1995-08-31', '-1', '0', '150'),
(191, 21, 9, 4, 'Gergő', 'Kocsis', '1994-03-07', '-1', '0', '200'),
(192, 18, 12, 12, 'Bence', 'Szabó', '1998-01-16', '-1', '0', '150'),
(193, 6, 9, 2, 'Diego', 'Vela', '1991-11-27', '0', '-1', '350'),
(194, 24, 5, 4, 'Djordje', 'Kamber', '1983-11-20', '-1', '-1', '300'),
(195, 21, 5, 3, 'Ákos', 'Bíró', '1998-04-25', '-1', '0', '50'),
(196, 23, 3, 1, 'Csaba', 'Spandler', '1996-03-07', '-1', '0', '175'),
(197, 51, 2, 4, 'András', 'Csonka', '2000-05-01', '-1', '0', '75'),
(198, 8, 7, 6, 'Tamás', 'Kecskés', '1986-01-15', '-1', '0', '150'),
(199, 6, 10, 4, 'József', 'Windecker', '1992-12-02', '-1', '0', '400'),
(200, 8, 11, 10, 'Bachana', 'Arabuli', '1994-01-05', '0', '-1', '300'),
(201, 1, 8, 9, 'Dávid', 'Dombó', '1993-02-26', '-1', '0', '125'),
(202, 29, 11, 1, 'Áron', 'Schmid', '1998-09-29', '-1', '0', '50'),
(203, 27, 9, 10, 'Ákos', 'Szarka', '1990-11-24', '0', '-1', '300'),
(204, 6, 8, 1, 'Gergő', 'Gohér', '1987-06-16', '-1', '0', '200'),
(205, 1, 6, 9, 'Gábor', 'Király', '1976-04-01', '-1', '0', '100'),
(206, 2, 4, 11, 'Ákos', 'Kinyik', '1993-05-12', '-1', '0', '250'),
(207, 17, 1, 10, 'Evgen', 'Pavlov', '1991-03-12', '0', '-1', '250'),
(208, 19, 2, 4, 'Julian', 'Koch', '1990-11-11', '0', '-1', '300'),
(209, 21, 2, 8, 'Endre', 'Botka', '1994-04-25', '-1', '0', '450'),
(210, 10, 3, 13, 'András', 'Radó', '1993-09-09', '-1', '0', '350'),
(211, 98, 1, 6, 'Bálint', 'Vogyicska', '1998-02-27', '-1', '0', '250'),
(212, 6, 12, 1, 'András', 'Fejes', '1988-08-26', '-1', '0', '300'),
(213, 74, 9, 5, 'Patrik', 'Ternován', '1997-06-10', '-1', '0', '75'),
(214, 6, 1, 2, 'Donát', 'Szivacski', '1997-01-18', '-1', '0', '200'),
(215, 1, 12, 9, 'Tamás', 'Horváth', '1987-06-18', '-1', '0', '150'),
(216, 2, 10, 8, 'Kristóf', 'Szűcs', '1997-01-03', '-1', '0', '150'),
(217, 21, 7, 4, 'Kristóf', 'Papp', '1993-05-14', '-1', '0', '250'),
(218, 70, 6, 4, 'András', 'Jancsó', '1996-04-22', '-1', '0', '200'),
(219, 67, 11, 4, 'Irakli', 'Maisuradze', '1988-08-22', '0', '-1', '300'),
(220, 68, 3, 11, 'János', 'Hegedűs', '1996-10-04', '-1', '0', '200'),
(221, 4, 10, 11, 'Dávid', 'Kálnoki Kis', '1991-08-06', '-1', '0', '350'),
(222, 27, 3, 2, 'Liridon', 'Latifi', '1994-02-06', '0', '-1', '750'),
(223, 37, 2, 1, 'Janek', 'Sternberg', '1992-10-19', '0', '-1', '250'),
(224, 29, 7, 2, 'Tamás', 'Koltai', '1987-04-30', '-1', '0', '200'),
(225, 15, 1, 11, 'Máté', 'Czingráber', '1997-06-13', '-1', '0', '100'),
(226, 99, 9, 9, 'Botond', 'Antal', '1991-08-22', '-1', '0', '150'),
(227, 15, 11, 11, 'Bence', 'Jagodics', '1994-03-31', '-1', '0', '100'),
(228, 7, 8, 12, 'Bence', 'Tóth', '1989-07-22', '-1', '0', '200'),
(229, 7, 3, 10, 'Márk', 'Szécsi', '1994-05-22', '-1', '0', '150'),
(230, 17, 5, 10, 'Danilo', 'Erdei', '1986-11-12', '0', '-1', '300'),
(231, 11, 12, 8, 'Loïc', 'Nego', '1991-01-15', '0', '-1', '900'),
(232, 25, 10, 3, 'Remzifaik', 'Selmani', '1997-05-05', '0', '-1', '150'),
(233, 8, 6, 3, 'Funsho', 'Bamgboye', '1999-01-09', '0', '-1', '75'),
(234, 81, 9, 11, 'Patrik', 'Ivánka', '1998-08-25', '-1', '0', '50'),
(235, 41, 11, 7, 'Ferenc', 'Rácz', '1991-03-28', '-1', '0', '75'),
(236, 10, 1, 12, 'Mohamed', 'Remili', '1985-05-31', '-1', '0', '300'),
(237, 29, 10, 4, 'Gergő', 'Németh', '1999-03-03', '-1', '0', '50'),
(238, 3, 12, 11, '', 'Vinícius', '1990-02-21', '-1', '-1', '1000'),
(239, 29, 4, 4, 'Erik', 'Kusnyír', '2000-02-07', '-1', '0', '50'),
(240, 30, 12, 8, 'Roland', 'Szolnoki', '1992-01-21', '-1', '0', '350'),
(241, 22, 9, 9, 'Ivan', 'Rados', '1984-02-21', '-1', '-1', '250'),
(242, 20, 7, 11, 'Péter', 'Zachán', '1997-12-12', '-1', '0', '150'),
(243, 2, 11, 9, 'Krisztián', 'Pogacsics', '1985-10-17', '-1', '0', '175'),
(244, 17, 7, 12, 'Dénes', 'Szakály', '1988-03-15', '-1', '0', '200'),
(245, 35, 10, 9, 'Bence', 'Gundel-Takács', '1998-04-06', '-1', '0', '50'),
(246, 77, 12, 8, 'Bendegúz', 'Bolla', '1999-11-22', '-1', '0', '75'),
(247, 8, 10, 6, 'Benjámin', 'Cseke', '1994-07-22', '-1', '0', '250'),
(248, 19, 8, 3, 'Márk', 'Koszta', '1996-09-26', '-1', '0', '250'),
(249, 19, 4, 7, 'Justin', 'Mengolo', '1993-06-24', '0', '-1', '350'),
(250, 12, 4, 9, 'Ján', 'Novota', '1983-11-29', '0', '-1', '300'),
(251, 25, 5, 11, 'Ivan', 'Lovric', '1985-07-11', '-1', '-1', '250'),
(252, 38, 7, 4, 'Ádám', 'Hajdú', '1993-01-16', '-1', '0', '200'),
(253, 46, 7, 4, 'Ádám', 'Simon', '1990-03-30', '-1', '0', '275'),
(254, 19, 11, 3, 'Nemanja', 'Andric', '1987-06-13', '-1', '-1', '250'),
(255, 44, 6, 9, 'Márton', 'Gyurján', '1995-05-01', '-1', '0', '75'),
(256, 40, 2, 3, 'Moutari', 'Amadou', '1994-01-19', '0', '-1', '700'),
(257, 80, 8, 4, 'Máté', 'Köböl', '1992-04-14', '0', '-1', '75'),
(258, 21, 10, 2, 'Benjámin', 'Balázs', '1990-04-26', '-1', '0', '300'),
(259, 9, 10, 10, 'Patrik', 'Tischler', '1991-07-30', '-1', '0', '250'),
(260, 27, 2, 6, 'Fernando', 'Gorriarán', '1994-11-27', '0', '-1', '1100'),
(261, 1, 4, 9, 'Oleksandr', 'Nad', '1985-09-02', '-1', '-1', '200'),
(262, 42, 6, 9, 'Gergely', 'Lévay', '1993-08-15', '-1', '0', '50'),
(263, 48, 9, 11, 'Dejan', 'Karan', '1988-08-25', '0', '-1', '300'),
(264, 55, 3, 12, 'Péter', 'Szakály', '1986-08-17', '-1', '0', '400'),
(265, 11, 11, 12, 'Carlo', 'Erdei', '1996-03-22', '-1', '-1', '50'),
(266, 80, 3, 12, 'Márk', 'Madarász', '1995-11-24', '-1', '0', '200'),
(267, 15, 2, 12, 'Tamás', 'Hajnal', '1981-03-15', '-1', '0', '100'),
(268, 20, 4, 10, 'Tamás', 'Takács', '1991-02-20', '-1', '-1', '150'),
(269, 14, 9, 3, 'Zsolt', 'Óvári', '1997-03-29', '-1', '0', '250'),
(270, 28, 11, 8, 'Tibor', 'Bokros', '1988-08-28', '-1', '0', '100'),
(271, 51, 12, 9, 'András', 'Hársfalvi', '1996-11-12', '-1', '0', '50'),
(272, 33, 11, 1, 'Eke', 'Uzoma', '1989-08-11', '0', '-1', '175'),
(273, 25, 2, 11, 'Miha', 'Blazic', '1993-05-08', '0', '-1', '450'),
(274, 3, 4, 11, 'Csaba', 'Szatmári', '1994-06-14', '-1', '0', '350'),
(275, 32, 1, 11, 'Vit', 'Benes', '1988-08-12', '0', '-1', '400'),
(276, 8, 2, 7, 'Gergő', 'Lovrencsics', '1988-09-01', '-1', '0', '900'),
(277, 18, 10, 4, 'Bojan', 'Sankovic', '1993-11-21', '0', '-1', '250'),
(278, 77, 3, 10, 'Antonio', 'Perosevic', '1992-03-06', '0', '-1', '450'),
(279, 22, 1, 11, 'Jan', 'Simunek', '1987-02-20', '0', '-1', '250'),
(280, 22, 4, 9, 'Péter', 'Kovács', '2000-02-10', '-1', '0', '50'),
(281, 11, 5, 10, 'Kadima', 'Kabangu', '1993-06-15', '0', '-1', '125'),
(282, 28, 8, 5, 'László', 'Gyurcsó', '1992-06-05', '-1', '0', '50'),
(283, 26, 11, 4, 'Zsombor', 'Gyömbér', '1989-04-03', '-1', '0', '75'),
(284, 18, 7, 2, 'Roland', 'Sallai', '1997-05-22', '-1', '0', '100'),
(285, 3, 6, 2, 'Kornél', 'Csernik', '1994-02-25', '-1', '0', '250'),
(286, 11, 9, 3, 'Danko', 'Kovacevic', '1990-08-18', '-1', '0', '350'),
(287, 28, 3, 8, 'Dániel', 'Sallói', '1994-04-22', '-1', '0', '150'),
(288, 5, 12, 6, 'Zoltán', 'Németh', '1989-09-19', '0', '-1', '175'),
(289, 1, 5, 4, 'József', 'Kanta', '1992-04-25', '-1', '0', '50'),
(290, 1, 9, 9, 'János', 'Molnár', '1990-02-22', '-1', '0', '200'),
(291, 8, 9, 12, 'Kristóf', 'Szűcs', '1993-06-27', '-1', '0', '150'),
(292, 4, 12, 2, 'Márk', 'Kóta', '1989-08-15', '-1', '0', '200'),
(293, 42, 4, 8, 'Ádám', 'Kovács', '1998-11-04', '-1', '0', '50'),
(294, 7, 11, 6, 'Kristóf', 'Németh', '1990-08-07', '0', '-1', '75'),
(295, 77, 6, 9, 'Máté', 'Kádár', '1990-06-16', '-1', '0', '350'),
(296, 24, 9, 5, 'Bálint', 'Óvári', '1986-03-11', '0', '-1', '100'),
(297, 14, 8, 6, 'Donát', 'Simek', '1997-01-24', '-1', '0', '75'),
(298, 41, 4, 7, 'Péter', 'Nagy', '1994-11-05', '-1', '0', '250'),
(299, 8, 4, 3, 'Mátyás', 'Németh', '1997-08-12', '-1', '0', '250'),
(300, 47, 1, 1, 'Dominik', 'Csontos', '1989-06-27', '-1', '0', '125'),
(301, 25, 12, 2, 'László', 'Kuttor', '1992-09-09', '-1', '0', '175'),
(302, 32, 6, 5, 'Máté', 'Papp', '1994-11-30', '-1', '0', '150'),
(303, 52, 11, 9, 'Tamás', 'Bokros', '1995-01-10', '-1', '0', '75'),
(304, 9, 5, 2, 'János', 'Németh', '1994-03-29', '-1', '0', '200'),
(305, 29, 1, 12, 'László', 'Szabó', '1984-06-12', '-1', '0', '50'),
(306, 67, 1, 3, 'Márk', 'Radványi', '1995-05-11', '-1', '0', '100'),
(307, 3, 12, 7, 'Gergő', 'Bódi', '1992-03-05', '-1', '0', '50'),
(308, 15, 9, 4, 'Áron', 'Tischler', '1991-02-16', '-1', '0', '175'),
(309, 6, 2, 10, 'Péter', 'Fejes', '1991-03-12', '-1', '0', '150'),
(310, 7, 7, 12, 'László', 'Hangya', '1995-09-15', '-1', '0', '50'),
(311, 29, 2, 10, 'Gergely', 'Támas', '1990-07-26', '-1', '0', '350'),
(312, 8, 8, 2, 'György', 'Fenyvesi', '1991-12-25', '-1', '0', '300'),
(313, 11, 12, 1, 'Áron', 'Huszák', '1992-04-12', '-1', '0', '150'),
(314, 8, 9, 6, 'Ádám', 'Németh', '1988-06-28', '-1', '0', '100'),
(315, 18, 11, 6, 'Ákos', 'Zsidai', '1990-10-20', '-1', '0', '200'),
(316, 14, 3, 1, 'György', 'Óvári', '1997-03-01', '-1', '0', '300'),
(317, 1, 2, 4, 'Zoltán', 'Fehér', '1996-09-20', '-1', '0', '150'),
(318, 29, 5, 4, 'Dániel', 'Sipos', '1993-07-16', '-1', '0', '100'),
(319, 25, 5, 5, 'John', 'Doe', '1995-08-30', '1', '0', '400'),
(323, 231, 11, 4, 'Pityunemkiraly', 'Kis', '1997-01-23', '-1', '0', '150');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `poszt`
--

CREATE TABLE `poszt` (
  `id` int(11) NOT NULL,
  `nev` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `poszt`
--

INSERT INTO `poszt` (`id`, `nev`) VALUES
(1, 'bal oldali védő'),
(2, 'jobb oldali középpályás'),
(3, 'bal szélső'),
(4, 'védekező középpályás'),
(5, 'bal oldali középpályás'),
(6, 'belső középpályás'),
(7, 'jobb szélső'),
(8, 'jobb oldali védő'),
(9, 'kapus'),
(10, 'középcsatár'),
(11, 'középső védő'),
(12, 'támadó középpályás'),
(13, 'hátravont csatár'),
(14, 'jobboldali védő');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szemelyek`
--

CREATE TABLE `szemelyek` (
  `id` bigint(20) NOT NULL,
  `cim` varchar(255) DEFAULT NULL,
  `kor` int(11) NOT NULL,
  `nev` varchar(255) DEFAULT NULL,
  `suly` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `szemelyek`
--

INSERT INTO `szemelyek` (`id`, `cim`, `kor`, `nev`, `suly`) VALUES
(1, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(2, 'Szeged', 22, 'Nagy Ilona', 72.3),
(3, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(4, 'Szeged', 22, 'Nagy Ilona', 72.3),
(5, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(6, 'Szeged', 22, 'Nagy Ilona', 72.3),
(7, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(8, 'Szeged', 22, 'Nagy Ilona', 72.3),
(9, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(10, 'Szeged', 22, 'Nagy Ilona', 72.3),
(11, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(12, 'Szeged', 22, 'Nagy Ilona', 72.3),
(13, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(14, 'Szeged', 22, 'Nagy Ilona', 72.3),
(15, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(16, 'Szeged', 22, 'Nagy Ilona', 72.3),
(17, 'Kecskemet', 35, 'Kovacs Tibor', 77.5),
(18, 'Szeged', 22, 'Nagy Ilona', 72.3);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_nb`
--

CREATE TABLE `user_nb` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL DEFAULT 'ROLE_USER',
  `password_confirm` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `user_nb`
--

INSERT INTO `user_nb` (`id`, `username`, `password_hash`, `email`, `name`, `role`, `password_confirm`) VALUES
(26, 'kiralyv2', '$2a$10$5akLb3DLj/BnETZt3pdzxOBZRoEZ1eBZzZw.95Nz4EqftD97dtUHO', 'kiralyv@gmail.com', 'Király Vagyok', 'USER', 'teszt124'),
(27, 'teszelo', '$2a$10$hpzmVElLtHyJTwXTJTy4lO1be9w.R.q9N5HrrjKKQ71CRf0oKVp9q', 'tesztelekmost@gmail.com', 'teszt jani', 'USER', 'kiralyvagyok'),
(28, 'admin', '$2a$10$vVfmCUOZTjokEg67ZruQqOTtMfkGGGVNK0SKBTuJgq7gtdb2n.Dq.', 'admin@admin.com', 'admin', 'ROLE_ADMIN', 'admin123'),
(31, 'kalanyos123', '$2a$10$Jkvp71tKayuO7FjL6PKFUe24eFZEeZEIiJ0yMv12MPj8Sg2W6hbCK', 'kalany@gm.com', 'Kalányos József', 'USER', 'kalanyos123'),
(33, 'dadadsdadadaads', '$2a$10$DefWCMCEI3VB.AKzVS7re.XUs8UoXBmT6TkAeAHUG9WXnk0EI6JJS', 'asdadasasasd@gmail.com', 'adsadsada', 'USER', 'qwertzuiop'),
(34, 'asdkiralyasd', '$2a$10$ziyHoK7kWpQFVJ0Qzb2fIu1wVmNbbl7au.Rrx7wN1/QHB6D6W970u', 'asdlol@gmail.ro', 'domikiraly', 'USER', 'asdkiralyasd'),
(35, 'ayqayq', '$2a$10$gcfSlsF/aJ5dM47/W38LsuEeyECNj1RdrblDeLhMwKvtGOZm9RAz6', 'asidaufdga7a@gmail.com', 'domikiraly', 'USER', 'asdasdasd');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `klub`
--
ALTER TABLE `klub`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `labdarugo`
--
ALTER TABLE `labdarugo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `klubid` (`klubid`),
  ADD KEY `posztid` (`posztid`);

--
-- A tábla indexei `poszt`
--
ALTER TABLE `poszt`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `szemelyek`
--
ALTER TABLE `szemelyek`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user_nb`
--
ALTER TABLE `user_nb`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT a táblához `labdarugo`
--
ALTER TABLE `labdarugo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=324;

--
-- AUTO_INCREMENT a táblához `szemelyek`
--
ALTER TABLE `szemelyek`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT a táblához `user_nb`
--
ALTER TABLE `user_nb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `labdarugo`
--
ALTER TABLE `labdarugo`
  ADD CONSTRAINT `labdarugo_ibfk_1` FOREIGN KEY (`klubid`) REFERENCES `klub` (`id`),
  ADD CONSTRAINT `labdarugo_ibfk_2` FOREIGN KEY (`posztid`) REFERENCES `poszt` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
