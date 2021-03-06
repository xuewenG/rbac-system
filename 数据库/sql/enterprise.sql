CREATE TABLE `T_SFC_ENTERPRISE` (
  `ENTERPRISEID` varchar(20) NOT NULL,
  `ENTERPRISENAME` varchar(255),
  `ENTERPRISEADDRESS` varchar(255),
  `LEGALREPRESENTATIVE` varchar(255),
  `REGISTEREDCAPITAL` varchar(255),
  `BUSINESSSCOPE` varchar(255),
  `BUSINESSQUALIFICATION` varchar(255),
  `NUMBEROFEMPLOYEES` varchar(11),
  `CORPORATEWEBSITE` varchar(255),
  `TELEPHONE` varchar(255),
  `LICENSEINFORMATION` varchar(255),
  PRIMARY KEY (`ENTERPRISEID`)
) CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;
