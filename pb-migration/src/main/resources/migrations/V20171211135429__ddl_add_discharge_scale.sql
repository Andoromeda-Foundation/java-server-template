CREATE TABLE plc_discharge_scale_metadata
(
  identifier VARCHAR(128),
  serial VARCHAR(14),
  extra VARCHAR(24),
  node VARCHAR(10) DEFAULT NULL,
  host VARCHAR(10) DEFAULT NULL,
  port INT(11),
  threshold INT(11),
  timestamp VARCHAR(24) DEFAULT NULL,
  max INT(11),
  min INT(11),
  mongo_id VARCHAR(30) DEFAULT NULL,
  mongo_at DATETIME,
  create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (identifier, serial, extra)
);