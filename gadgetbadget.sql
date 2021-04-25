-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 11:40 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `bpaymenttb`
--

CREATE TABLE `bpaymenttb` (
  `InvoiceID` int(11) NOT NULL,
  `CusID` varchar(45) DEFAULT NULL,
  `ProductID` varchar(45) DEFAULT NULL,
  `ProductName` varchar(45) DEFAULT NULL,
  `ServiceCharge` double DEFAULT NULL,
  `Quantity` double DEFAULT NULL,
  `TotalPayment` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bpaymenttb`
--

INSERT INTO `bpaymenttb` (`InvoiceID`, `CusID`, `ProductID`, `ProductName`, `ServiceCharge`, `Quantity`, `TotalPayment`) VALUES
(111, 'C_005', 'P_004', 'Complete Projects', 3200, 2, 6400);

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
  `Buyer ID` int(11) NOT NULL,
  `Buyer Code` varchar(10) NOT NULL,
  `Buyer Name` varchar(20) NOT NULL,
  `Buyer Email` varchar(30) NOT NULL,
  `Buyer Contact Number` int(10) NOT NULL,
  `Buyer Address` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`Buyer ID`, `Buyer Code`, `Buyer Name`, `Buyer Email`, `Buyer Contact Number`, `Buyer Address`) VALUES
(3, 'C123', 'Sunil Perera', 'sunil123@gmail.com', 773466629, 'Court Road,Kandy');

-- --------------------------------------------------------

--
-- Table structure for table `complete_project`
--

CREATE TABLE `complete_project` (
  `proj_id` int(11) NOT NULL,
  `rid` varchar(11) NOT NULL,
  `proj_code` varchar(10) NOT NULL,
  `proj_name` varchar(30) NOT NULL,
  `proj_desc` varchar(300) NOT NULL,
  `skills_required` varchar(200) NOT NULL,
  `payment_method` varchar(100) NOT NULL,
  `estimate_budget` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `complete_project`
--

INSERT INTO `complete_project` (`proj_id`, `rid`, `proj_code`, `proj_name`, `proj_desc`, `skills_required`, `payment_method`, `estimate_budget`) VALUES
(1, 'U_112', 'P_001', 'Clothing', 'Project which contain details about cloths', 'HTML,CSS,JS,PHP', 'Fixed price', 25000),
(2, 'U_125', 'P_003', 'Lights', 'Details about lights', 'HTML,CSS,Node JS,React', 'cash', 41500);

-- --------------------------------------------------------

--
-- Table structure for table `fund_proposal_t`
--

CREATE TABLE `fund_proposal_t` (
  `fundID` int(11) NOT NULL,
  `fundName` varchar(50) DEFAULT NULL,
  `projRequrment` varchar(50) DEFAULT NULL,
  `companyName` varchar(50) DEFAULT NULL,
  `typeOfProject` varchar(100) DEFAULT NULL,
  `ExceptedDate` varchar(50) DEFAULT NULL,
  `AmountOfFunds` double(5,3) DEFAULT NULL,
  `paymentDesc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fund_proposal_t`
--

INSERT INTO `fund_proposal_t` (`fundID`, `fundName`, `projRequrment`, `companyName`, `typeOfProject`, `ExceptedDate`, `AmountOfFunds`, `paymentDesc`) VALUES
(1, 'Samantha D Silva', 'New services', 'Qwsz', 'technical', '2021/07/11', 99.999, 'step by step');

-- --------------------------------------------------------

--
-- Table structure for table `innovetive_project`
--

CREATE TABLE `innovetive_project` (
  `proj_id` int(11) NOT NULL,
  `rid` varchar(20) NOT NULL,
  `proj_code` varchar(10) NOT NULL,
  `proj_name` varchar(30) NOT NULL,
  `proj_desc` varchar(300) NOT NULL,
  `skills_required` varchar(200) NOT NULL,
  `estimate_fund` double NOT NULL,
  `no_of_funds_made` int(100) NOT NULL,
  `amount_to_fund` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `innovetive_project`
--

INSERT INTO `innovetive_project` (`proj_id`, `rid`, `proj_code`, `proj_name`, `proj_desc`, `skills_required`, `estimate_fund`, `no_of_funds_made`, `amount_to_fund`) VALUES
(1, 'U_100', 'I_001', 'Retail', 'This is a project about clothing', 'HTML,CSS,JS,PHP,MYSQL', 12500, 2, 5500);

-- --------------------------------------------------------

--
-- Table structure for table `paymenttb`
--

CREATE TABLE `paymenttb` (
  `InvoiceID` int(11) NOT NULL,
  `InvoiceType` varchar(45) DEFAULT NULL,
  `CusID` varchar(45) DEFAULT NULL,
  `ProductID` varchar(45) DEFAULT NULL,
  `ProductName` varchar(45) DEFAULT NULL,
  `GBFee` double DEFAULT NULL,
  `ServiceCharge` double DEFAULT NULL,
  `OtherCharge` double DEFAULT NULL,
  `VAT` double DEFAULT NULL,
  `TotalPayment` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paymenttb`
--

INSERT INTO `paymenttb` (`InvoiceID`, `InvoiceType`, `CusID`, `ProductID`, `ProductName`, `GBFee`, `ServiceCharge`, `OtherCharge`, `VAT`, `TotalPayment`) VALUES
(111, 'Technical', 'C_005', 'P_004', 'Complete Projects', 1500, 3200, 1000, 500, 6200);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uID` int(11) NOT NULL,
  `userCode` varchar(5) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `gender_M_F` varchar(1) NOT NULL,
  `email` varchar(40) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `typeBuyer_T_F` varchar(1) NOT NULL,
  `typeResearcher_T_F` varchar(1) NOT NULL,
  `typeFundingBodies_T_F` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uID`, `userCode`, `firstName`, `lastName`, `dob`, `gender_M_F`, `email`, `address`, `phone`, `password`, `typeBuyer_T_F`, `typeResearcher_T_F`, `typeFundingBodies_T_F`) VALUES
