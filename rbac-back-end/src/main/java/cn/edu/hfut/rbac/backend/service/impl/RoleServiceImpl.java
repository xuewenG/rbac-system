package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.controller.bean.RoleBean;
import cn.edu.hfut.rbac.backend.entity.*;
import cn.edu.hfut.rbac.backend.exception.StaffNotFoundException;
import cn.edu.hfut.rbac.backend.mapper.RoleAuthMapper;
import cn.edu.hfut.rbac.backend.mapper.RoleMapper;
import cn.edu.hfut.rbac.backend.mapper.StaffInfoMapper;
import cn.edu.hfut.rbac.backend.mapper.StaffRoleMapper;
import cn.edu.hfut.rbac.backend.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleAuthMapper roleAuthMapper;
    @Autowired
    StaffRoleMapper staffRoleMapper;
    @Autowired
    StaffInfoMapper staffInfoMapper;

    @Override
    public List<RoleBean> getRoleList(String roleName) {
        List<Role> roleList = roleMapper.searchRoleByRoleName(roleName);

        List<RoleBean> roles = new ArrayList<>();
        for (Role role : roleList) {
            RoleBean roleBean = new RoleBean();
            BeanUtils.copyProperties(role, roleBean);
            roleBean.setAuthList(roleAuthMapper.selectAuthByRole(role.getRoleId()));
            roles.add(roleBean);
        }

        return roles;
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insertSelective(role);
    }

    @Override
    public void deleteRole(String roleId) {
        List<StaffRole> staffRoleList = staffRoleMapper.selectStaffRoleByRole(roleId);
        for (StaffRole staffRole : staffRoleList) {
            staffRoleMapper.deleteByStaffRole(staffRole);
        }
        List<RoleAuth> roleAuthList = roleAuthMapper.selectRoleAuthByRole(roleId);
        for (RoleAuth roleAuth : roleAuthList) {
            roleAuthMapper.dropAuthFromRole(roleAuth);

        }
        roleMapper.deleteByRoleId(roleId);

    }

    @Override
    public List<StaffInfo> getStaffListByRoleId(String roleId) {
        return staffRoleMapper.selectStaffListByRoleId(roleId);
    }

    @Override
    public void configStaffForRole(String roleId, List<String> staffIdList) {
        // 删除当前角色的所有员工
        List<StaffRole> staffRoleList = staffRoleMapper.selectStaffRoleListByStaffId(roleId);
        staffRoleList.forEach(staffRole -> {
            staffRoleMapper.deleteByStaffRole(staffRole);
        });

        // 重新配置角色-员工信息
        staffIdList.forEach(staffId -> {
            staffRoleMapper.insertStaffRole(new StaffRole(roleId, staffId));
        });
    }


    @Override
    public List<AuthElement> getAuthByRole(String roleId) {
        return roleAuthMapper.selectAuthByRole(roleId);
    }

    @Override
    public void configAuthForRole(String roleId, List<String> authIdList) {
        // 删除当前角色的所有权限
        List<RoleAuth> roleAuthList = roleAuthMapper.selectRoleAuthByRole(roleId);
        roleAuthList.forEach(roleAuth -> {
            roleAuthMapper.dropAuthFromRole(roleAuth);
        });

        // 重新配置角色-员工信息
        authIdList.forEach(authId -> {
            roleAuthMapper.configAuthForRole(new RoleAuth(roleId, authId));
        });
    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public List<RoleBean> getRoleListByStaffAccount(String staffAccount) {

        String staffId = staffInfoMapper.selectStaffIdByStaffAccount(staffAccount);
        if (staffId == null) {
            throw new StaffNotFoundException("account", staffAccount);
        }
        List<Role> roleList = staffRoleMapper.selectRoleListByStaffId(staffId);

        List<RoleBean> roles = new ArrayList<>();
        for (Role role : roleList) {
            RoleBean roleBean = new RoleBean();
            BeanUtils.copyProperties(role, roleBean);
            roleBean.setAuthList(roleAuthMapper.selectAuthByRole(role.getRoleId()));
            roles.add(roleBean);
        }

        return roles;
    }
}
