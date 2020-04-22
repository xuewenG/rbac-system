package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.StaffInfo;
import cn.edu.hfut.rbac.backend.service.impl.RoleServiceImpl;
import cn.edu.hfut.rbac.backend.service.impl.StaffServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/14 18:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffInfoMapperTest {
    @Autowired
    StaffInfoMapper staffInfoMapper;
    @Autowired
    StaffRoleMapper staffRoleMapper;
    @Autowired
    StaffServiceImpl staffService;
    @Autowired
    RoleServiceImpl roleService;
    Logger logger = LoggerFactory.getLogger(StaffInfoMapperTest.class);

    @Test
    public void getByStaffAccount() {
        StaffInfo staffInfo = staffInfoMapper.selectByStaffAccount("2");
        logger.info(staffInfo.toString());
    }

    @Test
    public void getByStaffIdStatus() {
        List<StaffInfo> staffInfoList = staffInfoMapper.selectByIdStatus("01");
        logger.info(staffInfoList.toString());
    }

    @Test
    public void getStaffIdByStaffAccount() {
        String staffId = staffInfoMapper.selectStaffIdByStaffAccount("2");
        logger.info(staffId);
    }

    @Test
    public void addStaff() {
        StaffInfo staff = new StaffInfo();
        staff.setStaffName("xiaoming");
        staff.setStaffState("1");
        staff.setStaffIdStatus("01");
        staff.setPetName("tony");
        staff.setOrganizationId("1");
        staffService.addStaff(staff);
    }

    @Test
    public void deleteStaff() {
        staffService.deleteStaff("4686289061");
    }

    @Test
    public void updateStaff() {
        StaffInfo staff = new StaffInfo();
        staff.setStaffId("5812289197");
        staff.setPetName("lalala");
        staffInfoMapper.updateStaffInfo(staff);
        StaffInfo staffNew = staffInfoMapper.selectByStaffAccount("090c2d086d");
        logger.info(staffNew.toString());

    }

    @Test
    public void configRoleForStaff() {
        //List<Role> roleList = roleService.getRoleList("");
        List<String> roleIdList = new ArrayList<>();
        /*for(Role role : roleList) {
            roleIdList.add(role.getRoleId());
        }
        roleIdL*/
        roleIdList.add("002");
        roleIdList.add("003");
        staffService.configRole(roleIdList, "5812289197");


    }

    @Test
    public void searchByStaffName() {
        //List<StaffBean> staffs = staffService.getStaffList("uewe");
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setStaffId("5812289197");
//        List<Role> roleList = staffRoleMapper.selectRoleByStaff(staffInfo);
//        logger.info(roleList.toString());
    }

    /*@Test
    public void getDiffer() {
        List<StaffRole> list1 = new ArrayList<>();
        List<StaffRole> list2 = new ArrayList<>();
        StaffRole staffRole = new StaffRole();

        staffRole.setStaffId("1");
        staffRole.setRoleId("001");
        list1.add(staffRole);
        staffRole.setRoleId("002");
        list1.add(staffRole);
        staffRole.setRoleId("003");
        list1.add(staffRole);

        staffRole.setRoleId("002");
        list2.add(staffRole);
        staffRole.setRoleId("003");
        list2.add(staffRole);
        staffRole.setRoleId("004");
        list2.add(staffRole);

        List<StaffRole> list = HashSetUtil.getDifferenceList(list1, list2);
        System.out.println(list.toString());

    }*/


}
