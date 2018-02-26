ALTER TABLE `power_broker`.`bss_power_consume`
  CHANGE COLUMN `customer_id` `customer_id` BIGINT(20) NULL
COMMENT '客户ID',
  ADD COLUMN `power_station_id` BIGINT(20) NULL
  AFTER `customer_id`;

ALTER TABLE `power_broker`.`power_consume_device`
  CHANGE COLUMN `specific` `specification` VARCHAR(45) NULL DEFAULT NULL
COMMENT '型号规格',
  CHANGE COLUMN `substation_name` `substation_name` VARCHAR(45) NULL
COMMENT '变配电站名称',
  CHANGE COLUMN `comment` `comments` VARCHAR(2000) NULL DEFAULT NULL
COMMENT '备注';
