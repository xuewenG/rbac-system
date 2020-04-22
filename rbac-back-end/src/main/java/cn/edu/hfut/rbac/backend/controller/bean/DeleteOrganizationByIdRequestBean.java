package cn.edu.hfut.rbac.backend.controller.bean;

/**
 * @author tanghan
 * @date 2019/9/5
 */
public class DeleteOrganizationByIdRequestBean {
    private String[] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
