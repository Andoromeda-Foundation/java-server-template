ALTER TABLE `plc_metric_parsed`
CHANGE COLUMN `l1_la` `l1_Ia` DECIMAL(20,4) NULL DEFAULT NULL COMMENT '电流(A)' ,
CHANGE COLUMN `l1_lb` `l1_Ib` DECIMAL(20,4) NULL DEFAULT NULL COMMENT '电流(A)' ,
CHANGE COLUMN `l1_lc` `l1_Ic` DECIMAL(20,4) NULL DEFAULT NULL COMMENT '电流(A)' ,
CHANGE COLUMN `l2_la` `l2_Ia` DECIMAL(20,4) NULL DEFAULT NULL ,
CHANGE COLUMN `l2_lb` `l2_Ib` DECIMAL(20,4) NULL DEFAULT NULL ,
CHANGE COLUMN `l2_lc` `l2_Ic` DECIMAL(20,4) NULL DEFAULT NULL ,
ADD COLUMN `l2_4_5_3_Uab` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_W` ,
ADD COLUMN `l2_4_5_3_Ubc` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_3_Uab` ,
ADD COLUMN `l2_4_5_3_Uca` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_3_Ubc` ,
ADD COLUMN `l2_4_5_3_Ia` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_3_Uca` ,
ADD COLUMN `l2_4_5_3_Ib` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_3_Ia` ,
ADD COLUMN `l2_4_5_3_Ic` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_3_Ib` ,
ADD COLUMN `l2_4_5_4_F` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_3_Ic` ,
ADD COLUMN `l2_4_5_4_PF` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_4_F` ,
ADD COLUMN `l2_4_5_4_P` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_4_PF` ,
ADD COLUMN `l2_4_5_4_Q` DECIMAL(20,4) NULL DEFAULT NULL AFTER `l2_4_5_4_P` ;