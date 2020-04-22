package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.controller.bean.StaffBean;
import cn.edu.hfut.rbac.backend.entity.StaffInfo;
import cn.edu.hfut.rbac.backend.entity.StaffPassword;

import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/14 15:25
 */
public interface StaffService {
    /**
     * 登录业务
     *
     * @param staffAccount 员工账号
     * @param password     密码
     * @return 员工基本信息
     * @author xuewenG
     * @date 2019/8/14 19:40
     */
    StaffInfo login(String staffAccount, String password);

    /**
     * 根据账号查找员工基本信息
     *
     * @param staffAccount 员工账号
     * @return 员工基本信息
     * @author xuewenG
     * @date 2019/8/14 15:25
     */
    StaffInfo getStaffByStaffAccount(String staffAccount);

    /**
     * 根据账号查找员工编号
     *
     * @param staffAccount 员工账号
     * @return 员工编号
     * @author xuewenG
     * @date 2019/8/14 15:25
     */
    String getStaffIdByStaffAccount(String staffAccount);

    /**
     * 检查员工账号是否处于可用状态
     *
     * @param staffInfo 员工基本信息
     * @return 员工账号是否可用
     * @author xuewenG
     * @date 2019/8/14 19:49
     */
    Boolean isActive(StaffInfo staffInfo);

    /**
     * 获取员工列表
     *
     * @param
     * @return 所有员工列表
     * @author yaxinL
     */
    List<StaffBean> getStaffList(String keyword);

    /**
     * 添加员工（注册业务）
     */
    void addStaff(StaffInfo staff);

    /**
     * 删除员工
     */
    void deleteStaff(String staffId);

    /**
     * 更新员工信息
     */
    void updateStaff(StaffInfo staff);

    /**
     * 配置角色
     */
    void configRole(List<String> roleIdList, String staffId);

    /**
     * 修改密码
     */
    void updatePassword(StaffPassword staffPassword);

    /**
     * 为员工配置工作组
     *
     * @param staffId     员工编号
     * @param groupIdList 工作组列表
     * @author xuewenG
     */
    void configGroup(String staffId, List<String> groupIdList);
}
