package cn.edu.hfut.rbac.backend.controller.bean;

import java.sql.Timestamp;

/**
 * @author tanghan
 * @date 2019/9/5
 */
public class InsertOrganizationRequestBean {
    private String orgaId;
    private String orgaName;
    private String orgaTypeId;
    private String orgaState;
    private String cityFlag;
    private String orgaCode;
    private String superOrgaCode;
    private String orgaDesc;
    private String areaCode;
    private Integer orderNum;
    private Timestamp updateTime;
    private String enterpriseId;

    @Override
    public String toString() {
        return "InsertOrganizationRequestBean{" +
                "orgaId='" + orgaId + '\'' +
                ", orgaName='" + orgaName + '\'' +
                ", orgaTypeId='" + orgaTypeId + '\'' +
                ", orgaState='" + orgaState + '\'' +
                ", cityFlag='" + cityFlag + '\'' +
                ", orgaCode='" + orgaCode + '\'' +
                ", superOrgaCode='" + superOrgaCode + '\'' +
                ", orgaDesc='" + orgaDesc + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", orderNum=" + orderNum +
                ", updateTime=" + updateTime +
                ", enterpriseId='" + enterpriseId + '\'' +
                '}';
    }

    public String getOrgaId() {
        return orgaId;
    }

    public void setOrgaId(String orgaId) {
        this.orgaId = orgaId;
    }

    public String getOrgaName() {
        return orgaName;
    }

    public void setOrgaName(String orgaName) {
        this.orgaName = orgaName;
    }

    public String getOrgaTypeId() {
        return orgaTypeId;
    }

    public void setOrgaTypeId(String orgaTypeId) {
        this.orgaTypeId = orgaTypeId;
    }

    public String getOrgaState() {
        return orgaState;
    }

    public void setOrgaState(String orgaState) {
        this.orgaState = orgaState;
    }

    public String getCityFlag() {
        return cityFlag;
    }

    public void setCityFlag(String cityFlag) {
        this.cityFlag = cityFlag;
    }

    public String getOrgaCode() {
        return orgaCode;
    }

    public void setOrgaCode(String orgaCode) {
        this.orgaCode = orgaCode;
    }

    public String getSuperOrgaCode() {
        return superOrgaCode;
    }

    public void setSuperOrgaCode(String superOrgaCode) {
        this.superOrgaCode = superOrgaCode;
    }

    public String getOrgaDesc() {
        return orgaDesc;
    }

    public void setOrgaDesc(String orgaDesc) {
        this.orgaDesc = orgaDesc;
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
