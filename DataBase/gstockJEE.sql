-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 20, 2022 at 02:05 AM
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
-- Database: `gstock`
--

-- --------------------------------------------------------

--
-- Table structure for table `article_stock`
--

DROP TABLE IF EXISTS `article_stock`;
CREATE TABLE IF NOT EXISTS `article_stock` (
  `codeArt` int(11) NOT NULL AUTO_INCREMENT,
  `nomArt` varchar(30) NOT NULL,
  `descArt` varchar(350) NOT NULL,
  `prixArt` int(11) NOT NULL,
  `qteArt` int(11) NOT NULL,
  PRIMARY KEY (`codeArt`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article_stock`
--

INSERT INTO `article_stock` (`codeArt`, `nomArt`, `descArt`, `prixArt`, `qteArt`) VALUES
(1, 'SAUVAGE Spray 100 mL', 'A new masculine, uninhibited way to wear fragrance. A fragrance in an unbreakable bottle you can take anywhere to apply your fragrance at any time of day.', 300, 0),
(2, 'NANO D-TOUCH POUCH', 'The nano D-Touch horizontal pouch is a modern and functional accessory. Crafted in black CD Diamond canvas, the design is enhanced by tonal grained calfskin details and a \'DIOR\' signature on the front. The zipped compartment will accommodate all cards and small essentials. ', 450, 20),
(3, 'B27 HIGH-TOP SNEAKER', 'The B27 high-top sneaker has become a House essential. Crafted in red, gray and white smooth calfskin, the style is adorned with beige and black Dior Oblique jacquard inserts on the sides.', 800, 0),
(4, 'DIORBLACKSUIT XL S2U', 'The DiorBlackSuit XL S2U sunglasses have a contemporary rectangular shape, reimagined with a play on colors that combines a brown tortoiseshell-effect acetate with a translucent blue and green acetate collage. ', 680, 30),
(5, 'EAU SAUVAGE EXTRÊME\r\n', 'Eau Sauvage Extrême carries the original accord to the peak of excess and enriches it with a noble woody note that has enveloping accents and a bold contemporary character to intensify its masculinity.', 800, 70),
(6, 'EAU SAUVAGE', 'François Demachy revisits the trail of Eau Sauvage in its Parfum interpretation with a refreshed aromatic power. As powerful and sensual as ever, the composition is invigorated with a unique freshness warmed by the Grasse sun.', 500, 70),
(7, 'EAU SAUVAGE\r\nSpray', 'A lightly scented and alcohol-free formula for lasting, gentle protection.', 200, 50);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
