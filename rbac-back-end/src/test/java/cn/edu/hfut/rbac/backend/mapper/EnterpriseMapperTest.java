package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Enterprise;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterpriseMapperTest {
    @Autowired
    EnterpriseMapper enterpriseMapper;
    Logger logger = LoggerFactory.getLogger(MenuMapperTest.class);

    @Test
    public void selectBySearchWordTest() {
        List<Enterprise> enterpriseList = enterpriseMapper.selectBySearchWord("合");
        logger.info(enterpriseList.toString());
    }
}
