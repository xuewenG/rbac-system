package cn.edu.hfut.rbac.backend.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuewenG
 * @date 2019/8/12 13:06
 */
public class TimeUtil {

    private TimeUtil() {
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:06
     */
    public static String getFormatTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:06
     * 比较 time1 和 time2 ，若time1 更早，则返回 true
     */
    public static boolean compareTime(String time1, String time2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.parse(time1).before(sdf.parse(time2));
    }

    /**
     * @throws ParseException 获得添加用户后系统当前时间，作为密码开始生效的时间
     * @author yaxinL
     * @date 2019/9/5 21:21
     */
    public static Timestamp getFormatTimeStamp() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        Date date = dateFormat.parse(getFormatTime());
        return new Timestamp(date.getTime());
    }

    /**
     * @return 设置用户密码生效结束时间（添加用户或用户修改密码后20天内有效，20天之后要修改）
     * @author yaxinL
     * @date 2019/9/5 21:21
     */
    public static Timestamp getFormatValidEndTime(Timestamp validStart) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        long validEnd = validStart.getTime() + 20 * 24 * 60 * 60 * 1000;
        Date date = dateFormat.parse(dateFormat.format(new Date(validEnd)));
        return new Timestamp(date.getTime());
    }
}