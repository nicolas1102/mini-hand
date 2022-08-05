-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 05, 2022 at 09:52 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minihanddb`
--

-- --------------------------------------------------------

--
-- Table structure for table `detalles`
--

CREATE TABLE `detalles` (
  `codigo_detalle` int(11) NOT NULL,
  `descripcion_detalle` varchar(30) NOT NULL,
  `valor_detalle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detalles`
--

INSERT INTO `detalles` (`codigo_detalle`, `descripcion_detalle`, `valor_detalle`) VALUES
(1, 'pension', 1200000),
(2, 'constancias de estudios', 7550),
(3, 'certificado de notas', 6000),
(4, 'carnet estudiantil', 15550),
(5, 'cursos vacacionales', 35000),
(6, 'derechos de grado', 35500),
(7, 'duplicado del carnet estudiant', 15550);

-- --------------------------------------------------------

--
-- Table structure for table `estudiantes`
--

CREATE TABLE `estudiantes` (
  `codigo_estudiante` int(11) NOT NULL,
  `codigo_persona` int(11) NOT NULL,
  `codigo_grado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `estudiantes`
--

INSERT INTO `estudiantes` (`codigo_estudiante`, `codigo_persona`, `codigo_grado`) VALUES
(1, 1, 1),
(2, 3, 1),
(3, 2, 12),
(4, 4, 9),
(5, 5, 8),
(6, 6, 8),
(7, 7, 11),
(8, 8, 7),
(9, 9, 8),
(10, 10, 6),
(11, 11, 4),
(12, 12, 2),
(13, 13, 1);

-- --------------------------------------------------------

--
-- Table structure for table `grados`
--

CREATE TABLE `grados` (
  `codigo_grado` int(11) NOT NULL,
  `descripcion_grado` varchar(30) NOT NULL,
  `jornada_grado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grados`
--

INSERT INTO `grados` (`codigo_grado`, `descripcion_grado`, `jornada_grado`) VALUES
(1, '1001', 'mañana'),
(2, '1002', 'mañana'),
(3, '1003', 'mañana'),
(4, '1004', 'tarde'),
(5, '1005', 'tarde'),
(6, '1006', 'tarde'),
(7, '1101', 'mañana'),
(8, '1102', 'mañana'),
(9, '1103', 'mañana'),
(10, '1104', 'tarde'),
(11, '1105', 'tarde'),
(12, '1106', 'tarde');

-- --------------------------------------------------------

--
-- Table structure for table `meses`
--

CREATE TABLE `meses` (
  `codigo_mes` int(11) NOT NULL,
  `nombre_mes` varchar(30) NOT NULL,
  `año_mes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `meses`
--

INSERT INTO `meses` (`codigo_mes`, `nombre_mes`, `año_mes`) VALUES
(1, 'noviembre', 2020),
(2, 'diciembre', 2020),
(3, 'enero', 2021),
(4, 'febrero', 2021),
(5, 'marzo', 2021),
(6, 'abril', 2021),
(7, 'mayo', 2021),
(8, 'junio', 2021),
(9, 'julio', 2021),
(10, 'agosto', 2021),
(11, 'septiembre', 2021),
(12, 'octubre', 2021),
(13, 'noviembre', 2021),
(14, 'diciembre', 2021),
(15, 'enero', 2022),
(16, 'febrero', 2022),
(17, 'marzo', 2022),
(18, 'abril', 2022),
(19, 'mayo', 2022),
(20, 'junio', 2022),
(21, 'julio', 2022),
(22, 'agosto', 2022);

-- --------------------------------------------------------

--
-- Table structure for table `pagos`
--

CREATE TABLE `pagos` (
  `codigo_pago` int(11) NOT NULL,
  `estado_pago` varchar(30) NOT NULL,
  `codigo_estudiante` int(11) NOT NULL,
  `codigo_mes` int(11) NOT NULL,
  `codigo_detalle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pagos`
--

INSERT INTO `pagos` (`codigo_pago`, `estado_pago`, `codigo_estudiante`, `codigo_mes`, `codigo_detalle`) VALUES
(1, 'true', 1, 19, 1),
(2, 'false', 2, 20, 1),
(3, 'true', 1, 21, 1),
(4, 'false', 2, 19, 1),
(5, 'false', 2, 20, 1),
(6, 'false', 2, 21, 1),
(7, 'true', 3, 19, 1),
(8, 'true', 3, 20, 1),
(9, 'false', 3, 21, 1),
(10, 'false', 4, 20, 2),
(11, 'true', 5, 19, 1),
(12, 'true', 5, 20, 3),
(13, 'false', 13, 19, 1),
(14, 'false', 9, 22, 4),
(15, 'false', 9, 22, 5),
(16, 'true', 8, 17, 1),
(17, 'true', 6, 19, 2),
(18, 'false', 8, 18, 3),
(19, 'false', 1, 18, 1);

-- --------------------------------------------------------

--
-- Table structure for table `personas`
--

CREATE TABLE `personas` (
  `codigo_persona` int(11) NOT NULL,
  `nombre_persona` varchar(30) NOT NULL,
  `edad_persona` int(11) NOT NULL,
  `año_vinculacion_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personas`
--

INSERT INTO `personas` (`codigo_persona`, `nombre_persona`, `edad_persona`, `año_vinculacion_persona`) VALUES
(1, 'Felipe', 19, 2018),
(2, 'Miguel', 27, 2021),
(3, 'Nicolas', 20, 2022),
(4, 'Daniel', 20, 2018),
(5, 'Alejandro', 20, 2022),
(6, 'Gabriela', 21, 2022),
(7, 'Juana', 21, 2018),
(8, 'David', 19, 2021),
(9, 'Peter', 20, 2020),
(10, 'Esteban', 20, 2021),
(11, 'Vanessa', 21, 2021),
(12, 'Alejandra', 19, 2021),
(13, 'Laura', 20, 2020);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`codigo_detalle`);

--
-- Indexes for table `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`codigo_estudiante`),
  ADD UNIQUE KEY `codigo_persona_2` (`codigo_persona`),
  ADD KEY `codigo_persona` (`codigo_persona`),
  ADD KEY `codigo_grado` (`codigo_grado`);

--
-- Indexes for table `grados`
--
ALTER TABLE `grados`
  ADD PRIMARY KEY (`codigo_grado`);

--
-- Indexes for table `meses`
--
ALTER TABLE `meses`
  ADD PRIMARY KEY (`codigo_mes`);

--
-- Indexes for table `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`codigo_pago`),
  ADD KEY `estudiante_codigo` (`codigo_estudiante`),
  ADD KEY `codigo_mes` (`codigo_mes`),
  ADD KEY `codigo_detalle` (`codigo_detalle`);

--
-- Indexes for table `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`codigo_persona`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`codigo_persona`) REFERENCES `personas` (`codigo_persona`) ON UPDATE CASCADE,
  ADD CONSTRAINT `estudiantes_ibfk_2` FOREIGN KEY (`codigo_grado`) REFERENCES `grados` (`codigo_grado`) ON UPDATE CASCADE;

--
-- Constraints for table `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`codigo_estudiante`) REFERENCES `estudiantes` (`codigo_estudiante`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pagos_ibfk_2` FOREIGN KEY (`codigo_detalle`) REFERENCES `detalles` (`codigo_detalle`) ON UPDATE CASCADE,
  ADD CONSTRAINT `pagos_ibfk_3` FOREIGN KEY (`codigo_mes`) REFERENCES `meses` (`codigo_mes`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
