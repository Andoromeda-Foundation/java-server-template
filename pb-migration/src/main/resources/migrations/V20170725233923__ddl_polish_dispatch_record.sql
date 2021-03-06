ALTER TABLE `power_broker`.`dispatch_record`
  CHANGE COLUMN `delete_by` `delete_by` BIGINT(20) NULL DEFAULT NULL COMMENT '删除者' AFTER `update_at`,
  CHANGE COLUMN `delete_at` `delete_at` DATETIME NULL DEFAULT NULL COMMENT '删除时间' AFTER `delete_by`,
  CHANGE COLUMN `inspection_date` `inspection_date` DATE NULL DEFAULT NULL COMMENT '巡视日期' ,
  CHANGE COLUMN `create_at` `create_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  CHANGE COLUMN `update_at` `update_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  CHANGE COLUMN `active` `active` TINYINT(1) NULL DEFAULT '1' COMMENT '激活标记' ,
  CHANGE COLUMN `deleted` `deleted` TINYINT(1) NULL DEFAULT '0' COMMENT '删除标记' ,
  ADD COLUMN `power_station_id` BIGINT(20) NULL AFTER `id`,
  ADD COLUMN `content` VARCHAR(45) NULL AFTER `conclusion`,
  ADD COLUMN `state` VARCHAR(45) NULL AFTER `content`,
  ADD COLUMN `device_count` VARCHAR(45) NULL AFTER `state`,
  ADD COLUMN `execution_rate` VARCHAR(45) NULL AFTER `device_count`,
  ADD COLUMN `finish_rate` VARCHAR(45) NULL AFTER `execution_rate`,
  ADD COLUMN `tour_unit` VARCHAR(45) NULL AFTER `finish_rate`,
  ADD COLUMN `defect` VARCHAR(45) NULL AFTER `tour_unit`,
  ADD COLUMN `extinct_defect` VARCHAR(45) NULL AFTER `defect`,
  ADD COLUMN `past_lock` VARCHAR(45) NULL AFTER `extinct_defect`;
