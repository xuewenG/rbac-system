package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddStaffReqBean {
    @NotNull(message = "staffName不能为空")
    private String staffName;

    @NotNull(message = "staffState不能为空")
    private String staffState;

    @NotNull(message = "staffIdStatus不能为空")
    private String staffIdStatus;

    @NotNull(message = "organizationId不能为空")
    private String organizationId;

    @NotNull(message = "petName不能为空")
    private String petName;

    @NotNull(message = "groupIdList不能为空")
    private List<String> groupIdList;
    @NotNull(message = "roleIdList不能为空")
    private List<String> roleIdList;

    @Override
    public String toString() {
        return "AddStaffReqBean{" +
                "staffName='" + staffName + '\'' +
                ", staffState='" + staffState + '\'' +
                ", staffIdStatus='" + staffIdStatus + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", petName='" + petName + '\'' +
                ", groupIdList=" + groupIdList +
                ", roleIdList=" + roleIdList +
                '}';
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffState() {
        return staffState;
    }

    public void setStaffState(String staffState) {
        this.staffState = staffState;
    }

    public String getStaffIdStatus() {
        return staffIdStatus;
    }

    public void setStaffIdStatus(String staffIdStatus) {
        this.staffIdStatus = staffIdStatus;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public List<String> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<String> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }


}
