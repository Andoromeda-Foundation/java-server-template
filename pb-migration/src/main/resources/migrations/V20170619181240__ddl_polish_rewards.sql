ALTER TABLE `rewards`
  DROP COLUMN `engineer_id`,
  DROP COLUMN `customer_id`,
  ADD COLUMN `accepted_at` DATETIME NULL AFTER `processed_at`,
  ADD COLUMN `departed_at` DATETIME NULL AFTER `accepted_at`,
  ADD COLUMN `executed_at` DATETIME NULL AFTER `departed_at`;
