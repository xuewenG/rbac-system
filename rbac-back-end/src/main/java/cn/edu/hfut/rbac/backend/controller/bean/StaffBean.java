package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.entity.GroupInfo;
import cn.edu.hfut.rbac.backend.entity.Organization;
import cn.edu.hfut.rbac.backend.entity.Role;

import java.sql.Timestamp;
import java.util.List;

public class StaffBean {
    private String staffId;
    private String staffName;
    private String staffState;
    private String staffIdStatus;
    private String dLevelId;
    private Double dlModulus;
    private String secondPost;
    private String dutyId;
    private String secondDuty;
    private String organizationId;
    private String postId;
    private String staffAccount;
    private Timestamp disableBeginDate;
    private Timestamp disableEndDate;
    private Timestamp updateTime;
    private String batchNo;
    private Integer workEfficiency;
    private String petName;

    // 扩展数据
    private Organization organization;
    private List<Role> roleList;
    private List<GroupInfo> groupList;

    @Override
    public String toString() {
        return "StaffBean{" +
                "staffId='" + staffId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffState='" + staffState + '\'' +
                ", staffIdStatus='" + staffIdStatus + '\'' +
                ", dLevelId='" + dLevelId + '\'' +
                ", dlModulus=" + dlModulus +
                ", secondPost='" + secondPost + '\'' +
                ", dutyId='" + dutyId + '\'' +
                ", secondDuty='" + secondDuty + '\'' +
                ", organizationId='" + organizationId + '\'' +
                ", postId='" + postId + '\'' +
                ", staffAccount='" + staffAccount + '\'' +
                ", disableBeginDate=" + disableBeginDate +
                ", disableEndDate=" + disableEndDate +
                ", updateTime=" + updateTime +
                ", batchNo='" + batchNo + '\'' +
                ", workEfficiency=" + workEfficiency +
                ", petName='" + petName + '\'' +
                ", organization=" + organization +
                ", roleList=" + roleList +
                ", groupInfoList=" + groupList +
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

    public String getdLevelId() {
        return dLevelId;
    }

    public void setdLevelId(String dLevelId) {
        this.dLevelId = dLevelId;
    }

    public Double getDlModulus() {
        return dlModulus;
    }

    public void setDlModulus(Double dlModulus) {
        this.dlModulus = dlModulus;
    }

    public String getSecondPost() {
        return secondPost;
    }

    public void setSecondPost(String secondPost) {
        this.secondPost = secondPost;
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getSecondDuty() {
        return secondDuty;
    }

    public void setSecondDuty(String secondDuty) {
        this.secondDuty = secondDuty;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    public Timestamp getDisableBeginDate() {
        return disableBeginDate;
    }

    public void setDisableBeginDate(Timestamp disableBeginDate) {
        this.disableBeginDate = disableBeginDate;
    }

    public Timestamp getDisableEndDate() {
        return disableEndDate;
    }

    public void setDisableEndDate(Timestamp disableEndDate) {
        this.disableEndDate = disableEndDate;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getWorkEfficiency() {
        return workEfficiency;
    }

    public void setWorkEfficiency(Integer workEfficiency) {
        this.workEfficiency = workEfficiency;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<GroupInfo> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupInfo> groupList) {
        this.groupList = groupList;
    }
}
