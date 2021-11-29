-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 27, 2021 at 10:11 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CaritasAppDB`
--
CREATE DATABASE IF NOT EXISTS `CaritasAppDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `CaritasAppDB`;

-- --------------------------------------------------------

--
-- Table structure for table `ADM_CATALOGS`
--

CREATE TABLE `ADM_CATALOGS` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `llave` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ADM_CATALOGS_VALUES`
--

CREATE TABLE `ADM_CATALOGS_VALUES` (
  `id` int(11) NOT NULL,
  `id_catalog` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `OPE_BITACORA_PAGOS_DONATIVOS`
--

CREATE TABLE `OPE_BITACORA_PAGOS_DONATIVOS` (
  `id_bitacora` int(18) NOT NULL,
  `id_donativo` int(18) NOT NULL,
  `id_num_pago` int(18) DEFAULT NULL,
  `fecha_cobro` datetime DEFAULT NULL,
  `fecha_pago` datetime NOT NULL,
  `fecha_visita` datetime DEFAULT NULL,
  `id_forma_pago` int(18) DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `id_recibo` varchar(50) DEFAULT NULL,
  `estatus_pago_tmp` int(18) DEFAULT NULL,
  `comentarios` varchar(200) DEFAULT NULL,
  `fecha_confirmacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OPE_BITACORA_PAGOS_DONATIVOS`
--

INSERT INTO `OPE_BITACORA_PAGOS_DONATIVOS` (`id_bitacora`, `id_donativo`, `id_num_pago`, `fecha_cobro`, `fecha_pago`, `fecha_visita`, `id_forma_pago`, `importe`, `id_recibo`, `estatus_pago_tmp`, `comentarios`, `fecha_confirmacion`) VALUES
(1, 6, NULL, NULL, '2018-12-23 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 11, NULL, NULL, '2019-03-05 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 6, NULL, NULL, '2019-12-23 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 7, NULL, NULL, '2020-02-16 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 9, NULL, NULL, '2020-05-26 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 1, NULL, NULL, '2020-08-18 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, 2, NULL, NULL, '2020-08-30 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 3, NULL, NULL, '2020-10-05 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, 6, NULL, NULL, '2020-12-23 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, 12, NULL, NULL, '2021-03-13 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 4, NULL, NULL, '2021-04-15 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, 4, NULL, NULL, '2021-05-15 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, 5, NULL, NULL, '2021-05-17 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(14, 4, NULL, NULL, '2021-06-15 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(15, 4, NULL, NULL, '2021-07-15 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(16, 8, NULL, NULL, '2021-10-22 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(17, 8, NULL, NULL, '2021-10-29 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(18, 8, NULL, NULL, '2021-11-05 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(19, 8, NULL, NULL, '2021-11-12 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(20, 8, NULL, NULL, '2021-11-19 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(21, 10, NULL, NULL, '2021-11-20 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(22, 10, NULL, NULL, '2021-11-21 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(23, 10, NULL, NULL, '2021-11-22 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(24, 10, NULL, NULL, '2021-11-23 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(25, 10, NULL, NULL, '2021-11-24 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(26, 10, NULL, NULL, '2021-11-25 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(27, 8, NULL, NULL, '2021-11-26 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(28, 10, NULL, NULL, '2021-11-26 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `OPE_DONANTES`
--

CREATE TABLE `OPE_DONANTES` (
  `id_donante` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `a_paterno` varchar(100) NOT NULL,
  `a_materno` varchar(255) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `id_titulo` int(18) DEFAULT NULL,
  `id_tipo_donante` int(18) DEFAULT NULL,
  `razon_social` varchar(100) DEFAULT NULL,
  `fecha_nac` datetime DEFAULT NULL,
  `tel_casa` int(18) DEFAULT NULL,
  `tel_oficina` int(18) DEFAULT NULL,
  `tel_movil` int(18) DEFAULT NULL,
  `estatus_donante` int(18) DEFAULT NULL,
  `CURP` varchar(100) DEFAULT NULL,
  `ultimo_donativo` int(18) DEFAULT NULL,
  `id_genero` int(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OPE_DONANTES`
--

