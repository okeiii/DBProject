-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2018 at 09:34 AM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `courier`
--

-- --------------------------------------------------------

--
-- Table structure for table `moneyexpress`
--

DROP TABLE IF EXISTS `moneyexpress`;
CREATE TABLE IF NOT EXISTS `moneyexpress` (
  `trackingNo` int(11) NOT NULL,
  `senderID` int(11) NOT NULL,
  `receiverID` int(11) NOT NULL,
  `amount` int(11) NOT NULL DEFAULT '50',
  `status` varchar(20) DEFAULT 'NOT YET RECEIVED'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moneyexpress`
--

INSERT INTO `moneyexpress` (`trackingNo`, `senderID`, `receiverID`, `amount`, `status`) VALUES
(123456789, 1001001, 110110, 50, 'NOT YET RECEIVED'),
(123456788, 1001010, 110101, 50, 'NOT YET RECEIVED'),
(120056779, 1111001, 110010, 50, 'NOT YET RECEIVED');

-- --------------------------------------------------------

--
-- Table structure for table `receiverdetails`
--

DROP TABLE IF EXISTS `receiverdetails`;
CREATE TABLE IF NOT EXISTS `receiverdetails` (
  `receiverID` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `contactNo` varchar(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receiverdetails`
--

INSERT INTO `receiverdetails` (`receiverID`, `firstName`, `lastName`, `address`, `contactNo`) VALUES
(110101, 'Johnny', 'Depp', '9336 Civic Center Drive Beverly Hills, CA', '09775632222'),
(110101, 'Chris', 'Hemsworth', '2001 Byron Bay, AU', '09175643325'),
(110110, 'Alexis', 'Knapp', 'Avonmore, Pennsylvania, USA', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `senderdetails`
--

DROP TABLE IF EXISTS `senderdetails`;
CREATE TABLE IF NOT EXISTS `senderdetails` (
  `senderID` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `contactNo` varchar(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `senderdetails`
--

INSERT INTO `senderdetails` (`senderID`, `firstName`, `lastName`, `address`, `contactNo`) VALUES
(1111001, 'Gian', 'Mauricio', '787 Aurora Hill Baguio City, PH', '09885776678'),
(1001001, 'Keilly', 'Panis', '198 Marcos Highway Baguio City, PH', '09129908563'),
(1001010, 'Cal', 'Bryan', '33 Upper Junction Green Valley Marcos Highway, PH', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE IF NOT EXISTS `transactions` (
  `trackingNo` int(11) NOT NULL,
  `senderID` int(11) NOT NULL,
  `receiverID` int(11) NOT NULL,
  `transactionDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `courierFee` int(11) NOT NULL DEFAULT '50'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`trackingNo`, `senderID`, `receiverID`, `transactionDate`, `courierFee`) VALUES
(123456789, 1001001, 110110, '2018-07-04 17:31:22', 50),
(123456788, 1001010, 110101, '2018-07-04 17:31:58', 50),
(120056779, 1111001, 110010, '2018-07-04 17:32:31', 50);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
