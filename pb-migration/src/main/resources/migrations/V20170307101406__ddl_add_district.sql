CREATE TABLE `staff_districts` (
  `staff_id` BIGINT(20) NOT NULL,
  `district_id` BIGINT(20) NOT NULL);

CREATE TABLE `district_power_stations` (
  `district_id` BIGINT(20) NOT NULL,
  `power_station_id` BIGINT(20) NOT NULL);

CREATE TABLE `districts` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `create_by` BIGINT(20) DEFAULT NULL,
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` BIGINT(20) DEFAULT NULL,
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) DEFAULT NULL,
  `delete_at` DATETIME NULL DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`));
