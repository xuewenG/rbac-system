package cn.edu.hfut.rbac.backend.service;

import cn.edu.hfut.rbac.backend.controller.bean.EnterpriseBean;

import java.util.List;

public interface EnterpriseService {
    List<EnterpriseBean> getEnterpriseList(String searchWord);

    void addEnterprise(EnterpriseBean enterpriseBean);

    void deleteEnterpriseList(List<String> enterpriseIdList);

    void editEnterprise(EnterpriseBean enterpriseBean);
}
