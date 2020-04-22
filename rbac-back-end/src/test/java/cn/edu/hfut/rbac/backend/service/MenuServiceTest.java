package cn.edu.hfut.rbac.backend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuewenG
 * @date 2019/8/22 14:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {
    @Autowired
    MenuService menuService;

    @Test
    public void addMenuTest() {
//        menuService.addMenu("测试菜单", "2",
//                "菜单描述", "/menu/url", "1", "mo3");
    }
}
