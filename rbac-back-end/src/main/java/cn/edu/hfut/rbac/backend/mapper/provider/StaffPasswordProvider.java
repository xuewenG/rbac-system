package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffPasswordColumn;
import cn.edu.hfut.rbac.backend.entity.StaffPassword;
import cn.edu.hfut.rbac.backend.util.PasswordUtil;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import cn.edu.hfut.rbac.backend.util.TimeUtil;
import org.apache.ibatis.jdbc.SQL;

import java.text.ParseException;

public class StaffPasswordProvider {
    public String selectByStaffIdProvider(String staffId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_PASSWORD);
            WHERE(String.format("%s = #{staffId}", StaffPasswordColumn.STAFF_ID));
        }}.toString();
    }

    public String insertStaffPwdReportProvider(StaffPassword staffPassword) throws ParseException {
        staffPassword.setPassword(PasswordUtil.encode("123456"));
        staffPassword.setValidStart(TimeUtil.getFormatTimeStamp());
        staffPassword.setValidEnd(TimeUtil.getFormatValidEndTime(staffPassword.getValidStart()));
        return new SQL() {{
            INSERT_INTO(TableName.STAFF_PASSWORD);
            VALUES(StaffPasswordColumn.STAFF_ID, SqlUtil.value("staffId"));
            VALUES(StaffPasswordColumn.PASSWORD, SqlUtil.value("password"));
            VALUES(StaffPasswordColumn.VALID_START, SqlUtil.value("validStart"));
            VALUES(StaffPasswordColumn.VALID_END, SqlUtil.value("validEnd"));
        }}.toString();
    }

    public String deleteStaffPwdReportProvider(String staffId) {
        return new SQL() {{
            DELETE_FROM(TableName.STAFF_PASSWORD);
            WHERE(SqlUtil.isEqual(StaffPasswordColumn.STAFF_ID, "staffId"));
        }}.toString();
    }

    public String updateStaffPwdReportProvider(StaffPassword staffPassword) throws ParseException {
        staffPassword.setPassword(PasswordUtil.encode(staffPassword.getPassword()));
        staffPassword.setValidStart(TimeUtil.getFormatTimeStamp());
        staffPassword.setValidEnd(TimeUtil.getFormatValidEndTime(staffPassword.getValidStart()));
        return new SQL() {{
            UPDATE(TableName.STAFF_PASSWORD);
            SET(SqlUtil.isEqual(StaffPasswordColumn.PASSWORD, "password"));
            SET(SqlUtil.isEqual(StaffPasswordColumn.VALID_START, "validStart"));
            SET(SqlUtil.isEqual(StaffPasswordColumn.VALID_END, "validEnd"));
            WHERE(SqlUtil.isEqual(StaffPasswordColumn.STAFF_ID, "staffId"));
        }}.toString();
    }
}
