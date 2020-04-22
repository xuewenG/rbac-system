package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.controller.bean.MenuBean;
import cn.edu.hfut.rbac.backend.entity.Menu;
import cn.edu.hfut.rbac.backend.exception.MenuNotFoundException;
import cn.edu.hfut.rbac.backend.mapper.AuthElementMapper;
import cn.edu.hfut.rbac.backend.mapper.MenuMapper;
import cn.edu.hfut.rbac.backend.service.MenuService;
import cn.edu.hfut.rbac.backend.util.TreeUtil;
import cn.edu.hfut.rbac.backend.util.bean.TreeNode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/22 16:16
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    AuthElementMapper authMapper;

    /**
     * @author xuewenG
     * @date 2019/8/22 15:01
     */
    @Override
    public TreeNode getMenuTree() {
        List<Menu> menuList = menuMapper.selectAll();
        List<MenuBean> menuBeanList = new ArrayList<>(menuList.size());
        menuList.forEach(menu -> {
            MenuBean menuBean = new MenuBean();
            BeanUtils.copyProperties(menu, menuBean);
            menuBean.setAuth(authMapper.selectByAuthId(menu.getAuthId()));
            menuBeanList.add(menuBean);
        });
        List<TreeNode> treeNodeList = TreeUtil.toTreeNodeList(menuBeanList);
        TreeNode menuTree = TreeUtil.buildTree(treeNodeList);
        return menuTree;
    }

    /**
     * @author xuewenG
     * @date 2019/9/11
     */
    @Override
    public void addMenu(String menuName, String parentId, String menuDescription,
                        String menuUrl, String authId, String moduleId) {
        if (!parentId.equals(TreeNode.ROOT_NODE_ID)) {
            Boolean parentExist = menuMapper.checkExistByMenuId(parentId);
            if (!parentExist) {
                throw new MenuNotFoundException(parentId);
            }
        }
        String menuId;
        while (true) {
            menuId = RandomStringUtils.randomNumeric(9);
            Boolean menuIdExist = menuMapper.checkExistByMenuId(menuId);
            if (!menuIdExist) {
                break;
            }
        }
        menuMapper.insertOne(menuId, menuName, parentId, menuDescription, menuUrl, authId, moduleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByMenuId(String menuId) {
        Boolean menuIdExist = menuMapper.checkExistByMenuId(menuId);
        if (!menuIdExist) {
            throw new MenuNotFoundException(menuId);
        }

        List<String> menuIdList = new ArrayList<>(16);
        menuIdList.add(menuId);

        deleteMenuRecursion(menuIdList);
    }

    private void deleteMenuRecursion(List<String> menuIdList) {
        menuIdList.forEach(id -> {
            menuMapper.deleteByMenuId(id);
            deleteMenuRecursion(menuMapper.selectChildrenIdListByMenuId(id));
        });
    }
}
