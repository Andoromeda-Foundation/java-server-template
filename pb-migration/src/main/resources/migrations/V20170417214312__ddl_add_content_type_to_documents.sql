ALTER TABLE `documents`
  ADD COLUMN `content_type` VARCHAR(45) NULL AFTER `saved_name`;