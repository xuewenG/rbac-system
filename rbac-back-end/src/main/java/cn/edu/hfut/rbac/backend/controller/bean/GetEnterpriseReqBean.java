package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

public class GetEnterpriseReqBean {
    @NotNull(message = "page不能为空")
    private int page;
    @NotNull(message = "pageSize不能为空")
    private int pageSize;
    private String searchWord;

    @Override
    public String toString() {
        return "GetEnterpriseReqBean{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", searchWord='" + searchWord + '\'' +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
