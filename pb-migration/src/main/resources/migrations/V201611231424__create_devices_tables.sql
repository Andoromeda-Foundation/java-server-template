INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('变配电站设备信息', 'maintain/powerStationDevices', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('配电网设备信息', 'maintain/powerGridDevices', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('分布式发电设备信息', 'maintain/powerProduceDevices', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('用电设备信息', 'maintain/powerConsumeDevices', '2');

DROP TABLE IF EXISTS `bss_substation_device`;
CREATE TABLE `bss_substation_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NOT NULL COMMENT '变配电站ID',
  `substation_name` varchar(45) NOT NULL COMMENT '变配电站名称',
  `device` varchar(45) DEFAULT NULL COMMENT '所属设备',
  `device_category` varchar(45) DEFAULT NULL COMMENT '设备种类',
  `device_name` varchar(45) DEFAULT NULL COMMENT '设备名称',
  `account_number` varchar(45) DEFAULT NULL COMMENT '台账编号',
  `nameplate_info` varchar(45) DEFAULT NULL COMMENT '铭牌信息',
  `production_info` varchar(45) DEFAULT NULL COMMENT '生产信息',
  `specific` varchar(45) DEFAULT NULL COMMENT '型号规格',
  `quantity` varchar(45) DEFAULT NULL COMMENT '数量',
  `factory_number` varchar(45) DEFAULT NULL COMMENT '出厂编号',
  `factory_date` varchar(45) DEFAULT NULL COMMENT '出厂日期',
  `operation_date` varchar(45) DEFAULT NULL COMMENT '投运日期',
  `comment` varchar(2000) DEFAULT NULL COMMENT '备注',
  `backup1` varchar(45) DEFAULT NULL COMMENT '自定义1',
  `backup2` varchar(45) DEFAULT NULL COMMENT '自定义2',
  

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='变配电站设备信息关系表';


DROP TABLE IF EXISTS `power_grid_device`;
CREATE TABLE `power_grid_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NOT NULL COMMENT '变配电站ID',
  `substation_name` varchar(45) NOT NULL COMMENT '变配电站名称',
  `device` varchar(45) DEFAULT NULL COMMENT '所属设备',
  `device_category` varchar(45) DEFAULT NULL COMMENT '设备种类',
  `device_name` varchar(45) DEFAULT NULL COMMENT '设备名称',
  `account_number` varchar(45) DEFAULT NULL COMMENT '台账编号',
  `nameplate_info` varchar(45) DEFAULT NULL COMMENT '铭牌信息',
  `production_info` varchar(45) DEFAULT NULL COMMENT '生产信息',
  `specific` varchar(45) DEFAULT NULL COMMENT '型号规格',
  `quantity` varchar(45) DEFAULT NULL COMMENT '数量',
  `factory_number` varchar(45) DEFAULT NULL COMMENT '出厂编号',
  `factory_date` varchar(45) DEFAULT NULL COMMENT '出厂日期',
  `operation_date` varchar(45) DEFAULT NULL COMMENT '投运日期',
  `comment` varchar(2000) DEFAULT NULL COMMENT '备注',
  `backup1` varchar(45) DEFAULT NULL COMMENT '自定义1',
  `backup2` varchar(45) DEFAULT NULL COMMENT '自定义2',
  

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='配电网设备信息关系表';


DROP TABLE IF EXISTS `power_produce_device`;
CREATE TABLE `power_produce_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NOT NULL COMMENT '变配电站ID',
  `substation_name` varchar(45) NOT NULL COMMENT '变配电站名称',
  `device` varchar(45) DEFAULT NULL COMMENT '所属设备',
  `device_category` varchar(45) DEFAULT NULL COMMENT '设备种类',
  `device_name` varchar(45) DEFAULT NULL COMMENT '设备名称',
  `account_number` varchar(45) DEFAULT NULL COMMENT '台账编号',
  `nameplate_info` varchar(45) DEFAULT NULL COMMENT '铭牌信息',
  `production_info` varchar(45) DEFAULT NULL COMMENT '生产信息',
  `specific` varchar(45) DEFAULT NULL COMMENT '型号规格',
  `quantity` varchar(45) DEFAULT NULL COMMENT '数量',
  `factory_number` varchar(45) DEFAULT NULL COMMENT '出厂编号',
  `factory_date` varchar(45) DEFAULT NULL COMMENT '出厂日期',
  `operation_date` varchar(45) DEFAULT NULL COMMENT '投运日期',
  `comment` varchar(2000) DEFAULT NULL COMMENT '备注',
  `backup1` varchar(45) DEFAULT NULL COMMENT '自定义1',
  `backup2` varchar(45) DEFAULT NULL COMMENT '自定义2',
  

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='分布式发电设备信息关系表';


DROP TABLE IF EXISTS `power_consume_device`;
CREATE TABLE `power_consume_device` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NOT NULL COMMENT '变配电站ID',
  `substation_name` varchar(45) NOT NULL COMMENT '变配电站名称',
  `device` varchar(45) DEFAULT NULL COMMENT '所属设备',
  `device_category` varchar(45) DEFAULT NULL COMMENT '设备种类',
  `device_name` varchar(45) DEFAULT NULL COMMENT '设备名称',
  `account_number` varchar(45) DEFAULT NULL COMMENT '台账编号',
  `nameplate_info` varchar(45) DEFAULT NULL COMMENT '铭牌信息',
  `production_info` varchar(45) DEFAULT NULL COMMENT '生产信息',
  `specific` varchar(45) DEFAULT NULL COMMENT '型号规格',
  `quantity` varchar(45) DEFAULT NULL COMMENT '数量',
  `factory_number` varchar(45) DEFAULT NULL COMMENT '出厂编号',
  `factory_date` varchar(45) DEFAULT NULL COMMENT '出厂日期',
  `operation_date` varchar(45) DEFAULT NULL COMMENT '投运日期',
  `comment` varchar(2000) DEFAULT NULL COMMENT '备注',
  `backup1` varchar(45) DEFAULT NULL COMMENT '自定义1',
  `backup2` varchar(45) DEFAULT NULL COMMENT '自定义2',
  

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='用电设备信息关系表';