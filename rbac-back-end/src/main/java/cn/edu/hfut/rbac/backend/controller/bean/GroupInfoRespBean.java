package cn.edu.hfut.rbac.backend.controller.bean;

import cn.edu.hfut.rbac.backend.entity.GroupInfo;

import java.util.List;

/**
 * @author tanghan
 * @date 2019/9/7
 */
public class GroupInfoRespBean {
    private List<GroupInfo> groupInfoList;
    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<GroupInfo> getGroupInfoList() {
        return groupInfoList;
    }

    public void setGroupInfoList(List<GroupInfo> groupInfoList) {
        this.groupInfoList = groupInfoList;
    }
}
