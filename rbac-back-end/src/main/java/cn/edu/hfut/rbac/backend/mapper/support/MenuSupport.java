package cn.edu.hfut.rbac.backend.mapper.support;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.MenuColumn;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

/**
 * @author xuewenG
 * @date 2019/8/22 14:24
 */
public final class MenuSupport {
    public final static MenuTable menuTable = new MenuTable();
    public final static SqlColumn<String> menuId = menuTable.menuId;
    public final static SqlColumn<String> moduleId = menuTable.moduleId;
    public final static SqlColumn<String> parentId = menuTable.parentId;
    public final static SqlColumn<String> imageUrl = menuTable.imageUrl;
    public final static SqlColumn<String> menuName = menuTable.menuName;
    public final static SqlColumn<String> menuDescription = menuTable.menuDescription;
    public final static SqlColumn<String> menuUrl = menuTable.menuUrl;
    public final static SqlColumn<Integer> displayNo = menuTable.displayNo;
    public final static SqlColumn<String> openModule = menuTable.openModule;
    public final static SqlColumn<String> authId = menuTable.authId;
    public final static SqlColumn<String> fastKey = menuTable.fastKey;
    public final static SqlColumn<String> isHidden = menuTable.isHidden;
    public final static SqlColumn<String> serviceId = menuTable.serviceId;
    public final static SqlColumn<String> isDisplay = menuTable.isDisplay;
    public final static SqlColumn<String> callback = menuTable.callback;
    public final static SqlColumn<String> displayType = menuTable.displayType;
    public final static SqlColumn<String> dyField1 = menuTable.dyField1;
    public final static SqlColumn<String> dyField2 = menuTable.dyField2;
    public final static SqlColumn<String> dyField3 = menuTable.dyField3;
    public final static SqlColumn<String> dyField4 = menuTable.dyField4;
    public final static SqlColumn<String> dyField5 = menuTable.dyField5;
    public final static SqlColumn<Integer> clickTotal = menuTable.clickTotal;

    public static final class MenuTable extends SqlTable {
        public final SqlColumn<String> menuId = column(MenuColumn.MENU_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> moduleId = column(MenuColumn.MODULE_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> parentId = column(MenuColumn.PARENT_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> imageUrl = column(MenuColumn.IMAGE_URL, JDBCType.VARCHAR);
        public final SqlColumn<String> menuName = column(MenuColumn.MENU_NAME, JDBCType.VARCHAR);
        public final SqlColumn<String> menuDescription = column(MenuColumn.MENU_DESCRIPTION, JDBCType.VARCHAR);
        public final SqlColumn<String> menuUrl = column(MenuColumn.MENU_URL, JDBCType.VARCHAR);
        public final SqlColumn<Integer> displayNo = column(MenuColumn.DISPLAY_NO, JDBCType.INTEGER);
        public final SqlColumn<String> openModule = column(MenuColumn.OPEN_MODULE, JDBCType.VARCHAR);
        public final SqlColumn<String> authId = column(MenuColumn.AUTH_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> fastKey = column(MenuColumn.FAST_KEY, JDBCType.VARCHAR);
        public final SqlColumn<String> isHidden = column(MenuColumn.IS_HIDDEN, JDBCType.VARCHAR);
        public final SqlColumn<String> serviceId = column(MenuColumn.SERVICE_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> isDisplay = column(MenuColumn.IS_DISPLAY, JDBCType.VARCHAR);
        public final SqlColumn<String> callback = column(MenuColumn.CALLBACK, JDBCType.VARCHAR);
        public final SqlColumn<String> displayType = column(MenuColumn.DISPLAY_TYPE, JDBCType.VARCHAR);
        public final SqlColumn<String> dyField1 = column(MenuColumn.DY_FIELD1, JDBCType.VARCHAR);
        public final SqlColumn<String> dyField2 = column(MenuColumn.DY_FIELD2, JDBCType.VARCHAR);
        public final SqlColumn<String> dyField3 = column(MenuColumn.DY_FIELD3, JDBCType.VARCHAR);
        public final SqlColumn<String> dyField4 = column(MenuColumn.DY_FIELD4, JDBCType.VARCHAR);
        public final SqlColumn<String> dyField5 = column(MenuColumn.DY_FIELD5, JDBCType.VARCHAR);
        public final SqlColumn<Integer> clickTotal = column(MenuColumn.CLICK_TOTAL, JDBCType.INTEGER);

        public MenuTable() {
            super(TableName.MENU);
        }
    }
}
