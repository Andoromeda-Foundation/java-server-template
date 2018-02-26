DROP TABLE IF EXISTS `work_routines`;
CREATE TABLE `work_routines` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `power_station_id` BIGINT NULL COMMENT '所属变配电站',
  `area_id` BIGINT NULL COMMENT '所属片区',
  `routine_type_id` BIGINT NULL COMMENT '工作类型',
  `work_period` VARCHAR(200) NULL COMMENT '工作周期',
  `responsible_department_id` BIGINT NULL COMMENT '责任部门',
  `responsible_position` VARCHAR(200) NULL COMMENT '责任岗位',
  `responsible_area_id` BIGINT NULL COMMENT '责任片区',
  `work_content` VARCHAR(500) NULL COMMENT '工作内容',
  `work_requirement` VARCHAR(500) NULL COMMENT '工作要求',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`))
COMMENT = '例行工作维护';



DROP TABLE IF EXISTS `regular_interview_plans`;
CREATE TABLE `regular_interview_plans` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `area_id` BIGINT NULL COMMENT '所属片区',
  `interview_level_id` BIGINT NULL COMMENT '访谈级别',
  `interview_period` VARCHAR(200) NULL COMMENT '访谈周期',
  `responsible_department_id` BIGINT NULL COMMENT '责任部门',
  `responsible_position` VARCHAR(200) NULL COMMENT '责任岗位',
  `customer_name` VARCHAR(200) NULL COMMENT '客户名',
  `interview_project_id` BIGINT NULL COMMENT '访谈项目',


    `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`))
COMMENT = '定期客户上门访谈安排';


DROP TABLE IF EXISTS `regular_evaluations`;
CREATE TABLE `regular_evaluations` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `evaluation_project` VARCHAR(200) NULL COMMENT '考核项目',
  `evaluation_content` TEXT NULL COMMENT '考核内容',
  `evaluation_period` VARCHAR(200)  NULL COMMENT '考核周期',
  `evaluation_subject` VARCHAR(200) NULL COMMENT '考核对象',
  `evaluator` VARCHAR(45) NULL COMMENT '考核人',

     `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`))
COMMENT = '定期工作考核评价表';



DROP TABLE IF EXISTS `regular_meeting_plans`;
CREATE TABLE `regular_meeting_plans` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `meeting_name` VARCHAR(200) NULL COMMENT '例会名称',
  `meeting_period` VARCHAR(200) NULL COMMENT '例会周期',
  `main_content` TEXT NULL COMMENT '主要内容',
  `sponsor` VARCHAR(200) NULL COMMENT '召集人',

   `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`))
COMMENT = '变配电站定期例会安排表';



DROP TABLE IF EXISTS `regular_demand_declare_plans`;
CREATE TABLE `regular_demand_declare_plans` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(200) NULL COMMENT '客户名',
  `power_station_id` BIGINT NULL COMMENT '配电站名',
  `distribution_transformer_id` BIGINT NULL COMMENT '归属配变号',
  `declare_date` TIMESTAMP NULL COMMENT '申报日期',
  `declare_change_period` BIGINT NULL COMMENT '申改周期',
  `responsible_department_id` BIGINT NULL COMMENT '责任部门',
  `responsible_position` VARCHAR(200) NULL COMMENT '责任岗位',
  `responsible_area_id` BIGINT NULL COMMENT '责任片区',
  `previous_month_demand` VARCHAR(200) NULL COMMENT '上月需量',
  `previous_year_demand` VARCHAR(200) NULL COMMENT '上年需量',
  `previous_month_dispersion` VARCHAR(200) NULL COMMENT '上月差量',
  `previous_year_dispersion` VARCHAR(200) NULL COMMENT '上年差量',
  `declare_demand` VARCHAR(200) NULL COMMENT '本次申报量',
  `distribution_transform_capacity` VARCHAR(200) NULL COMMENT '配变容量',

      `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`))
COMMENT = '变配电站定期契约需量申报安排表';


DROP TABLE IF EXISTS `substation_onduty_groups`;
CREATE TABLE `substation_onduty_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NOT NULL COMMENT '变配电站ID',
  `customer_name` varchar(45) NULL COMMENT '客户名称',
  `substation_name` varchar(45) NULL COMMENT '变配电站名称',
  `duty_department` varchar(45) NULL COMMENT '责任部门',
  `group_name` varchar(45) NULL COMMENT '班组名称',
  `duty_man` varchar(45) NULL COMMENT '负责人',
  `evaluation_content` varchar(200) NULL COMMENT '考核内容',
  `remark` varchar(2000) NULL COMMENT '备注',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='值守站运行班组岗位配置表';



DROP TABLE IF EXISTS `rel_onduty_group_employees`;
CREATE TABLE `rel_onduty_group_employees` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `onduty_group_id` bigint NOT NULL COMMENT '值守班组ID',
  `employee_id` bigint NOT NULL COMMENT '员工ID',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='值守站运行班组成人员关系表';


