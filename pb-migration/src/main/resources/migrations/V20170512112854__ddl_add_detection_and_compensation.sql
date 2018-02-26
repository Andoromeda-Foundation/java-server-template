ALTER TABLE `power_stations`
  ADD COLUMN `detection` TINYINT(1) NULL DEFAULT '0' AFTER `type`,
  ADD COLUMN `compensation` TINYINT(1) NULL DEFAULT '0' AFTER `detection`;
