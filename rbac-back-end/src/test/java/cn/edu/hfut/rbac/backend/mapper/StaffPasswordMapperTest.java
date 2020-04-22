package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.StaffPassword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuewenG
 * @date 2019/9/2 21:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffPasswordMapperTest {
    @Autowired
    StaffPasswordMapper staffPasswordMapper;
    Logger logger = LoggerFactory.getLogger(StaffPasswordMapperTest.class);

    @Test
    public void selectByStaffIdTest() {
        StaffPassword staffPassword = staffPasswordMapper.selectByStaffId("2");
        if (staffPassword != null) {
            logger.info(staffPassword.toString());
        }
    }

    @Test
    public void insertStaffPwd() {
        StaffPassword staffPassword = new StaffPassword();
        staffPassword.setStaffId("5812289197");
        staffPasswordMapper.insertStaffPwdReport(staffPassword);
    }

    @Test
    public void deleteStaffPwd() {
        staffPasswordMapper.deleteStaffPwdReport("5812289197");
    }

    @Test
    public void updateStaffPwd() {
        StaffPassword staffPassword = new StaffPassword();
        staffPassword.setStaffId("5812289197");
        staffPassword.setPassword("000000");
        staffPasswordMapper.updateStaffPwdReport(staffPassword);
    }


}
