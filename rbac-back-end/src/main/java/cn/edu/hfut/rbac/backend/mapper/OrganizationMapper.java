package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.constant.database.table.EnterpriseColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.OrganizationColumn;
import cn.edu.hfut.rbac.backend.controller.bean.OrganizationBean;
import cn.edu.hfut.rbac.backend.entity.Enterprise;
import cn.edu.hfut.rbac.backend.entity.Organization;
import cn.edu.hfut.rbac.backend.mapper.provider.OrganizationProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/2
 */

@Mapper
public interface OrganizationMapper {
    /**
     * 根据组织机构编号，获取组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/2
     */
    @SelectProvider(type = OrganizationProvider.class, method = "selectByOrganizationNameProvider")
    @Results(id = "organizationResults", value = {
            @Result(column = OrganizationColumn.ORGANIZATION_ID, property = "organizationId", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = OrganizationColumn.ORGANIZATION_NAME, property = "organizationName", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.ORGANIZATION_TYPE_ID, property = "organizationType", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.ORGANIZATION_STATE, property = "organizationState", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.CITY_FLAG, property = "cityFlag", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.ORGANIZATION_CODE, property = "organizationCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.SUPER_ORGANIZATION_CODE, property = "superOrganizationCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.ORGANIZATION_DESC, property = "organizationDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.AREA_CODE, property = "areaCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.SUPER_VISOR_IDS, property = "supervisorIds", jdbcType = JdbcType.VARCHAR),
            @Result(column = OrganizationColumn.ORDER_NUM, property = "orderNum", jdbcType = JdbcType.INTEGER),
            @Result(column = OrganizationColumn.UPDATE_TIME, property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
    })
    List<Organization> selectListByOrganizationName(String organizationName);

    @SelectProvider(type = OrganizationProvider.class, method = "selectByOrganizationIdProvider")
    @ResultMap("organizationResults")
    Organization selectByOrganizationId(String organizationId);

    /**
     * 根据组织机构编号，删除组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/3
     */
    @DeleteProvider(type = OrganizationProvider.class, method = "deleteByOrganizationIdProvider")
    @ResultMap("organizationResults")
    void deleteByOrganizationId(String organizationId);

    /**
     * 增加组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/3
     */
    @InsertProvider(type = OrganizationProvider.class, method = "insertOrganizationProvider")
    @ResultMap("organizationResults")
    void insertOrganization(Organization organization);

    /**
     * 根据组织机构编号，修改组织机构基本信息
     *
     * @author tanghan
     * @date 2019/9/3
     */
    @UpdateProvider(type = OrganizationProvider.class, method = "updateOrganizationProvider")
    @ResultMap("organizationResults")
    void updateOrganization(Organization organization);

    @UpdateProvider(type = OrganizationProvider.class, method = "updateStaffInfoOrganizationIdProvider")
    @ResultMap("organizationResults")
    void updateStaffInfoOrganizationId(String organizationId);
}
