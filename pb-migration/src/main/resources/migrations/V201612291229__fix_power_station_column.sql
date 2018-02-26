ALTER TABLE power_broker.power_stations CHANGE `desc` comment VARCHAR(100);
ALTER TABLE power_broker.power_stations CHANGE voltage_unkonw voltage_unknow INT(11) DEFAULT '0';
ALTER TABLE power_broker.power_stations CHANGE client_name customer_name VARCHAR(45);
ALTER TABLE power_broker.power_stations CHANGE client_code customer_no VARCHAR(10);