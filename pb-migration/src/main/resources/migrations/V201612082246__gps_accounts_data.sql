/*
-- Query: SELECT * FROM power_broker.gps_accounts
LIMIT 0, 50

-- Date: 2016-12-08 22:46
*/
INSERT INTO `gps_accounts` (`id`,`name`,`password`,`create_by`,`create_at`,`update_by`,`update_at`,`delete_by`,`delete_at`,`active`,`deleted`) VALUES (1,'15618659798','qwer1234',NULL,'2016-12-08 22:08:11',NULL,'2016-12-08 22:22:48',NULL,'2016-12-08 22:08:11',1,0);
INSERT INTO `gps_accounts` (`id`,`name`,`password`,`create_by`,`create_at`,`update_by`,`update_at`,`delete_by`,`delete_at`,`active`,`deleted`) VALUES (2,'13482151117','qwer1234',NULL,'2016-12-08 22:08:49',NULL,'2016-12-08 22:22:48',NULL,'2016-12-08 22:08:49',1,0);

INSERT INTO `gpses` (`id`,`imei`,`access_token`,`expires_in`,`gps_account_id`,`create_by`,`create_at`,`update_by`,`update_at`,`delete_by`,`delete_at`,`active`,`deleted`) VALUES (1,'868120151022032',NULL,NULL,1,NULL,'2016-12-08 22:10:03',NULL,'2016-12-08 22:22:24',NULL,'2016-12-08 22:10:03',1,0);
INSERT INTO `gpses` (`id`,`imei`,`access_token`,`expires_in`,`gps_account_id`,`create_by`,`create_at`,`update_by`,`update_at`,`delete_by`,`delete_at`,`active`,`deleted`) VALUES (2,'868120150259247',NULL,NULL,2,NULL,'2016-12-08 22:10:03',NULL,'2016-12-08 22:22:24',NULL,'2016-12-08 22:10:03',1,0);
INSERT INTO `gpses` (`id`,`imei`,`access_token`,`expires_in`,`gps_account_id`,`create_by`,`create_at`,`update_by`,`update_at`,`delete_by`,`delete_at`,`active`,`deleted`) VALUES (3,'868120152734858',NULL,NULL,2,NULL,'2016-12-08 22:10:03',NULL,'2016-12-08 22:22:24',NULL,'2016-12-08 22:10:03',1,0);
