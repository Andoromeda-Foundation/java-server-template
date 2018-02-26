CREATE TABLE `reward_score` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  `process_instance_id` varchar(45) DEFAULT NULL COMMENT '流程实例id',
  `ctx` text DEFAULT NULL COMMENT '内容',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active` tinyint(1) NOT NULL DEFAULT '1' COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `delete_by` bigint(20) DEFAULT NULL COMMENT '删除者',
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='工作任务-表计读取';

CREATE TABLE `reward_fault` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  `process_instance_id` varchar(45) DEFAULT NULL COMMENT '流程实例id',
  `ctx` text DEFAULT NULL COMMENT '内容',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active` tinyint(1) NOT NULL DEFAULT '1' COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `delete_by` bigint(20) DEFAULT NULL COMMENT '删除者',
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='工作任务-故障';

CREATE TABLE `reward_patrol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  `process_instance_id` varchar(45) DEFAULT NULL COMMENT '流程实例id',
  `ctx` text DEFAULT NULL COMMENT '内容',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active` tinyint(1) NOT NULL DEFAULT '1' COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  `delete_by` bigint(20) DEFAULT NULL COMMENT '删除者',
  `delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='工作任务-设备巡视';