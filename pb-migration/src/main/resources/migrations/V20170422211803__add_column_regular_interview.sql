ALTER TABLE `power_broker`.`regular_interview_plans` 
ADD COLUMN `power_station_id` BIGINT(20) NULL AFTER `id`;

ALTER TABLE `power_broker`.`patrols`
  CHANGE COLUMN `fixed_date` `fixed_date` DATE NULL DEFAULT NULL COMMENT '固定日期' ,
  ADD COLUMN `duty_department_id` BIGINT(20) NULL AFTER `device_category`;

