ALTER TABLE `indexes`
  ADD COLUMN `identifier` VARCHAR(128) NOT NULL AFTER `name`;

ALTER TABLE `index_mappings`
  ADD COLUMN `index_identifier` VARCHAR(128) NULL AFTER `index_id`;
