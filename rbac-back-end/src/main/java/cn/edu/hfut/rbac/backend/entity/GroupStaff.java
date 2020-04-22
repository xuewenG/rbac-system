package cn.edu.hfut.rbac.backend.entity;

import cn.edu.hfut.rbac.backend.util.bean.Treeable;

/**
 * @author tanghan
 * @date 2019/9/6
 */
public class GroupStaff implements Treeable {
    private String groupId;
    private String staffId;
    private String isPrinciple;
    private String baseGroupId;

    public GroupStaff() {
    }

    public GroupStaff(String groupId, String staffId) {
        this.groupId = groupId;
        this.staffId = staffId;
    }

    @Override
    public String getNodeId() {
        return groupId;
    }

    @Override
    public String getParentNodeId() {
        return "0";
    }

    @Override
    public String toString() {
        return "GroupStaff{" +
                "groupId='" + groupId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", isPrinciple='" + isPrinciple + '\'' +
                ", baseGroupId='" + baseGroupId + '\'' +
                '}';
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getIsPrinciple() {
        return isPrinciple;
    }

    public void setIsPrinciple(String isPrinciple) {
        this.isPrinciple = isPrinciple;
    }

    public String getBaseGroupId() {
        return baseGroupId;
    }

    public void setBaseGroupId(String baseGroupId) {
        this.baseGroupId = baseGroupId;
    }
}
