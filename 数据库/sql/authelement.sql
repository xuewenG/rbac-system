CREATE TABLE `rbac`.`T_SFC_AUTHELEMENT`  (
  `AUTHID` varchar(80) NOT NULL,
  `MODULEID` varchar(30) NOT NULL,
  `AUTHCODE` varchar(60) NOT NULL,
  `SUPERCODE` varchar(60) NOT NULL,
  `AUTHNAME` varchar(100) NOT NULL,
  `MENUFLAG` varchar(1) NOT NULL,
  `DESCRIPTION` varchar(100),
  PRIMARY KEY (`AUTHID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;