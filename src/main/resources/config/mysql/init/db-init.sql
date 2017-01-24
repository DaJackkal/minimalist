CREATE DATABASE IF NOT EXISTS movies_db;
USE movies_db;

CREATE TABLE IF NOT EXISTS movies (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `year` INT NULL,
  PRIMARY KEY (`id`));

INSERT INTO movies (`name`, `year`) VALUES ('Movie 1', '1989');
INSERT INTO movies (`name`, `year`) VALUES ('Movie 2', '1990');
INSERT INTO movies (`name`, `year`) VALUES ('Movie 3', '1991');