package cn.edu.hfut.rbac.backend.controller.bean;

import javax.validation.constraints.NotNull;

public class StaffListReqBean {
    @NotNull(message = "page 不能为空")
    private int page;
    private String searchWord;
    @NotNull(message = "pageSize 不能为空")
    private int pageSize;

    @Override
    public String toString() {
        return "PageReqBean{" +
                "page=" + page +
                ", searchWord='" + searchWord + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
