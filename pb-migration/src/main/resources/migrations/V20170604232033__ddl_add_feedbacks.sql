CREATE TABLE `feedbacks` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NULL,
  `client_id` BIGINT(20) NULL,
  `submitted_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` BIGINT(20) NULL DEFAULT NULL,
  `create_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'CURRENT_TIMESTAMP',
  `update_by` BIGINT(20) NULL DEFAULT NULL,
  `update_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20) NULL DEFAULT NULL,
  `delete_at` DATETIME NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT '1',
  `deleted` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`));
