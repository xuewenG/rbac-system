package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.GroupInfo;
import cn.edu.hfut.rbac.backend.mapper.provider.GroupInfoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/6
 */
@Mapper
public interface GroupInfoMapper {
    @SelectProvider(type = GroupInfoProvider.class, method = "selectAllGroupInfoProvider")
    List<GroupInfo> selectAllGroupInfo();

    @SelectProvider(type = GroupInfoProvider.class, method = "selectGroupInfoByGroupNameProvider")
    List<GroupInfo> selectGroupInfoByGroupName(String groupName);

    @InsertProvider(type = GroupInfoProvider.class, method = "insertGroupInfoProvider")
    void insertGroupInfo(GroupInfo groupInfo);

    @DeleteProvider(type = GroupInfoProvider.class, method = "deleteGroupInfoByIdProvider")
    void deleteGroupInfoById(String groupId);

    @UpdateProvider(type = GroupInfoProvider.class, method = "updateGroupInfoProvider")
    void updateGroupInfo(GroupInfo groupInfo);

    @DeleteProvider(type = GroupInfoProvider.class, method = "deleteGroupStaffProvider")
    void deleteGroupStaff(String groupId);
}
