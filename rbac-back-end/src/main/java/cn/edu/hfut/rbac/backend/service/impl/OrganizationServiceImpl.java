package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.controller.bean.OrganizationBean;
import cn.edu.hfut.rbac.backend.entity.Organization;
import cn.edu.hfut.rbac.backend.mapper.EnterpriseMapper;
import cn.edu.hfut.rbac.backend.mapper.OrganizationMapper;
import cn.edu.hfut.rbac.backend.service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/5
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Override
    public List<OrganizationBean> getOrganizationList(String organizationName) {
        List<Organization> organizationList = organizationMapper.selectListByOrganizationName(organizationName);

        List<OrganizationBean> organizations = new ArrayList<>();
        for(Organization organization : organizationList){
            OrganizationBean organizationBean = new OrganizationBean();
            BeanUtils.copyProperties(organization, organizationBean);

            organizationBean.setEnterpriseName(enterpriseMapper.selectEnterpriseNameByEnterpriseId(organizationBean.getEnterpriseId()));
            organizations.add(organizationBean);
        }
        return organizations;
    }

    @Override
    public void insertOrganization(Organization organization) {
        organizationMapper.insertOrganization(organization);
    }

    @Override
    public void deleteOrganization(String organizationId) {
        organizationMapper.deleteByOrganizationId(organizationId);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationMapper.updateOrganization(organization);
    }

    @Override
    public void updateStaffInfoOrganizationId(String organizationId) {
        organizationMapper.updateStaffInfoOrganizationId(organizationId);
    }
}
