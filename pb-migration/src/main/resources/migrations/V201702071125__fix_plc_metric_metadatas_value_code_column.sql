ALTER TABLE `power_broker`.`plc_metric_metadatas` 
CHANGE COLUMN `value` `value` TEXT NULL DEFAULT NULL,
CHANGE COLUMN `code` `code` TEXT NULL DEFAULT NULL;