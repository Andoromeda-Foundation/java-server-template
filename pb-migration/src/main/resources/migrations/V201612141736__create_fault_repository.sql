INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('故障知识库', 'running/faultRepositories', '3');

DROP TABLE IF EXISTS `fault_repository`;
CREATE TABLE `fault_repository` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `appearance` varchar(45) DEFAULT NULL COMMENT '故障现象',
  `fault_device` varchar(45) DEFAULT NULL COMMENT '可能故障设备',
  `fault_reason` varchar(45) DEFAULT NULL COMMENT '可能故障原因',
  `isolation_mode` varchar(45) DEFAULT NULL COMMENT '故障隔离方式',
  `isolation_reference` varchar(45) DEFAULT NULL COMMENT '故障修复参考方案',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='故障知识库（判断，隔离，更新参数）';