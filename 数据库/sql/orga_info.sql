CREATE TABLE `rbac`.`T_SFC_ORGAINFO`  (
  `ORGAID` varchar(20) NOT NULL,
  `ORGANAME` varchar(200),
  `ORGATYPEID` varchar(20),
  `ORGASTATE` varchar(2),
  `CITYFLAG` varchar(128),
  `ORGACODE` varchar(60),
  `SUPERORGACODE` varchar(60),
  `ORGADESC` varchar(200),
  `AREACODE` varchar(10),
  `SUPERVISORIDS` varchar(500),
  `ORDERNUM` int(8),
  `UPDATETIME` datetime,
  PRIMARY KEY (`ORGAID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;