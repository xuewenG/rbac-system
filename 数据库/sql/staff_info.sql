CREATE TABLE `rbac`.`T_SFC_STAFFINFO`  (
  `STAFFID` varchar(20) NOT NULL,
  `STAFFNAME` varchar(100) NOT NULL,
  `STAFFSTATE` varchar(2) NOT NULL,
  `STAFFIDSTATUS` varchar(2) NOT NULL,
  `DLEVELID` varchar(20),
  `DLMODULUS` double(4, 2),
  `SECONDPOST` varchar(20),
  `DUTYID` varchar(20),
  `SECONDDUTY` varchar(20),
  `ORGAID` varchar(20) NOT NULL,
  `POSTID` varchar(20),
  `STAFFACCOUNT` varchar(20),
  `DISABLEBEGINDATE` datetime,
  `DISABLEENDDATE` datetime,
  `UPDATETIME` datetime,
  `BATCHNO` varchar(30),
  `WORKEFFICIENCY` int(8),
  `PETNAME` varchar(100) NOT NULL,
  PRIMARY KEY (`STAFFID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;