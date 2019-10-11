-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2017 a las 13:45:02
-- Versión del servidor: 5.6.11
-- Versión de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `administracionpm`
--
CREATE DATABASE IF NOT EXISTS `administracionpm` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `administracionpm`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fecha_alta` date NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `apellido`, `direccion`, `telefono`, `email`, `fecha_alta`) VALUES
(1, 'Juan', 'Perez', 'Olazabal 5014 6° A', 12345678, 'juanperez@hotmail.com', '1998-03-20'),
(2, 'Francisco', 'Moreira', 'Mendoza 5342 2° B', 12345678, 'francisco@yahoo.com.ar', '2002-03-20'),
(3, 'Fernando ', 'Molina', 'Catamarca 2577 1° E', 45232314, 'fermolina@gmail.com', '1995-03-06'),
(4, 'Susana', 'Sanchez', 'San Luis 1722 10° A', 47184467, 'susanasanchez@hotmail.com', '2009-03-06'),
(5, 'Roberto ', 'Carminati', 'Monroe 5254 3° C', 45224318, 'roberto@hotmail.com', '2000-06-01'),
(6, 'Valeria', 'Frontini', 'Santa Fe 3569 11° D', 48535671, 'valeriafrontini@gmail.com', '2007-08-20'),
(7, 'Luciana', 'Vecchia', 'La Pampa 2589 3° A', 59612345, 'lucianavecchia@gmail.com', '2012-03-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepedido`
--

CREATE TABLE IF NOT EXISTS `detallepedido` (
  `id_pedido` int(11) NOT NULL,
  `codigo_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_pedido`,`codigo_producto`),
  KEY `codigo_producto` (`codigo_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detallepedido`
--

INSERT INTO `detallepedido` (`id_pedido`, `codigo_producto`, `cantidad`) VALUES
(1, 1001, 2),
(1, 1002, 5),
(1, 1010, 3),
(1, 1011, 2),
(1, 1014, 1),
(2, 1001, 2),
(2, 1002, 1),
(2, 1003, 2),
(2, 1004, 4),
(3, 1003, 2),
(3, 1004, 3),
(3, 1005, 6),
(3, 1007, 1),
(4, 1001, 2),
(4, 1013, 2),
(5, 1001, 20),
(6, 1012, 2),
(6, 1013, 2),
(6, 1014, 5),
(7, 1001, 2),
(7, 1003, 1),
(8, 1015, 5),
(9, 1002, 10),
(10, 1008, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE IF NOT EXISTS `pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `descuento` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id_pedido`, `descripcion`, `id_cliente`, `fecha_compra`, `fecha_entrega`, `descuento`) VALUES
(1, 'www', 1, '2012-03-13', '2012-03-20', '0.15'),
(2, 'xxx', 2, '2012-03-08', '2012-03-19', '0.10'),
(3, 'aaa', 1, '2012-03-15', '2012-03-22', '0.00'),
(4, 'ddd', 1, '2012-03-20', '2012-03-27', '0.05'),
(5, 'aaa', 2, '2012-03-10', '2012-03-15', '0.00'),
(6, 'ddd', 2, '2012-03-13', '2012-03-26', '0.00'),
(7, 'aaa', 3, '2012-03-07', '2012-03-12', '0.00'),
(8, 'aaa', 4, '2012-03-12', '2012-03-19', '0.00'),
(9, 'aaa', 5, '2012-03-13', '2012-03-21', '0.05'),
(10, 'aaa', 6, '2012-03-13', '2012-03-23', '0.05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `codigo` int(30) NOT NULL,
  `producto` varchar(30) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `producto`, `descripcion`, `precio`) VALUES
(1001, 'Lampara Xenon B54', 'Las lamparas de xenon generan hasta 4 veces mas luz que las lamparas halogenas comunes. El consumo de energia es de 35watt, casi la mitad del consumo de las lamparas halogenas comunes. ', '234.00'),
(1002, 'Lampara Xenon B16', 'El funcionamiento mediante la descarga electrica aumenta la cantidad de horas utiles de la lampara, ya que los golpes y las vibraciones no las da?an, como sucede con las lamparas halogenas.', '254.00'),
(1003, 'Lampara Xenon 300SD', 'El funcionamiento mediante la descarga electrica aumenta la cantidad de horas utiles de la lampara, ya que los golpes y las vibraciones no las da?an, como sucede con las lamparas halogenas.', '344.00'),
(1004, 'Lampara Xenon B45SD', 'No hace falta realizar ninguna modificacion electrica en el auto, tampoco hace falta cortar cables. Hay kits para cada modelo y marca de autos. Los kits consumen casi la mitad de electricidad que las lamparas halogenas comunes.', '256.40'),
(1005, 'Lampara Xenon 28SE', 'Este modelo de lampara genera un ahorro de combustible.', '310.50'),
(1006, 'Lampara Xenon B345', 'En caso de ser necesario se pueden colocar lamparas halogenas de forma inmediata, los kits no modifican la instalacion electrica original del auto. ', '340.00'),
(1007, 'Lampara Xenon 34SE', 'En caso de ser necesario se pueden colocar lamparas halogenas de forma inmediata, los kits no modifican la instalacion electrica original del auto. ', '322.50'),
(1008, 'Lampara Xenon B90', 'Las lamparas de xenon generan menos calor que las lamparas halogenas, todas las opticas soportan las lamparas de xenon.', '349.90'),
(1009, 'Lampara Xenon 43SE', 'Las lamparas de xenon generan menos calor que las lamparas halogenas, todas las opticas soportan las lamparas de xenon.', '230.90'),
(1010, 'Lampara Xenon 98DE', 'Las lamparas de xenon generan menos calor que las lamparas halogenas, todas las opticas soportan las lamparas de xenon.', '110.00'),
(1011, 'Lampara Xenon 65SD', 'Los balastros son de menor tama?o y son digitales. Los balastros no generan ningun tipo de interferencia en las computadoras de los autos ni en las radios. ', '430.00'),
(1012, 'Lampara Xenon B44', 'Los balastros son de menor tama?o y son digitales. Los balastros no generan ningun tipo de interferencia en las computadoras de los autos ni en las radios.', '235.60'),
(1013, 'Lampara Xenon 3D4G', 'Las lamparas de 6000k generan el mismo color que los autos de alta gama que vienen con lamparas de xenon de serie. A medida que aumenta la temperatura de las lamparas la potencia lum?nica disminuye. ', '260.60'),
(1014, 'Lampara Xenon 109FD', 'Las lamparas de 6000k generan el mismo color que los autos de alta gama que vienen con lamparas de xenon de serie. A medida que aumenta la temperatura de las lamparas la potencia lum?nica disminuye. ', '456.60'),
(1015, 'Lampara Xenon 90FT', 'El funcionamiento mediante la descarga electrica aumenta la cantidad de horas utiles de la lampara, ya que los golpes y las vibraciones no las da?an, como sucede con las lamparas halogenas.', '456.60'),
(1016, 'Lampara Xenon FG34', 'El funcionamiento mediante la descarga electrica aumenta la cantidad de horas utiles de la lampara, ya que los golpes y las vibraciones no las da?an, como sucede con las lamparas halogenas.', '190.00');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detallepedido`
--
ALTER TABLE `detallepedido`
  ADD CONSTRAINT `detallepedido_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`),
  ADD CONSTRAINT `detallepedido_ibfk_2` FOREIGN KEY (`codigo_producto`) REFERENCES `productos` (`codigo`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
