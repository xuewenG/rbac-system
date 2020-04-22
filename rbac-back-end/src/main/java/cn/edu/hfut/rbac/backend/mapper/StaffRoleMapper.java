package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.entity.StaffInfo;
import cn.edu.hfut.rbac.backend.entity.StaffRole;
import cn.edu.hfut.rbac.backend.mapper.provider.StaffRoleProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StaffRoleMapper {

    /**
     * 根据角色查询人员-角色列表
     *
     * @param roleId
     * @return 人员-角色列表
     * @author yaxinL
     * @date
     */
    @SelectProvider(type = StaffRoleProvider.class, method = "selectStaffRoleByRoleProvider")
    List<StaffRole> selectStaffRoleByRole(String roleId);

    /**
     * 查询该角色下的所有人员
     *
     * @param roleId
     * @return 某角色下的人员列表
     * @author yaxinL
     * @date
     */
    //TODO 返回值待定
    @SelectProvider(type = StaffRoleProvider.class, method = "selectStaffListByRoleIdProvider")
    List<StaffInfo> selectStaffListByRoleId(String roleId);

    /**
     * 为角色批量添加人员
     *
     * @param staffRoleList
     * @author yaxinL
     * @date
     */
    @InsertProvider(type = StaffRoleProvider.class, method = "insertStaffForRoleProvider")
    void insertStaffForRole(@Param("staffRoleList") List<StaffRole> staffRoleList);

    @InsertProvider(type = StaffRoleProvider.class, method = "insertStaffRoleProvider")
    void insertStaffRole(StaffRole staffRole);


    /**
     * 为角色批量删除人员
     *
     * @param staffRoleList
     * @author yaxinL
     * @date
     */
    @DeleteProvider(type = StaffRoleProvider.class, method = "deleteStaffForRoleProvider")
    void deleteStaffForRole(@Param("staffRoleList") List<StaffRole> staffRoleList);

    @DeleteProvider(type = StaffRoleProvider.class, method = "deleteStaffRoleProvider")
    void deleteByStaffRole(StaffRole staffRole);

    /**
     * 根据人员Id查询人员-角色列表
     *
     * @param staffId
     * @return 人员-角色列表
     * @author yaxinL
     * @date
     */
    @SelectProvider(type = StaffRoleProvider.class, method = "selectStaffRoleByStaffIdProvider")
    List<StaffRole> selectStaffRoleListByStaffId(String staffId);

    /**
     * 查询该人员所拥有的所有角色
     *
     * @param staffId
     * @return 某人员被赋予的角色列表
     * @author yaxinL
     * @date
     */
    @SelectProvider(type = StaffRoleProvider.class, method = "selectRoleListByStaffIdProvider")
    List<Role> selectRoleListByStaffId(String staffId);

    /**
     * 为人员配置角色
     *
     * @param staffRoleList
     * @author yaxinL
     * @date
     */
    @InsertProvider(type = StaffRoleProvider.class, method = "configRoleForStaffProvider")
    void configRoleForStaff(@Param("staffRoleList") List<StaffRole> staffRoleList);

    /**
     * 为人员撤销角色
     *
     * @param staffRoleList
     * @author
     * @date
     */
    @DeleteProvider(type = StaffRoleProvider.class, method = "dropRoleForStaffProvider")
    void dropRoleForStaff(@Param("staffRoleList") List<StaffRole> staffRoleList);

}
