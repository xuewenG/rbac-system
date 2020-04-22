CREATE TABLE `rbac`.`T_SFC_GROUPSTAFF`  (
  `GROUPID` varchar(80) NOT NULL,
  `STAFFID` varchar(20) NOT NULL,
  `ISPRINCIPAL` varchar(1),
  `BASEGROUPID` varchar(20),
  PRIMARY KEY (`GROUPID`, `STAFFID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;