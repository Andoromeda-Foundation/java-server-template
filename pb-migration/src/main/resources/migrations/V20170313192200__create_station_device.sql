CREATE TABLE `power_station_device`
SELECT * FROM `bss_substation_device`;

ALTER TABLE `power_broker`.`power_station_device` 
CHANGE COLUMN `substation_id` `substation_id` BIGINT(20) NULL COMMENT '变配电站ID' ,
CHANGE COLUMN `substation_name` `substation_name` VARCHAR(45) NULL COMMENT '变配电站名称' ,
CHANGE COLUMN `specific` `specification` VARCHAR(45) NULL DEFAULT NULL COMMENT '型号规格' ,
CHANGE COLUMN `comment` `comments` VARCHAR(2000) NULL DEFAULT NULL COMMENT '备注' ;

DROP TABLE IF EXISTS `bss_substation_device`;