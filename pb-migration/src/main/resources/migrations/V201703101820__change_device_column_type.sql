ALTER TABLE `power_broker`.`power_produce_device`
  CHANGE COLUMN `substation_id` `substation_id` BIGINT(20) NULL COMMENT '变配电站ID' ,
  CHANGE COLUMN `substation_name` `substation_name` VARCHAR(45) NULL COMMENT '变配电站名称' ;

ALTER TABLE `power_broker`.`power_produce_device`
  CHANGE COLUMN `specific` `specification` VARCHAR(45) NULL DEFAULT NULL COMMENT '型号规格' ,
  CHANGE COLUMN `comment` `comments` VARCHAR(2000) NULL DEFAULT NULL COMMENT '备注' ;

ALTER TABLE `power_broker`.`power_produce_device`
  CHANGE COLUMN `factory_date` `factory_date` DATETIME NULL DEFAULT NULL COMMENT '出厂日期' ,
  CHANGE COLUMN `operation_date` `operation_date` DATETIME NULL DEFAULT NULL COMMENT '投运日期' ;

ALTER TABLE `power_broker`.`power_grid_device`
  CHANGE COLUMN `substation_id` `substation_id` BIGINT(20) NULL COMMENT '变配电站ID' ,
  CHANGE COLUMN `substation_name` `substation_name` VARCHAR(45) NULL COMMENT '变配电站名称' ,
  CHANGE COLUMN `specific` `specification` VARCHAR(45) NULL DEFAULT NULL COMMENT '型号规格' ,
  CHANGE COLUMN `comment` `comments` VARCHAR(2000) NULL DEFAULT NULL COMMENT '备注' ;

ALTER TABLE `power_broker`.`power_grid_device`
  CHANGE COLUMN `factory_date` `factory_date` DATETIME NULL DEFAULT NULL COMMENT '出厂日期' ,
  CHANGE COLUMN `operation_date` `operation_date` DATETIME NULL DEFAULT NULL COMMENT '投运日期' ;
