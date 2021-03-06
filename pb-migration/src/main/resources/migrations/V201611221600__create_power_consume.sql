INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('客户耗电信息', 'maintain/powerConsumes', '2');

DROP TABLE IF EXISTS `bss_power_consume`;
CREATE TABLE `bss_power_consume` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_id` bigint NOT NULL COMMENT '客户ID',
  `main_business` varchar(45) DEFAULT NULL COMMENT '主要业务',
  `sec_business1` varchar(45) DEFAULT NULL COMMENT '次要业务1',
  `sec_business2` varchar(45) DEFAULT NULL COMMENT '次要业务2',
  `sec_business3` varchar(45) DEFAULT NULL COMMENT '次要业务3',
  `sec_business4` varchar(45) DEFAULT NULL COMMENT '次要业务4',
  `sec_business5` varchar(45) DEFAULT NULL COMMENT '次要业务5',
  `sec_business6` varchar(45) DEFAULT NULL COMMENT '次要业务6',
  `sec_business7` varchar(45) DEFAULT NULL COMMENT '次要业务7',
  `sec_business8` varchar(45) DEFAULT NULL COMMENT '次要业务8',
  `sec_business9` varchar(45) DEFAULT NULL COMMENT '次要业务9',
  `sec_business10` varchar(45) DEFAULT NULL COMMENT '次要业务10',
  `sec_business_summary` varchar(45) DEFAULT NULL COMMENT '次要业务合计',
  `summary_time` timestamp NULL COMMENT '统计时间',
  `all_business` varchar(45) DEFAULT NULL COMMENT '全部业务（成本占比、单耗）',
  `main_business_cost` varchar(45) DEFAULT NULL COMMENT '主要业务（成本、单耗）',
  `sec_business_cost1` varchar(45) DEFAULT NULL COMMENT '次要业务1（成本、单耗）',
  `sec_business_cost2` varchar(45) DEFAULT NULL COMMENT '次要业务2（成本、单耗）',
  `sec_business_cost3` varchar(45) DEFAULT NULL COMMENT '次要业务3（成本、单耗）',
  `sec_business_cost4` varchar(45) DEFAULT NULL COMMENT '次要业务4（成本、单耗）',
  `sec_business_cost5` varchar(45) DEFAULT NULL COMMENT '次要业务5（成本、单耗）',
  `sec_business_cost6` varchar(45) DEFAULT NULL COMMENT '次要业务6（成本、单耗）',
  `sec_business_cost7` varchar(45) DEFAULT NULL COMMENT '次要业务7（成本、单耗）',
  `sec_business_cost8` varchar(45) DEFAULT NULL COMMENT '次要业务8（成本、单耗）',
  `sec_business_cost9` varchar(45) DEFAULT NULL COMMENT '次要业务9（成本、单耗）',
  `sec_business_cost10` varchar(45) DEFAULT NULL COMMENT '次要业务10（成本、单耗）',
  `sec_business_cost_summary` varchar(45) DEFAULT NULL COMMENT '次要业务合计',
  `cost_summary_time` timestamp NULL COMMENT '统计时间',
  `demand1` varchar(45) DEFAULT NULL COMMENT '需求1',
  `demand2` varchar(45) DEFAULT NULL COMMENT '需求2',
  `demand3` varchar(45) DEFAULT NULL COMMENT '需求3',
  `demand4` varchar(45) DEFAULT NULL COMMENT '需求4',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='客户耗电信息表';