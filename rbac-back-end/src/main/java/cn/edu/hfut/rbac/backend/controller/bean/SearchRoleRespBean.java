package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class SearchRoleRespBean {
    private Long total;
    private List<RoleBean> roles;

    @Override
    public String toString() {
        return "SearchRoleRespBean{" +
                "total=" + total +
                ", roles=" + roles +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<RoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleBean> roles) {
        this.roles = roles;
    }
}
