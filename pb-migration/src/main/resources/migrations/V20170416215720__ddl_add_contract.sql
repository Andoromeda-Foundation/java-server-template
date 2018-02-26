CREATE TABLE `contracts` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `type` INT NULL,
  `power_station_id` BIGINT(20) NULL,
  `amount` DECIMAL(20,4) NULL,
  `client_principal` VARCHAR(45) NULL,
  `client_phone` VARCHAR(45) NULL,
  `signed_at` DATETIME NULL,
  `expired_at` DATETIME NULL,
  `signed_by` VARCHAR(45) NULL,
  `custodian_by` VARCHAR(45) NULL,
  `document_id` BIGINT(20) NULL,
  `remark` VARCHAR(100) NULL DEFAULT NULL,
  `create_by` BIGINT(20) NULL DEFAULT NULL,
  `create_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` BIGINT(20) NULL DEFAULT NULL,
  `update_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) NULL DEFAULT NULL,
  `delete_at` DATETIME NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT '1',
  `deleted` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`));
