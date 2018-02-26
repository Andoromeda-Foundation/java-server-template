ALTER TABLE `plc_metric_parse_configs`
CHANGE COLUMN `node` `node` VARCHAR(30) NULL ,
CHANGE COLUMN `name` `name` VARCHAR(30) NULL ,
ADD COLUMN `identifier` VARCHAR(128) NOT NULL AFTER `id`;