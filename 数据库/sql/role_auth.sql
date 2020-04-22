CREATE TABLE `rbac`.`T_SFC_ROLEAUTH`  (
  `ROLEID` varchar(30) NOT NULL,
  `MODULEID` varchar(60) NOT NULL,
  `AUTHID` varchar(80),
  `CONDITIONSTR` varchar(500),
  PRIMARY KEY (`ROLEID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;