ALTER TABLE `rewards`
  ADD COLUMN `power_station_id` BIGINT(20) NULL AFTER `customer_id`,
  ADD COLUMN `publish_client_id` BIGINT(20) NULL AFTER `power_station_id`,
  ADD COLUMN `publish_user_id` BIGINT(20) NULL AFTER `publish_client_id`,
  ADD COLUMN `staff_id` BIGINT(20) NULL AFTER `publish_user_id`,
  ADD COLUMN `due_at` DATETIME NULL AFTER `assigned`;
