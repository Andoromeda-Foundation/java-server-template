ALTER TABLE `rewards`
  ADD COLUMN `contact` VARCHAR(45) NULL AFTER `confirmed_at`,
  ADD COLUMN `phone` VARCHAR(45) NULL AFTER `contact`;

ALTER TABLE `delegations`
  ADD COLUMN `contact` VARCHAR(45) NULL AFTER `processed_by`,
  ADD COLUMN `phone` VARCHAR(45) NULL AFTER `contact`;
