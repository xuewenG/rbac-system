package cn.edu.hfut.rbac.backend.util;

public class SqlUtil {
    private SqlUtil() {
    }

    public static String isEqual(String column, String valueName) {
        return String.format("%s = #{%s}", column, valueName);
    }

    public static String value(String valueName) {
        return String.format("#{%s}", valueName);
    }

    public static String fullName(String tableName, String colunmName) {
        return String.format("%s.%s", tableName, colunmName);
    }

    public static String constant(String c) {
        return String.format("'%s'", c);
    }
}
