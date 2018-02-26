CREATE TABLE `power_broker`.`gps_accounts` (
  `id`        BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name`      VARCHAR(20) NOT NULL,
  `password`  VARCHAR(20) NULL,
  `create_by` BIGINT(20)           DEFAULT NULL,
  `create_at` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT 'CURRENT_TIMESTAMP',
  `update_by` BIGINT(20)           DEFAULT NULL,
  `update_at` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by` BIGINT(20)           DEFAULT NULL,
  `delete_at` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active`    TINYINT(1)  NOT NULL DEFAULT '1',
  `deleted`   TINYINT(1)  NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `power_broker`.`gpses` (
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `imei`           VARCHAR(45) NOT NULL,
  `access_token`   VARCHAR(100) NULL,
  `expires_in`     BIGINT(20)  NULL,
  `gps_account_id` BIGINT(20)  NULL,
  `create_by`      BIGINT(20)           DEFAULT NULL,
  `create_at`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT 'CURRENT_TIMESTAMP',
  `update_by`      BIGINT(20)           DEFAULT NULL,
  `update_at`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_by`      BIGINT(20)           DEFAULT NULL,
  `delete_at`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active`         TINYINT(1)  NOT NULL DEFAULT '1',
  `deleted`        TINYINT(1)  NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;