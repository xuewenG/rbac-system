package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;
import java.util.List;

public class EditStaffReqBean {
    private String staffId;
    private String staffName;
    private String staffState;
    private String staffIdStatus;
    private String organizationId;
    private String petName;
    @NotNull(message = "groupList 不能为 null")
    private List<String> groupIdList;
    @NotNull(message = "roleList 不能为 null")
    private List<String> roleIdList;

    @Override
    public String toString() {
        return "EditStaffReqBean{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffState='" + staffState + '\'' +
                ", staffIdStatus='" + staffIdStatus + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", petName='" + petName + '\'' +
                ", groupIdList='" + groupIdList + '\'' +
                ", roleIdList=" + roleIdList +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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
