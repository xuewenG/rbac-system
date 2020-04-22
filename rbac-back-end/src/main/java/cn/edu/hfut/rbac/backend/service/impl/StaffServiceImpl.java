package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.constant.state.StaffIdStatus;
import cn.edu.hfut.rbac.backend.controller.bean.StaffBean;
import cn.edu.hfut.rbac.backend.entity.*;
import cn.edu.hfut.rbac.backend.exception.InvalidPasswordException;
import cn.edu.hfut.rbac.backend.exception.PasswordExpiredException;
import cn.edu.hfut.rbac.backend.exception.StaffAccountNotActiveException;
import cn.edu.hfut.rbac.backend.exception.StaffNotFoundException;
import cn.edu.hfut.rbac.backend.mapper.*;
import cn.edu.hfut.rbac.backend.service.StaffService;
import cn.edu.hfut.rbac.backend.util.PasswordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/14 15:24
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffInfoMapper staffInfoMapper;
    @Autowired
    StaffPasswordMapper staffPasswordMapper;
    @Autowired
    StaffRoleMapper staffRoleMapper;
    @Autowired
    GroupStaffMapper gropuStaffMapper;
    @Autowired
    OrganizationMapper organizationMapper;

    /**
     * @author xuewenG
     * @date 2019/8/14 19:48
     */
    @Override
    public StaffInfo login(String staffAccount, String password) {
        // 还要检查账户状态，因此获取了全部的信息
        StaffInfo staffInfo = getStaffByStaffAccount(staffAccount);
        if (!isActive(staffInfo)) {
            throw new StaffAccountNotActiveException("account", staffAccount);
        }
        String staffId = staffInfo.getStaffId();
        StaffPassword staffPassword = staffPasswordMapper.selectByStaffId(staffId);
        if (!PasswordUtil.isActive(staffPassword)) {
            throw new PasswordExpiredException();
        }
        if (!PasswordUtil.check(password, staffPassword.getPassword())) {
            throw new InvalidPasswordException();
        }
        return staffInfo;
    }

    /**
     * @author xuewenG
     * @date 2019/8/14 15:25
     */
    @Override
    public StaffInfo getStaffByStaffAccount(String staffAccount) {
        StaffInfo staffInfo = staffInfoMapper.selectByStaffAccount(staffAccount);
        if (staffInfo == null) {
            throw new StaffNotFoundException("account", staffAccount);
        }
        return staffInfo;
    }

    /**
     * @author xuewenG
     * @date 2019/8/14 19:59
     */
    @Override
    public String getStaffIdByStaffAccount(String staffAccount) {
        String staffId = staffInfoMapper.selectStaffIdByStaffAccount(staffAccount);
        if (staffId == null) {
            throw new StaffNotFoundException("account", staffAccount);
        }
        return staffId;
    }

    /**
     * @author xuewenG
     * @date 2019/8/14 19:49
     */
    @Override
    public Boolean isActive(StaffInfo staffInfo) {
        return StaffIdStatus.NORMAL.equals(staffInfo.getStaffIdStatus());
    }


    /**
     * @return
     * @author yaxinL
     */
    @Override
    public List<StaffBean> getStaffList(String keyword) {
        List<StaffInfo> staffList = staffInfoMapper.searchByStaffName(keyword);

        List<StaffBean> staffs = new ArrayList<>();
        for (StaffInfo staff : staffList) {
            StaffBean staffBean = new StaffBean();
            BeanUtils.copyProperties(staff, staffBean);

            // 设置扩展数据
            staffBean.setRoleList(staffRoleMapper.selectRoleListByStaffId(staff.getStaffId()));
            staffBean.setGroupList(gropuStaffMapper.selectGroupInfoListByStaffId(staff.getStaffId()));
            staffBean.setOrganization(organizationMapper.selectByOrganizationId(staff.getOrganizationId()));
            staffs.add(staffBean);
        }
        return staffs;
    }

    @Override
    public void addStaff(StaffInfo staff) {
        staffInfoMapper.insertStaff(staff);
        StaffPassword staffPassword = new StaffPassword();
        staffPassword.setStaffId(staff.getStaffId());
        staffPasswordMapper.insertStaffPwdReport(staffPassword);
    }

    @Override
    public void deleteStaff(String staffId) {
        staffInfoMapper.deleteStaffByStaffId(staffId);
        staffPasswordMapper.deleteStaffPwdReport(staffId);
    }

    @Override
    public void updateStaff(StaffInfo staff) {
        staffInfoMapper.updateStaffInfo(staff);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void configRole(List<String> roleIdList, String staffId) {
        // 删除当前员工的所有角色
        List<StaffRole> staffRoleList = staffRoleMapper.selectStaffRoleListByStaffId(staffId);
        staffRoleList.forEach(staffRole -> {
            staffRoleMapper.deleteByStaffRole(staffRole);
        });

        // 重新配置角色信息
        roleIdList.forEach(roleId -> {
            staffRoleMapper.insertStaffRole(new StaffRole(roleId, staffId));
        });
    }

    @Override
    public void updatePassword(StaffPassword staffPassword) {
        staffPasswordMapper.updateStaffPwdReport(staffPassword);
    }

    @Override
    public void configGroup(String staffId, List<String> groupIdList) {
        // 删除当前员工的所有工作组
        List<GroupInfo> groupInfoList = gropuStaffMapper.selectGroupInfoListByStaffId(staffId);
        groupInfoList.forEach(groupInfo -> {
            gropuStaffMapper.deleteGroupStaffById(groupInfo.getGroupId(), staffId);
        });

        // 重新配置工作组信息
        groupIdList.forEach(groupId -> {
            gropuStaffMapper.insertOne(new GroupStaff(groupId, staffId));
        });
    }
}
