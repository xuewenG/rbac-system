package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.MenuUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.AddMenuReqBean;
import cn.edu.hfut.rbac.backend.controller.bean.DeleteMenuReqBean;
import cn.edu.hfut.rbac.backend.controller.bean.ListMenuRespBean;
import cn.edu.hfut.rbac.backend.service.MenuService;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import cn.edu.hfut.rbac.backend.util.bean.TreeNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xuewenG
 * @date 2019/8/22 14:58
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping(MenuUrlConstant.MENU)
public class MenuController {
    @Autowired
    MenuService menuService;

    /**
     * 获取菜单树
     *
     * @return 菜单树
     * @author xuewenG
     */
    @ApiOperation("获取树形菜单")
    @PostMapping(MenuUrlConstant.GET)
    public Message<ListMenuRespBean> listMenu() {
        TreeNode menuTree = menuService.getMenuTree();

        ListMenuRespBean listMenuRespBean = new ListMenuRespBean();
        listMenuRespBean.setMenuList(menuTree);

        return ResultUtil.success(listMenuRespBean);
    }

    /**
     * 添加菜单项
     *
     * @param addMenuReqBean 菜单数据
     * @return 添加结果
     * @author xuewenG
     */
    @ApiOperation("添加菜单")
    @PostMapping(MenuUrlConstant.ADD)
    public Message addMenu(@RequestBody @Valid AddMenuReqBean addMenuReqBean) {
        String menuName = addMenuReqBean.getMenuName();
        String parentId = addMenuReqBean.getParentId();
        String menuDescription = addMenuReqBean.getMenuDescription();
        String menuUrl = addMenuReqBean.getMenuUrl();
        String authId = addMenuReqBean.getAuthId();
        String moduleId = addMenuReqBean.getModuleId();

        menuService.addMenu(menuName, parentId, menuDescription,
                menuUrl, authId, moduleId);

        return ResultUtil.success();
    }

    /**
     * 删除菜单项
     *
     * @param deleteMenuReqBean 菜单编号
     * @return 删除结果
     * @author xuewenG
     */
    @ApiOperation("删除菜单")
    @PostMapping(MenuUrlConstant.DELETE)
    public Message deleteMenu(@RequestBody @Valid DeleteMenuReqBean deleteMenuReqBean) {
        String menuId = deleteMenuReqBean.getMenuId();

        menuService.deleteByMenuId(menuId);

        return ResultUtil.success();
    }
}
