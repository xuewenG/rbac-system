CREATE TABLE `rbac`.`T_SFC_MENU`  (
  `MODULEID` varchar(20) NOT NULL,
  `MENUID` varchar(60) NOT NULL,
  `PARENTID` varchar(60) NOT NULL,
  `IMAGEURL` varchar(100),
  `MENUNAME` varchar(50) NOT NULL,
  `MENUDESCRIPTION` varchar(500),
  `MENUURL` varchar(500),
  `DISPLAYNO` int(5) NOT NULL,
  `OPENMODULE` varchar(2) NOT NULL,
  `AUTHID` varchar(80) NOT NULL,
  `FASTKEY` varchar(100),
  `ISHIDDEN` varchar(2) NOT NULL,
  `SERVICEID` varchar(20),
  `ISDISPLAY` varchar(2) NOT NULL,
  `CALLBACK` varchar(20),
  `DISPLAYTYPE` varchar(2),
  `DYFIELD1` varchar(100),
  `DYFIELD2` varchar(100),
  `DYFIELD3` varchar(100),
  `DYFIELD4` varchar(100),
  `DYFIELD5` varchar(100),
  `CLICKTOTAL` int(11),
  PRIMARY KEY (`MENUID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;