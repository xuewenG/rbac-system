package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.GlobalResponseCode;

/**
 * @author xuewenG
 * @date 2019/8/14 19:42
 */
public class BaseException extends RuntimeException {
    private String code;

    public BaseException(String msg) {
        super(msg);
        this.code = GlobalResponseCode.UNKNOWN_ERROR;
    }

    public BaseException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
