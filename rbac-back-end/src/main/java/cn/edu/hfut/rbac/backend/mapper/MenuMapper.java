package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Menu;
import cn.edu.hfut.rbac.backend.mapper.provider.MenuProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/22 14:23
 */
@Mapper
public interface MenuMapper {
    /**
     * 根据编号查询菜单
     *
     * @param menuIdPara 菜单编号
     * @return 菜单记录
     * @author xuewenG
     * @date 2019/8/22 14:35
     */
    @SelectProvider(type = MenuProvider.class, method = "selectByMenuIdProvider")
    Menu selectByMenuId(String menuIdPara);

    /**
     * 获取所有菜单记录
     *
     * @return 菜单记录列表
     * @author xuewenG
     * @date 2019/8/22 14:35
     */
    @SelectProvider(type = MenuProvider.class, method = "selectAllProvider")
    List<Menu> selectAll();

    /**
     * 检查 menuId 是否存在
     *
     * @param menuId 菜单编号
     * @return 是否存在
     * @author xuewenG
     * @date 2019/9/11
     */
    @SelectProvider(type = MenuProvider.class, method = "checkExistByMenuIdProvider")
    Boolean checkExistByMenuId(String menuId);

    /**
     * 添加菜单
     *
     * @param menuId          菜单编号
     * @param menuName        菜单名称
     * @param parentId        父菜单编号
     * @param menuDescription 菜单描述
     * @param menuUrl         菜单地址
     * @param authId          权限编号
     * @author xuewenG
     * @date 2019/9/11
     */
    @InsertProvider(type = MenuProvider.class, method = "insertOneProvider")
    void insertOne(String menuId, String menuName, String parentId,
                   String menuDescription, String menuUrl, String authId, String moduleId);

    /**
     * 根据 menuId 删除菜单项
     *
     * @param menuId 菜单编号
     * @author xuewenG
     * @date 2019/9/11
     */
    @DeleteProvider(type = MenuProvider.class, method = "deleteByMenuIdProvider")
    void deleteByMenuId(String menuId);

    /**
     * 根据 menuId 查找子菜单
     *
     * @return 子菜单编号列表
     * @author xuewenG
     * @date 2019/9/11
     */
    @SelectProvider(type = MenuProvider.class, method = "selectChildrenIdListByMenuIdProvider")
    List<String> selectChildrenIdListByMenuId(String menuId);

    /**
     * 检查是否存在以 authId 为权限的菜单
     *
     * @param authId 权限编号
     * @return 是否存在
     * @author xuewenG
     */
    @SelectProvider(type = MenuProvider.class, method = "checkAuthExistByAuthIdProvider")
    Boolean checkAuthExistByAuthId(String authId);
}
