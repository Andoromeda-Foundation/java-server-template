DROP TABLE IF EXISTS `plc_metric_parsed`;

CREATE TABLE `plc_metric_parsed` (
  `node` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `metric_at` datetime NOT NULL,
  `mongo_id` varchar(30) NULL,
  `mongo_at` datetime NULL,
  `l1_Uab` decimal(20,4) DEFAULT NULL COMMENT '线电压(KV)',
  `l1_Ubc` decimal(20,4) DEFAULT NULL COMMENT '线电压(KV)',
  `l1_Uca` decimal(20,4) DEFAULT NULL COMMENT '线电压(KV)',
  `l1_la` decimal(20,4) DEFAULT NULL COMMENT '电流(A)',
  `l1_lb` decimal(20,4) DEFAULT NULL COMMENT '电流(A)',
  `l1_lc` decimal(20,4) DEFAULT NULL COMMENT '电流(A)',
  `l1_F` decimal(20,4) DEFAULT NULL COMMENT '频率(Hz)',
  `l1_PF` decimal(20,4) DEFAULT NULL COMMENT '功率因数',
  `l1_P` decimal(20,4) DEFAULT NULL COMMENT '有功功率(KW)',
  `l1_Q` decimal(20,4) DEFAULT NULL COMMENT '无功功率(KW)',
  `l1_S` decimal(20,4) DEFAULT NULL COMMENT '视在功率(KW)',
  `l1_Ta` decimal(20,4) DEFAULT NULL COMMENT '摄氏度(℃)',
  `l1_Tb` decimal(20,4) DEFAULT NULL COMMENT '摄氏度(℃)',
  `l1_Tc` decimal(20,4) DEFAULT NULL COMMENT '摄氏度(℃)',
  `l1_MD` decimal(20,4) DEFAULT NULL COMMENT '需量(KW)',
  `l1_W` decimal(20,4) DEFAULT NULL COMMENT '用电量(Kwh)',
  `l2_Uab` decimal(20,4) DEFAULT NULL,
  `l2_Ubc` decimal(20,4) DEFAULT NULL,
  `l2_Uca` decimal(20,4) DEFAULT NULL,
  `l2_la` decimal(20,4) DEFAULT NULL,
  `l2_lb` decimal(20,4) DEFAULT NULL,
  `l2_lc` decimal(20,4) DEFAULT NULL,
  `l2_F` decimal(20,4) DEFAULT NULL,
  `l2_PF` decimal(20,4) DEFAULT NULL,
  `l2_P` decimal(20,4) DEFAULT NULL,
  `l2_Q` decimal(20,4) DEFAULT NULL,
  `l2_S` decimal(20,4) DEFAULT NULL,
  `l2_Ta` decimal(20,4) DEFAULT NULL,
  `l2_Tb` decimal(20,4) DEFAULT NULL,
  `l2_Tc` decimal(20,4) DEFAULT NULL,
  `l2_MD` decimal(20,4) DEFAULT NULL,
  `l2_W` decimal(20,4) DEFAULT NULL,
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`node`,`name`,`metric_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;