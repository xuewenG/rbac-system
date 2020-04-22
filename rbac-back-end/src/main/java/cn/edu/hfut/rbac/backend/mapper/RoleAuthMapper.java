package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.AuthElement;
import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.entity.RoleAuth;
import cn.edu.hfut.rbac.backend.mapper.provider.RoleAuthProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface RoleAuthMapper {

    /**
     * 查询 角色-权限列表
     *
     * @param roleId
     * @return 子系统下的角色-权限列表
     * @author
     * @date
     */
    @SelectProvider(type = RoleAuthProvider.class, method = "selectRoleAuthByRoleProvider")
    List<RoleAuth> selectRoleAuthByRole(String roleId);

    /**
     * 查询子系统下的所有角色
     *
     * @param moduleId
     * @return 子系统下的角色列表
     * @author
     * @date
     */
    @SelectProvider(type = RoleAuthProvider.class, method = "selectRoleByModuleIdProvider")
    List<Role> selectRoleByModuleId(String moduleId);

    /**
     * 为角色设置权限
     *
     * @param roleAuth
     * @author
     * @date
     */
    @InsertProvider(type = RoleAuthProvider.class, method = "configAuthForRoleProvider")
    void configAuthForRole(RoleAuth roleAuth);

    /**
     * 为角色撤销权限
     *
     * @param roleAuth
     * @author
     * @date
     */
    @DeleteProvider(type = RoleAuthProvider.class, method = "dropAuthFromRoleProvider")
    void dropAuthFromRole(RoleAuth roleAuth);

    /**
     * 查询该角色所拥有的所有权限
     *
     * @param roleId
     * @author
     * @date
     */
    @SelectProvider(type = RoleAuthProvider.class, method = "selectAuthByRoleProvider")
    List<AuthElement> selectAuthByRole(String roleId);

}
