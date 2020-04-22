package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.entity.GroupStaff;
import cn.edu.hfut.rbac.backend.mapper.GroupStaffMapper;
import cn.edu.hfut.rbac.backend.service.GroupStaffService;
import cn.edu.hfut.rbac.backend.util.TreeUtil;
import cn.edu.hfut.rbac.backend.util.bean.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/6
 */
@Service
public class GroupStaffServiceImpl implements GroupStaffService {
    @Autowired
    GroupStaffMapper groupStaffMapper;

    @Override
    public TreeNode getGroupStaffTree(String groupId, String staffId) {
        List<GroupStaff> groupStaffList = groupStaffMapper.selectGroupStaffById(groupId, staffId);
        List<TreeNode> treeNodeList = TreeUtil.toTreeNodeList(groupStaffList);
        TreeNode groupStaffTree = TreeUtil.buildTree(treeNodeList);
        return groupStaffTree;
    }

    @Override
    public TreeNode getAllGroupStaffTree() {
        List<GroupStaff> groupStaffList = groupStaffMapper.selectAllGroupStaff();
        List<TreeNode> treeNodeList = TreeUtil.toTreeNodeList(groupStaffList);
        TreeNode groupStaffTree = TreeUtil.buildTree(treeNodeList);
        return groupStaffTree;
    }

    @Override
    public void insertGroupStaff(GroupStaff groupStaff) {
        groupStaffMapper.insertOne(groupStaff);
    }

    @Override
    public void deleteGroupStaff(String groupId, String staffId) {
        groupStaffMapper.deleteGroupStaffById(groupId, staffId);
    }

    @Override
    public void updateGroupStaff(GroupStaff groupStaff) {
        groupStaffMapper.updateGroupStaff(groupStaff);
    }
}
