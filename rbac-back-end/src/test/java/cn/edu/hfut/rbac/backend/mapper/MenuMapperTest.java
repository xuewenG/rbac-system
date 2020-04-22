package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/22 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuMapperTest {
    @Autowired
    MenuMapper menuMapper;
    Logger logger = LoggerFactory.getLogger(MenuMapperTest.class);

    @Test
    public void selectByMenuIdTest() {
        Menu menu = menuMapper.selectByMenuId("2");
        if (menu != null) {
            logger.info(menu.toString());
        }
    }

    @Test
    public void selectAllTest() {
        List<Menu> menuMapperList = menuMapper.selectAll();
        logger.info(menuMapperList.toString());
    }

    @Test
    public void checkExistByMenuIdTest() {
        Boolean exist = menuMapper.checkExistByMenuId("13");
        if (exist) {
            logger.info("exist");
        } else {
            logger.info("not exist");
        }
    }

    @Test
    public void insertOneTest() {
//        menuMapper.insertOne("122501", "测试菜单", "2",
//                "菜单描述", "/menu/url", "1", "mo2");
    }

    @Test
    public void selectChildrenIdListByMenuIdTest() {
        System.out.println(menuMapper.selectChildrenIdListByMenuId("9"));

    }
}
