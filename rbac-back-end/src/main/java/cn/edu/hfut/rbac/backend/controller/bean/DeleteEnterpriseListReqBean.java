package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class DeleteEnterpriseListReqBean {
    private List<String> enterpriseIdList;

    @Override
    public String toString() {
        return "DeleteEnterpriseListReqBean{" +
                "enterpriseIdList=" + enterpriseIdList +
                '}';
    }

    public List<String> getEnterpriseIdList() {
        return enterpriseIdList;
    }

    public void setEnterpriseIdList(List<String> enterpriseIdList) {
        this.enterpriseIdList = enterpriseIdList;
    }
}
