ALTER TABLE `documents`
  ADD COLUMN `origin_name` VARCHAR(128) NULL AFTER `name`,
  ADD COLUMN `saved_name` VARCHAR(128) NULL AFTER `origin_name`;
