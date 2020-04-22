package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.StaffResponseCode;

/**
 * @author xuewenG
 * @date 2019/8/14 20:05
 */
public class PasswordExpiredException extends BaseException {
    public PasswordExpiredException() {
        super(StaffResponseCode.EXPIRED_PASSWORD, "password expired");
    }
}
