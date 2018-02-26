INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('日常蓄电池检查记录', 'running/batteryInspections', '3');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('日常避雷针动作记录', 'running/arresterActions', '3');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('保护装置动作记录', 'running/protectionDeviceActions', '3');


DROP TABLE IF EXISTS `battery_inspection_record`;
CREATE TABLE `battery_inspection_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站',
  `battery_name` varchar(45) DEFAULT NULL COMMENT '蓄电池组名',
  `measure_time` timestamp NULL COMMENT '测量时间',
  `measure_man` varchar(45) DEFAULT NULL COMMENT '测量人',
  `check_man` varchar(45) DEFAULT NULL COMMENT '检查人',
  `battery_voltage` varchar(45) DEFAULT NULL COMMENT '电池电压',
  `control_bus_voltage` varchar(45) DEFAULT NULL COMMENT '控制母线电压',
  `charge_current` varchar(45) DEFAULT NULL COMMENT '充电电流',
  `battery_health` varchar(45) DEFAULT NULL COMMENT '蓄电池状况',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='日常蓄电池检查记录';

DROP TABLE IF EXISTS `arrester_action_record`;
CREATE TABLE `arrester_action_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `arrester_name` varchar(45) DEFAULT NULL COMMENT '避雷器名',
  `voltage` varchar(45) DEFAULT NULL COMMENT '电压',
  `action_times` varchar(45) DEFAULT NULL COMMENT '累计动作次数',
  `leakage_current` varchar(45) DEFAULT NULL COMMENT '泄漏电流',
  `check_man` varchar(45) DEFAULT NULL COMMENT '检查人',
  `check_date` timestamp NULL COMMENT '检查时间',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='日常避雷针动作记录';

DROP TABLE IF EXISTS `protection_device_working_record`;
CREATE TABLE `protection_device_working_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `device_name` varchar(45) DEFAULT NULL COMMENT '装置',
  `protection_function` varchar(45) DEFAULT NULL COMMENT '保护功能',
  `action_situation` varchar(45) DEFAULT NULL COMMENT '动作情况',
  `action_time` varchar(45) DEFAULT NULL COMMENT '动作时间',
  `action_reason` varchar(45) DEFAULT NULL COMMENT '动作原因',
  `description` varchar(45) DEFAULT NULL COMMENT '备注描述',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='自动保护设备工作记录';