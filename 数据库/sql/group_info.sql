CREATE TABLE `rbac`.`T_SFC_GROUPINFO`  (
  `GROUPID` varchar(80) NOT NULL,
  `GROUPNAME` varchar(30) NOT NULL,
  `GROUPTYPEID` varchar(60) NOT NULL,
  `GROUPCODE` varchar(60) NOT NULL,
  `SUPERGROUPCODE` varchar(100),
  `VALIDSTART` datetime,
  `VALIDEND` datetime,
  `GROUPDESC` varchar(1000),
  `CITYID` varchar(200),
  PRIMARY KEY (`GROUPID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;