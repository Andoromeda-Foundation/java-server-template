CREATE TABLE `insurances` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NULL,
  `vehicle_id` BIGINT(20) NULL,
  `type` VARCHAR(45) NULL,
  `amount` DECIMAL(20,4) NULL,
  `join_at` DATE NULL,
  `entity` VARCHAR(45) NULL,
  `principal` VARCHAR(45) NULL,
  `document_id` BIGINT(20) NULL,
  `create_by` BIGINT(20) NULL DEFAULT NULL,
  `create_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` BIGINT(20) NULL DEFAULT NULL,
  `update_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) NULL DEFAULT NULL,
  `delete_at` DATETIME NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT '1',
  `deleted` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`));
