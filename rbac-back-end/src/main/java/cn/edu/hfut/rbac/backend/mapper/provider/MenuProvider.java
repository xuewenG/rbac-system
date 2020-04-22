package cn.edu.hfut.rbac.backend.mapper.provider;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.MenuColumn;
import cn.edu.hfut.rbac.backend.util.SqlUtil;
import org.apache.ibatis.jdbc.SQL;

public class MenuProvider {
    public String selectByMenuIdProvider(String menuId) {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.MENU);
            WHERE(String.format("%s = #{menuId}", MenuColumn.MENU_ID));
        }}.toString();
    }

    public String selectAllProvider() {
        return new SQL() {{
            SELECT("*");
            FROM(TableName.MENU);
        }}.toString();
    }

    public String checkExistByMenuIdProvider(String menuId) {
        return String.format("SELECT EXISTS(SELECT 1 FROM %s WHERE %s=#{%s})",
                TableName.MENU,
                MenuColumn.MENU_ID,
                "menuId");
    }

    public String checkAuthExistByAuthIdProvider(String authId) {
        return String.format("SELECT EXISTS(SELECT 1 FROM %s WHERE %s=#{%s})",
                TableName.MENU,
                MenuColumn.AUTH_ID,
                "authId");
    }

    public String insertOneProvider(String menuId, String menuName, String parentId,
                                    String menuDescription, String menuUrl, String authId, String moduleId) {
        return new SQL() {{
            INSERT_INTO(TableName.MENU);
            VALUES(MenuColumn.MENU_ID, SqlUtil.constant(menuId));
            VALUES(MenuColumn.DISPLAY_NO, SqlUtil.constant("1"));
            VALUES(MenuColumn.OPEN_MODULE, SqlUtil.constant("OM"));
            VALUES(MenuColumn.IS_HIDDEN, SqlUtil.constant("1"));
            VALUES(MenuColumn.IS_DISPLAY, SqlUtil.constant("1"));

            VALUES(MenuColumn.MENU_NAME, "#{menuName}");
            VALUES(MenuColumn.PARENT_ID, "#{parentId}");
            VALUES(MenuColumn.MENU_DESCRIPTION, "#{menuDescription}");
            VALUES(MenuColumn.MENU_URL, "#{menuUrl}");
            VALUES(MenuColumn.AUTH_ID, "#{authId}");
            VALUES(MenuColumn.MODULE_ID, "#{moduleId}");
        }}.toString();
    }

    public String deleteByMenuIdProvider(String menuId) {
        return new SQL() {{
            DELETE_FROM(TableName.MENU);
            WHERE(SqlUtil.isEqual(MenuColumn.MENU_ID, "menuId"));
        }}.toString();
    }

    public String selectChildrenIdListByMenuIdProvider(String menuId) {
        return new SQL() {{
            SELECT(MenuColumn.MENU_ID);
            FROM(TableName.MENU);
            WHERE(SqlUtil.isEqual(MenuColumn.PARENT_ID, "menuId"));
        }}.toString();
    }
}
