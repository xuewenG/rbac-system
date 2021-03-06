package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

/**
 * @author tanghan
 * @date 2019/9/7
 */
public class DeleteGroupStaffByIdRequestBean {
    @NotNull(message = "groupId不能为空")
    @NotNull(message = "staffId不能为空")
    private String groupId;
    private String staffId;

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
}
