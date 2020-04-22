package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.RoleColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffInfoColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffRoleColumn;
import cn.edu.hfut.rbac.backend.entity.StaffRole;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class StaffRoleProvider {

    public String selectStaffRoleByRoleProvider(String roleId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_ROLE);
            WHERE(SqlUtil.isEqual(StaffRoleColumn.ROLE_ID, "roleId"));
        }}.toString();
    }

    public String selectStaffRoleByStaffIdProvider(String staffId) {
        return new SQL() {{
            SELECT(StaffRoleColumn.STAFF_ID, StaffRoleColumn.ROLE_ID);
            FROM(TableName.STAFF_ROLE);
            WHERE(SqlUtil.isEqual(StaffRoleColumn.STAFF_ID, "staffId"));
        }}.toString();
    }

    public String selectStaffListByRoleIdProvider(String roleId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_ROLE, TableName.STAFF_INFO);
            WHERE(SqlUtil.fullName(TableName.STAFF_ROLE, StaffRoleColumn.STAFF_ID) + "=" +
                    SqlUtil.fullName(TableName.STAFF_INFO, StaffInfoColumn.STAFF_ID));
            WHERE(SqlUtil.isEqual(StaffRoleColumn.ROLE_ID, "roleId"));
        }}.toString();
    }

    public String selectRoleListByStaffIdProvider(String staffId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_ROLE, TableName.ROLE);
            WHERE(SqlUtil.fullName(TableName.STAFF_ROLE, StaffRoleColumn.ROLE_ID) + "=" +
                    SqlUtil.fullName(TableName.ROLE, RoleColumn.ROLE_ID));
            WHERE(SqlUtil.isEqual(StaffRoleColumn.STAFF_ID, "staffId"));
        }}.toString();
    }

    public String insertStaffRoleProvider(StaffRole staffRole) {
        return new SQL() {{
            INSERT_INTO(TableName.STAFF_ROLE);
            VALUES(StaffRoleColumn.STAFF_ID, SqlUtil.value("staffId"));
            VALUES(StaffRoleColumn.ROLE_ID, SqlUtil.value("roleId"));
            if (staffRole.getConditionStr() != null) {
                VALUES(StaffRoleColumn.CONDITION_STR, staffRole.getConditionStr());
            }
        }}.toString();
    }

    public String deleteStaffRoleProvider(StaffRole staffRole) {
        return new SQL() {{
            DELETE_FROM(TableName.STAFF_ROLE);
            WHERE(SqlUtil.isEqual(StaffRoleColumn.ROLE_ID, "roleId"),
                    SqlUtil.isEqual(StaffRoleColumn.STAFF_ID, "staffId"));
        }}.toString();
    }

    //TODO 批量添加
    public String insertStaffForRoleProvider(List<StaffRole> staffRoleList) {
        String sql = null;
        for (StaffRole staffRole : staffRoleList) {
            sql.join(new SQL() {{
                INSERT_INTO(TableName.STAFF_ROLE);
                VALUES(StaffRoleColumn.STAFF_ID, SqlUtil.value("staffId"));
                VALUES(StaffRoleColumn.ROLE_ID, SqlUtil.value("roleId"));
                if (staffRole.getConditionStr() != null) {
                    VALUES(StaffRoleColumn.CONDITION_STR, staffRole.getConditionStr());
                }
            }}.toString());
        }
        return sql;
    }

    //TODO 批量删除
    public String deleteStaffForRoleProvider(List<StaffRole> staffRoleList) {
        String sql = null;
        for (StaffRole staffRole : staffRoleList) {
            sql.join(new SQL() {{
                DELETE_FROM(TableName.STAFF_ROLE);
                WHERE(SqlUtil.isEqual(StaffRoleColumn.ROLE_ID, "roleId"),
                        SqlUtil.isEqual(StaffRoleColumn.STAFF_ID, "staffId"));
            }}.toString());
        }
        return sql;
    }


    public String configRoleForStaffProvider(List<StaffRole> staffRoleList) {
        String sql = null;
        for (StaffRole staffRole : staffRoleList) {
            sql.join(new SQL() {{
                INSERT_INTO(TableName.STAFF_ROLE);
                VALUES(StaffRoleColumn.STAFF_ID, SqlUtil.value("staffId"));
                VALUES(StaffRoleColumn.ROLE_ID, SqlUtil.value("roleId"));
            }}.toString());
        }
        return sql;
    }

    public String dropRoleForStaffProvider(List<StaffRole> staffRoleList) {
        String sql = null;
        for (StaffRole staffRole : staffRoleList) {
            sql.join(new SQL() {{
                DELETE_FROM(TableName.STAFF_ROLE);
                WHERE(SqlUtil.isEqual(StaffRoleColumn.STAFF_ID, "staffId"),
                        SqlUtil.isEqual(StaffRoleColumn.ROLE_ID, "roleId"));

            }}.toString());
        }
        return sql;
    }

}
