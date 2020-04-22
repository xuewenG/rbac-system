package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.entity.AuthElement;
import cn.edu.hfut.rbac.backend.exception.BaseException;
import cn.edu.hfut.rbac.backend.mapper.AuthElementMapper;
import cn.edu.hfut.rbac.backend.mapper.MenuMapper;
import cn.edu.hfut.rbac.backend.service.AuthElementService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthElementServiceImpl implements AuthElementService {
    @Autowired
    AuthElementMapper authElementMapper;
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<AuthElement> searchByAuthName(String authName) {
        return authElementMapper.selectByAuthName(authName);
    }

    @Override
    public void addAuth(String authName, String moduleId, String authCode,
                        String superCode, String menuFlag, String description) {
        String authId;
        while (true) {
            authId = RandomStringUtils.randomNumeric(6);
            Boolean exist = authElementMapper.checkExistByAuthId(authId);
            if (!exist) {
                break;
            }
        }
        authElementMapper.insertAuth(authId, authName, moduleId, authCode, superCode, menuFlag, description);
    }

    @Override
    public void deleteAuth(String authId) {
        Boolean exist = menuMapper.checkAuthExistByAuthId(authId);
        if (exist) {
            throw new BaseException("权限在使用中");
        }
        authElementMapper.deleteByAuthId(authId);
    }
}
