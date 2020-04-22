package cn.edu.hfut.rbac.backend.mapper.support;

import cn.edu.hfut.rbac.backend.constant.database.TableName;
import cn.edu.hfut.rbac.backend.constant.database.table.StaffInfoColumn;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.sql.Timestamp;

/**
 * @author xuewenG
 * @date 2019/8/14 18:24
 */
public final class StaffInfoSupport {
    public static final StaffInfoTable staffInfoTable = new StaffInfoTable();
    public static final SqlColumn<String> staffId = staffInfoTable.staffId;
    public static final SqlColumn<String> staffName = staffInfoTable.staffName;
    public static final SqlColumn<String> staffState = staffInfoTable.staffState;
    public static final SqlColumn<String> staffIdStatus = staffInfoTable.staffIdStatus;
    public static final SqlColumn<Double> dLevelId = staffInfoTable.dLevelId;
    public static final SqlColumn<String> dlModulus = staffInfoTable.dlModulus;
    public static final SqlColumn<String> secondPost = staffInfoTable.secondPost;
    public static final SqlColumn<String> dutyId = staffInfoTable.dutyId;
    public static final SqlColumn<String> secondDuty = staffInfoTable.secondDuty;
    public static final SqlColumn<String> organizationId = staffInfoTable.organizationId;
    public static final SqlColumn<String> postId = staffInfoTable.postId;
    public static final SqlColumn<String> staffAccount = staffInfoTable.staffAccount;
    public static final SqlColumn<Timestamp> disableBeginDate = staffInfoTable.disableBeginDate;
    public static final SqlColumn<Timestamp> disableEndDate = staffInfoTable.disableEndDate;
    public static final SqlColumn<Timestamp> updateTime = staffInfoTable.updateTime;
    public static final SqlColumn<String> batchNo = staffInfoTable.batchNo;
    public static final SqlColumn<String> workEfficiency = staffInfoTable.workEfficiency;
    public static final SqlColumn<String> petName = staffInfoTable.petName;

    public static final class StaffInfoTable extends SqlTable {
        public final SqlColumn<String> staffId = column(StaffInfoColumn.STAFF_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> staffName = column(StaffInfoColumn.STAFF_NAME, JDBCType.VARCHAR);
        public final SqlColumn<String> staffState = column(StaffInfoColumn.STAFF_STATE, JDBCType.VARCHAR);
        public final SqlColumn<String> staffIdStatus = column(StaffInfoColumn.STAFF_ID_STATUS, JDBCType.VARCHAR);
        public final SqlColumn<Double> dLevelId = column(StaffInfoColumn.D_LEVEL_ID, JDBCType.DOUBLE);
        public final SqlColumn<String> dlModulus = column(StaffInfoColumn.DL_MODULUS, JDBCType.VARCHAR);
        public final SqlColumn<String> secondPost = column(StaffInfoColumn.SECOND_POST, JDBCType.VARCHAR);
        public final SqlColumn<String> dutyId = column(StaffInfoColumn.DUTY_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> secondDuty = column(StaffInfoColumn.SECOND_DUTY, JDBCType.VARCHAR);
        public final SqlColumn<String> organizationId = column(StaffInfoColumn.ORGANIZATION_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> postId = column(StaffInfoColumn.POST_ID, JDBCType.VARCHAR);
        public final SqlColumn<String> staffAccount = column(StaffInfoColumn.STAFF_ACCOUNT, JDBCType.VARCHAR);
        public final SqlColumn<Timestamp> disableBeginDate = column(StaffInfoColumn.DISABLE_BEGIN_DATE, JDBCType.TIMESTAMP);
        public final SqlColumn<Timestamp> disableEndDate = column(StaffInfoColumn.DISABLE_END_DATE, JDBCType.TIMESTAMP);
        public final SqlColumn<Timestamp> updateTime = column(StaffInfoColumn.UPDATE_TIME, JDBCType.TIMESTAMP);
        public final SqlColumn<String> batchNo = column(StaffInfoColumn.BATCH_NO, JDBCType.VARCHAR);
        public final SqlColumn<String> workEfficiency = column(StaffInfoColumn.WORK_EFFICIENCY, JDBCType.VARCHAR);
        public final SqlColumn<String> petName = column(StaffInfoColumn.PET_NAME, JDBCType.VARCHAR);

        public StaffInfoTable() {
            super(TableName.STAFF_INFO);
        }
    }
}
