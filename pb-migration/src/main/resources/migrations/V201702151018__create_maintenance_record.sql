INSERT INTO `sidebars` (`name`, `link`, `nav_id`) VALUES ('维保记录', 'maintenance/maintenanceRecord', 5);

DROP TABLE IF EXISTS `maintenance_record`;
CREATE TABLE `maintenance_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `time` varchar(45) DEFAULT NULL COMMENT '维保时间',
  `person_liable` varchar(45) DEFAULT NULL COMMENT '工作负责人',
  `work_staff` varchar(45) DEFAULT NULL COMMENT '工作人员',
  `work_content` varchar(45) DEFAULT NULL COMMENT '工作内容',
  `customer_acceptance` varchar(45) DEFAULT NULL COMMENT '客户验收',
  `change_facilities` varchar(45) DEFAULT NULL COMMENT '更动设施',
  `other_tips` varchar(45) DEFAULT NULL COMMENT '其他建议',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='维保记录表';