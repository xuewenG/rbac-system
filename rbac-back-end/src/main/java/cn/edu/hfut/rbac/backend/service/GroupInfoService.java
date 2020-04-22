package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.entity.GroupInfo;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/6
 */
public interface GroupInfoService {
    List<GroupInfo> getGroupInfo(String groupName);

    void insertGroupInfo(GroupInfo groupInfo);

    void deleteGroupInfo(String groupId);

    void updateGroupInfo(GroupInfo groupInfo);

    void deleteGroupStaff(String groupId);
}
