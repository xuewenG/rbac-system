package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.constant.database.table.StaffInfoColumn;
import cn.edu.hfut.rbac.backend.entity.StaffInfo;
import cn.edu.hfut.rbac.backend.mapper.provider.StaffInfoProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/14 15:52
 */
@Mapper
public interface StaffInfoMapper {
    /**
     * 根据员工账号获取员工基本信息
     *
     * @param staffAccount 员工账号
     * @return 员工基本信息
     * @author xuewenG
     * @date 2019/8/14 19:24
     */
    @Results(id = "staffInfoResults", value = {
            @Result(column = StaffInfoColumn.ORGANIZATION_ID, property = "organizationId", jdbcType = JdbcType.VARCHAR)
    })
    @SelectProvider(type = StaffInfoProvider.class, method = "selectByStaffAccountProvider")
    StaffInfo selectByStaffAccount(String staffAccount);

    /**
     * 根据账号状态获取员工
     *
     * @param status 账号状态
     * @return 员工基本信息列表
     * @author xuewenG
     * @date 2019/8/14 19:24
     */
    @ResultMap("staffInfoResults")
    @SelectProvider(type = StaffInfoProvider.class, method = "selectByIdStateProvider")
    List<StaffInfo> selectByIdStatus(String status);

    /**
     * 根据员工账号获取员工编号
     *
     * @param staffAccount 员工账号
     * @return 员工编号
     * @author xuewenG
     * @date 2019/8/14 19:24
     */
    @SelectProvider(type = StaffInfoProvider.class, method = "selectStaffIdByStaffAccountProvider")
    String selectStaffIdByStaffAccount(String staffAccount);

    /**
     * 获取员工列表
     */
    @SelectProvider(type = StaffInfoProvider.class, method = "searchByStaffNameProvider")
    @ResultMap("staffInfoResults")
    List<StaffInfo> searchByStaffName(String keyword);

    /**
     * 添加人员
     * 将传过来的数据整理 如人员-角色
     *
     * @param staff
     */
    @InsertProvider(type = StaffInfoProvider.class, method = "insertStaffProvider")
    void insertStaff(StaffInfo staff);

    /**
     * 删除一个人员
     *
     * @param staffId
     */
    @DeleteProvider(type = StaffInfoProvider.class, method = "deleteStaffByStaffIdProvider")
    void deleteStaffByStaffId(String staffId);

    /**
     * 更新人员信息 如：人员状态，账号状态
     */
    @ResultMap("staffInfoResults")
    @UpdateProvider(type = StaffInfoProvider.class, method = "updateStaffInfoProvider")
    void updateStaffInfo(StaffInfo staff);

}
