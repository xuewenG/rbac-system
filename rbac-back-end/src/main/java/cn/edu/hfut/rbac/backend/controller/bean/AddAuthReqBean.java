package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

public class AddAuthReqBean {
    @NotNull(message = "authName 不能为空")
    private String authName;
    @NotNull(message = "moduleId 不能为空")
    private String moduleId;
    @NotNull(message = "authCode 不能为空")
    private String authCode;
    @NotNull(message = "superCode 不能为空")
    private String superCode;
    @NotNull(message = "menuFlag 不能为空")
    private String menuFlag;
    @NotNull(message = "description 不能为空")
    private String description;

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getSuperCode() {
        return superCode;
    }

    public void setSuperCode(String superCode) {
        this.superCode = superCode;
    }

    public String getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(String menuFlag) {
        this.menuFlag = menuFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
