package cn.edu.hfut.rbac.backend.util;


import cn.edu.hfut.rbac.backend.constant.code.GlobalResponseCode;
import cn.edu.hfut.rbac.backend.util.bean.Message;

/**
 * @author xuewenG
 * @date 2019/8/12 13:05
 */
public class ResultUtil {

    private ResultUtil() {
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 接口请求成功返回
     */

    @SuppressWarnings("unchecked")
    public static <T> T success(Object object) {
        Message message = new Message();
        message.setCode(GlobalResponseCode.SUCCESS);
        message.setMsg("请求成功");
        message.setData(object);
        return (T) message;
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 接口请求成功返回
     */
    public static Message success() {
        return success(null);
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 接口请求失败返回
     */
    public static Message error(String code, String resultMessage) {
        Message message = new Message();
        message.setCode(code);
        message.setMsg(resultMessage);
        return message;
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 接口请求失败返回
     */
    public static Message error(String resultMessage) {
        return error(GlobalResponseCode.UNKNOWN_ERROR, resultMessage);
    }

    /**
     * @author xuewenG
     * @date 2019/8/12 13:05
     * 接口请求失败返回
     */
    public static Message error() {
        return error(GlobalResponseCode.UNKNOWN_ERROR, "未知错误");
    }
}
