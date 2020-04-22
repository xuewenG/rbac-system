package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

/**
 * @author tanghan
 * @date 2019/9/7
 */
public class SelectGroupInfoByIdRequestBean {
    private String searchWord;
    @NotNull(message = "page 不能为空")
    private Integer page;
    @NotNull(message = "pageSize 不能为空")
    private Integer pageSize;

    @Override
    public String toString() {
        return "SelectGroupInfoByIdRequestBean{" +
                "searchWord='" + searchWord + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
