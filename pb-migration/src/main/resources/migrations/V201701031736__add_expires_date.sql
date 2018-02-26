ALTER TABLE `power_broker`.`gpses`
ADD COLUMN `expires_date` TIMESTAMP NULL AFTER `expires_in`;