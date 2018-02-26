ALTER TABLE `power_broker`.`gpses`
ADD COLUMN `mobile_num` VARCHAR(20) NULL AFTER `expires_in`,
ADD COLUMN `plate` VARCHAR(10) NULL AFTER `mobile_num`,
ADD COLUMN `remark` VARCHAR(50) NULL AFTER `plate`;
