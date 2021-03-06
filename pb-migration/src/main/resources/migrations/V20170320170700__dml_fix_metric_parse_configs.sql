TRUNCATE `plc_metric_parse_configs`;
-- 达邦
INSERT INTO `plc_metric_parse_configs` (`node`,`name`,`exec_item`,`code`,`lineParam`)
VALUES
('wppcampus','MODBUS_TCP','TX_43','DATA2125','l1_Uab'),
('wppcampus','MODBUS_TCP','TX_43','DATA2126','l1_Ubc'),
('wppcampus','MODBUS_TCP','TX_43','DATA2127','l1_Uca'),
('wppcampus','MODBUS_TCP','TX_43','DATA2128','l1_Ia'),
('wppcampus','MODBUS_TCP','TX_43','DATA2129','l1_Ib'),
('wppcampus','MODBUS_TCP','TX_43','DATA2130','l1_Ic'),
('wppcampus','MODBUS_TCP','TX_43','DATA2131','l1_F'),
('wppcampus','MODBUS_TCP','TX_43','DATA2132','l1_PF'),
('wppcampus','MODBUS_TCP','TX_43','DATA2133','l1_P'),
('wppcampus','MODBUS_TCP','TX_43','DATA2134','l1_Q'),
('wppcampus','MODBUS_TCP','TX_44','DATA2175','l2_Uab'),
('wppcampus','MODBUS_TCP','TX_44','DATA2176','l2_Ubc'),
('wppcampus','MODBUS_TCP','TX_44','DATA2177','l2_Uca'),
('wppcampus','MODBUS_TCP','TX_44','DATA2178','l2_Ia'),
('wppcampus','MODBUS_TCP','TX_44','DATA2179','l2_Ib'),
('wppcampus','MODBUS_TCP','TX_44','DATA2180','l2_Ic'),
('wppcampus','MODBUS_TCP','TX_44','DATA2181','l2_F'),
('wppcampus','MODBUS_TCP','TX_44','DATA2182','l2_PF'),
('wppcampus','MODBUS_TCP','TX_44','DATA2183','l2_P'),
('wppcampus','MODBUS_TCP','TX_44','DATA2184','l2_Q'),
('wppcampus','MODBUS_TCP','TX_38','DATA1881','l2_4_5_3_Uab'),
('wppcampus','MODBUS_TCP','TX_38','DATA1882','l2_4_5_3_Ubc'),
('wppcampus','MODBUS_TCP','TX_38','DATA1883','l2_4_5_3_Uca'),
('wppcampus','MODBUS_TCP','TX_38','DATA1884','l2_4_5_3_Ia'),
('wppcampus','MODBUS_TCP','TX_38','DATA1885','l2_4_5_3_Ib'),
('wppcampus','MODBUS_TCP','TX_38','DATA1886','l2_4_5_3_Ic'),
('wppcampus','MODBUS_TCP','TX_38','DATA1887','l2_4_5_4_F'),
('wppcampus','MODBUS_TCP','TX_38','DATA1888','l2_4_5_4_PF'),
('wppcampus','MODBUS_TCP','TX_38','DATA1889','l2_4_5_4_P'),
('wppcampus','MODBUS_TCP','TX_38','DATA1890','l2_4_5_4_Q');

-- 近铁
INSERT INTO `power_broker`.`plc_metric_parse_configs` (`node`,`name`,`exec_item`,`code`,`lineParam`)
VALUES
('mtrcity','RS485_1','TX_1','DATA6','l1_Uab'),
('mtrcity','RS485_1','TX_1','DATA7','l1_Ubc'),
('mtrcity','RS485_1','TX_1','DATA8','l1_Uca'),
('mtrcity','RS485_1','TX_1','DATA10','l1_Ia'),
('mtrcity','RS485_1','TX_1','DATA11','l1_Ib'),
('mtrcity','RS485_1','TX_1','DATA12','l1_Ic'),
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
('mtrcity','RS485_1','TX_1','DATA27','l2_Ia'),
('mtrcity','RS485_1','TX_1','DATA28','l2_Ib'),
('mtrcity','RS485_1','TX_1','DATA29','l2_Ic'),
('mtrcity','RS485_1','TX_1','DATA18','l2_F'),
('mtrcity','RS485_1','TX_1','DATA34','l2_PF'),
('mtrcity','RS485_1','TX_1','DATA31','l2_P'),
('mtrcity','RS485_1','TX_1','DATA32','l2_Q'),
('mtrcity','RS485_1','TX_1','DATA33','l2_S'),
('mtrcity','RS485_1','TX_7','DATA308','l2_Ta'),
('mtrcity','RS485_1','TX_7','DATA309','l2_Tb'),
('mtrcity','RS485_1','TX_7','DATA310','l2_Tc');