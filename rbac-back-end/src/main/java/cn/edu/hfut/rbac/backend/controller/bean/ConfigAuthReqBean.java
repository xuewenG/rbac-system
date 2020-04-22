package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class ConfigAuthReqBean {
    private String roleId;
    private List<String> authIdList;

    @Override
    public String toString() {
        return "configAuthReqBean{" +
                "roleId='" + roleId + '\'' +
                ", authIdList=" + authIdList +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getAuthIdList() {
        return authIdList;
    }

    public void setAuthIdList(List<String> authIdList) {
        this.authIdList = authIdList;
    }
}


