package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.mapper.provider.RoleProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface RoleMapper {
    /**
     * 通过角色编号获得角色具体信息（精确查询）
     *
     * @param roleId 角色编号
     * @return 角色具体信息
     * @author yaxinL
     * @date
     */
    @SelectProvider(type = RoleProvider.class, method = "getAccurateRoleByRoleIdProvider")
    Role getAccurateRoleByRoleId(String roleId);

    /**
     * 根据输入框内的数据查询所有符合条件的角色信息得到角色列表（模糊查询）
     *
     * @param roleName 角色名
     * @return 角色具体信息（列表）
     * @author yaxinL
     * @date
     */
    @SelectProvider(type = RoleProvider.class, method = "searchRoleByRoleNameProvider")
    List<Role> searchRoleByRoleName(String roleName);

    /**
     * 添加一个角色
     *
     * @param role 角色对象
     * @return 角色具体信息（列表）
     * @author yaxinL
     * @date
     */
    @InsertProvider(type = RoleProvider.class, method = "insertSelectiveProvider")
    void insertSelective(Role role);

    /**
     * 批量添加角色
     *
     * @param roleList 批量添加的角色列表
     * @return 角色具体信息（列表）
     * @author yaxinL
     * @date
     */
    @InsertProvider(type = RoleProvider.class, method = "insertByBatchProvider")
    void insertByBatch(@Param("roleList") List<Role> roleList);

    /**
     * 删除一个角色
     *
     * @return 角色具体信息（列表）
     * @author yaxinL
     * @date
     */
    @DeleteProvider(type = RoleProvider.class, method = "deleteByRoleIdProvider")
    void deleteByRoleId(String roleId);

    /**
     * 批量删除角色
     *
     * @param roleList 批量删除的角色列表
     * @author yaxinL
     * @date
     */
    @DeleteProvider(type = RoleProvider.class, method = "deleteRoleByBatchProvider")
    void deleteRoleByBatch(List<Role> roleList);

    /**
     * 更新角色信息
     *
     * @param role 角色对象
     * @author yaxinL
     * @date
     */
    @UpdateProvider(type = RoleProvider.class, method = "updateRoleBySuperCodeSelectiveProvider")
    void updateRoleBySuperCodeSelective(Role role);


}
