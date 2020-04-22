package cn.edu.hfut.rbac.backend.entity;

public class AuthElement {

    private String authId;
    private String moduleId;
    private String authCode;
    private String superCode;
    private String authName;
    private String menuFlag;
    private String description;

    @Override
    public String toString() {
        return "AuthElement{" +
                "authId='" + authId + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", authCode='" + authCode + '\'' +
                ", superCode='" + superCode + '\'' +
                ", authAame='" + authName + '\'' +
                ", menuFlag='" + menuFlag + '\'' +
                ", description='" + description + '\'' +
                '}';
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

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authAame) {
        this.authName = authAame;
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
