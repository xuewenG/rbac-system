package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

/**
 * @author tanghan
 * @date 2019/9/7
 */
public class InsertGroupStaffRequestBean {
    @NotNull(message = "groupId不能为空")
    @NotNull(message = "staffId不能为空")
    private String groupId;
    private String staffId;
    private String isPrinciple;
    private String baseGroupId;

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
