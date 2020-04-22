package cn.edu.hfut.rbac.backend.service.impl;

import cn.edu.hfut.rbac.backend.controller.bean.EnterpriseBean;
import cn.edu.hfut.rbac.backend.entity.Enterprise;
import cn.edu.hfut.rbac.backend.mapper.EnterpriseMapper;
import cn.edu.hfut.rbac.backend.service.EnterpriseService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    EnterpriseMapper enterpriseMapper;

    @Override
    public List<EnterpriseBean> getEnterpriseList(String searchWord) {
        List<Enterprise> enterpriseList = enterpriseMapper.selectBySearchWord(searchWord);
        List<EnterpriseBean> enterpriseBeanList = new ArrayList<>();
        for (Enterprise enterprise : enterpriseList) {
            EnterpriseBean enterpriseBean = new EnterpriseBean();
            BeanUtils.copyProperties(enterprise, enterpriseBean);
            enterpriseBeanList.add(enterpriseBean);
        }
        return enterpriseBeanList;
    }

    @Override
    public void addEnterprise(EnterpriseBean enterpriseBean) {
        Enterprise enterprise=new Enterprise();
        BeanUtils.copyProperties(enterpriseBean,enterprise);
        enterprise.setEnterpriseId(RandomStringUtils.randomNumeric(10));
        enterpriseMapper.add(enterprise);
    }

    @Override
    public void deleteEnterpriseList(List<String> enterpriseIdList) {
        for (String id:
             enterpriseIdList) {
            enterpriseMapper.deleteById(id);
        }
    }

    @Override
    public void editEnterprise(EnterpriseBean enterpriseBean) {
        Enterprise enterprise=new Enterprise();
        BeanUtils.copyProperties(enterpriseBean,enterprise);
        enterpriseMapper.editById(enterprise);
    }
}
