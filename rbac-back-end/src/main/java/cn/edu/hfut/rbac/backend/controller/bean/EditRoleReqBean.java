package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class EditRoleReqBean {
    private String roleId;
    private String roleName;
    private String description;
    private List<String> authIds;

    @Override
    public String toString() {
        return "EditRoleReqBean{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", authIds=" + authIds +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public List<String> getAuthIds() {
        return authIds;
    }

    public void setAuthIds(List<String> authIds) {
        this.authIds = authIds;
    }


}
