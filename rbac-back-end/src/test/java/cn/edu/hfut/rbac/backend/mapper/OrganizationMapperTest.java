package cn.edu.hfut.rbac.backend.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuewenG
 * @date 2019/9/2 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationMapperTest {
    @Autowired
    OrganizationMapper organizationMapper;
    Logger logger = LoggerFactory.getLogger(OrganizationMapperTest.class);

    @Test
    public void selectByOrganizationIdTest() {
    }
}
