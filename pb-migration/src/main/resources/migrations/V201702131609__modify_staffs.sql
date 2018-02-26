ALTER TABLE `power_broker`.`staffs` 
CHANGE COLUMN `name` `name` VARCHAR(45) NOT NULL AFTER `user_id`,
ADD COLUMN `no` VARCHAR(45) NULL DEFAULT '000' AFTER `name`,
ADD COLUMN `gender` INT NULL DEFAULT 0 AFTER `dept_id`,
ADD COLUMN `birthday` DATE NULL AFTER `gender`,
ADD COLUMN `id_card_no` VARCHAR(20) NULL AFTER `birthday`,
ADD COLUMN `birthplace` VARCHAR(20) NULL AFTER `id_card_no`,
ADD COLUMN `phone` VARCHAR(20) NULL AFTER `birthplace`,
ADD COLUMN `email` VARCHAR(50) NULL AFTER `phone`,
ADD COLUMN `remark` VARCHAR(100) NULL AFTER `email`;
