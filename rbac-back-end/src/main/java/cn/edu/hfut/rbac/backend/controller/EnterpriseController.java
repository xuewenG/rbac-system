package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.EnterpriseUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.*;
import cn.edu.hfut.rbac.backend.entity.Enterprise;
import cn.edu.hfut.rbac.backend.mapper.EnterpriseMapper;
import cn.edu.hfut.rbac.backend.service.EnterpriseService;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(EnterpriseUrlConstant.Enterprise)
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    /**
     * @author xwh
     * @date 2019/9/24
     */
    @RequestMapping(EnterpriseUrlConstant.GET)
    public Message getEnterpriseList(@RequestBody @Valid GetEnterpriseReqBean getEnterpriseReqBean) {
        PageHelper.startPage(getEnterpriseReqBean.getPage(), getEnterpriseReqBean.getPageSize());
        List<EnterpriseBean> enterpriseBeanList = enterpriseService.getEnterpriseList(getEnterpriseReqBean.getSearchWord());
        PageInfo<EnterpriseBean> pageInfo = new PageInfo<>(enterpriseBeanList);
        GetEnterpriseRespBean getEnterpriseRespBean = new GetEnterpriseRespBean();
        getEnterpriseRespBean.setEnterpriseBeanList(enterpriseBeanList);
        getEnterpriseRespBean.setTotal(pageInfo.getTotal());
        return ResultUtil.success(getEnterpriseRespBean);
    }

    @RequestMapping(EnterpriseUrlConstant.INSERT)
    public Message addEnterprise(@RequestBody @Valid AddEnterpriseReqBean addEnterpriseReqBean) {
        EnterpriseBean enterpriseBean = new EnterpriseBean();
        BeanUtils.copyProperties(addEnterpriseReqBean, enterpriseBean);
        enterpriseService.addEnterprise(enterpriseBean);
        return ResultUtil.success();
    }

    @RequestMapping(EnterpriseUrlConstant.DELETE)
    public Message deleteEnterpriseList(@RequestBody @Valid DeleteEnterpriseListReqBean deleteEnterpriseListReqBean) {
        List<String> enterpriseIdList = deleteEnterpriseListReqBean.getEnterpriseIdList();
        enterpriseService.deleteEnterpriseList(enterpriseIdList);
        return ResultUtil.success();
    }

    @RequestMapping(EnterpriseUrlConstant.UPDATE)
    public Message editEnterprise(@RequestBody @Valid EditEnterpriseReqBean editEnterpriseReqBean) {
        EnterpriseBean enterpriseBean = new EnterpriseBean();
        BeanUtils.copyProperties(editEnterpriseReqBean, enterpriseBean);
        enterpriseService.editEnterprise(enterpriseBean);
        return ResultUtil.success();
    }

}
