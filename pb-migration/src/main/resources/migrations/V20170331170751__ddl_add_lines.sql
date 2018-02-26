CREATE TABLE `power_station_lines` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `identifier` VARCHAR(256) NULL,
  `power_station_id` BIGINT(20) NULL,
  `create_by` BIGINT(20) NULL DEFAULT NULL,
  `create_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` BIGINT(20) NULL DEFAULT NULL,
  `update_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) NULL DEFAULT NULL,
  `delete_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `active` TINYINT(1) NULL DEFAULT '1',
  `deleted` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`));
