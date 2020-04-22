package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.GroupStaffUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.*;
import cn.edu.hfut.rbac.backend.entity.GroupStaff;
import cn.edu.hfut.rbac.backend.service.GroupStaffService;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import cn.edu.hfut.rbac.backend.util.bean.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author tanghan
 * @date 2019/9/6
 */
@RestController
@RequestMapping(GroupStaffUrlConstant.GROUPSTAFF)
public class GroupStaffController {
    @Autowired
    GroupStaffService groupStaffService;

    @PostMapping(GroupStaffUrlConstant.SELECTID)
    public Message selectGroupStaffById(@RequestBody @Valid SelectGroupStaffByIdRequestBean selectGroupStaffByIdRequestBean) {
        String groupId = selectGroupStaffByIdRequestBean.getGroupId();
        String staffId = selectGroupStaffByIdRequestBean.getStaffId();

        TreeNode groupStaffTree = groupStaffService.getGroupStaffTree(groupId, staffId);
        GroupStaffRespBean groupStaffRespBean = new GroupStaffRespBean();
        groupStaffRespBean.setGroupStaff(groupStaffTree);

        return ResultUtil.success(groupStaffTree);
    }

    @PostMapping(GroupStaffUrlConstant.SELECTALL)
    public Message selectAllGroupStaff() {
        TreeNode groupStaffTree = groupStaffService.getAllGroupStaffTree();
        GroupStaffRespBean groupStaffRespBean = new GroupStaffRespBean();
        groupStaffRespBean.setGroupStaff(groupStaffTree);

        return ResultUtil.success(groupStaffTree);
    }

    @PostMapping(GroupStaffUrlConstant.INSERT)
    public Message insertGroupStaff(@RequestBody @Valid InsertGroupStaffRequestBean insertGroupStaffRequestBean) {
        GroupStaff groupStaff = new GroupStaff();
        if (insertGroupStaffRequestBean.getGroupId() != null) {
            groupStaff.setGroupId(insertGroupStaffRequestBean.getGroupId());
        }
        if (insertGroupStaffRequestBean.getStaffId() != null) {
            groupStaff.setStaffId(insertGroupStaffRequestBean.getStaffId());
        }
        if (insertGroupStaffRequestBean.getIsPrinciple() != null) {
            groupStaff.setIsPrinciple(insertGroupStaffRequestBean.getIsPrinciple());
        }
        if (insertGroupStaffRequestBean.getBaseGroupId() != null) {
            groupStaff.setBaseGroupId(insertGroupStaffRequestBean.getBaseGroupId());
        }

        groupStaffService.insertGroupStaff(groupStaff);
        return ResultUtil.success();
    }

    @PostMapping(GroupStaffUrlConstant.DELETE)
    public Message deleteGroupStaffById(@RequestBody @Valid DeleteGroupStaffByIdRequestBean deleteGroupStaffByIdRequestBean) {
        String groupId = deleteGroupStaffByIdRequestBean.getGroupId();
        String staffId = deleteGroupStaffByIdRequestBean.getStaffId();

        groupStaffService.deleteGroupStaff(groupId, staffId);
        return ResultUtil.success();
    }

    @PostMapping(GroupStaffUrlConstant.UPDATE)
    public Message updateGroupStaff(@RequestBody @Valid UpdateGroupStaffRequestBean updateGroupStaffRequestBean) {
        GroupStaff groupStaff = new GroupStaff();
        if (updateGroupStaffRequestBean.getGroupId() != null) {
            groupStaff.setGroupId(updateGroupStaffRequestBean.getGroupId());
        }
        if (updateGroupStaffRequestBean.getStaffId() != null) {
            groupStaff.setStaffId(updateGroupStaffRequestBean.getStaffId());
        }
        if (updateGroupStaffRequestBean.getIsPrinciple() != null) {
            groupStaff.setIsPrinciple(updateGroupStaffRequestBean.getIsPrinciple());
        }
        if (updateGroupStaffRequestBean.getBaseGroupId() != null) {
            groupStaff.setBaseGroupId(updateGroupStaffRequestBean.getBaseGroupId());
        }

        groupStaffService.updateGroupStaff(groupStaff);
        return ResultUtil.success();
    }
}
