--
-- Table structure for table `ctm_bss_customer`
--

DROP TABLE IF EXISTS `ctm_bss_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctm_bss_customer` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`name` varchar(45) NOT NULL COMMENT '客户名称',
	`customer_no` varchar(45) NOT NULL COMMENT '客户号',
	`address` varchar(45) DEFAULT NULL COMMENT '地址',
	`regist_capital` varchar(45) DEFAULT NULL COMMENT '注册资本',
	`corporate_represent` varchar(45) DEFAULT NULL COMMENT '法人代表',
	`industry_category` varchar(45) DEFAULT NULL COMMENT '行业分类',
	`main_business` varchar(45) DEFAULT NULL COMMENT '主要业务',
	`main_product` varchar(45) DEFAULT NULL COMMENT '主要产品',
	`product_capability` varchar(45) DEFAULT NULL COMMENT '产品能力',
	`upstream_product` varchar(45) DEFAULT NULL COMMENT '上游产品',
	`downstream_industry` varchar(45) DEFAULT NULL COMMENT '下游产业',
	`competent_department` varchar(45) DEFAULT NULL COMMENT '主管部门',
	`production_shift` varchar(45) DEFAULT NULL COMMENT '生产班次',
	`elect_supervisor` varchar(45) DEFAULT NULL COMMENT '电气主管',
	`elect_supervisor_mobile` varchar(45) DEFAULT NULL COMMENT '电气主管手机',
	`employee_count` varchar(45) DEFAULT NULL COMMENT '公司人数',
	`contract_no` varchar(45) DEFAULT NULL COMMENT '服务合同号',
	`contract_subject` varchar(45) DEFAULT NULL COMMENT '合同标的',
	`service_item` varchar(45) DEFAULT NULL COMMENT '服务项目',
	`service_content` varchar(45) DEFAULT NULL COMMENT '服务内容',
	`service_level` varchar(45) DEFAULT NULL COMMENT '服务等级',
	`account_manager` varchar(45) DEFAULT NULL COMMENT '客户经理',
	`employee_id` bigint(20) DEFAULT NULL COMMENT '公司负责人',
	`account_manager_job` varchar(45) DEFAULT NULL COMMENT '客户经理职务',
	`account_manager_telephone` varchar(45) DEFAULT NULL COMMENT '客户经理联系电话',
	`account_manager_mobile` varchar(45) DEFAULT NULL COMMENT '客户经理手机',
	`account_manager_hobby` varchar(45) DEFAULT NULL COMMENT '客户经理爱好',
	`account_manager_character` varchar(45) DEFAULT NULL COMMENT '客户经理性格类型',
	`account_manager_address` varchar(45) DEFAULT NULL COMMENT '客户经理住址',
	`elect_category` varchar(45) DEFAULT NULL COMMENT '用电分类',
	`structure_area` varchar(45) DEFAULT NULL COMMENT '建筑面积',
	`elect_price_attr` varchar(45) DEFAULT NULL COMMENT '电价属性',
	`supply_capacity` varchar(45) DEFAULT NULL COMMENT '供电容量',
	`supply_circuit` varchar(45) DEFAULT NULL COMMENT '供电回路',
	`service_area` varchar(45) DEFAULT NULL COMMENT '服务片区',
	`supply_voltage` varchar(45) DEFAULT NULL COMMENT '供电电压',
	`supply_unit` varchar(45) DEFAULT NULL COMMENT '供电单位',
	`use_self` tinyint(1) DEFAULT NULL COMMENT '是否自用',
	`resale_number` int(11) DEFAULT NULL COMMENT '转售户数',
	`resale_relationship` varchar(45) DEFAULT NULL COMMENT '转售关系',
	`resale_property` varchar(45) DEFAULT NULL COMMENT '转售用电性质',
	`resale_elect_capacity` varchar(45) DEFAULT NULL COMMENT '转售用电容量',
	`customer_focus` varchar(45) DEFAULT NULL COMMENT '客户关注',
	`create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
	`create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
	`update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`active` tinyint(1) NOT NULL DEFAULT '1' COMMENT '激活标记',
	`deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
	`delete_by` bigint(20) DEFAULT NULL COMMENT '删除者',
	`delete_at` timestamp NULL DEFAULT NULL COMMENT '删除时间',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctm_bss_customer`
--

LOCK TABLES `ctm_bss_customer` WRITE;
/*!40000 ALTER TABLE `ctm_bss_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctm_bss_customer` ENABLE KEYS */;
UNLOCK TABLES;
