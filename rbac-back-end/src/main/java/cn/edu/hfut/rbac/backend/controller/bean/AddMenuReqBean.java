package cn.edu.hfut.rbac.backend.controller.bean;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class AddMenuReqBean {
    @ApiModelProperty(required = true)
    @NotNull(message = "menuName 不能为空")
    private String menuName;
    @ApiModelProperty(required = true)
    @NotNull(message = "parentId 不能为空")
    private String parentId;
    @ApiModelProperty(required = true)
    @NotNull(message = "menuDescription 不能为空")
    private String menuDescription;
    @ApiModelProperty(required = true)
    @NotNull(message = "menuUrl 不能为空")
    private String menuUrl;
    @ApiModelProperty(required = true)
    @NotNull(message = "authId 不能为空")
    private String authId;
    @ApiModelProperty(required = true)
    @NotNull(message = "moduleId 不能为空")
    private String moduleId;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
