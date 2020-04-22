package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

/**
 * @author xuewenG
 * @date 2019/8/14 20:10
 */
public class LoginReqBean {
    @NotNull(message = "staffAccount 不能为空")
    private String staffAccount;
    @NotNull(message = "password 不能为空")
    private String password;

    @Override
    public String toString() {
        return "LoginReqBean{" +
                "staffAccount='" + staffAccount + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
