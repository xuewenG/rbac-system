package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.entity.StaffInfo;

/**
 * @author xuewenG
 * @date 2019/8/14 20:18
 */
public class LoginRespBean {
    StaffInfo staffInfo;

    @Override
    public String toString() {
        return "LoginRespBean{" +
                "staffInfo=" + staffInfo +
                '}';
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }
}
