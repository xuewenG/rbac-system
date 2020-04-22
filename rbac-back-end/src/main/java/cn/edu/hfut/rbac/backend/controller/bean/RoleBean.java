package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.entity.AuthElement;

import java.util.List;

public class RoleBean {
    private String roleId;
    private String roleCode;
    private String superCode;
    private String roleName;
    private String description;

    //扩展数据
    private List<AuthElement> authList;


    @Override
    public String toString() {
        return "RoleBean{" +
                "roleId='" + roleId + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", superCode='" + superCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", authList=" + authList +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getSuperCode() {
        return superCode;
    }

    public void setSuperCode(String superCode) {
        this.superCode = superCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AuthElement> getAuthList() {
        return authList;
    }

    public void setAuthList(List<AuthElement> authList) {
        this.authList = authList;
    }
}
