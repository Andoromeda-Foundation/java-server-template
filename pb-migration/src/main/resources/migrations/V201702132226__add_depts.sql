CREATE TABLE `depts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `phonetic` varchar(100) DEFAULT NULL,
  `enterprise_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` bigint(20) DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` bigint(20) DEFAULT NULL,
  `delete_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) DEFAULT '1',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `power_broker`.`depts` (`name`) VALUES ('行政管理部');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('技术支持部');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('工程部');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('市场发展部');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('安全运行部');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('青浦、嘉定分公司');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('闵行、松江分公司');
INSERT INTO `power_broker`.`depts` (`name`) VALUES ('金山分公司');
INSERT INTO `power_broker`.`depts` (`name`, `parent_id`) VALUES ('人事、行政助理', '1');

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('部门信息', 'admin/depts', 10);