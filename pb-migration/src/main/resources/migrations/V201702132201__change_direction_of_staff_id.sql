ALTER TABLE `power_broker`.`users`
ADD COLUMN `staff_id` BIGINT(20) NULL AFTER `password`;

ALTER TABLE `power_broker`.`staffs`
DROP COLUMN `user_id`;