-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 04-09-2023 a las 23:16:55
-- Versión del servidor: 8.0.27
-- Versión de PHP: 7.4.26

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- START TRANSACTION;
-- SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sf_replay_sport`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--
-- CREATE TABLE IF NOT EXISTS `categoria` (
--   `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--   `categoria_nombre` varchar(45) NOT NULL,
--   PRIMARY KEY (`id`)
-- );
/*
DELETE FROM `categoria` WHERE `id` IN ('1','2','3');
INSERT INTO `categoria`(`id`, `categoria_nombre`)VALUES
(1, 'Futbol'),
(2, 'Basquet'),
(3, 'Voley');
*/
-- INSERT INTO `categoria` (`id`, `categoria_nombre`)
--   SELECT '1','Futbol'
--   WHERE NOT EXISTS(SELECT 1 FROM `categoria` WHERE `id` = '1')
-- UNION
--   SELECT '2','Basquet'
-- WHERE NOT EXISTS(SELECT 1 FROM `categoria` WHERE `id` = '2')
-- UNION
--   SELECT '3','Voley'
--   WHERE NOT EXISTS(SELECT 1 FROM `categoria` WHERE `id` = '3');
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_videos`
--

/*
DROP TABLE IF EXISTS `categoria_videos`;
CREATE TABLE IF NOT EXISTS `categoria_videos` (
  `categoria_id` bigint NOT NULL,
  `videos_id` bigint NOT NULL,
  UNIQUE KEY `UK_ggd0djxi9q0a1l32jshmb48pt` (`videos_id`),
  KEY `FKb3aa17hkinmh7dmqe70ev3o0q` (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

/*
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(60) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cdmw5hxlfj78uf4997i3qyyw5` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/
--
-- Volcado de datos para la tabla `usuarios`
--
-- DELETE FROM `usuarios` WHERE `id` IN ('1', '2');

-- INSERT INTO `usuarios` (`id`, `apellido`, `correo`, `nombre`) 
-- VALUES
-- (1, 'Gauna', 'niwel123@hotmail.com', 'zNiwel'),
-- (2, 'Albornoz', 'brandon435@gmail.com', 'Brock');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videos`
--

/*
DROP TABLE IF EXISTS `videos`;
CREATE TABLE IF NOT EXISTS `videos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categoria_nombre` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_our5j9a2bluhtjnhlo9gfoc7s` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/
--
-- Volcado de datos para la tabla `videos`
--
-- DELETE FROM `videos` WHERE `id` = '1';

-- INSERT INTO `videos` (`id`, `categoria`, `name`, `url`) 
-- VALUES 
-- (1, 'Futbol', 'video1', 'C:/Users/lucas/OneDrive/Desktop/programacion/SF ReplaySport con spingboot/videos/Argentina_vs_Brasil.mp4');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria_videos`
--
-- ALTER TABLE `categoria_videos`
--   ADD CONSTRAINT `FKb3aa17hkinmh7dmqe70ev3o0q` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
--   ADD CONSTRAINT `FKkfbtpigr3k2b26irux0kkk01m` FOREIGN KEY (`videos_id`) REFERENCES `videos` (`id`);
-- COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
