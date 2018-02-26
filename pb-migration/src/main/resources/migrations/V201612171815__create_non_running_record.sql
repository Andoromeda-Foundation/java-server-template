UPDATE sidebars set link='running/batteryInspection' WHERE link='running/batteryInspections';
UPDATE sidebars set link='running/arresterAction' WHERE link='running/arresterActions';
UPDATE sidebars set link='running/protectionDeviceAction' WHERE link='running/protectionDeviceActions';

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('设备非运行状态记录', 'running/nonRunningRecord', '3');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('解锁钥匙使用记录', 'running/unlockKeyRecord', '3');

DROP TABLE IF EXISTS `non_running_record`;
CREATE TABLE `non_running_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `device_name` varchar(45) DEFAULT NULL COMMENT '装置',
  `down_reason` varchar(45) DEFAULT NULL COMMENT '原因',
  `down_duty` varchar(45) DEFAULT NULL COMMENT '责任',
  `down_start` timestamp NULL COMMENT '非运行状态始时',
  `down_end` timestamp NULL COMMENT '非运行状态终时',
  `termination_order` varchar(45) DEFAULT NULL COMMENT '非运行状态终止令',
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
) COMMENT='日常非运行状态记录';


DROP TABLE IF EXISTS `unlock_key_record`;
CREATE TABLE `unlock_key_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `device_name` varchar(45) DEFAULT NULL COMMENT '解锁设备',
  `use_time` timestamp NULL COMMENT '使用时间',
  `use_person` varchar(45) DEFAULT NULL COMMENT '使用人',
  `use_reason` varchar(45) DEFAULT NULL COMMENT '使用原因',
  `approved_person` varchar(45) DEFAULT NULL COMMENT '批准人',
  `return_time` timestamp NULL COMMENT '归还时间',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='解锁钥匙使用记录';