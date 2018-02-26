ALTER TABLE `defect_record`
  CHANGE COLUMN `delete_by` `delete_by` BIGINT(20) NULL DEFAULT NULL COMMENT '删除者' AFTER `update_at`,
  CHANGE COLUMN `delete_at` `delete_at` DATETIME NULL DEFAULT NULL COMMENT '删除时间' AFTER `delete_by`,
  CHANGE COLUMN `create_at` `create_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  CHANGE COLUMN `update_at` `update_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  CHANGE COLUMN `active` `active` TINYINT(1) NULL DEFAULT '1' COMMENT '激活标记' ,
  CHANGE COLUMN `deleted` `deleted` TINYINT(1) NULL DEFAULT '0' COMMENT '删除标记' ,
  ADD COLUMN `rfid_id` BIGINT(20) NULL DEFAULT NULL AFTER `id`;

CREATE TABLE `defects_documents` (
  `defect_id` bigint(20) NOT NULL,
  `document_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;