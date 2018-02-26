INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('变配电站电量参数', 'running/electricParameter', '3');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('变配电站非电量参数', 'running/nonElectricParameter', '3');

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('派工记录', 'running/dispatchRecord', '3');


DROP TABLE IF EXISTS `electric_parameter_record`;
CREATE TABLE `electric_parameter_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `is_electric` tinyint(1) NOT NULL COMMENT '是否电量参数',
  `env_humidity` varchar(45) DEFAULT NULL COMMENT '环境湿度',
  `env_temperature` varchar(45) DEFAULT NULL COMMENT '环境温度',
  `sf_pressure1` varchar(45) DEFAULT NULL COMMENT 'SF6压力1',
  `sf_pressure2` varchar(45) DEFAULT NULL COMMENT 'SF6压力2',
  `sf_pressure3` varchar(45) DEFAULT NULL COMMENT 'SF6压力3',
  `transformer_temperature1` varchar(45) DEFAULT NULL COMMENT '变压器温度1',
  `transformer_temperature2` varchar(45) DEFAULT NULL COMMENT '变压器温度2',
  `transformer_temperature3` varchar(45) DEFAULT NULL COMMENT '变压器温度3',
  `transformer_oil1` varchar(45) DEFAULT NULL COMMENT '变压器1油位',
  `transformer_oil2` varchar(45) DEFAULT NULL COMMENT '变压器2油位',
  `transformer_oil3` varchar(45) DEFAULT NULL COMMENT '变压器3油位',
  `switch_vacuum1` varchar(45) DEFAULT NULL COMMENT '开关1真空度',
  `switch_vacuum2` varchar(45) DEFAULT NULL COMMENT '开关2真空度',
  `switch_vacuum3` varchar(45) DEFAULT NULL COMMENT '开关3真空度',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='变配电站电量参数记录';


DROP TABLE IF EXISTS `dispatch_record`;
CREATE TABLE `dispatch_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `customer_name` varchar(45) DEFAULT NULL COMMENT '客户名称',
  `station_name` varchar(45) DEFAULT NULL COMMENT '变配电站名',
  `inspection_items` varchar(45) DEFAULT NULL COMMENT '巡视项目',
  `inspection_standards` varchar(45) DEFAULT NULL COMMENT '巡视标准',
  `inspection_confirmation` varchar(45) DEFAULT NULL COMMENT '巡视确认',
  `inspection_man` varchar(45) DEFAULT NULL COMMENT '巡视人',
  `inspection_date` timestamp NULL COMMENT '巡视日期',
  `inspection_situation` varchar(45) DEFAULT NULL COMMENT '巡视情况',
  `conclusion` varchar(45) DEFAULT NULL COMMENT '结论',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='巡视派工记录';