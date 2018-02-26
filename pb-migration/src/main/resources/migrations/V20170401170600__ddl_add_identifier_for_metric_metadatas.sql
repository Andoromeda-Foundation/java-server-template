ALTER TABLE `plc_metric_metadatas`
ADD COLUMN `identifier` VARCHAR(128) NOT NULL FIRST,
CHANGE COLUMN `metric_at` `metric_at` VARCHAR(14) NOT NULL AFTER `identifier`,
CHANGE COLUMN `exec_item` `exec_item` VARCHAR(20) NOT NULL AFTER `metric_at`,
CHANGE COLUMN `node` `node` VARCHAR(30) NULL DEFAULT NULL ,
CHANGE COLUMN `name` `name` VARCHAR(30) NULL DEFAULT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`identifier`, `metric_at`, `exec_item`);