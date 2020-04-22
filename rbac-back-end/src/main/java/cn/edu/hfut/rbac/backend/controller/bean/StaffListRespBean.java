package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class StaffListRespBean {
    private Long total;
    private List<StaffBean> staffs;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<StaffBean> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<StaffBean> staffs) {
        this.staffs = staffs;
    }
}
