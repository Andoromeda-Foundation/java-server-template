ALTER TABLE `plc_metric_metadatas`
ADD COLUMN `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;