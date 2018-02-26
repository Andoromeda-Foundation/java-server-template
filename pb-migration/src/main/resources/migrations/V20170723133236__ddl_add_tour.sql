CREATE TABLE `tours` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `rfid_id` BIGINT(20) NULL,
  `device_state` INT NULL,
  `leak` TINYINT(1) NULL,
  `illumination` TINYINT(1) NULL,
  `animal` TINYINT(1) NULL,
  `security` TINYINT(1) NULL,
  `hygiene` TINYINT(1) NULL,
  `content` VARCHAR(255) NULL,
  `create_by` BIGINT(20) NULL DEFAULT NULL COMMENT '创建者',
  `create_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` BIGINT(20) NULL DEFAULT NULL COMMENT '更新者',
  `update_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `delete_by` BIGINT(20) NULL DEFAULT NULL COMMENT '删除者',
  `delete_at` DATETIME NULL DEFAULT NULL COMMENT '删除时间',
  `active` TINYINT(1) NULL DEFAULT '1' COMMENT '激活标记',
  `deleted` TINYINT(1) NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`));

CREATE TABLE `tours_documents` (
  `tour_id` bigint(20) NOT NULL,
  `document_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
