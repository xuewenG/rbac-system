CREATE TABLE `rbac`.`T_SFC_ROLE`  (
  `ROLEID` varchar(20) NOT NULL,
  `ROLECODE` varchar(60) NOT NULL,
  `SUPERCODE` varchar(60) NOT NULL,
  `ROLENAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100),
  PRIMARY KEY (`ROLEID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;