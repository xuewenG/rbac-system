package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.controller.bean.OrganizationBean;
import cn.edu.hfut.rbac.backend.entity.Organization;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/5
 */
public interface OrganizationService {
    List<OrganizationBean> getOrganizationList(String organizationId);

    void insertOrganization(Organization organization);

    void deleteOrganization(String organizationId);

    void updateOrganization(Organization organization);

    void updateStaffInfoOrganizationId(String organizationId);
}