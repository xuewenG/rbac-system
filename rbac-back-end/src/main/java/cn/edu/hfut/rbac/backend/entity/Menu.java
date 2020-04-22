package cn.edu.hfut.rbac.backend.entity;

import cn.edu.hfut.rbac.backend.util.bean.Treeable;

/**
 * @author xuewenG
 * @date 2019/8/22 14:07
 */
public class Menu implements Treeable {
    private String menuId;
    private String moduleId;
    private String parentId;
    private String imageUrl;
    private String menuName;
    private String menuDescription;
    private String menuUrl;
    private Integer displayNo;
    private String openModule;
    private String authId;
    private String fastKey;
    private String isHidden;
    private String serviceId;
    private String isDisplay;
    private String callback;
    private String displayType;
    private String dyField1;
    private String dyField2;
    private String dyField3;
    private String dyField4;
    private String dyField5;
    private Integer clickTotal;

    @Override
    public String getNodeId() {
        return menuId;
    }

    @Override
    public String getParentNodeId() {
        return parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuDescription='" + menuDescription + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", displayNo=" + displayNo +
                ", openModule='" + openModule + '\'' +
                ", authId='" + authId + '\'' +
                ", fastKey='" + fastKey + '\'' +
                ", isHidden='" + isHidden + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", isDisplay='" + isDisplay + '\'' +
                ", callback='" + callback + '\'' +
                ", displayType='" + displayType + '\'' +
                ", dyField1='" + dyField1 + '\'' +
                ", dyField2='" + dyField2 + '\'' +
                ", dyField3='" + dyField3 + '\'' +
                ", dyField4='" + dyField4 + '\'' +
                ", dyField5='" + dyField5 + '\'' +
                ", clickTotal=" + clickTotal +
                '}';
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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

    public Integer getDisplayNo() {
        return displayNo;
    }

    public void setDisplayNo(Integer displayNo) {
        this.displayNo = displayNo;
    }

    public String getOpenModule() {
        return openModule;
    }

    public void setOpenModule(String openModule) {
        this.openModule = openModule;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getFastKey() {
        return fastKey;
    }

    public void setFastKey(String fastKey) {
        this.fastKey = fastKey;
    }

    public String getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDyField1() {
        return dyField1;
    }

    public void setDyField1(String dyField1) {
        this.dyField1 = dyField1;
    }

    public String getDyField2() {
        return dyField2;
    }

    public void setDyField2(String dyField2) {
        this.dyField2 = dyField2;
    }

    public String getDyField3() {
        return dyField3;
    }

    public void setDyField3(String dyField3) {
        this.dyField3 = dyField3;
    }

    public String getDyField4() {
        return dyField4;
    }

    public void setDyField4(String dyField4) {
        this.dyField4 = dyField4;
    }

    public String getDyField5() {
        return dyField5;
    }

    public void setDyField5(String dyField5) {
        this.dyField5 = dyField5;
    }

    public Integer getClickTotal() {
        return clickTotal;
    }

    public void setClickTotal(Integer clickTotal) {
        this.clickTotal = clickTotal;
    }
}
