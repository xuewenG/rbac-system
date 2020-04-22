package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.EnterpriseColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.OrganizationColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffInfoColumn;
import cn.edu.hfut.rbac.backend.entity.Organization;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class OrganizationProvider {
    /**
     * 根据组织机构编号，获取组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/2
     */
    public String selectByOrganizationNameProvider(String organizationName) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.ORGANIZATION);
            if (StringUtils.isNotBlank(organizationName)) {
                WHERE(OrganizationColumn.ORGANIZATION_NAME + " like concat('%', #{organizationName}, '%')");
            }
        }}.toString();
    }

    public String selectByOrganizationIdProvider(String organizationId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.ORGANIZATION);
            WHERE(SqlUtil.isEqual(OrganizationColumn.ORGANIZATION_ID, "organizationId"));
        }}.toString();
    }

    /**
     * 根据组织机构编号，删除组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/3
     */
    public String deleteByOrganizationIdProvider(String organizationId) {
        return new SQL() {{
            DELETE_FROM(TableName.ORGANIZATION);
            WHERE(String.format("%s = #{organizationId}", OrganizationColumn.ORGANIZATION_ID));
        }}.toString();
    }

    /**
     * 增加组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/3
     */
    public String insertOrganizationProvider(Organization organization) {
        organization.setOrganizationId(RandomStringUtils.randomNumeric(10));
        return new SQL() {{
            INSERT_INTO(TableName.ORGANIZATION);
            VALUES(OrganizationColumn.ORGANIZATION_ID, "#{organizationId}");
            VALUES(OrganizationColumn.ORGANIZATION_NAME, "#{organizationName}");
            VALUES(OrganizationColumn.ORGANIZATION_TYPE_ID, "#{organizationType}");
            VALUES(OrganizationColumn.ORGANIZATION_STATE, "#{organizationState}");
            VALUES(OrganizationColumn.CITY_FLAG, "#{cityFlag}");
            VALUES(OrganizationColumn.ORGANIZATION_CODE, "#{organizationCode}");
            VALUES(OrganizationColumn.SUPER_ORGANIZATION_CODE, "#{superOrganizationCode}");
            VALUES(OrganizationColumn.ORGANIZATION_DESC, "#{organizationDesc}");
            VALUES(OrganizationColumn.AREA_CODE, "#{areaCode}");
            VALUES(OrganizationColumn.ORDER_NUM, "#{orderNum}");
            VALUES(OrganizationColumn.UPDATE_TIME, "#{updateTime}");
            VALUES(OrganizationColumn.ENTERPRISE_ID, "#{enterpriseId}");
        }}.toString();
    }

    /**
     * 根据组织机构编号，修改组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/3
     */
    public String updateOrganizationProvider(Organization organization) {
        return new SQL() {{
            UPDATE(TableName.ORGANIZATION);
            SET(String.format("%s = #{organizationName}", OrganizationColumn.ORGANIZATION_NAME));
            SET(String.format("%s = #{organizationType}", OrganizationColumn.ORGANIZATION_TYPE_ID));
            SET(String.format("%s = #{organizationState}", OrganizationColumn.ORGANIZATION_STATE));
            SET(String.format("%s = #{cityFlag}", OrganizationColumn.CITY_FLAG));
            SET(String.format("%s = #{organizationCode}", OrganizationColumn.ORGANIZATION_CODE));
            SET(String.format("%s = #{superOrganizationCode}", OrganizationColumn.SUPER_ORGANIZATION_CODE));
            SET(String.format("%s = #{organizationDesc}", OrganizationColumn.ORGANIZATION_DESC));
            SET(String.format("%s = #{areaCode}", OrganizationColumn.AREA_CODE));
            SET(String.format("%s = #{orderNum}", OrganizationColumn.ORDER_NUM));
            SET(String.format("%s = #{updateTime}", OrganizationColumn.UPDATE_TIME));
            SET(String.format("%s = #{enterpriseId}", OrganizationColumn.ENTERPRISE_ID));
            WHERE(String.format("%s = #{organizationId}", OrganizationColumn.ORGANIZATION_ID));
        }}.toString();
    }

    public String updateStaffInfoOrganizationIdProvider(String organizationId) {
        return new SQL() {{
            UPDATE(TableName.STAFF_INFO);
            SET(String.format("%s = null", StaffInfoColumn.ORGANIZATION_ID));
            WHERE(String.format("%s = #{organizationId}", StaffInfoColumn.ORGANIZATION_ID));
        }}.toString();
    }

    public String selectEnterpriseNameByEnterpriseIdProvider(String enterpriseId){
        return new SQL(){{
            SELECT(EnterpriseColumn.ENTERPRISE_NAME);
            FROM(TableName.ENTERPRISE);
            WHERE(String.format("%s = #{enterpriseId}", EnterpriseColumn.ENTERPRISE_ID));
        }}.toString();
    }
}
