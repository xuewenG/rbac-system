package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.entity.Organization;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/5
 */
public class OrganizationRespBean {
    private List<OrganizationBean> organizationList;
    private Long total;

    public List<OrganizationBean> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<OrganizationBean> organizationList) {
        this.organizationList = organizationList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
