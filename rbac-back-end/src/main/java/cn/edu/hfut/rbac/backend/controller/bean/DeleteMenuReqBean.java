package cn.edu.hfut.rbac.backend.controller.bean;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class DeleteMenuReqBean {
    @ApiModelProperty(required = true)
    @NotNull(message = "menuId 不能为空")
    private String menuId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
