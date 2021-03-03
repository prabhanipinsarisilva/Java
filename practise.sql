-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2020 at 09:57 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `practise`
--

-- --------------------------------------------------------

--
-- Table structure for table `item1`
--

CREATE TABLE `item1` (
  `item_code` varchar(5) DEFAULT NULL,
  `item_name` varchar(20) DEFAULT NULL,
  `rate` int(12) DEFAULT NULL,
  `stock_in_hand` int(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item1`
--

INSERT INTO `item1` (`item_code`, `item_name`, `rate`, `stock_in_hand`) VALUES
('3', 'buns', 50, 25),
('235', 'polo sambola', 44, -6),
('122', 'chocolate', 200, 23);

-- --------------------------------------------------------

--
-- Table structure for table `item2`
--

CREATE TABLE `item2` (
  `customer_code` int(5) DEFAULT NULL,
  `customer_name` varchar(25) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `pin_no` int(6) DEFAULT NULL,
  `phone_no` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item2`
--

INSERT INTO `item2` (`customer_code`, `customer_name`, `address`, `city`, `state`, `pin_no`, `phone_no`) VALUES
(1, 'sss', 'sss', 'sss', 'sss', 323, 324324);

-- --------------------------------------------------------

--
-- Table structure for table `item3`
--

CREATE TABLE `item3` (
  `billno` int(6) DEFAULT NULL,
  `customer_type` varchar(8) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `item_code` int(16) DEFAULT NULL,
  `item_name` varchar(15) DEFAULT NULL,
  `quantity` int(7) DEFAULT NULL,
  `amount` float(13,2) DEFAULT NULL,
  `discount` float(13,2) DEFAULT NULL,
  `netamount` float(13,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item3`
--

INSERT INTO `item3` (`billno`, `customer_type`, `name`, `date`, `item_code`, `item_name`, `quantity`, `amount`, `discount`, `netamount`) VALUES
(1, 'Customer', 'DSD', '1990-01-01', 123, 'dzxc', 2, 0.00, 0.00, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `item4`
--

CREATE TABLE `item4` (
  `supplier_code` varchar(5) DEFAULT NULL,
  `supplier_name` varchar(25) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(25) DEFAULT NULL,
  `pin_no` int(6) DEFAULT NULL,
  `phone_no` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item4`
--

INSERT INTO `item4` (`supplier_code`, `supplier_name`, `address`, `city`, `state`, `pin_no`, `phone_no`) VALUES
('1', 'dhanushka', '100 basline colombo 3', 'colombo', 'western', 1234, 7723456),
('C0002', 'kasun', '133 padukka debarawawa', 'homagama', 'waestern', 1234, 772030380);

-- --------------------------------------------------------

--
-- Table structure for table `item5`
--

CREATE TABLE `item5` (
  `employee_code` int(15) DEFAULT 1,
  `employee_name` varchar(25) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `pin_no` int(6) DEFAULT NULL,
  `phone_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item5`
--

INSERT INTO `item5` (`employee_code`, `employee_name`, `address`, `city`, `state`, `pin_no`, `phone_no`) VALUES
(1, 'sad', 'asds', 'asdad', 'asds', 2322, 231321),
(23, 'ssdsf', 'sdfsdfsd', 'sdfdsf', 'sfdsdf', 3242, 234324324);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `name` varchar(150) NOT NULL,
  `phone_no` int(10) NOT NULL,
  `id` int(6) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`name`, `phone_no`, `id`, `password`) VALUES
('dhanushka', 775645361, 1234, '1234'),
('sadun', 772030280, 12, '12'),
('1', 1, 1, '1'),
('2', 2, 2, '2'),
('pasindu', 772039234, 2345, '1234'),
('kamal', 772030380, 2435, '1234'),
('dhanushka', 772030380, 9623456, '1234'),
('kasun', 772030380, 233445677, '123');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `cashier` varchar(255) NOT NULL,
  `pay` int(11) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `date`, `subtotal`, `cashier`, `pay`, `balance`) VALUES
(37, '2019/01/29', 375000, '', 400000, 25000),
(38, '2019/01/29', 1410000, 'kobi', 2000000, 590000),
(39, '2019/01/31', 300000, '', 300000, 0),
(40, '2019/02/14', 195000, '', 200000, 5000),
(41, '2019/02/14', 105000, '', 200000, 95000),
(42, '2019/02/14', 30000, '', 40000, 10000),
(43, '2019/04/21', 60000, '', 700000, 640000),
(44, '2019/04/21', 90000, '', 2333, -87667),
(45, '2019/04/21', 180000, '', 2222, -177778),
(46, '2019/04/21', 90000, '', 3333, -86667),
(47, '2019/04/22', 105000, '', 2333, -102667),
(48, '2019/04/22', 435000, '', 333, -434667),
(49, '2019/04/22', 180000, '', 2222, -177778),
(50, '2019/04/22', 90000, '', 333, -89667),
(51, '2019/07/01', 150000, 'kobi', 200000, 50000),
(52, '2020/11/18', 3456, '', 33333, -29877),
(53, '2020/11/18', 100, '', 100, 0),
(54, '2020/11/18', 150, '', 290, -140);

-- --------------------------------------------------------

--
-- Table structure for table `sales_product`
--

CREATE TABLE `sales_product` (
  `id` int(11) NOT NULL,
  `sales_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `sell_price` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_product`
--

INSERT INTO `sales_product` (`id`, `sales_id`, `product_id`, `sell_price`, `qty`, `total`) VALUES
(56, 37, 111, 30000, 10, 300000),
(57, 37, 222, 15000, 5, 75000),
(58, 38, 222, 15000, 2, 30000),
(59, 38, 111, 30000, 2, 60000),
(60, 38, 333, 40000, 33, 1320000),
(61, 39, 111, 30000, 10, 300000),
(62, 40, 222, 15000, 3, 45000),
(63, 40, 111, 30000, 5, 150000),
(64, 41, 222, 15000, 3, 45000),
(65, 41, 111, 30000, 2, 60000),
(66, 42, 222, 15000, 2, 30000),
(67, 43, 111, 30000, 2, 60000),
(68, 44, 111, 30000, 3, 90000),
(69, 45, 111, 30000, 2, 60000),
(70, 45, 222, 15000, 2, 30000),
(71, 45, 111, 30000, 3, 90000),
(72, 46, 222, 15000, 2, 30000),
(73, 46, 111, 30000, 2, 60000),
(74, 47, 111, 30000, 2, 60000),
(75, 47, 222, 15000, 3, 45000),
(76, 48, 222, 15000, 22, 330000),
(77, 48, 111, 30000, 2, 60000),
(78, 48, 222, 15000, 3, 45000),
(79, 49, 222, 15000, 2, 30000),
(80, 49, 333, 40000, 3, 120000),
(81, 49, 222, 15000, 2, 30000),
(82, 50, 222, 15000, 2, 30000),
(83, 50, 111, 30000, 2, 60000),
(84, 51, 222, 15000, 2, 30000),
(85, 51, 333, 40000, 3, 120000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales_product`
--
ALTER TABLE `sales_product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `sales_product`
--
ALTER TABLE `sales_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
