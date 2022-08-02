-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 20, 2022 at 02:04 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gvente`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `codeArt` int(11) NOT NULL AUTO_INCREMENT,
  `nomArt` varchar(20) NOT NULL,
  `descArt` varchar(300) NOT NULL,
  `prixArt` float NOT NULL,
  `image` varchar(30) NOT NULL,
  PRIMARY KEY (`codeArt`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`codeArt`, `nomArt`, `descArt`, `prixArt`, `image`) VALUES
(1, 'SAUVAGE Spray 100 mL', 'A new masculine, uninhibited way to wear fragrance. A fragrance in an unbreakable bottle you can take anywhere to apply your fragrance at any time of day.', 300, 'Sauvage100ml'),
(2, 'NANO D-TOUCH POUCH', 'The nano D-Touch horizontal pouch is a modern and functional accessory. Crafted in black CD Diamond canvas, the design is enhanced by tonal grained calfskin details and a \'DIOR\' signature on the front. The zipped compartment will accommodate all cards and small essentials. ', 450, 'DiorNanoBlack'),
(3, 'B27 HIGH-TOP SNEAKER', 'The B27 high-top sneaker has become a House essential. Crafted in red, gray and white smooth calfskin, the style is adorned with beige and black Dior Oblique jacquard inserts on the sides.', 800, 'B27Red'),
(4, 'DIORBLACKSUIT XL S2U', 'The DiorBlackSuit XL S2U sunglasses have a contemporary rectangular shape, reimagined with a play on colors that combines a brown tortoiseshell-effect acetate with a translucent blue and green acetate collage. ', 680, 'DIORS2U'),
(5, 'EAU SAUVAGE EXTRÊME ', 'Eau Sauvage Extrême carries the original accord to the peak of excess and enriches it with a noble woody note that has enveloping accents and a bold contemporary character to intensify its masculinity.', 800, 'Sauvage1'),
(6, 'EAU SAUVAGE', 'François Demachy revisits the trail of Eau Sauvage in its Parfum interpretation with a refreshed aromatic power. As powerful and sensual as ever, the composition is invigorated with a unique freshness warmed by the Grasse sun.', 500, 'Sauvage0'),
(7, 'EAU SAUVAGE Spray', 'A lightly scented and alcohol-free formula for lasting, gentle protection.', 200, 'SauvageSpray');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `codeCmd` int(11) NOT NULL AUTO_INCREMENT,
  `client` varchar(20) NOT NULL,
  `codeArt` int(11) NOT NULL,
  `qteCmd` int(11) NOT NULL,
  `PrixTotal` int(11) NOT NULL,
  `dateCmd` datetime NOT NULL,
  PRIMARY KEY (`codeCmd`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`codeCmd`, `client`, `codeArt`, `qteCmd`, `PrixTotal`, `dateCmd`) VALUES
(4, 'Ayoub Elk', 2, 30, 13500, '2022-06-15 17:36:03');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`) VALUES
(1, 'AyoubElk', 'AyoubElk@gmail.com', '12345678'),
(2, 'AyoubMod', 'AyoubMod@gmail.com', '12345678');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
