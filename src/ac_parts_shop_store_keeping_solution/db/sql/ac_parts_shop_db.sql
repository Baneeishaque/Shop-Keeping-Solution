-- phpMyAdmin SQL Dump
-- version 4.6.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 19, 2016 at 06:32 PM
-- Server version: 5.7.13-log
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ac_parts_shop_db`
--
CREATE DATABASE IF NOT EXISTS `ac_parts_shop_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ac_parts_shop_db`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `customer_address` varchar(50) NOT NULL,
  `customer_email_id` varchar(50) NOT NULL,
  `customer_mobile_no` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_name`, `customer_address`, `customer_email_id`, `customer_mobile_no`) VALUES
(1, 'Customer1', 'Customer1 Address', 'Customer1 email', '9895'),
(2, 'C2', 'c2a', 'c2e', '6589');

-- --------------------------------------------------------

--
-- Table structure for table `expense`
--

CREATE TABLE `expense` (
  `serial_number` int(11) NOT NULL,
  `expense_date` date NOT NULL,
  `expense_description` varchar(250) NOT NULL,
  `expense_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `expense`
--

INSERT INTO `expense` (`serial_number`, `expense_date`, `expense_description`, `expense_amount`) VALUES
(1, '2016-09-18', 'aaaa', '125.0000');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_bill`
--

CREATE TABLE `purchase_bill` (
  `purchase_bill_number` int(11) NOT NULL,
  `purchase_bill_date` date NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `purchase_bill_amount` decimal(13,4) NOT NULL,
  `purchase_bill_type` varchar(50) NOT NULL,
  `purchase_bill_payed_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchase_bill`
--

INSERT INTO `purchase_bill` (`purchase_bill_number`, `purchase_bill_date`, `supplier_id`, `purchase_bill_amount`, `purchase_bill_type`, `purchase_bill_payed_amount`) VALUES
(1, '2016-09-16', 1, '50.0000', 'Credit', '40.0000'),
(2, '2016-09-16', 2, '5.0000', 'Credit', '2.0000'),
(3, '2016-09-18', 2, '500.0000', 'Credit', '450.0000'),
(4, '2016-09-18', 1, '200.0000', 'Ready', '200.0000'),
(5, '2016-09-18', 2, '260.0000', 'Ready', '260.0000');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_bill_credit`
--

CREATE TABLE `purchase_bill_credit` (
  `serial_number` int(11) NOT NULL,
  `purchase_bill_number` int(11) NOT NULL,
  `purchase_bill_credit_pay_date` date NOT NULL,
  `purchase_bill_credit_payed_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchase_bill_credit`
--

INSERT INTO `purchase_bill_credit` (`serial_number`, `purchase_bill_number`, `purchase_bill_credit_pay_date`, `purchase_bill_credit_payed_amount`) VALUES
(1, 1, '2016-09-16', '2.0000'),
(2, 1, '2016-09-16', '2.0000'),
(3, 1, '2016-09-16', '5.0000'),
(4, 2, '2016-09-18', '1.0000'),
(5, 3, '2016-09-18', '48.0000'),
(6, 2, '2016-09-18', '1.0000'),
(7, 3, '2016-09-18', '2.0000');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_item`
--

CREATE TABLE `purchase_item` (
  `serial_number` int(11) NOT NULL,
  `purchase_bill_number` int(11) NOT NULL,
  `purchase_item_id` int(11) NOT NULL,
  `purchase_item_quantity` int(11) NOT NULL,
  `purchase_item_price` decimal(13,4) NOT NULL,
  `purchase_item_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchase_item`
--

INSERT INTO `purchase_item` (`serial_number`, `purchase_bill_number`, `purchase_item_id`, `purchase_item_quantity`, `purchase_item_price`, `purchase_item_amount`) VALUES
(1, 1, 1, 10, '5.0000', '50.0000'),
(2, 2, 2, 5, '1.0000', '5.0000'),
(3, 3, 2, 100, '5.0000', '500.0000'),
(4, 4, 2, 50, '4.0000', '200.0000'),
(5, 5, 2, 52, '5.0000', '260.0000');

-- --------------------------------------------------------

--
-- Table structure for table `sales_bill`
--

CREATE TABLE `sales_bill` (
  `sales_bill_number` int(11) NOT NULL,
  `sales_bill_date` varchar(50) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `sales_bill_amount` decimal(13,4) NOT NULL,
  `sales_bill_type` varchar(50) NOT NULL,
  `sales_bill_payed_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sales_bill`
--

INSERT INTO `sales_bill` (`sales_bill_number`, `sales_bill_date`, `customer_id`, `sales_bill_amount`, `sales_bill_type`, `sales_bill_payed_amount`) VALUES
(1, '18-09-2016', 1, '50.0000', 'Ready', '50.0000'),
(2, '18-09-2016', 1, '50.0000', 'Credit', '20.0000'),
(3, '18-09-2016', 2, '40.0000', 'Credit', '30.0000'),
(4, '18-09-2016', 2, '60.0000', 'Credit', '15.0000');

-- --------------------------------------------------------

--
-- Table structure for table `sales_bill_credit`
--

CREATE TABLE `sales_bill_credit` (
  `serial_number` int(11) NOT NULL,
  `sales_bill_number` int(11) NOT NULL,
  `sales_bill_credit_pay_date` varchar(50) NOT NULL,
  `sales_bill_credit_payed_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sales_bill_credit`
--

INSERT INTO `sales_bill_credit` (`serial_number`, `sales_bill_number`, `sales_bill_credit_pay_date`, `sales_bill_credit_payed_amount`) VALUES
(1, 4, '18-09-2016', '5.0000'),
(2, 4, '18-09-2016', '20.0000');

-- --------------------------------------------------------

--
-- Table structure for table `sales_item`
--

CREATE TABLE `sales_item` (
  `serial_number` int(11) NOT NULL,
  `sales_bill_number` int(11) NOT NULL,
  `sales_item_id` int(11) NOT NULL,
  `sales_item_quantity` int(11) NOT NULL,
  `sales_item_price` decimal(13,4) NOT NULL,
  `sales_item_amount` decimal(13,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sales_item`
--

INSERT INTO `sales_item` (`serial_number`, `sales_bill_number`, `sales_item_id`, `sales_item_quantity`, `sales_item_price`, `sales_item_amount`) VALUES
(1, 1, 1, 10, '5.0000', '50.0000'),
(2, 2, 1, 10, '5.0000', '50.0000'),
(3, 3, 1, 10, '4.0000', '40.0000'),
(4, 4, 2, 10, '6.0000', '60.0000');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `stock_item_id` int(11) NOT NULL,
  `stock_item_name` varchar(50) NOT NULL,
  `stock_item_quantity` int(11) NOT NULL,
  `stock_item_selling_price` decimal(13,4) NOT NULL,
  `stock_item_remarks` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`stock_item_id`, `stock_item_name`, `stock_item_quantity`, `stock_item_selling_price`, `stock_item_remarks`) VALUES
(1, 'Item1', 380, '5.0000', 'Initial Stock-p1-s1-s2-s3'),
(2, 'Item2', 697, '4.0000', 'Initial Stock-p2-p3-p4-s4-p5');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(50) NOT NULL,
  `supplier_address` varchar(50) NOT NULL,
  `supplier_email_id` varchar(50) NOT NULL,
  `supplier_mobile_no` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_email_id`, `supplier_mobile_no`) VALUES
(1, 'Supplier1', 'aaa', 'vbb', '34'),
(2, 'Supplier2', 'a3', 'bbb', '45');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `expense`
--
ALTER TABLE `expense`
  ADD PRIMARY KEY (`serial_number`);

--
-- Indexes for table `purchase_bill`
--
ALTER TABLE `purchase_bill`
  ADD PRIMARY KEY (`purchase_bill_number`);

--
-- Indexes for table `purchase_bill_credit`
--
ALTER TABLE `purchase_bill_credit`
  ADD PRIMARY KEY (`serial_number`);

--
-- Indexes for table `purchase_item`
--
ALTER TABLE `purchase_item`
  ADD PRIMARY KEY (`serial_number`);

--
-- Indexes for table `sales_bill`
--
ALTER TABLE `sales_bill`
  ADD PRIMARY KEY (`sales_bill_number`);

--
-- Indexes for table `sales_bill_credit`
--
ALTER TABLE `sales_bill_credit`
  ADD PRIMARY KEY (`serial_number`);

--
-- Indexes for table `sales_item`
--
ALTER TABLE `sales_item`
  ADD PRIMARY KEY (`serial_number`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`stock_item_id`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`supplier_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
