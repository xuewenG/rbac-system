package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.ArrayList;
import java.util.List;

public class GetEnterpriseRespBean {
    private List<EnterpriseBean> enterpriseBeanList=new ArrayList<>();

    @Override
    public String toString() {
        return "GetEnterpriseRespBean{" +
                "enterpriseBeanList=" + enterpriseBeanList +
                ", total=" + total +
                '}';
    }

    public List<EnterpriseBean> getEnterpriseBeanList() {
        return enterpriseBeanList;
    }

    public void setEnterpriseBeanList(List<EnterpriseBean> enterpriseBeanList) {
        this.enterpriseBeanList = enterpriseBeanList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private Long total;
}
