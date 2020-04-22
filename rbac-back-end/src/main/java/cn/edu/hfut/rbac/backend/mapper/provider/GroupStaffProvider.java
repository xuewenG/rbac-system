package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.GroupInfoColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.GroupStaffColumn;
import cn.edu.hfut.rbac.backend.entity.GroupStaff;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author tanghan
 * @date 2019/9/6
 */
public class GroupStaffProvider {
    public String selectAllGroupStaffProvider() {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.GROUP_STAFF);
        }}.toString();
    }

    public String selectGroupStaffByIdProvider(String groupId, String staffId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.GROUP_STAFF);
            WHERE(String.format("%s = #{groupId}", GroupStaffColumn.GROUP_ID), String.format("%s = #{staffId}", GroupStaffColumn.STAFF_ID));
        }}.toString();
    }

    public String selectGroupListByStaffIdProvider(String staffId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.GROUP_STAFF, TableName.GROUP_INFO);
            WHERE(SqlUtil.fullName(TableName.GROUP_STAFF, GroupStaffColumn.GROUP_ID) + "=" +
                    SqlUtil.fullName(TableName.GROUP_INFO, GroupInfoColumn.GROUP_ID));
            WHERE(SqlUtil.isEqual(GroupStaffColumn.STAFF_ID, "staffId"));
        }}.toString();
    }

    public String insertOneProvider(GroupStaff groupStaff) {
        return new SQL() {{
            INSERT_INTO(TableName.GROUP_STAFF);
            VALUES(GroupStaffColumn.GROUP_ID, "#{groupId}");
            VALUES(GroupStaffColumn.STAFF_ID, "#{staffId}");
            VALUES(GroupStaffColumn.IS_PRINCIPLE, "#{isPrinciple}");
            VALUES(GroupStaffColumn.BASE_GROUP_ID, "#{baseGroupId}");
        }}.toString();
    }

    public String deleteGroupStaffByIdProvider(String groupId, String staffId) {
        return new SQL() {{
            DELETE_FROM(TableName.GROUP_STAFF);
            WHERE(String.format("%s = #{groupId}", GroupStaffColumn.GROUP_ID), String.format("%s = #{staffId}", GroupStaffColumn.STAFF_ID));
        }}.toString();
    }

    public String updateGroupStaffProvider(GroupStaff groupStaff) {
        return new SQL() {{
            UPDATE(TableName.GROUP_STAFF);
            if (groupStaff.getGroupId() != null) {
                SET(String.format("%s = #{groupId}", GroupStaffColumn.GROUP_ID));
            }
            if (groupStaff.getStaffId() != null) {
                SET(String.format("%s = #{staffId}", GroupStaffColumn.STAFF_ID));
            }
            if (groupStaff.getIsPrinciple() != null) {
                SET(String.format("%s = #{isPrinciple}", GroupStaffColumn.IS_PRINCIPLE));
            }
            if (groupStaff.getBaseGroupId() != null) {
                SET(String.format("%s = #{baseGroupId}", GroupStaffColumn.BASE_GROUP_ID));
            }
        }}.toString();
    }
}
