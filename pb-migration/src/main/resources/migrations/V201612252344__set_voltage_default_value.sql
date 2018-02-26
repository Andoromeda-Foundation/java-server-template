ALTER TABLE `power_broker`.`power_stations`
ADD COLUMN `type` INT(11) NULL DEFAULT 0 AFTER `state`;

ALTER TABLE `power_broker`.`power_stations`
CHANGE COLUMN `voltage10` `voltage10` INT(11) NULL DEFAULT 0 ,
CHANGE COLUMN `voltage35` `voltage35` INT(11) NULL DEFAULT 0 ,
CHANGE COLUMN `voltage110` `voltage110` INT(11) NULL DEFAULT 0 ;

UPDATE `power_broker`.`power_stations` SET `voltage10`='0' WHERE `voltage10` IS NULL;
UPDATE `power_broker`.`power_stations` SET `voltage35`='0' WHERE `voltage35` IS NULL;
UPDATE `power_broker`.`power_stations` SET `voltage110`='0' WHERE `voltage110` IS NULL;

