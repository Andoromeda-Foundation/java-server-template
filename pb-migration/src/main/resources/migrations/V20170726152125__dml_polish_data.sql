UPDATE `power_broker`.`navs` SET `name`='电站运行管理' WHERE `id`='3';

UPDATE `power_broker`.`sidebars` SET `nav_id`='3' WHERE `nav_id` IN (4, 5);
UPDATE `power_broker`.`sidebars` SET `deleted`='1' WHERE `nav_id` = 6;

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('电试管理', 'electricalTestings', 3);


UPDATE `power_broker`.`sidebars` SET `name`='地图查询' WHERE `link` = 'map';
