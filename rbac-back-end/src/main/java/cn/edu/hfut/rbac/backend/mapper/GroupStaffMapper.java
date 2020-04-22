package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.GroupInfo;
import cn.edu.hfut.rbac.backend.entity.GroupStaff;
import cn.edu.hfut.rbac.backend.mapper.provider.GroupStaffProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/6
 */
@Mapper
public interface GroupStaffMapper {
    @SelectProvider(type = GroupStaffProvider.class, method = "selectAllGroupStaffProvider")
    List<GroupStaff> selectAllGroupStaff();

    @SelectProvider(type = GroupStaffProvider.class, method = "selectGroupStaffByIdProvider")
    List<GroupStaff> selectGroupStaffById(String groupId, String staffId);

    /**
     * 根据 staffId 获取 GroupId 列表
     *
     * @param staffId staffId
     * @return GroupId 列表
     * @author xuewenG
     */
    @SelectProvider(type = GroupStaffProvider.class, method = "selectGroupListByStaffIdProvider")
    List<GroupInfo> selectGroupInfoListByStaffId(String staffId);

    @InsertProvider(type = GroupStaffProvider.class, method = "insertOneProvider")
    void insertOne(GroupStaff groupStaff);

    @DeleteProvider(type = GroupStaffProvider.class, method = "deleteGroupStaffByIdProvider")
    void deleteGroupStaffById(String groupId, String staffId);

    @UpdateProvider(type = GroupStaffProvider.class, method = "updateGroupStaffProvider")
    void updateGroupStaff(GroupStaff groupStaff);
}