DROP TABLE IF EXISTS `patrols`;
CREATE TABLE `patrols` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NULL COMMENT '变配电站ID',
  `customer_name` varchar(45) NULL COMMENT '客户名称',
  `substation_name` varchar(45) NULL COMMENT '变配电站名称',
  `device_category` varchar(45) NULL COMMENT '设备种类',
  `duty_department` varchar(45) NULL COMMENT '责任部门',
  `duty_post` varchar(45) NULL COMMENT '责任岗位',
  `patrol_category` varchar(45) NULL COMMENT '巡视类别',
  `patrol_cycle` varchar(45) NULL COMMENT '巡视周期',
  `fixed_date` varchar(45) NULL COMMENT '固定日期',
  `area` varchar(45) NULL COMMENT '所属片区',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='巡视设置表';


DROP TABLE IF EXISTS `power_cuts`;
CREATE TABLE `power_cuts` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint NULL COMMENT '变配电站ID',
  `customer_name` varchar(45) NULL COMMENT '客户名称',
  `substation_name` varchar(45) NULL COMMENT '变配电站名称',
  `transformer_no` varchar(45)  NULL COMMENT '停电变配编号',
  `supply_line_no` varchar(45)  NULL COMMENT '停电供电线路号',
  `feed_line_no` varchar(45)  NULL COMMENT '停电馈电线路号',
  `power_cut_category` varchar(45)  NULL COMMENT '停电类型',
  `start_time` varchar(45)  NULL COMMENT '停电开始时间',
  `end_time` varchar(45)  NULL COMMENT '停电终止时间',
  `outage_load` varchar(45)  NULL COMMENT '停电前负荷',
  `power_saving` varchar(45)  NULL COMMENT '停电少用电量',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='停电信息表';

DROP TABLE IF EXISTS `running_modes`;
CREATE TABLE `running_modes` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `substation_id` bigint  NULL COMMENT '变配电站ID',
  `customer_name` varchar(45) NULL COMMENT '客户名称',
  `substation_name` varchar(45) NULL COMMENT '变配电站名称',
  `area` varchar(45)  NULL COMMENT '所属片区',

  `high_voltage_inline_mode` varchar(45)  NULL COMMENT '高压进线方式',
  `high_voltage_inline_name` varchar(45)  NULL COMMENT '高压进线线路名',
  `high_voltage_busline_name` varchar(45)  NULL COMMENT '高压母线接线方式',
  `high_voltage` varchar(45)  NULL COMMENT '高压受电电压',
  `low_voltage_busline` varchar(45)  NULL COMMENT '低压母线接线方式',
  `generator_connecting_voltage` VARCHAR(200) NULL COMMENT '发电机接入电压',
  `generator_connecting_mode` BIGINT NULL COMMENT '发电机接入方式',
  `grid_connection_point` VARCHAR(200) NULL COMMENT '发电并网点',
  `grid_connection_switch_number` VARCHAR(200) NULL COMMENT '发电并网开关编号',
  `low_voltage_outlet_circui_amount` VARCHAR(200) NULL COMMENT '低压出线回路数',
  `transformer_amount` VARCHAR(200) NULL COMMENT '变压器台数',
  `principle_connects_picture_url` VARCHAR(200) NULL COMMENT '原理接线图上传',

  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) COMMENT='运行方式表';


CREATE TABLE `power_broker`.`electrical_testings` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NULL COMMENT '客户名称',
  `power_station_id` VARCHAR(45) NULL COMMENT '变电站',
  `testing_time` TIMESTAMP NULL COMMENT '试验时间',
  `testing_period` VARCHAR(200) NULL COMMENT '试验周期',
  `tester` VARCHAR(200) NULL COMMENT '试验人',
  `environment_temperature` VARCHAR(200) NULL COMMENT '环境温度',
  `environment_humidity` VARCHAR(200) NULL COMMENT '环境湿度',
  `weather` VARCHAR(200) NULL COMMENT '天气',
  `testing_device` VARCHAR(200) NULL COMMENT '试验设备',
  `testing_project` VARCHAR(200) NULL COMMENT '试验项目',
  `testing_param` VARCHAR(200) NULL COMMENT '试验参数',
  `standard_param` VARCHAR(200) NULL COMMENT '标准参数',
  `conclusion` VARCHAR(200) NULL COMMENT '结论',
  `comment` TEXT NULL COMMENT '备注',

    `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint DEFAULT NULL COMMENT '更新者',
  `update_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `active`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '激活标记',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  `delete_by` bigint DEFAULT NULL COMMENT '删除者',
  `delete_at` TIMESTAMP NULL COMMENT '删除时间',
  PRIMARY KEY (`id`))
COMMENT = '电试试验';

