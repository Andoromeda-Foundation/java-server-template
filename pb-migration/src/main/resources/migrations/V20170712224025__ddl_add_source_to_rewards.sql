ALTER TABLE `rewards`
  ADD COLUMN `source` INT(11) NULL DEFAULT '1' AFTER `type`;
