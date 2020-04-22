package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleService roleService;
    Logger logger = LoggerFactory.getLogger(RoleMapperTest.class);

    @Test
    public void insertRole() {
        Role role = new Role();
        role.setRoleId("001");
        role.setRoleCode("2017100001");
        role.setRoleName("hero");
        role.setSuperCode("2017000001");
        role.setDescription("I am a bright man");
        roleMapper.insertSelective(role);

    }

    @Test
    public void insertRoleList() {
        List<Role> roleList = new ArrayList<>();

        Role role = new Role();

        role.setRoleId("002");
        role.setRoleCode("2017100002");
        role.setRoleName("heroine");
        role.setSuperCode("2017000001");
        role.setDescription("I am an elegant lady");
        roleList.add(role);

        role.setRoleId("003");
        role.setRoleCode("2017200001");
        role.setRoleName("male supporting role");
        role.setSuperCode("2017000001");
        role.setDescription("I love heroine");
        roleList.add(role);

        role.setRoleId("004");
        role.setRoleCode("2017200002");
        role.setRoleName("female supporting role");
        role.setSuperCode("2017000001");
        role.setDescription("I admire male supporting role");
        roleList.add(role);

//        roleMapper.insertByBatch(roleList);
    }

    @Test
    public void getRoleByRoleId() {
        Role role = roleMapper.getAccurateRoleByRoleId("001");
//        logger.info(role.toString());
    }

    @Test
    public void getRoleByRoleName() {
        List<Role> roleList = roleMapper.searchRoleByRoleName("ero");
        logger.info(roleList.toString());
    }

    @Test
    public void deleteRole() {
        roleService.deleteRole("002");
    }


}
