CREATE TABLE `rbac`.`T_SFC_STAFFPASSWORD`  (
  `STAFFID` varchar(20) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `VALIDSTART` datetime,
  `VALIDEND` datetime,
  PRIMARY KEY (`STAFFID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;