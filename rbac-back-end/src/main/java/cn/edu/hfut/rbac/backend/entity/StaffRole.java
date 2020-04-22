package cn.edu.hfut.rbac.backend.entity;

public class StaffRole {

    private String roleId;
    private String staffId;
    private String conditionStr;

    public StaffRole() {
    }

    public StaffRole(String roleId, String staffId) {
        this.roleId = roleId;
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "StaffRole{" +
                "roleId='" + roleId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", conditionStr='" + conditionStr + '\'' +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getConditionStr() {
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr;
    }
}
