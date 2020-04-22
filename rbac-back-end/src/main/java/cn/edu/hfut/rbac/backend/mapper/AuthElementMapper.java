package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.AuthElement;
import cn.edu.hfut.rbac.backend.mapper.provider.AuthElementProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthElementMapper {

    /**
     * 为子系统添加权限
     *
     * @param authList
     * @author
     */
    @InsertProvider(type = AuthElementProvider.class, method = "insertAuthByBatchProvider")
    void insertAuthByBatch(List<AuthElement> authList);

    /**
     * 为子系统撤销权限
     *
     * @param authId 权限编号
     * @author xuewenG
     */
    @DeleteProvider(type = AuthElementProvider.class, method = "deleteByAuthIdProvider")
    void deleteByAuthId(String authId);

    /**
     * 查询子系统所拥有全部权限
     *
     * @param moduleId
     * @return 子系统的权限列表
     * @author
     */
    @UpdateProvider(type = AuthElementProvider.class, method = "selectAllAuthProvider")
    List<AuthElement> selectAllAuth(String moduleId);

    /**
     * 根据 authName 查询权限
     *
     * @param authName 权限名
     * @return 权限列表
     * @author xuewenG
     */
    @SelectProvider(type = AuthElementProvider.class, method = "selectByAuthNameProvider")
    List<AuthElement> selectByAuthName(String authName);

    /**
     * 根据 authName 查询权限
     *
     * @param authId 权限编号
     * @return 权限列表
     * @author xuewenG
     */
    @SelectProvider(type = AuthElementProvider.class, method = "selectByAuthIdProvider")
    AuthElement selectByAuthId(String authId);

    /**
     * 检查指定的 authId 是否存在
     *
     * @param authId 权限编号
     * @return 是否存在
     * @author xuewen
     */
    @SelectProvider(type = AuthElementProvider.class, method = "checkExistByAuthIdProvider")
    Boolean checkExistByAuthId(String authId);

    /**
     * 添加权限
     *
     * @param authId      权限编号
     * @param authName    权限名称
     * @param moduleId    组件名
     * @param authCode    权限号码
     * @param superCode   上级号码
     * @param menuFlag    菜单类别
     * @param description 描述
     * @author xuewen
     */
    @InsertProvider(type = AuthElementProvider.class, method = "insertAuthProvider")
    void insertAuth(String authId, String authName, String moduleId, String authCode,
                    String superCode, String menuFlag, String description);
}
