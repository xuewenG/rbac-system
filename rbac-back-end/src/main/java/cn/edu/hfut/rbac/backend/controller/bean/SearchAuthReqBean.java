package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

public class SearchAuthReqBean {
    @NotNull(message = "page 不能为空")
    private Integer page;
    @NotNull(message = "pageSize 不能为空")
    private Integer pageSize;
    @NotNull(message = "searchWord 不能为空")
    private String searchWord;

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

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
