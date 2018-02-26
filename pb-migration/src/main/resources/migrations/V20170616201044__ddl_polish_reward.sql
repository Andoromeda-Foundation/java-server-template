ALTER TABLE `rewards`
  ADD COLUMN `assigner_id` BIGINT(20) NULL AFTER `publish_user_id`;
