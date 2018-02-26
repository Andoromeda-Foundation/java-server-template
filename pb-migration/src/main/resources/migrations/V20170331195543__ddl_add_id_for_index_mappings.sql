ALTER TABLE `index_mappings`
  ADD COLUMN `station_id` BIGINT(20) NULL AFTER `index_id`,
  ADD COLUMN `line_id` BIGINT(20) NULL AFTER `station_identifier`;
