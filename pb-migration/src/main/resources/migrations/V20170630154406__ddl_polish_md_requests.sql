ALTER TABLE `md_requests`
  DROP COLUMN `id`,
  CHANGE COLUMN `power_station_id` `id` BIGINT(20) NOT NULL ,
  DROP PRIMARY KEY,
  ADD PRIMARY KEY (`id`);
