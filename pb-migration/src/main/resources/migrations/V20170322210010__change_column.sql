ALTER TABLE `power_broker`.`regular_demand_declare_plans`
  CHANGE COLUMN `declare_date` `declare_date` DATE NULL DEFAULT NULL COMMENT '申报日期' ;

ALTER TABLE `power_broker`.`regular_interview_plans`
  CHANGE COLUMN `area_id` `district` INT NULL DEFAULT NULL COMMENT '所属片区' ;
