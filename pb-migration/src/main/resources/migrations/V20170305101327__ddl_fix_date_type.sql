ALTER TABLE `power_broker`.`devices` 
CHANGE COLUMN `factory_date` `factory_date` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `operation_date` `operation_date` DATETIME NULL DEFAULT NULL ;

