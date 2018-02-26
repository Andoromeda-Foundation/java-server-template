ALTER TABLE `power_broker`.`defects`
  ADD COLUMN `reward_id` BIGINT(20) NULL AFTER `id`;

ALTER TABLE `power_broker`.`tours`
  ADD COLUMN `reward_id` BIGINT(20) NULL AFTER `id`;

ALTER TABLE `power_broker`.`rewards`
  ADD COLUMN `has_data` TINYINT(1) NULL DEFAULT '0' AFTER `has_comment`;