CREATE TABLE `rbac`.`T_SFC_STAFFROLE`  (
  `ROLEID` varchar(20) NOT NULL,
  `STAFFID` varchar(20) NOT NULL,
  `CONDITIONSTR` varchar(100),
  PRIMARY KEY (`ROLEID`, `STAFFID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;