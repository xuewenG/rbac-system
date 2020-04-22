package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.StaffResponseCode;

/**
 * @author xuewenG
 * @date 2019/8/14 20:06
 */
public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException() {
        super(StaffResponseCode.INVALID_PASSWORD, "invalid password");
    }
}
