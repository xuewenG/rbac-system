package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.List;

public class DeleteStaffReqBean {
    private List<String> ids;

    @Override
    public String toString() {
        return "DeleteStaffReqBean{" +
                "ids=" + ids +
                '}';
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
