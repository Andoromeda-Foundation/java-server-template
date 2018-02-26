ALTER TABLE `power_broker`.`power_station_device`
  CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID' ,
  ADD PRIMARY KEY (`id`);
