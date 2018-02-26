UPDATE `navs` SET `link`='/bss/defect' WHERE `id`='4';
INSERT INTO `sidebars` (`name`, `link`, `nav_id`) VALUES ('缺陷记录管理', 'defect/defectRecord', '4');

DROP TABLE IF EXISTS `defect_record`;
CREATE TABLE `defect_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `source` varchar(45) DEFAULT NULL COMMENT '缺陷来源',
  `primary_device` varchar(45) DEFAULT NULL COMMENT '缺陷主设备',
  `device_attachment` varchar(45) DEFAULT NULL COMMENT '设备附件',
  `nature` varchar(45) DEFAULT NULL COMMENT '缺陷性质',
  `content` varchar(200) DEFAULT NULL COMMENT '缺陷内容',
  `discoverer` varchar(45) DEFAULT NULL COMMENT '发现人',
  `discovery_date` timestamp NULL COMMENT '发现日期',
  `liability_cause` varchar(45) DEFAULT NULL COMMENT '责任原因',
  `technical_reason` varchar(45) DEFAULT NULL COMMENT '技术原因',
  `handle_suggestion` varchar(45) DEFAULT NULL COMMENT '处理建议',
  `image` varchar(45) DEFAULT NULL COMMENT '缺陷图片',
  `plan_dispose_date` timestamp NULL COMMENT '计划消缺到期时间',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='缺陷记录';