ALTER TABLE `power_broker`.`electrical_testings`
  ADD COLUMN `station_id` BIGINT(20) NULL AFTER `customer_name`;
