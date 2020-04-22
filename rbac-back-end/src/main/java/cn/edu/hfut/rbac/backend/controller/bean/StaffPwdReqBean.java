package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

public class StaffPwdReqBean {
    @NotNull(message = "staffId不能为空")
    private String staffId;

    @NotNull(message = "staffPassword不能为空")
    private String oldStaffPwd;

    @NotNull(message = "staffPassword不能为空")
    private String newStaffPwd;

    @Override
    public String toString() {
        return "StaffPwdReqBean{" +
                "staffId='" + staffId + '\'' +
                ", oldStaffPwd='" + oldStaffPwd + '\'' +
                ", newStaffPwd='" + newStaffPwd + '\'' +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }


    public String getOldStaffPwd() {
        return oldStaffPwd;
    }

    public void setOldStaffPwd(String oldStaffPwd) {
        this.oldStaffPwd = oldStaffPwd;
    }

    public String getNewStaffPwd() {
        return newStaffPwd;
    }

    public void setNewStaffPwd(String newStaffPwd) {
        this.newStaffPwd = newStaffPwd;
    }
}
