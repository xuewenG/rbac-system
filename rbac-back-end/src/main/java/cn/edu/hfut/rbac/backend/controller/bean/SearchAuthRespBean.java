package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.entity.AuthElement;

import java.util.List;

public class SearchAuthRespBean {
    Long total;
    List<AuthElement> authList;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<AuthElement> getAuthList() {
        return authList;
    }

    public void setAuthList(List<AuthElement> authList) {
        this.authList = authList;
    }
}
