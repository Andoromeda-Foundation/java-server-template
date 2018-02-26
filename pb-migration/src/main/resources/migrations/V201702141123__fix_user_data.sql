INSERT INTO `power_broker`.`staffs` (`name`, `dept_id`) VALUES ('william', '1');

UPDATE `power_broker`.`users` SET `staff_id`='1' WHERE `id`='1';

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('员工信息', 'admin/staffs', '10');
