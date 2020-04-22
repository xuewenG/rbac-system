package cn.edu.hfut.rbac.backend.controller.bean;

/**
 * @author tanghan
 * @date 2019/9/5
 */
public class SelectOrganizationByIdRequestBean {
    private String searchWord;
    private Integer page;
    private Integer pageSize;

    @Override
    public String toString() {
        return "SelectOrganizationByIdRequestBean{" +
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
