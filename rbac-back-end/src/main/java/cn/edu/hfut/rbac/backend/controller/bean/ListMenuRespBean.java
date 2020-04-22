package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.util.bean.TreeNode;

/**
 * @author xuewenG
 * @date 2019/8/22 18:21
 */
public class ListMenuRespBean {
    private TreeNode menuList;

    public TreeNode getMenuList() {
        return menuList;
    }

    public void setMenuList(TreeNode menuList) {
        this.menuList = menuList;
    }
}
