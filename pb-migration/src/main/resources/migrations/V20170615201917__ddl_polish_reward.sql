ALTER TABLE `rewards`
  ADD COLUMN `has_comment` TINYINT(1) NULL DEFAULT '0' AFTER `confirmed_at`;