INSERT INTO `OPE_DONANTES` (`id_donante`, `email`, `contrasena`, `a_paterno`, `a_materno`, `nombre`, `id_titulo`, `id_tipo_donante`, `razon_social`, `fecha_nac`, `tel_casa`, `tel_oficina`, `tel_movil`, `estatus_donante`, `CURP`, `ultimo_donativo`, `id_genero`) VALUES
(1, 'fdoddoli@gmail.com', 'caritasfdoddoli', 'Doddoli', 'Lankenau', 'Fernando', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'cescamilla@gmail.com', 'caritascescamilla', 'Escamilla', 'Sada', 'Cristóbal Alberto', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'lidigoras@gmail.com', 'caritaslidigoras', 'Idígoras', 'Laitano', 'Lucas Eduardo', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'aguerra@gmail.com', 'caritasaguerra', 'Guerra', 'Ochoa', 'Andrés', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'jgomez@gmail.com', 'caritasjgomez', 'Gómez', 'Ortiz', 'Juan Manuel', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `OPE_DONATIVOS_DONANTE`
--

CREATE TABLE `OPE_DONATIVOS_DONANTE` (
  `id_donativo` int(11) NOT NULL,
  `id_donante` int(11) NOT NULL,
  `id_tipo_donativo` int(18) DEFAULT NULL,
  `id_forma_pago` int(18) DEFAULT NULL,
  `id_frecuencia` int(18) NOT NULL COMMENT '1 - Pago único\n2 - Diario\n3 - Semanal\n4 - Mensual\n5 - Anual',
  `num_frecuencia` int(18) DEFAULT NULL,
  `pago_unico` int(1) DEFAULT NULL,
  `importe` float NOT NULL,
  `id_estatus` int(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `OPE_DONATIVOS_DONANTE`
--

INSERT INTO `OPE_DONATIVOS_DONANTE` (`id_donativo`, `id_donante`, `id_tipo_donativo`, `id_forma_pago`, `id_frecuencia`, `num_frecuencia`, `pago_unico`, `importe`, `id_estatus`) VALUES
(1, 1, NULL, NULL, 1, NULL, NULL, 300, NULL),
(2, 1, NULL, NULL, 1, NULL, NULL, 120, NULL),
(3, 1, NULL, NULL, 1, NULL, NULL, 200, NULL),
(4, 1, NULL, NULL, 4, NULL, NULL, 500, NULL),
(5, 2, NULL, NULL, 1, NULL, NULL, 300, NULL),
(6, 2, NULL, NULL, 5, NULL, NULL, 3000, NULL),
(7, 3, NULL, NULL, 1, NULL, NULL, 150, NULL),
(8, 3, NULL, NULL, 3, NULL, NULL, 30, NULL),
(9, 4, NULL, NULL, 1, NULL, NULL, 95, NULL),
(10, 4, NULL, NULL, 2, NULL, NULL, 10, NULL),
(11, 5, NULL, NULL, 1, NULL, NULL, 400, NULL),
(12, 5, NULL, NULL, 1, NULL, NULL, 600, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ADM_CATALOGS`
--
ALTER TABLE `ADM_CATALOGS`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ADM_CATALOGS_VALUES`
--
ALTER TABLE `ADM_CATALOGS_VALUES`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_catalog` (`id_catalog`);

--
-- Indexes for table `OPE_BITACORA_PAGOS_DONATIVOS`
--
ALTER TABLE `OPE_BITACORA_PAGOS_DONATIVOS`
  ADD PRIMARY KEY (`id_bitacora`),
  ADD KEY `id_donativo` (`id_donativo`);

--
-- Indexes for table `OPE_DONANTES`
--
ALTER TABLE `OPE_DONANTES`
  ADD PRIMARY KEY (`id_donante`),
  ADD KEY `id_titulo` (`id_titulo`);

--
-- Indexes for table `OPE_DONATIVOS_DONANTE`
--
ALTER TABLE `OPE_DONATIVOS_DONANTE`
  ADD PRIMARY KEY (`id_donativo`),
  ADD KEY `id_donante` (`id_donante`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ADM_CATALOGS`
--
ALTER TABLE `ADM_CATALOGS`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ADM_CATALOGS_VALUES`
--
ALTER TABLE `ADM_CATALOGS_VALUES`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `OPE_BITACORA_PAGOS_DONATIVOS`
--
ALTER TABLE `OPE_BITACORA_PAGOS_DONATIVOS`
  MODIFY `id_bitacora` int(18) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `OPE_DONANTES`
--
ALTER TABLE `OPE_DONANTES`
  MODIFY `id_donante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `OPE_DONATIVOS_DONANTE`
--
ALTER TABLE `OPE_DONATIVOS_DONANTE`
  MODIFY `id_donativo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ADM_CATALOGS_VALUES`
--
ALTER TABLE `ADM_CATALOGS_VALUES`
  ADD CONSTRAINT `adm_catalogs_values_ibfk_1` FOREIGN KEY (`id_catalog`) REFERENCES `ADM_CATALOGS` (`id`);

--
-- Constraints for table `OPE_BITACORA_PAGOS_DONATIVOS`
--
ALTER TABLE `OPE_BITACORA_PAGOS_DONATIVOS`
  ADD CONSTRAINT `ope_bitacora_pagos_donativos_ibfk_1` FOREIGN KEY (`id_donativo`) REFERENCES `OPE_DONATIVOS_DONANTE` (`id_donativo`);

--
-- Constraints for table `OPE_DONANTES`
--
ALTER TABLE `OPE_DONANTES`
  ADD CONSTRAINT `ope_donantes_ibfk_1` FOREIGN KEY (`id_titulo`) REFERENCES `ADM_CATALOGS_VALUES` (`id`);

--
-- Constraints for table `OPE_DONATIVOS_DONANTE`
--
ALTER TABLE `OPE_DONATIVOS_DONANTE`
  ADD CONSTRAINT `ope_donativos_donante_ibfk_1` FOREIGN KEY (`id_donante`) REFERENCES `OPE_DONANTES` (`id_donante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
