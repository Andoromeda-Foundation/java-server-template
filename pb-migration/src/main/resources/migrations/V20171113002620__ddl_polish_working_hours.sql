ALTER TABLE `power_broker`.`working_hours`
  ADD COLUMN `staff_id` BIGINT(20) NULL AFTER `finished`,
  ADD COLUMN `reward_id` BIGINT(20) NULL AFTER `staff_id`;