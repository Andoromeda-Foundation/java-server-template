ALTER TABLE `power_broker`.`roles`
ADD COLUMN `role_type` VARCHAR(45) NULL AFTER `name`,
ADD COLUMN `display_name` VARCHAR(45) NULL AFTER `role_type`,
ADD COLUMN `comment` VARCHAR(45) NULL AFTER `display_name`;

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('角色权限', 'admin/roles', '10');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('设备种类录入', 'admin/deviceCategorys', '10');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('用户操作日志', 'admin/operationRecords', '10');