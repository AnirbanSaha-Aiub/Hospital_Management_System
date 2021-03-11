-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2019 at 07:40 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital_internal_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountant`
--

CREATE TABLE `accountant` (
  `AC_Id` varchar(10) NOT NULL,
  `AC_Name` varchar(20) NOT NULL,
  `PhoneNo` int(14) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountant`
--

INSERT INTO `accountant` (`AC_Id`, `AC_Name`, `PhoneNo`, `Password`) VALUES
('ac001', 'Bijoy Sarkar', 1758694211, 'ac001'),
('ac002', 'Bristy Khan', 1759631247, 'ac002');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `A_Id` varchar(10) NOT NULL,
  `A_Name` varchar(20) NOT NULL,
  `PhoneNo` int(14) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`A_Id`, `A_Name`, `PhoneNo`, `Password`) VALUES
('a001', 'Anirban Saha', 1776304248, 'a001'),
('a002', 'Asif khan', 1759631255, 'a002');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `D_Id` varchar(10) NOT NULL,
  `D_Name` varchar(20) NOT NULL,
  `Qualification` varchar(10) NOT NULL,
  `PhoneNo` int(14) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`D_Id`, `D_Name`, `Qualification`, `PhoneNo`, `Password`) VALUES
('d001', 'Dr. Bishowjit', 'MBBS, FCPS', 1758621119, 'd001'),
('d002', 'Dr. Anik Saha', 'MBBS', 1849504244, 'd002'),
('d003', 'Dr. Zubaer Hossain', 'MBBS', 1746786660, 'd003');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `P_Id` varchar(10) NOT NULL,
  `P_Name` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Blood_Group` varchar(5) NOT NULL,
  `PhoneNO` int(14) NOT NULL,
  `Record` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`P_Id`, `P_Name`, `DOB`, `Blood_Group`, `PhoneNO`, `Record`) VALUES
('p001', 'Pranto Datta', '1998-08-12', 'B+', 1776521485, 'Fever, Headache '),
('p002', 'Mithila', '1987-10-19', 'B-', 1775696312, 'Fever, Headache');

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

CREATE TABLE `receptionist` (
  `R_Id` varchar(10) NOT NULL,
  `R_Name` varchar(20) NOT NULL,
  `PhoneNo` int(14) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`R_Id`, `R_Name`, `PhoneNo`, `Password`) VALUES
('r001', 'Nishi Hossain', 1758694586, 'r001'),
('r002', 'Aishe Bisswas', 1759634547, 'r002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountant`
--
ALTER TABLE `accountant`
  ADD PRIMARY KEY (`AC_Id`),
  ADD UNIQUE KEY `PhoneNo` (`PhoneNo`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`A_Id`),
  ADD UNIQUE KEY `PhoneNo` (`PhoneNo`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`D_Id`),
  ADD UNIQUE KEY `PhoneNo` (`PhoneNo`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`P_Id`),
  ADD UNIQUE KEY `PhoneNO` (`PhoneNO`);

--
-- Indexes for table `receptionist`
--
ALTER TABLE `receptionist`
  ADD PRIMARY KEY (`R_Id`),
  ADD UNIQUE KEY `PhoneNo` (`PhoneNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
