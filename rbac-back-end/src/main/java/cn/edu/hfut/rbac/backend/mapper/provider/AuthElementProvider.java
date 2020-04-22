package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.AuthElementColumn;
import cn.edu.hfut.rbac.backend.entity.AuthElement;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class AuthElementProvider {

    public String insertAuthByBatchProvider(List<AuthElement> authList) {
        String sql = null;
        for (AuthElement auth : authList) {
            sql.join(new SQL() {{
                INSERT_INTO(TableName.AUTH_ELEMENT);
                VALUES(AuthElementColumn.AUTH_ID, auth.getAuthId());
                VALUES(AuthElementColumn.MODULE_ID, auth.getModuleId());
                VALUES(AuthElementColumn.AUTH_CODE, auth.getAuthCode());
                VALUES(AuthElementColumn.SUPER_CODE, auth.getSuperCode());
                VALUES(AuthElementColumn.AUTH_NAME, auth.getAuthName());
                VALUES(AuthElementColumn.MENU_FLAG, auth.getAuthName());
                VALUES(AuthElementColumn.DESCRIPTION, auth.getDescription());
            }}.toString());
        }
        return sql;
    }

    public String deleteByAuthIdProvider(String authId) {
        return new SQL() {{
            DELETE_FROM(TableName.AUTH_ELEMENT);
            WHERE(SqlUtil.isEqual(AuthElementColumn.AUTH_ID, "authId"));
        }}.toString();
    }

    public String selectAllAuthProvider(String moduleId) {
        return new SQL() {{
            SELECT(AuthElementColumn.AUTH_ID, AuthElementColumn.AUTH_NAME, AuthElementColumn.DESCRIPTION);
            FROM(TableName.AUTH_ELEMENT);
            WHERE(String.format("%s = #{moduleId}", AuthElementColumn.MODULE_ID));
        }}.toString();
    }

    public String selectByAuthNameProvider(String authName) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.AUTH_ELEMENT);
            WHERE(AuthElementColumn.AUTH_NAME + " like concat('%', #{authName}, '%')");
        }}.toString();
    }

    public String selectByAuthIdProvider(String authId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.AUTH_ELEMENT);
            WHERE(SqlUtil.isEqual(AuthElementColumn.AUTH_ID, authId));
        }}.toString();
    }

    public String checkExistByAuthIdProvider(String authId) {
        return String.format("SELECT EXISTS(SELECT 1 FROM %s WHERE %s=#{%s})",
                TableName.AUTH_ELEMENT,
                AuthElementColumn.AUTH_ID,
                "authId");
    }

    public String insertAuthProvider(String authId, String authName, String moduleId, String authCode,
                                     String superCode, String menuFlag, String description) {
        return new SQL() {{
            INSERT_INTO(TableName.AUTH_ELEMENT);
            VALUES(AuthElementColumn.AUTH_ID, SqlUtil.value("authId"));
            VALUES(AuthElementColumn.AUTH_NAME, SqlUtil.value("authName"));
            VALUES(AuthElementColumn.MODULE_ID, SqlUtil.value("moduleId"));
            VALUES(AuthElementColumn.AUTH_CODE, SqlUtil.value("authCode"));
            VALUES(AuthElementColumn.SUPER_CODE, SqlUtil.value("superCode"));
            VALUES(AuthElementColumn.MENU_FLAG, SqlUtil.value("menuFlag"));
            VALUES(AuthElementColumn.DESCRIPTION, SqlUtil.value("description"));
        }}.toString();
    }
}
