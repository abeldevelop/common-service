create schema commons_db;

CREATE TABLE `commons_db`.`applications` (
  `code` varchar(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `APPLICATIONS_UNIQUE_NAME` (`name`)
);