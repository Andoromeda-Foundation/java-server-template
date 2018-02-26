ALTER TABLE `power_broker`.`devices` 
CHANGE COLUMN `factory_date` `factory_date` DATE NULL DEFAULT NULL ,
CHANGE COLUMN `operation_date` `operation_date` DATE NULL DEFAULT NULL ;
