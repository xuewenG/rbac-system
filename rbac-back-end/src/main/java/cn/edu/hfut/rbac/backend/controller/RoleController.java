package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.RoleUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.*;
import cn.edu.hfut.rbac.backend.entity.Role;
import cn.edu.hfut.rbac.backend.service.RoleService;
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
@RequestMapping(RoleUrlConstant.ROLE)
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping(RoleUrlConstant.GET)
    public Message searchGroup(@RequestBody @Valid SearchRoleReqBean searchRoleReqBean) {
        String searchWord = searchRoleReqBean.getSearchWord();
        Integer page = searchRoleReqBean.getPage();
        Integer pageSize = searchRoleReqBean.getPageSize();

        PageHelper.startPage(page, pageSize);
        List<RoleBean> roleList = roleService.getRoleList(searchWord);
        PageInfo<RoleBean> pageInfo = new PageInfo<>(roleList);

        SearchRoleRespBean searchRoleRespBean = new SearchRoleRespBean();
        searchRoleRespBean.setTotal(pageInfo.getTotal());
        searchRoleRespBean.setRoles(roleList);

        return ResultUtil.success(searchRoleRespBean);
    }

    @PostMapping(RoleUrlConstant.GET_BY_STAFF_ACCOUNT)
    public Message getByStaffAccount(@RequestBody @Valid GetRoleByStaffAccountReqBean getRoleByStaffAccountReqBean) {

        List<RoleBean> roleList = roleService.getRoleListByStaffAccount(getRoleByStaffAccountReqBean.getStaffAccount());
        GetRoleByStaffAccountRespBean getRoleByStaffAccountRespBean = new GetRoleByStaffAccountRespBean();
        getRoleByStaffAccountRespBean.setRoles(roleList);

        return ResultUtil.success(getRoleByStaffAccountRespBean);
    }

    @PostMapping(RoleUrlConstant.ADD)
    public Message addRole(@RequestBody @Valid AddRoleReqBean addRoleReqBean) {
        Role role = new Role();
        role.setRoleName(addRoleReqBean.getRoleName());
        role.setDescription(addRoleReqBean.getDescription());
        role.setRoleCode("2017100004");
        role.setSuperCode("2017000001");

        roleService.addRole(role);

        return ResultUtil.success();
    }

    @PostMapping(RoleUrlConstant.DELETE)
    public Message deleteRole(@RequestBody @Valid DeleteRoleReqBean deleteRoleReqBean) {
        roleService.deleteRole(deleteRoleReqBean.getRoleId());
        return ResultUtil.success();
    }

    @PostMapping(RoleUrlConstant.EDIT)
    public Message editRole(@RequestBody @Valid EditRoleReqBean editRoleReqBean) {
        Role role = new Role();
        role.setRoleId(editRoleReqBean.getRoleId());
        role.setRoleName(editRoleReqBean.getRoleName());
        role.setDescription(editRoleReqBean.getDescription());

        roleService.updateRole(role);
        roleService.configAuthForRole(editRoleReqBean.getRoleId(), editRoleReqBean.getAuthIds());

        return ResultUtil.success();

    }

}
