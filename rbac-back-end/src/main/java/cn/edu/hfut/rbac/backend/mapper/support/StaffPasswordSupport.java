package cn.edu.hfut.rbac.backend.mapper.support;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffPasswordColumn;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.sql.Timestamp;

/**
 * @author xuewenG
 * @date 2019/8/14 19:34
 */
public class StaffPasswordSupport {
    public static final StaffPasswordTable staffPasswordTable = new StaffPasswordTable();
    public static final SqlColumn<String> staffId = staffPasswordTable.staffId;
    public static final SqlColumn<String> password = staffPasswordTable.password;
    public static final SqlColumn<Timestamp> validStart = staffPasswordTable.validStart;
    public static final SqlColumn<Timestamp> validEnd = staffPasswordTable.validEnd;

    public static final class StaffPasswordTable extends SqlTable {
        public final SqlColumn<String> staffId = column(StaffPasswordColumn.STAFF_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> password = column(StaffPasswordColumn.PASSWORD, JDBCType.VARCHAR);
        public final SqlColumn<Timestamp> validStart = column(StaffPasswordColumn.VALID_START, JDBCType.TIMESTAMP);
        public final SqlColumn<Timestamp> validEnd = column(StaffPasswordColumn.VALID_START, JDBCType.TIMESTAMP);

        public StaffPasswordTable() {
            super(TableName.STAFF_PASSWORD);
        }
    }
}
