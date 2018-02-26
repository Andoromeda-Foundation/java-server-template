ALTER TABLE `rewards`
  ADD COLUMN `task_state` INT(11) NULL DEFAULT 10 AFTER `type`,
  ADD COLUMN `processed_at` DATETIME NULL AFTER `task_state`,
  ADD COLUMN `completed_at` DATETIME NULL AFTER `processed_at`,
  ADD COLUMN `confirmed_at` DATETIME NULL AFTER `completed_at`;
