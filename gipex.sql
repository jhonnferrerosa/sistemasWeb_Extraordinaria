-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2022 a las 13:16:11
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gipex`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `cif` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe`
--

CREATE TABLE `informe` (
  `id` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `nota` int(11) NOT NULL,
  `alumno_usuario` varchar(50) NOT NULL,
  `tutor_usuario` varchar(50) DEFAULT NULL,
  `comentarios` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listaasignados`
--

CREATE TABLE `listaasignados` (
  `alumno_usuario` varchar(50) NOT NULL,
  `oferta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `numPlazas` int(11) NOT NULL,
  `empresa_cif` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preferencia`
--

CREATE TABLE `preferencia` (
  `posicionPreferencia` int(11) NOT NULL,
  `alumnno_usuario` varchar(50) NOT NULL,
  `oferta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsable`
--

CREATE TABLE `responsable` (
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutor`
--

CREATE TABLE `tutor` (
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `empresa_cif` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`cif`);

--
-- Indices de la tabla `informe`
--
ALTER TABLE `informe`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `alumno_usuario_2` (`alumno_usuario`),
  ADD KEY `alumno_usuario` (`alumno_usuario`,`tutor_usuario`),
  ADD KEY `tutor_usuario` (`tutor_usuario`);

--
-- Indices de la tabla `listaasignados`
--
ALTER TABLE `listaasignados`
  ADD PRIMARY KEY (`alumno_usuario`),
  ADD UNIQUE KEY `oferta_id` (`oferta_id`),
  ADD UNIQUE KEY `oferta_id_4` (`oferta_id`),
  ADD UNIQUE KEY `oferta_id_6` (`oferta_id`),
  ADD KEY `oferta_id_2` (`oferta_id`),
  ADD KEY `oferta_id_3` (`oferta_id`),
  ADD KEY `oferta_id_5` (`oferta_id`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empresa_cif` (`empresa_cif`);

--
-- Indices de la tabla `preferencia`
--
ALTER TABLE `preferencia`
  ADD PRIMARY KEY (`posicionPreferencia`,`alumnno_usuario`),
  ADD KEY `oferta_id` (`oferta_id`),
  ADD KEY `alumnno_usuario` (`alumnno_usuario`);

--
-- Indices de la tabla `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`usuario`),
  ADD KEY `empresa_cif` (`empresa_cif`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `informe`
--
ALTER TABLE `informe`
  ADD CONSTRAINT `informe_ibfk_1` FOREIGN KEY (`tutor_usuario`) REFERENCES `tutor` (`usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `informe_ibfk_2` FOREIGN KEY (`alumno_usuario`) REFERENCES `alumno` (`usuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `listaasignados`
--
ALTER TABLE `listaasignados`
  ADD CONSTRAINT `listaasignados_ibfk_1` FOREIGN KEY (`alumno_usuario`) REFERENCES `alumno` (`usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `listaasignados_ibfk_2` FOREIGN KEY (`oferta_id`) REFERENCES `oferta` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `oferta_ibfk_1` FOREIGN KEY (`empresa_cif`) REFERENCES `empresa` (`cif`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `preferencia`
--
ALTER TABLE `preferencia`
  ADD CONSTRAINT `preferencia_ibfk_1` FOREIGN KEY (`alumnno_usuario`) REFERENCES `alumno` (`usuario`) ON UPDATE CASCADE,
  ADD CONSTRAINT `preferencia_ibfk_2` FOREIGN KEY (`oferta_id`) REFERENCES `oferta` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`empresa_cif`) REFERENCES `empresa` (`cif`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
