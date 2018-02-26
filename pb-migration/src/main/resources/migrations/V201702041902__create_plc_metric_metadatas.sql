DROP TABLE IF EXISTS `plc_metric_metadatas`;
CREATE TABLE `plc_metric_metadatas` (
  `node` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `create_at` varchar(14) NOT NULL,
  `exec_item` varchar(20) NOT NULL,
  `config_version` varchar(80) NULL,
  `mongo_id` varchar(30) NULL,
  `mongo_at` datetime NULL,
  `error` VARCHAR(45) NULL DEFAULT NULL,
  `value` varchar(3000) NULL,
  `code` varchar(3000) NULL,
  PRIMARY KEY (`node`,`name`,`create_at`,`exec_item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
