package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.entity.GroupStaff;
import cn.edu.hfut.rbac.backend.util.bean.TreeNode;

/**
 * @author tanghan
 * @date 2019/9/6
 */
public interface GroupStaffService {
    TreeNode getGroupStaffTree(String groupId, String staffId);

    TreeNode getAllGroupStaffTree();

    void insertGroupStaff(GroupStaff groupStaff);

    void deleteGroupStaff(String groupId, String staffId);

    void updateGroupStaff(GroupStaff groupStaff);
}
