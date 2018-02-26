CREATE TABLE `accidents` (
  `id` BIGINT(20) NOT NULL,
  `vehicle_id` BIGINT(20) NULL,
  `nature` VARCHAR(45) NULL,
  `loss` DECIMAL(20,4) NULL,
  `at` DATE NULL,
  `place` VARCHAR(45) NULL,
  `consequence` VARCHAR(45) NULL,
  `driver` VARCHAR(45) NULL,
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