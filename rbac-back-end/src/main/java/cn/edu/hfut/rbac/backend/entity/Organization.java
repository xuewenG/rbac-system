package cn.edu.hfut.rbac.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * @author tanghan
 * @date 2019/9/2
 */

public class Organization {
    @JsonProperty("orgaId")
    private String organizationId;
    @JsonProperty("orgaName")
    private String organizationName;
    @JsonProperty("orgaTypeId")
    private String organizationType;
    @JsonProperty("orgaState")
    private String organizationState;
    private String cityFlag;
    @JsonProperty("orgaCode")
    private String organizationCode;
    @JsonProperty("superOrgaCode")
    private String superOrganizationCode;
    @JsonProperty("orgaDesc")
    private String organizationDesc;
    private String areaCode;
    private Integer orderNum;
    private Timestamp updateTime;
    private String supervisorIds;
    private String enterpriseId;

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId='" + organizationId + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", organizationState='" + organizationState + '\'' +
                ", cityFlag='" + cityFlag + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", superOrganizationCode='" + superOrganizationCode + '\'' +
                ", organizationDesc='" + organizationDesc + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", orderNum=" + orderNum +
                ", updateTime=" + updateTime +
                ", supervisorIds='" + supervisorIds + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                '}';
    }

    public String getSupervisorIds() {
        return supervisorIds;
    }

    public void setSupervisorIds(String supervisorIds) {
        this.supervisorIds = supervisorIds;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getOrganizationState() {
        return organizationState;
    }

    public void setOrganizationState(String organizationState) {
        this.organizationState = organizationState;
    }

    public String getCityFlag() {
        return cityFlag;
    }

    public void setCityFlag(String cityFlag) {
        this.cityFlag = cityFlag;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getSuperOrganizationCode() {
        return superOrganizationCode;
    }

    public void setSuperOrganizationCode(String superOrganizationCode) {
        this.superOrganizationCode = superOrganizationCode;
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = Integer.valueOf(orderNum);
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}