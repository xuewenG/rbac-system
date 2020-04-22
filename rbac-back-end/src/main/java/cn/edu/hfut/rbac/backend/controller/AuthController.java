package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.AuthUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.AddAuthReqBean;
import cn.edu.hfut.rbac.backend.controller.bean.DeleteAuthReqBean;
import cn.edu.hfut.rbac.backend.controller.bean.SearchAuthReqBean;
import cn.edu.hfut.rbac.backend.controller.bean.SearchAuthRespBean;
import cn.edu.hfut.rbac.backend.entity.AuthElement;
import cn.edu.hfut.rbac.backend.service.AuthElementService;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(AuthUrlConstant.AUTH)
public class AuthController {
    @Autowired
    AuthElementService authElementService;

    @PostMapping(AuthUrlConstant.GET)
    public Message searchAuth(@RequestBody @Valid SearchAuthReqBean searchAuthReqBean) {
        Integer page = searchAuthReqBean.getPage();
        Integer pageSize = searchAuthReqBean.getPageSize();
        String searchWord = searchAuthReqBean.getSearchWord();

        PageHelper.startPage(page, pageSize);
        List<AuthElement> authElementList = authElementService.searchByAuthName(searchWord);
        PageInfo<AuthElement> pageInfo = new PageInfo<>(authElementList);
        SearchAuthRespBean searchAuthRespBean = new SearchAuthRespBean();
        searchAuthRespBean.setTotal(pageInfo.getTotal());
        searchAuthRespBean.setAuthList(authElementList);

        return ResultUtil.success(searchAuthRespBean);
    }

    @PostMapping(AuthUrlConstant.ADD)
    public Message add(@RequestBody @Valid AddAuthReqBean addAuthReqBean) {
        String authName = addAuthReqBean.getAuthName();
        String moduleId = addAuthReqBean.getModuleId();
        String authCode = addAuthReqBean.getAuthCode();
        String superCode = addAuthReqBean.getSuperCode();
        String menuFlag = addAuthReqBean.getMenuFlag();
        String description = addAuthReqBean.getDescription();

        authElementService.addAuth(authName, moduleId, authCode, superCode, menuFlag, description);

        return ResultUtil.success();
    }

    @PostMapping(AuthUrlConstant.DELETE)
    public Message add(@RequestBody @Valid DeleteAuthReqBean deleteAuthReqBean) {
        String authId = deleteAuthReqBean.getAuthId();

        authElementService.deleteAuth(authId);

        return ResultUtil.success();
    }
}
