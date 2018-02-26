ALTER TABLE `plc_metric_parsed`
ADD COLUMN `identifier` VARCHAR(128) NOT NULL FIRST,
CHANGE COLUMN `metric_at` `metric_at` DATETIME NOT NULL AFTER `identifier`,
CHANGE COLUMN `node` `node` VARCHAR(30) NULL DEFAULT NULL ,
CHANGE COLUMN `name` `name` VARCHAR(30) NULL DEFAULT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`identifier`, `metric_at`);
