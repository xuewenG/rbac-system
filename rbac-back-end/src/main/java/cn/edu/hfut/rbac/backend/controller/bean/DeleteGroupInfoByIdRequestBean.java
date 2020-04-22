package cn.edu.hfut.rbac.backend.controller.bean;

import java.util.Arrays;

/**
 * @author tanghan
 * @date 2019/9/7
 */
public class DeleteGroupInfoByIdRequestBean {
    private String[] ids;

    @Override
    public String toString() {
        return "DeleteGroupInfoByIdRequestBean{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
