INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('例行工作', 'maintain/workRoutines', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('定期客户访谈', 'maintain/regularInterviews', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('工作考核', 'maintain/regularEvaluations', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('定期契约需量', 'maintain/regularDemandDeclarePlans', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('例会安排', 'maintain/regularMeetingPlans', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('运行班组岗位配置', 'maintain/substationOndutyGroups', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('巡视配置', 'maintain/patrols', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('供电停电信息维护', 'maintain/powerCuts', '2');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('运行方式维护', 'maintain/runningModes', '2');

update power_broker.navs set link = '/bss/report' where `id` = 7 ;

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('地图查询', 'report/map', '7');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('电站信息', 'report/powerStation', '7');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('员工任务', 'report/taskOverview', '7');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('客户信息', 'report', '7');

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('工时登录', 'attendance', '9');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('工时审核', 'attendance', '9');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('工时统计', 'attendance', '9');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('工时分析', 'attendance', '9');