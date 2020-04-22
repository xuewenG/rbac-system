package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.GlobalConstant;
import cn.edu.hfut.rbac.backend.constant.url.StaffUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.*;
import cn.edu.hfut.rbac.backend.entity.StaffInfo;
import cn.edu.hfut.rbac.backend.entity.StaffPassword;
import cn.edu.hfut.rbac.backend.service.StaffService;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuewenG
 * @date 2019/8/14 15:04
 */
@RestController
@RequestMapping(StaffUrlConstant.STAFF)
public class StaffController {
    @Autowired
    StaffService staffService;

    @PostMapping(StaffUrlConstant.LOGIN)
    public Message login(@RequestBody @Valid LoginReqBean loginReqBean, HttpSession httpSession) {
        String staffAccount = loginReqBean.getStaffAccount();
        String password = loginReqBean.getPassword();

        StaffInfo staffInfo = staffService.login(staffAccount, password);
        httpSession.setAttribute(GlobalConstant.STAFF_SESSION_NAME, staffInfo);

        LoginRespBean loginRespBean = new LoginRespBean();
        loginRespBean.setStaffInfo(staffInfo);
        return ResultUtil.success(loginRespBean);
    }

    @PostMapping(StaffUrlConstant.ADD)
    public Message addStaff(@RequestBody @Valid AddStaffReqBean addStaffReqBean) {
        StaffInfo staff = new StaffInfo();
        staff.setStaffName(addStaffReqBean.getStaffName());
        staff.setStaffState(addStaffReqBean.getStaffState());
        staff.setStaffIdStatus(addStaffReqBean.getStaffIdStatus());
        staff.setOrganizationId(addStaffReqBean.getOrganizationId());
        staff.setPetName(addStaffReqBean.getPetName());
        staffService.addStaff(staff);
        staffService.configRole(addStaffReqBean.getRoleIdList(), staff.getStaffId());
        staffService.configGroup(staff.getStaffId(), addStaffReqBean.getGroupIdList());

        return ResultUtil.success();
    }

    @PostMapping(StaffUrlConstant.DELETE)
    public Message deleteStaff(@RequestBody @Valid DeleteStaffReqBean deleteStaffReqBean) {
        List<String> staffIds = deleteStaffReqBean.getIds();
        List<String> roleIdList = new ArrayList<>();
        List<String> groupIdList = new ArrayList<>();
        staffIds.forEach(staffId -> {
            staffService.configRole(roleIdList, staffId);
            staffService.configGroup(staffId, groupIdList);
            staffService.deleteStaff(staffId);
        });
        return ResultUtil.success();
    }

    @PostMapping(StaffUrlConstant.EDIT)
    public Message editStaff(@RequestBody @Valid EditStaffReqBean editStaffReqBean) {
        StaffInfo staff = new StaffInfo();
        staff.setStaffId(editStaffReqBean.getStaffId());
        staff.setStaffName(editStaffReqBean.getStaffName());
        staff.setStaffState(editStaffReqBean.getStaffState());
        staff.setStaffIdStatus(editStaffReqBean.getStaffIdStatus());
        staff.setOrganizationId(editStaffReqBean.getOrganizationId());
        staff.setPetName(editStaffReqBean.getPetName());
        staffService.updateStaff(staff);
        staffService.configRole(editStaffReqBean.getRoleIdList(), editStaffReqBean.getStaffId());
        staffService.configGroup(editStaffReqBean.getStaffId(), editStaffReqBean.getGroupIdList());

        return ResultUtil.success();
    }

    @PostMapping(StaffUrlConstant.GET)
    public Message getStaffList(@RequestBody @Valid StaffListReqBean staffListReqBean) {

        PageHelper.startPage(staffListReqBean.getPage(), staffListReqBean.getPageSize());
        List<StaffBean> staffs = staffService.getStaffList(staffListReqBean.getSearchWord());

        PageInfo<StaffBean> pageInfo = new PageInfo<>(staffs);

        StaffListRespBean staffListRespBean = new StaffListRespBean();
        staffListRespBean.setTotal(pageInfo.getTotal());
        staffListRespBean.setStaffs(staffs);
        return ResultUtil.success(staffListRespBean);
    }

    @PostMapping(StaffUrlConstant.PWD)
    public Message updatePwd(@RequestBody @Valid StaffPwdReqBean staffPwdReqBean) {
        StaffPassword staffPassword = new StaffPassword();
        staffPassword.setStaffId(staffPwdReqBean.getStaffId());
        staffPassword.setPassword(staffPwdReqBean.getNewStaffPwd());
        staffService.updatePassword(staffPassword);
        return ResultUtil.success();
    }

}