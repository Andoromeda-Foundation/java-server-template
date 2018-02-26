CREATE TABLE `indexes` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `queue_name` VARCHAR(100) NOT NULL,
  `create_by` BIGINT(20) NULL DEFAULT NULL,
  `create_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` BIGINT(20) NULL DEFAULT NULL,
  `update_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) NULL DEFAULT NULL,
  `delete_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `active` TINYINT(1) NULL DEFAULT '1',
  `deleted` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`));

CREATE TABLE `index_mappings` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `index_id` BIGINT(20) NULL,
  `station_identifier` VARCHAR(128) NULL,
  `line_identifier` VARCHAR(128) NULL,
  `keys` VARCHAR(255) NULL,
  `create_by` BIGINT(20) NULL DEFAULT NULL,
  `create_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` BIGINT(20) NULL DEFAULT NULL,
  `update_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) NULL DEFAULT NULL,
  `delete_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `active` TINYINT(1) NULL DEFAULT '1',
  `deleted` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`));