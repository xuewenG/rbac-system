package cn.edu.hfut.rbac.backend.mapper;

import cn.edu.hfut.rbac.backend.entity.Enterprise;
import cn.edu.hfut.rbac.backend.mapper.provider.EnterpriseProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    @SelectProvider(type = EnterpriseProvider.class, method = "selectBySearchWordProvider")
    List<Enterprise> selectBySearchWord(String searchWord);

    @InsertProvider(type = EnterpriseProvider.class, method = "addProvider")
    void add(Enterprise enterprise);

    @DeleteProvider(type = EnterpriseProvider.class, method = "deleteByIdProvider")
    void deleteById(String id);

    @UpdateProvider(type = EnterpriseProvider.class,method = "editByIdProvider")
    void editById(Enterprise enterprise);

    @SelectProvider(type = EnterpriseProvider.class, method = "selectEnterpriseNameByEnterpriseIdProvider")
    String selectEnterpriseNameByEnterpriseId(String enterpriseId);
}
