DROP TABLE IF EXISTS `plc_metric_parse_configs`;

CREATE TABLE `plc_metric_parse_configs` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `node` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `exec_item` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `lineParam` varchar(20) NOT NULL,
  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` DATETIME NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 达邦
INSERT INTO `power_broker`.`plc_metric_parse_configs` (`node`,`name`,`exec_item`,`code`,`lineParam`)
VALUES
('wppcampus','MODBUS_TCP','TX_43','DATA2125','l1_Uab'),
('wppcampus','MODBUS_TCP','TX_43','DATA2126','l1_Ubc'),
('wppcampus','MODBUS_TCP','TX_43','DATA2127','l1_Uca'),
('wppcampus','MODBUS_TCP','TX_43','DATA2128','l1_la'),
('wppcampus','MODBUS_TCP','TX_43','DATA2129','l1_lb'),
('wppcampus','MODBUS_TCP','TX_43','DATA2130','l1_lc'),
('wppcampus','MODBUS_TCP','TX_43','DATA2131','l1_F'),
('wppcampus','MODBUS_TCP','TX_43','DATA2132','l1_PF'),
('wppcampus','MODBUS_TCP','TX_43','DATA2133','l1_P'),
('wppcampus','MODBUS_TCP','TX_43','DATA2134','l1_Q'),
('wppcampus','MODBUS_TCP','TX_44','DATA2175','l2_Uab'),
('wppcampus','MODBUS_TCP','TX_44','DATA2176','l2_Ubc'),
('wppcampus','MODBUS_TCP','TX_44','DATA2177','l2_Uca'),
('wppcampus','MODBUS_TCP','TX_44','DATA2178','l2_la'),
('wppcampus','MODBUS_TCP','TX_44','DATA2179','l2_lb'),
('wppcampus','MODBUS_TCP','TX_44','DATA2180','l2_lc'),
('wppcampus','MODBUS_TCP','TX_44','DATA2181','l2_F'),
('wppcampus','MODBUS_TCP','TX_44','DATA2182','l2_PF'),
('wppcampus','MODBUS_TCP','TX_44','DATA2183','l2_P'),
('wppcampus','MODBUS_TCP','TX_44','DATA2184','l2_Q');

-- 近铁
INSERT INTO `power_broker`.`plc_metric_parse_configs` (`node`,`name`,`exec_item`,`code`,`lineParam`)
VALUES
('mtrcity','RS485_1','TX_1','DATA6','l1_Uab'),
('mtrcity','RS485_1','TX_1','DATA7','l1_Ubc'),
('mtrcity','RS485_1','TX_1','DATA8','l1_Uca'),
('mtrcity','RS485_1','TX_1','DATA10','l1_la'),
('mtrcity','RS485_1','TX_1','DATA11','l1_lb'),
('mtrcity','RS485_1','TX_1','DATA12','l1_lc'),
('mtrcity','RS485_1','TX_1','DATA1','l1_F'),
('mtrcity','RS485_1','TX_1','DATA17','l1_PF'),
('mtrcity','RS485_1','TX_1','DATA14','l1_P'),
('mtrcity','RS485_1','TX_1','DATA15','l1_Q'),
('mtrcity','RS485_1','TX_1','DATA16','l1_S'),
('mtrcity','RS485_1','TX_7','DATA305','l1_Ta'),
('mtrcity','RS485_1','TX_7','DATA306','l1_Tb'),
('mtrcity','RS485_1','TX_7','DATA307','l1_Tc'),
('mtrcity','RS485_1','TX_1','DATA23','l2_Uab'),
('mtrcity','RS485_1','TX_1','DATA24','l2_Ubc'),
('mtrcity','RS485_1','TX_1','DATA25','l2_Uca'),
('mtrcity','RS485_1','TX_1','DATA27','l2_la'),
('mtrcity','RS485_1','TX_1','DATA28','l2_lb'),
('mtrcity','RS485_1','TX_1','DATA29','l2_lc'),
('mtrcity','RS485_1','TX_1','DATA18','l2_F'),
('mtrcity','RS485_1','TX_1','DATA34','l2_PF'),
('mtrcity','RS485_1','TX_1','DATA31','l2_P'),
('mtrcity','RS485_1','TX_1','DATA32','l2_Q'),
('mtrcity','RS485_1','TX_1','DATA33','l2_S'),
('mtrcity','RS485_1','TX_7','DATA308','l2_Ta'),
('mtrcity','RS485_1','TX_7','DATA309','l2_Tb'),
('mtrcity','RS485_1','TX_7','DATA310','l2_Tc');