(1, '111', 'Dulmi', 'Ramesha', '1998-12-13', 'F', 'dulmi@gmail.com', 'fdggh', '0122121342', '123#1', 'T', 'T', 'T'),
(3, '232', 'Vajira', 'Kavindi', '1998-12-12', 'F', 'vjira@gmail.com', 'Galle', '0711212121', '111@1', 'F', 'F', 'T'),
(5, '345', 'Iresh', 'Perera', '1998-02-13', 'M', 'iresh@gmail.com', 'Mathara', '0112343452', '432@1', 'F', 'T', 'F'),
(6, '543', 'Eshani', 'Wijethunga', '1998-03-28', 'F', 'eshani@gmail.com', 'Mathara', '0123232345', '543@1', 'F', 'F', 'T'),
(7, '321', 'Chathura', 'Amarathunga', '1997-06-20', 'M', 'chathura@gmail.com', 'Homagama', '0112343452', '422@1', 'T', 'F', 'F'),
(8, '654', 'Piumi', 'Kulathunga', '1997-05-23', 'F', 'piumi@ggmail.com', 'Gampaha', '0339843234', '23$3', 'T', 'T', 'T');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bpaymenttb`
--
ALTER TABLE `bpaymenttb`
  ADD PRIMARY KEY (`InvoiceID`);

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`Buyer ID`);

--
-- Indexes for table `complete_project`
--
ALTER TABLE `complete_project`
  ADD PRIMARY KEY (`proj_id`);

--
-- Indexes for table `fund_proposal_t`
--
ALTER TABLE `fund_proposal_t`
  ADD PRIMARY KEY (`fundID`);

--
-- Indexes for table `innovetive_project`
--
ALTER TABLE `innovetive_project`
  ADD PRIMARY KEY (`proj_id`);

--
-- Indexes for table `paymenttb`
--
ALTER TABLE `paymenttb`
  ADD PRIMARY KEY (`InvoiceID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bpaymenttb`
--
ALTER TABLE `bpaymenttb`
  MODIFY `InvoiceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `buyer`
--
ALTER TABLE `buyer`
  MODIFY `Buyer ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `complete_project`
--
ALTER TABLE `complete_project`
  MODIFY `proj_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `innovetive_project`
--
ALTER TABLE `innovetive_project`
  MODIFY `proj_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `paymenttb`
--
ALTER TABLE `paymenttb`
  MODIFY `InvoiceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
