package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.AuthElementColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.RoleAuthColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.RoleColumn;
import cn.edu.hfut.rbac.backend.entity.RoleAuth;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.ibatis.jdbc.SQL;

public class RoleAuthProvider {

    public String selectRoleAuthByRoleProvider(String roleId) {
        return new SQL() {{
            SELECT_DISTINCT("*");
            FROM(TableName.ROLE_AUTH);
            WHERE(SqlUtil.isEqual(RoleAuthColumn.ROLE_ID, "roleId"));
        }}.toString();
    }

    public String selectRoleByModuleIdProvider(String moduleId) {
        return new SQL() {{
            SELECT_DISTINCT("*");
            FROM(TableName.ROLE_AUTH, TableName.ROLE);
            WHERE(SqlUtil.fullName(TableName.ROLE_AUTH, RoleAuthColumn.MODULE_ID) + "=" +
                    SqlUtil.fullName(TableName.ROLE, RoleColumn.ROLE_ID));
            WHERE(SqlUtil.isEqual(RoleAuthColumn.MODULE_ID, "moduleId"));
        }}.toString();
    }

    public String configAuthForRoleProvider(RoleAuth roleAuth) {
        return new SQL() {{
            INSERT_INTO(TableName.ROLE_AUTH);
            VALUES(RoleAuthColumn.ROLE_ID, SqlUtil.value("roleId"));
            VALUES(RoleAuthColumn.MODULE_ID, SqlUtil.value("moduleId"));
            VALUES(RoleAuthColumn.AUTH_ID, SqlUtil.value("authId"));
        }}.toString();
    }

    public String dropAuthFromRoleProvider(RoleAuth roleAuth) {
        return new SQL() {{
            DELETE_FROM(TableName.ROLE_AUTH);
            WHERE(SqlUtil.isEqual(RoleAuthColumn.ROLE_ID, "roleId"),
                    SqlUtil.isEqual(RoleAuthColumn.AUTH_ID, "authId"));
        }}.toString();
    }


    public String selectAuthByRoleProvider(String roleId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.ROLE_AUTH, TableName.AUTH_ELEMENT);
            WHERE(SqlUtil.fullName(TableName.ROLE_AUTH, RoleAuthColumn.AUTH_ID) + "=" +
                    SqlUtil.fullName(TableName.AUTH_ELEMENT, AuthElementColumn.AUTH_ID));
            WHERE(String.format("%s = #{roleId}", RoleAuthColumn.ROLE_ID));
        }}.toString();
    }
}
