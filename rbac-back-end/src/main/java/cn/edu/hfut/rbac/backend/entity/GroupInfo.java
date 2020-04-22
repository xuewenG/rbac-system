package cn.edu.hfut.rbac.backend.entity;

import cn.edu.hfut.rbac.backend.util.bean.Treeable;

import java.sql.Timestamp;

/**
 * @author tanghan
 * @date 2019/9/6
 */
public class GroupInfo implements Treeable {
    private String groupId;
    private String groupName;
    private String groupTypeId;
    private String groupCode;
    private String superGroupCode;
    private Timestamp validStart;
    private Timestamp validEnd;
    private String groupDesc;
    private String cityId;

    @Override
    public String toString() {
        return "GroupInfo{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupTypeId='" + groupTypeId + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", superGroupCode='" + superGroupCode + '\'' +
                ", validStart='" + validStart + '\'' +
                ", validEnd='" + validEnd + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTypeId() {
        return groupTypeId;
    }

    public void setGroupTypeId(String groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getSuperGroupCode() {
        return superGroupCode;
    }

    public void setSuperGroupCode(String superGroupCode) {
        this.superGroupCode = superGroupCode;
    }

    public Timestamp getValidStart() {
        return validStart;
    }

    public void setValidStart(Timestamp validStart) {
        this.validStart = validStart;
    }

    public Timestamp getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(Timestamp validEnd) {
        this.validEnd = validEnd;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    public String getNodeId() {
        return groupId;
    }

    @Override
    public String getParentNodeId() {
        return "0";
    }
}
