ALTER TABLE `updaters`
  ADD COLUMN `bundle_id` VARCHAR(45) NULL AFTER `update_url`,
  ADD UNIQUE INDEX `bundle_id_UNIQUE` (`bundle_id` ASC);
