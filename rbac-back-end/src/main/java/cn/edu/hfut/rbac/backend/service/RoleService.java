package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.controller.bean.RoleBean;
import cn.edu.hfut.rbac.backend.entity.AuthElement;
import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.entity.StaffInfo;

import java.util.List;

public interface RoleService {

    //获取角色列表
    List<RoleBean> getRoleList(String roleName);

    //添加角色
    void addRole(Role role);

    //删除角色
    void deleteRole(String roleId);

    //获取角色下人员列表
    List<StaffInfo> getStaffListByRoleId(String roleId);

    //为角色增删用户
    void configStaffForRole(String roleId, List<String> staffIdList);

    //获得当前角色所拥有的权限
    List<AuthElement> getAuthByRole(String roleId);

    //为角色配置权限
    void configAuthForRole(String roleId, List<String> authIdList);

    /**
     * 通过 员工账号 获取角色列表
     *
     * @param staffAccount 员工账号
     * @return 角色列表
     */
    List<RoleBean> getRoleListByStaffAccount(String staffAccount);

    //编辑角色信息
    void updateRole(Role role);
}
