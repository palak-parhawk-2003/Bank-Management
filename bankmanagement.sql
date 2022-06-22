-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2022 at 06:55 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `acc_no` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(256) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `email` varchar(250) DEFAULT NULL,
  `address` varchar(300) NOT NULL,
  `balance` double NOT NULL,
  `password` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`acc_no`, `name`, `phone_number`, `email`, `address`, `balance`, `password`, `created_at`) VALUES
(100, 'Subhankar Dutta', '6209265435', 'subhankar0810@gmail.com', 'd.71 bagunnaar, baridhi', 4000, 'Sub@2019', '2022-06-21 07:06:50'),
(101, 'Aman', '53421234', 'ama223@fgmail.com', 'adaasfef', 3000, 'Sub@1m14', '2022-06-21 07:07:36'),
(102, 'Palak', '5355323455', 'palak@123gmai.com', 'This is my address', 5000, 'Palak@123', '2022-06-21 07:15:41');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `sender` bigint(20) UNSIGNED NOT NULL,
  `reciver` bigint(20) UNSIGNED NOT NULL,
  `amount` int(11) NOT NULL,
  `descripton` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`acc_no`),
  ADD UNIQUE KEY `phone_number` (`phone_number`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reciver` (`reciver`),
  ADD KEY `sender` (`sender`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `acc_no` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`reciver`) REFERENCES `bank` (`acc_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`sender`) REFERENCES `bank` (`acc_no`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
