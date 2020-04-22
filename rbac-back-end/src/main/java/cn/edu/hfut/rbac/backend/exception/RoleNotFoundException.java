package cn.edu.hfut.rbac.backend.exception;

import cn.edu.hfut.rbac.backend.constant.code.RoleResponseCode;

public class RoleNotFoundException extends BaseException {
    public RoleNotFoundException(String role, String roleName) {
        super(RoleResponseCode.ROLE_NOT_FOUNT, String.format("role not found, %s : %s", role, roleName));

    }
}
