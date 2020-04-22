package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.StaffPassword;
import cn.edu.hfut.rbac.backend.mapper.provider.StaffPasswordProvider;
import org.apache.ibatis.annotations.*;

/**
 * @author xuewenG
 * @date 2019/8/14 19:33
 */
@Mapper
public interface StaffPasswordMapper {
    /**
     * 查询多条记录
     *
     * @param staffId 员工编号
     * @return 员工密码记录
     * @author xuewenG
     * @date 2019/8/14 19:37
     */
    @SelectProvider(type = StaffPasswordProvider.class, method = "selectByStaffIdProvider")
    StaffPassword selectByStaffId(String staffId);

    /**
     * 添加账户密码记录
     *
     * @param staffPassword
     * @author yaxinL
     */
    @InsertProvider(type = StaffPasswordProvider.class, method = "insertStaffPwdReportProvider")
    void insertStaffPwdReport(StaffPassword staffPassword);

    /**
     * 删除账户密码记录
     *
     * @param staffId
     * @author yaxinL
     */
    @DeleteProvider(type = StaffPasswordProvider.class, method = "deleteStaffPwdReportProvider")
    void deleteStaffPwdReport(String staffId);

    /**
     * 修改密码
     *
     * @param staffPassword
     * @author yaxinL
     */
    @UpdateProvider(type = StaffPasswordProvider.class, method = "updateStaffPwdReportProvider")
    void updateStaffPwdReport(StaffPassword staffPassword);
}
