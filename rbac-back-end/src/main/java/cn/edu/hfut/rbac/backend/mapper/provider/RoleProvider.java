package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.RoleColumn;
import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class RoleProvider {

    public String getAccurateRoleByRoleIdProvider(String roleId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.ROLE);
            WHERE(String.format("%s = #{roleId}", RoleColumn.ROLE_ID));
        }}.toString();
    }

    public String searchRoleByRoleNameProvider(String roleName) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.ROLE);
            WHERE(RoleColumn.ROLE_NAME + " like concat('%', #{roleName}  ,'%')");
        }}.toString();
    }

    public String insertSelectiveProvider(Role role) {
        role.setRoleId(RandomStringUtils.randomNumeric(6));
        return new SQL() {{
            INSERT_INTO(TableName.ROLE);
            VALUES(RoleColumn.ROLE_ID, SqlUtil.value("roleId"));
            VALUES(RoleColumn.ROLE_NAME, SqlUtil.value("roleName"));
            VALUES(RoleColumn.ROLE_CODE, SqlUtil.value("roleCode"));
            VALUES(RoleColumn.SUPER_CODE, SqlUtil.value("superCode"));
            VALUES(RoleColumn.DESCRIPTION, SqlUtil.value("description"));
        }}.toString();
    }

    //TODO 批量操作
    public String insertByBatchProvider(List<Role> roleList) {
        String sql = "";
        for (Role role : roleList) {
            /*String roleId = role.getRoleId();
            String roleName = role.getRoleName();
            String roleCode = role.getRoleCode();
            String superCode = role.getSuperCode();
            String description = role.getDescription();*/
            sql = sql +
                    insertSelectiveProvider(role);
                    /*new SQL() {{
                INSERT_INTO(TableName.ROLE);
                VALUES(RoleColumn.ROLE_ID, SqlUtil.value("role.roleId"));
                VALUES(RoleColumn.ROLE_NAME, SqlUtil.value("role.roleName"));
                VALUES(RoleColumn.ROLE_CODE, SqlUtil.value("role.roleCode"));
                VALUES(RoleColumn.SUPER_CODE, SqlUtil.value("role.superCode"));
                VALUES(RoleColumn.DESCRIPTION, SqlUtil.value("role.description"));
            }}.toString();*/
        }
        return sql;
    }

    public String deleteByRoleIdProvider(String roleId) {
        return new SQL() {{
            DELETE_FROM(TableName.ROLE);
            WHERE(String.format("%s = #{roleId}", RoleColumn.ROLE_ID));
        }}.toString();
    }

    public String deleteRoleByBatchProvider(List<Role> roleList) {
        String sql = null;
        for (Role role : roleList) {
            sql.join(new SQL() {{
                DELETE_FROM(TableName.ROLE);
                WHERE(SqlUtil.isEqual(RoleColumn.ROLE_ID, "roleId"));
            }}.toString());
        }
        return sql;
    }

    public String updateRoleBySuperCodeSelectiveProvider(Role role) {
        return new SQL() {{
            UPDATE(TableName.ROLE);
            if (role.getRoleName() != null) {
                SET(SqlUtil.isEqual(RoleColumn.ROLE_NAME, "roleName"));
            }
            if (role.getRoleCode() != null) {
                SET(SqlUtil.isEqual(RoleColumn.ROLE_CODE, "roleCode"));
            }
            if (role.getSuperCode() != null) {
                SET(SqlUtil.isEqual(RoleColumn.SUPER_CODE, "superCode"));
            }
            if (role.getDescription() != null) {
                SET(SqlUtil.isEqual(RoleColumn.DESCRIPTION, "description"));
            }
            WHERE(SqlUtil.isEqual(RoleColumn.ROLE_ID, "roleId"));
        }}.toString();
    }


}
