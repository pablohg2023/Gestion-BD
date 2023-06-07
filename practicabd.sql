-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 07-06-2023 a las 08:22:39
-- Versión del servidor: 5.7.40
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practicabd`
--

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `modificacionProducto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificacionProducto` (IN `producto_id` INT, OUT `total` INT)   BEGIN
		select count(*) into total
		from respaldo_productos where producto_id = id_producto && tipo_operacion = "update" && precio_antiguo != precio_nuevo;
		set total = 0;
    select total;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`) VALUES
(1, 'Manuel'),
(2, 'Alejandro'),
(3, 'Sofia'),
(4, 'Raul'),
(5, 'Pablo'),
(6, 'miguel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_producto`
--

DROP TABLE IF EXISTS `cliente_producto`;
CREATE TABLE IF NOT EXISTS `cliente_producto` (
  `cliente_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente_producto`
--

INSERT INTO `cliente_producto` (`cliente_id`, `producto_id`) VALUES
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 4),
(5, 10),
(1, 5),
(1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`) VALUES
(1, 'ordenador'),
(3, 'alfombra'),
(4, 'boligrafo'),
(5, 'maleta'),
(6, 'play'),
(7, 'mascara'),
(8, 'cascos'),
(9, 'monitor'),
(10, 'libro');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `t1t2_t2`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `t1t2_t2`;
CREATE TABLE IF NOT EXISTS `t1t2_t2` (
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `t1_t1t2`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `t1_t1t2`;
CREATE TABLE IF NOT EXISTS `t1_t1t2` (
);

-- --------------------------------------------------------

--
-- Estructura para la vista `t1t2_t2`
--
DROP TABLE IF EXISTS `t1t2_t2`;

DROP VIEW IF EXISTS `t1t2_t2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`pablo`@`localhost` SQL SECURITY DEFINER VIEW `t1t2_t2`  AS SELECT `producto`.`id` AS `id`, `producto`.`nombre` AS `nombre`, `producto_cliente`.`producto_id` AS `producto_id`, `producto_cliente`.`cliente_id` AS `cliente_id` FROM (`producto` join `producto_cliente` on((`producto_cliente`.`producto_id` = `producto`.`id`))) ORDER BY `producto`.`id` ASC  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `t1_t1t2`
--
DROP TABLE IF EXISTS `t1_t1t2`;

DROP VIEW IF EXISTS `t1_t1t2`;
CREATE ALGORITHM=UNDEFINED DEFINER=`pablo`@`localhost` SQL SECURITY DEFINER VIEW `t1_t1t2`  AS SELECT `cliente`.`id` AS `id`, `cliente`.`nombre` AS `nombre`, `producto_cliente`.`producto_id` AS `producto_id`, `producto_cliente`.`cliente_id` AS `cliente_id` FROM (`cliente` join `producto_cliente` on((`cliente`.`id` = `producto_cliente`.`cliente_id`)))  ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
