ALTER TABLE `documents`
  ADD COLUMN `checksum` VARCHAR(128) NULL AFTER `content_type`;
