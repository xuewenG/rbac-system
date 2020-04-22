package cn.edu.hfut.rbac.backend.controller.bean;

public class AddRoleReqBean {
    private String roleName;
    private String description;

    @Override
    public String toString() {
        return "AddRoleReqBean{" +
                "roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
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
}
