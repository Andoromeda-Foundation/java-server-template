ALTER TABLE `warning_logs`
  ADD COLUMN `power_station_id` BIGINT(20) NULL AFTER `content`,
  ADD COLUMN `confirmed` TINYINT(1) NULL DEFAULT '0' AFTER `power_station_id`;
