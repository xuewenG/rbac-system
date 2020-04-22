package cn.edu.hfut.rbac.backend.entity;

public class RoleAuth {
    private String roleId;
    private String moduleId;
    private String authId;
    private String conditionStr;

    public RoleAuth(String roleId, String authId) {
        this.roleId = roleId;
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "RoleAuth{" +
                "roleId='" + roleId + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", authId='" + authId + '\'' +
                ", conditionStr='" + conditionStr + '\'' +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getConditionStr() {
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr;
    }
}

