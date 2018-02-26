ALTER TABLE `power_broker`.`index_mappings`
  ADD COLUMN `type` INT(11) NULL DEFAULT 1 COMMENT '1: metric, 2 : discharge' AFTER `index_identifier`;
