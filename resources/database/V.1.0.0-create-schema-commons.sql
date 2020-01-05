create schema commons_db;

CREATE TABLE `commons_db`.`applications` (
  `code` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `APPLICATIONS_UNIQUE_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;