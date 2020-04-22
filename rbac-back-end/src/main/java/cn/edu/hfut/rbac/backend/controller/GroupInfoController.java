package cn.edu.hfut.rbac.backend.controller;

import cn.edu.hfut.rbac.backend.constant.url.GroupInfoUrlConstant;
import cn.edu.hfut.rbac.backend.controller.bean.*;
import cn.edu.hfut.rbac.backend.entity.GroupInfo;
import cn.edu.hfut.rbac.backend.service.GroupInfoService;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/7
 */
@RestController
@RequestMapping(GroupInfoUrlConstant.GROUP_INFO)
public class GroupInfoController {
    @Autowired
    GroupInfoService groupInfoService;

    @PostMapping(GroupInfoUrlConstant.SELECT)
    public Message searchGroup(@RequestBody @Valid SelectGroupInfoByIdRequestBean selectGroupInfoByIdRequestBean) {
        String searchWord = selectGroupInfoByIdRequestBean.getSearchWord();
        Integer page = selectGroupInfoByIdRequestBean.getPage();
        Integer pageSize = selectGroupInfoByIdRequestBean.getPageSize();

        PageHelper.startPage(page, pageSize);
        List<GroupInfo> groupInfoList = groupInfoService.getGroupInfo(searchWord);
        PageInfo<GroupInfo> pageInfo = new PageInfo<>(groupInfoList);

        GroupInfoRespBean groupInfoRespBean = new GroupInfoRespBean();
        groupInfoRespBean.setTotal(pageInfo.getTotal());
        groupInfoRespBean.setGroupInfoList(groupInfoList);

        return ResultUtil.success(groupInfoRespBean);
    }

    @PostMapping(GroupInfoUrlConstant.INSERT)
    public Message insertGroupInfo(@RequestBody @Valid InsertGroupInfoRequestBean insertGroupInfoRequestBean) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupId(insertGroupInfoRequestBean.getGroupId());
        groupInfo.setGroupName(insertGroupInfoRequestBean.getGroupName());
        groupInfo.setGroupTypeId(insertGroupInfoRequestBean.getGroupTypeId());
        groupInfo.setGroupCode(insertGroupInfoRequestBean.getGroupCode());
        groupInfo.setSuperGroupCode(insertGroupInfoRequestBean.getSuperGroupCode());
        groupInfo.setValidStart(insertGroupInfoRequestBean.getValidStart());
        groupInfo.setValidEnd(insertGroupInfoRequestBean.getValidEnd());
        groupInfo.setGroupDesc(insertGroupInfoRequestBean.getGroupDesc());
        groupInfo.setCityId(insertGroupInfoRequestBean.getCityId());
        groupInfoService.insertGroupInfo(groupInfo);
        return ResultUtil.success();
    }


    @PostMapping(GroupInfoUrlConstant.DELETE)
    public Message deleteGroupInfoById(@RequestBody @Valid DeleteGroupInfoByIdRequestBean deleteGroupInfoByIdRequestBean) {
        String[] ids = deleteGroupInfoByIdRequestBean.getIds();
        for (int i = 0; i < ids.length; i++) {
            groupInfoService.deleteGroupInfo(ids[i]);
            groupInfoService.deleteGroupStaff(ids[i]);
        }
        return ResultUtil.success();
    }

    @PostMapping(GroupInfoUrlConstant.UPDATE)
    public Message updateGroupInfo(@RequestBody @Valid UpdateGroupInfoRequestBean updateGroupInfoRequestBean) {
        GroupInfo groupInfo = new GroupInfo();
        BeanUtils.copyProperties(updateGroupInfoRequestBean, groupInfo);

        groupInfoService.updateGroupInfo(groupInfo);

        return ResultUtil.success();
    }
}
