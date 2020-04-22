package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class GetRoleByStaffAccountRespBean {
    private List<RoleBean> roles;

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roleList) {
        this.roles = roleList;
    }
}
