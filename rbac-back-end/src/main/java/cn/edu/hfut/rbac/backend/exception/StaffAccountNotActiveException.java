package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.StaffResponseCode;

/**
 * @author xuewenG
 * @date 2019/8/14 19:55
 */
public class StaffAccountNotActiveException extends BaseException {
    public StaffAccountNotActiveException(String key, String staffAccount) {
        super(StaffResponseCode.ACCOUNT_NOT_ACTIVE, String.format("staff not active, %s : %s", key, staffAccount));
    }
}
