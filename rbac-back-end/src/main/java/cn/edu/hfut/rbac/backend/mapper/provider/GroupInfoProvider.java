package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.GroupInfoColumn;
import cn.edu.hfut.rbac.backend.constant.database.table.GroupStaffColumn;
import cn.edu.hfut.rbac.backend.entity.GroupInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author tanghan
 * @date 2019/9/6
 */
public class GroupInfoProvider {
    public String selectAllGroupInfoProvider() {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.GROUP_INFO);
        }}.toString();
    }

    public String selectGroupInfoByGroupNameProvider(String groupName) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.GROUP_INFO);
            if (StringUtils.isNotBlank(groupName)) {
                WHERE(GroupInfoColumn.GROUP_NAME + " like concat('%', #{groupName}, '%')");
            }
        }}.toString();
    }

    public String insertGroupInfoProvider(GroupInfo groupInfo) {
        groupInfo.setGroupId(RandomStringUtils.randomNumeric(10));
        return new SQL() {{
            INSERT_INTO(TableName.GROUP_INFO);
            VALUES(GroupInfoColumn.GROUP_ID, "#{groupId}");
            VALUES(GroupInfoColumn.GROUP_NAME, "#{groupName}");
            VALUES(GroupInfoColumn.GROUP_TYPE_ID, "#{groupTypeId}");
            VALUES(GroupInfoColumn.GROUP_CODE, "#{groupCode}");
            VALUES(GroupInfoColumn.SUPER_GROUP_CODE, "#{superGroupCode}");
            VALUES(GroupInfoColumn.VALID_START, "#{validStart}");
            VALUES(GroupInfoColumn.VALID_END, "#{validEnd}");
            VALUES(GroupInfoColumn.GROUP_DESC, "#{groupDesc}");
            VALUES(GroupInfoColumn.CITY_ID, "#{cityId}");
        }}.toString();
    }

    public String deleteGroupInfoByIdProvider(String groupId) {
        return new SQL() {{
            DELETE_FROM(TableName.GROUP_INFO);
            WHERE(String.format("%s = #{groupId}", GroupInfoColumn.GROUP_ID));
        }}.toString();
    }

    public String updateGroupInfoProvider(GroupInfo groupInfo) {
        return new SQL() {{
            UPDATE(TableName.GROUP_INFO);
            SET(String.format("%s = #{groupName}", GroupInfoColumn.GROUP_NAME));
            SET(String.format("%s = #{groupTypeId}", GroupInfoColumn.GROUP_TYPE_ID));
            SET(String.format("%s = #{groupCode}", GroupInfoColumn.GROUP_CODE));
            SET(String.format("%s = #{superGroupCode}", GroupInfoColumn.SUPER_GROUP_CODE));
            SET(String.format("%s = #{validStart}", GroupInfoColumn.VALID_START));
            SET(String.format("%s = #{validEnd}", GroupInfoColumn.VALID_END));
            SET(String.format("%s = #{groupDesc}", GroupInfoColumn.GROUP_DESC));
            SET(String.format("%s = #{cityId}", GroupInfoColumn.CITY_ID));
            WHERE(String.format("%s = #{groupId}", GroupInfoColumn.GROUP_ID));
        }}.toString();
    }

    public String deleteGroupStaffProvider(String groupId) {
        return new SQL() {{
            DELETE_FROM(TableName.GROUP_STAFF);
            WHERE(String.format("%s = #{groupId}", GroupStaffColumn.GROUP_ID));
        }}.toString();
    }
}
