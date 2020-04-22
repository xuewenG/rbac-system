package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffInfoColumn;
import cn.edu.hfut.rbac.backend.entity.StaffInfo;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.UUID;

public class StaffInfoProvider {
    public String selectByStaffAccountProvider(String staffAccount) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_INFO);
            WHERE(String.format("%s = #{staffAccount}", StaffInfoColumn.STAFF_ACCOUNT));
        }}.toString();
    }

    public String selectByIdStateProvider(String status) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_INFO);
            WHERE(String.format("%s = #{status}", StaffInfoColumn.STAFF_ID_STATUS));
        }}.toString();
    }

    public String selectStaffIdByStaffAccountProvider(String staffAccount) {
        return new SQL() {{
            SELECT(StaffInfoColumn.STAFF_ID);
            FROM(TableName.STAFF_INFO);
            WHERE(String.format("%s = #{staffAccount}", StaffInfoColumn.STAFF_ACCOUNT));
        }}.toString();
    }

    public String searchByStaffNameProvider(String keyword) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.STAFF_INFO);
            WHERE(StaffInfoColumn.STAFF_NAME + " like concat('%', #{keyword},'%')");
        }}.toString();
    }

    //TODO 待完善 Id account
    public String insertStaffProvider(StaffInfo staff) {
        staff.setStaffId(RandomStringUtils.randomNumeric(10));
        staff.setStaffAccount(UUID.randomUUID().toString().replace("-", "").toLowerCase().substring(0, 10));
        return new SQL() {{
            INSERT_INTO(TableName.STAFF_INFO);
            VALUES(StaffInfoColumn.STAFF_ID, SqlUtil.value("staffId"));
            VALUES(StaffInfoColumn.STAFF_NAME, SqlUtil.value("staffName"));
            VALUES(StaffInfoColumn.STAFF_STATE, SqlUtil.value("staffState"));
            VALUES(StaffInfoColumn.STAFF_ID_STATUS, SqlUtil.value("staffIdStatus"));
            VALUES(StaffInfoColumn.ORGANIZATION_ID, SqlUtil.value("organizationId"));
            VALUES(StaffInfoColumn.PET_NAME, SqlUtil.value("petName"));
            VALUES(StaffInfoColumn.STAFF_ACCOUNT, SqlUtil.value("staffAccount"));
        }}.toString();
    }

    public String deleteStaffByStaffIdProvider(String staffId) {
        return new SQL() {{
            DELETE_FROM(TableName.STAFF_INFO);
            WHERE(SqlUtil.isEqual(StaffInfoColumn.STAFF_ID, staffId));
        }}.toString();
    }

    public String updateStaffInfoProvider(StaffInfo staff) {
        return new SQL() {{
            UPDATE(TableName.STAFF_INFO);
            if (staff.getStaffName() != null) {
                SET(SqlUtil.isEqual(StaffInfoColumn.STAFF_NAME, "staffName"));
            }
            if (staff.getStaffState() != null) {
                SET(SqlUtil.isEqual(StaffInfoColumn.STAFF_STATE, "staffState"));
            }
            if (staff.getStaffIdStatus() != null) {
                SET(SqlUtil.isEqual(StaffInfoColumn.STAFF_ID_STATUS, "staffIdStatus"));
            }
            if (staff.getOrganizationId() != null) {
                SET(SqlUtil.isEqual(StaffInfoColumn.ORGANIZATION_ID, "organizationId"));
            }
            if (staff.getPetName() != null) {
                SET(SqlUtil.isEqual(StaffInfoColumn.PET_NAME, "petName"));
            }
            WHERE(SqlUtil.isEqual(StaffInfoColumn.STAFF_ID, "staffId"));
        }}.toString();
    }
}
