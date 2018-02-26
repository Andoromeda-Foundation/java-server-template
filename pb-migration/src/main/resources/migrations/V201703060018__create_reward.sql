DROP TABLE IF EXISTS `reward`;
CREATE TABLE `reward` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(45) DEFAULT NULL COMMENT '任务名称',
  `customer_id` bigint NULL COMMENT 'ID',
  `process_instance_id` varchar(45) DEFAULT NULL COMMENT '流程实例id',
  `assigned` tinyint(1) NULL COMMENT '是否指定工程师',
  `engineer_id` varchar(45) DEFAULT NULL COMMENT '工程师ID',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='工作任务';