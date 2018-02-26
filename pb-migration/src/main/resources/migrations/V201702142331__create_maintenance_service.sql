UPDATE `navs` SET `link`='/bss/maintenance' WHERE `id`=5;
INSERT INTO `sidebars` (`name`, `link`, `nav_id`) VALUES ('维保服务管理', 'maintenance/maintenanceService', 5);

DROP TABLE IF EXISTS `maintenance_service`;
CREATE TABLE `maintenance_service` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `level` varchar(45) DEFAULT NULL COMMENT '维保等级',
  `project` varchar(45) DEFAULT NULL COMMENT '维保项目',
  `content` varchar(200) DEFAULT NULL COMMENT '维保内容',
  `standard` varchar(45) DEFAULT NULL COMMENT '维保标准',
  `power_cut` varchar(45) DEFAULT NULL COMMENT '维保停电',
  `cycle` varchar(45) DEFAULT NULL COMMENT '维保周期',
  `material` varchar(45) DEFAULT NULL COMMENT '维保材料',
  `ext_assist` tinyint(1) NULL DEFAULT 0 COMMENT '是否外协',
  `working_hours` varchar(45) DEFAULT NULL COMMENT '维保工时',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='设备维保服务';