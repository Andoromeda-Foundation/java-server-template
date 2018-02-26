DROP TABLE IF EXISTS `devices`;
CREATE TABLE `power_broker`.`devices` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `device_genere` VARCHAR(45) NULL,
  `device_category` VARCHAR(45) NULL,
  `device_name` VARCHAR(45) NULL,
  `account_number` VARCHAR(45) NULL,
  `nameplate_info` VARCHAR(45) NULL,
  `specification` VARCHAR(45) NULL,
  `production_info` VARCHAR(45) NULL,
  `quantity` VARCHAR(45) NULL,
  `factory_number` VARCHAR(45) NULL,
  `factory_date` VARCHAR(45) NULL,
  `operation_date` VARCHAR(45) NULL,
  `comment` VARCHAR(45) NULL,
  `backup1` VARCHAR(45) NULL,
  `backup2` VARCHAR(45) NULL,

       `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`));



DROP TABLE IF EXISTS `device_categories`;
CREATE TABLE `power_broker`.`device_categories` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `device_genere` VARCHAR(45) NULL,
  `device_category` VARCHAR(45) NULL,

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`));



DROP TABLE IF EXISTS `operation_records`;
CREATE TABLE `power_broker`.`operation_records` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `operate_by` VARCHAR(45) NOT NULL,
  `operation_content` VARCHAR(45) NULL,
  `begin_time` VARCHAR(14) NULL,
  `end_time` VARCHAR(14) NULL,

    `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`));
