CREATE TABLE `plc_discharge_metadata` (
  `identifier` varchar(128) NOT NULL,
  `serial` varchar(24) NOT NULL,
  `extra` varchar(24) NOT NULL,
  `node` varchar(10) DEFAULT NULL,
  `host` varchar(20) DEFAULT NULL,
  `port` int(11) DEFAULT NULL,
  `threshold` int(11) DEFAULT NULL,
  `timestamp` varchar(24) DEFAULT NULL,
  `max` int(11) DEFAULT NULL,
  `min` int(11) DEFAULT NULL,
  `detail` text,
  `mongo_id` varchar(30) DEFAULT NULL,
  `mongo_at` datetime DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`identifier`,`serial`,`extra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
