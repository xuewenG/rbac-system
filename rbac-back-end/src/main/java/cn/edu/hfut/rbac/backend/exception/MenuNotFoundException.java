package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.MenuResponseCode;

public class MenuNotFoundException extends BaseException {
    public MenuNotFoundException(String menuId) {
        super(MenuResponseCode.MENU_NOT_FOUNT, String.format("menu not found, menuId: %s", menuId));
    }
}
