
update power_broker.navs set link = '/bss/electricalTestings' where `id` = 6 ;

INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('试验查询', 'electricalTestings', '6');
INSERT INTO `power_broker`.`sidebars` (`name`, `link`, `nav_id`) VALUES ('试验报告分析', 'electricalTestings', '6');
