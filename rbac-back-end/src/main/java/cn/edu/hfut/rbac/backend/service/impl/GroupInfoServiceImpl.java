package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.entity.GroupInfo;
import cn.edu.hfut.rbac.backend.mapper.GroupInfoMapper;
import cn.edu.hfut.rbac.backend.service.GroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/6
 */
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
    @Autowired
    GroupInfoMapper groupInfoMapper;

    public List<GroupInfo> getGroupInfo(String groupName) {
        return groupInfoMapper.selectGroupInfoByGroupName(groupName);
    }

    @Override
    public void insertGroupInfo(GroupInfo groupInfo) {
        groupInfoMapper.insertGroupInfo(groupInfo);
    }

    @Override
    public void deleteGroupInfo(String groupId) {
        groupInfoMapper.deleteGroupInfoById(groupId);
    }

    @Override
    public void updateGroupInfo(GroupInfo groupInfo) {
        groupInfoMapper.updateGroupInfo(groupInfo);
    }

    @Override
    public void deleteGroupStaff(String groupId) {
        groupInfoMapper.deleteGroupStaff(groupId);
    }
}
