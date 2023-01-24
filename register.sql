-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 09, 2022 at 12:45 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students`
--

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `Student_ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Index_Num` varchar(100) NOT NULL,
  `Course` varchar(100) NOT NULL,
  `Mobile` varchar(100) NOT NULL,
  `Hall` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`Student_ID`, `Name`, `Index_Num`, `Course`, `Mobile`, `Hall`) VALUES
(1, 'Aholo Joseph', 'BS424100720', 'Java', '0242543015', 'The Point'),
(2, 'Apau Samuel', 'BS423526272', 'UI/UX', '0249228325', 'KT'),
(3, 'Venunnye Wilbert', 'BS423663733', 'Pearl', '0254899522', 'Chambers'),
(4, 'Dede Davis', 'BS436756736', 'Cyber_Security', '02458965602', 'JK'),
(5, 'Washington Precious', 'BS245637363', 'Python', '02147852021', 'Hilda');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`Student_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `Student_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
