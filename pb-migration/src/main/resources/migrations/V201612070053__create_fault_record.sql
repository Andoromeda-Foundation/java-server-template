UPDATE `power_broker`.`navs` SET `link`='/bss/running' WHERE `id`='3';
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('故障记录', 'running/faultRecords', '3');

DROP TABLE IF EXISTS `fault_record`;
CREATE TABLE `fault_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站',
  `fault_device` varchar(45) DEFAULT NULL COMMENT '故障设备',
  `appearance` varchar(45) DEFAULT NULL COMMENT '故障现象',
  `repair_date` timestamp NULL COMMENT '抢修日期',
  `repair_duration` varchar(45) DEFAULT NULL COMMENT '抢修时间',
  `recovery_date` timestamp NULL COMMENT '恢复送电时间',
  `duty_employee` varchar(45) DEFAULT NULL COMMENT '抢修负责人',
  `arrive_date` timestamp NULL COMMENT '到达时间',
  `isolation_date` timestamp NULL COMMENT '故障隔离时间',
  `repair_employee` varchar(45) DEFAULT NULL COMMENT '抢修人员',
  `area` varchar(45) DEFAULT NULL COMMENT '服务片区',
  `technology_reason` varchar(45) DEFAULT NULL COMMENT '故障原因（设备技术方面）',
  `device_reason` varchar(45) DEFAULT NULL COMMENT '故障原因（设备范围）',
  `desc` varchar(45) DEFAULT NULL COMMENT '修复内容及工程队（文字描述）',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='故障记录表';