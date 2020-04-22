package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.entity.AuthElement;

import java.util.List;

public interface AuthElementService {
    /**
     * 根据 authName 搜索权限
     *
     * @param authName 权限名称
     * @return 权限列表
     * @author xuewenG
     */
    List<AuthElement> searchByAuthName(String authName);

    /**
     * 添加权限
     *
     * @param authName    权限名称
     * @param moduleId    组件名
     * @param authCode    权限号码
     * @param superCode   上级号码
     * @param menuFlag    菜单类别
     * @param description 描述
     * @author xuewenG
     */
    void addAuth(String authName, String moduleId, String authCode,
                 String superCode, String menuFlag, String description);

    /**
     * 删除权限
     *
     * @param authId 权限编号
     * @author xuewenG
     */
    void deleteAuth(String authId);
}
