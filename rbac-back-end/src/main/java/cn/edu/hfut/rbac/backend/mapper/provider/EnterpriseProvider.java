package cn.edu.hfut.rbac.backend.mapper.provider;


import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.EnterpriseColumn;
import cn.edu.hfut.rbac.backend.entity.Enterprise;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.ibatis.jdbc.SQL;

public class EnterpriseProvider {
    public String selectBySearchWordProvider(String searchWord) {
        return new SQL() {
            {
                SELECT("*");
                FROM(TableName.ENTERPRISE);
                WHERE(EnterpriseColumn.ENTERPRISE_NAME + " like concat('%',#{searchWord},'%')");
            }
        }.toString();
    }

    public String addProvider(Enterprise enterprise) {
        return new SQL() {
            {
                INSERT_INTO(TableName.ENTERPRISE);
                INTO_COLUMNS(
                        EnterpriseColumn.ENTERPRISE_ID, EnterpriseColumn.ENTERPRISE_NAME,
                        EnterpriseColumn.ENTERPRISE_ADDRESS, EnterpriseColumn.LEGAL_REPRESENTATIVE,
                        EnterpriseColumn.REGISTERED_CAPITAL, EnterpriseColumn.BUSINESS_SCOPE,
                        EnterpriseColumn.BUSINESS_QUALIFICATION, EnterpriseColumn.NUMBER_OF_EMPLOYEES,
                        EnterpriseColumn.CORPORATE_WEBSITE, EnterpriseColumn.TELEPHONE,
                        EnterpriseColumn.LICENSE_INFORMATION
                );
                INTO_VALUES(
                        SqlUtil.value("enterpriseId"), SqlUtil.value("enterpriseName"),
                        SqlUtil.value("enterpriseAddress"), SqlUtil.value("legalRepresentative"),
                        SqlUtil.value("registeredCapital"), SqlUtil.value("businessScope"),
                        SqlUtil.value("businessQualification"), SqlUtil.value("numberOfEmployees"),
                        SqlUtil.value("corporateWebsite"), SqlUtil.value("telephone"),
                        SqlUtil.value("licenseInformation")
                );
            }
        }.toString();
    }

    public String deleteByIdProvider(String id) {
        return new SQL() {
            {
                DELETE_FROM(TableName.ENTERPRISE);
                WHERE(SqlUtil.isEqual(EnterpriseColumn.ENTERPRISE_ID, id));
            }
        }.toString();
    }

    public String editByIdProvider(Enterprise enterprise) {
        return new SQL() {
            {
                UPDATE(TableName.ENTERPRISE);
                SET(
                        SqlUtil.isEqual(EnterpriseColumn.ENTERPRISE_NAME, "enterpriseName"),
                        SqlUtil.isEqual(EnterpriseColumn.ENTERPRISE_ADDRESS, "enterpriseAddress"),
                        SqlUtil.isEqual(EnterpriseColumn.LEGAL_REPRESENTATIVE, "legalRepresentative"),
                        SqlUtil.isEqual(EnterpriseColumn.REGISTERED_CAPITAL, "registeredCapital"),
                        SqlUtil.isEqual(EnterpriseColumn.BUSINESS_SCOPE, "businessScope"),
                        SqlUtil.isEqual(EnterpriseColumn.BUSINESS_QUALIFICATION,"businessQualification"),
                        SqlUtil.isEqual(EnterpriseColumn.NUMBER_OF_EMPLOYEES, "numberOfEmployees"),
                        SqlUtil.isEqual(EnterpriseColumn.CORPORATE_WEBSITE, "corporateWebsite"),
                        SqlUtil.isEqual(EnterpriseColumn.TELEPHONE, "telephone"),
                        SqlUtil.isEqual(EnterpriseColumn.LICENSE_INFORMATION, "licenseInformation")
                );
                WHERE(SqlUtil.isEqual(EnterpriseColumn.ENTERPRISE_ID,"enterpriseId"));
            }
        }.toString();
    }

    public String selectEnterpriseNameByEnterpriseIdProvider(String enterpriseId){
        return new SQL(){{
            SELECT(EnterpriseColumn.ENTERPRISE_NAME);
            FROM(TableName.ENTERPRISE);
            WHERE(String.format("%s = #{enterpriseId}", EnterpriseColumn.ENTERPRISE_ID));
        }}.toString();
    }
}
