package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.OrganizationUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.*;
import cn.edu.hfut.rbac.backend.entity.Organization;
import cn.edu.hfut.rbac.backend.service.OrganizationService;
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

/**
 * @author tanghan
 * @date 2019/9/5
 */
@RestController
@RequestMapping(OrganizationUrlConstant.ORGANIZATION)
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    /**
     * @author tanghan
     * @date 2019/9/5
     */
    @PostMapping(OrganizationUrlConstant.SELECT)
    public Message selectOrganizationById(@RequestBody @Valid SelectOrganizationByIdRequestBean selectOrganizationByIdRequestBean) {
        String searchWord = selectOrganizationByIdRequestBean.getSearchWord();
        Integer page = selectOrganizationByIdRequestBean.getPage();
        Integer pageSize = selectOrganizationByIdRequestBean.getPageSize();

        PageHelper.startPage(page, pageSize);
        List<OrganizationBean> organizationList = organizationService.getOrganizationList(searchWord);
        PageInfo<OrganizationBean> pageInfo = new PageInfo<>(organizationList);

        OrganizationRespBean organizationRespBean = new OrganizationRespBean();
        organizationRespBean.setTotal(pageInfo.getTotal());
        organizationRespBean.setOrganizationList(organizationList);

        return ResultUtil.success(organizationRespBean);
    }

    /**
     * @author tanghan
     * @date 2019/9/5
     * 增加组织机构
     */
    @PostMapping(OrganizationUrlConstant.INSERT)
    public Message insertOrganization(@RequestBody @Valid InsertOrganizationRequestBean insertOrganizationRequestBean) {
        Organization organization = new Organization();
        organization.setOrganizationId(insertOrganizationRequestBean.getOrgaId());
        organization.setOrganizationName(insertOrganizationRequestBean.getOrgaName());
        organization.setOrganizationType(insertOrganizationRequestBean.getOrgaTypeId());
        organization.setOrganizationState(insertOrganizationRequestBean.getOrgaState());
        organization.setCityFlag(insertOrganizationRequestBean.getCityFlag());
        organization.setOrganizationCode(insertOrganizationRequestBean.getOrgaCode());
        organization.setSuperOrganizationCode(insertOrganizationRequestBean.getSuperOrgaCode());
        organization.setOrganizationDesc(insertOrganizationRequestBean.getOrgaDesc());
        organization.setAreaCode(insertOrganizationRequestBean.getAreaCode());
        organization.setOrderNum(insertOrganizationRequestBean.getOrderNum());
        organization.setUpdateTime(insertOrganizationRequestBean.getUpdateTime());
        organization.setEnterpriseId(insertOrganizationRequestBean.getEnterpriseId());
        organizationService.insertOrganization(organization);
        return ResultUtil.success();
    }

    /**
     * @author tanghan
     * @date 2019/9/5
     * 删除组织机构
     */
    @PostMapping(OrganizationUrlConstant.DELETE)
    public Message deleteOrganization(@RequestBody @Valid DeleteOrganizationByIdRequestBean deleteOrganizationByIdRequestBean) {
        String ids[] = deleteOrganizationByIdRequestBean.getIds();
        for (int i = 0; i < ids.length; i++) {
            organizationService.deleteOrganization(ids[i]);
            organizationService.updateStaffInfoOrganizationId(ids[i]);
        }
        return ResultUtil.success();
    }

    /**
     * @author tanghan
     * @date 2019/9/5
     * 修改组织机构
     */
    @PostMapping(OrganizationUrlConstant.UPDATE)
    public Message updateOrganization(@RequestBody @Valid UpdateOrganizationRequestBean updateOrganizationRequestBean) {
        Organization organization = new Organization();
        organization.setOrganizationId(updateOrganizationRequestBean.getOrgaId());
        organization.setOrganizationName(updateOrganizationRequestBean.getOrgaName());
        organization.setOrganizationType(updateOrganizationRequestBean.getOrgaTypeId());
        organization.setOrganizationState(updateOrganizationRequestBean.getOrgaState());
        organization.setCityFlag(updateOrganizationRequestBean.getCityFlag());
        organization.setOrganizationCode(updateOrganizationRequestBean.getOrgaCode());
        organization.setSuperOrganizationCode(updateOrganizationRequestBean.getSuperOrgaCode());
        organization.setOrganizationDesc(updateOrganizationRequestBean.getOrgaDesc());
        organization.setAreaCode(updateOrganizationRequestBean.getAreaCode());
        organization.setOrderNum(updateOrganizationRequestBean.getOrderNum());
        organization.setUpdateTime(updateOrganizationRequestBean.getUpdateTime());
        organization.setEnterpriseId(updateOrganizationRequestBean.getEnterpriseId());

        organizationService.updateOrganization(organization);

        return ResultUtil.success();
    }
}
