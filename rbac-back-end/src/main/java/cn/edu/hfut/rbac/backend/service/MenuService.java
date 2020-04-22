package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.util.bean.TreeNode;

/**
 * @author xuewenG
 * @date 2019/8/22 15:01
 */
public interface MenuService {
    /**
     * 获取菜单树
     *
     * @return 菜单树结构
     * @author xuewenG
     * @date 2019/8/22
     */
    TreeNode getMenuTree();

    /**
     * 添加菜单项
     *
     * @author xuewenG
     * @date 2019/9/11
     */
    void addMenu(String menuName, String parentId, String menuDescription,
                 String menuUrl, String authId, String moduleId);

    /**
     * 删除菜单项
     *
     * @author xuewenG
     * @date 2019/9/11
     */
    void deleteByMenuId(String menuId);
}
