ALTER TABLE `power_broker`.`power_stations` 
ADD COLUMN `longitude` VARCHAR(45) NULL AFTER `address`,
ADD COLUMN `latitude` VARCHAR(45) NULL AFTER `longitude`;

ALTER TABLE power_broker.power_stations DROP voltage;
ALTER TABLE power_broker.power_stations ADD voltage110 INT NULL;
ALTER TABLE power_broker.power_stations ADD voltage35 INT NULL;
ALTER TABLE power_broker.power_stations ADD voltage10 INT NULL;
ALTER TABLE power_broker.power_stations
  MODIFY COLUMN voltage10 INT AFTER industry_class,
  MODIFY COLUMN voltage35 INT AFTER voltage10,
  MODIFY COLUMN voltage110 INT AFTER voltage35;


insert into `power_broker`.power_stations(`name`,`response_area`,`address`,`voltage10`,`voltage35`,`voltage110`,`latitude`,`longitude`)
  select ps.name,ps.area,ps.address,if(ps.kv10='',null,ps.kv10),if(ps.kv35='',null,ps.kv35),if(ps.kv110='',null,ps.kv110),ps.longitude,ps.latitude from `power_broker`.`temp_distribution` ps left join
    `power_broker`.`power_stations` tt on ps.address = tt.address where tt.id is null;