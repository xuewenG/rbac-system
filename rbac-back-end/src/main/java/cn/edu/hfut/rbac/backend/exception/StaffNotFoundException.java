package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.StaffResponseCode;

/**
 * @author xuewenG
 * @date 2019/8/14 19:43
 */
public class StaffNotFoundException extends BaseException {
    public StaffNotFoundException(String key, String staffAccount) {
        super(StaffResponseCode.USER_NOT_FOUNT, String.format("staff not found, %s : %s", key, staffAccount));
    }
}
