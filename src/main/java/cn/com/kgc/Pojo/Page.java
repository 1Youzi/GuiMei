package cn.com.kgc.Pojo;

import java.util.List;

/**
 * 分页       查询
 * @param <T>
 */

public class Page<T> {
    private  int pageSize;
    private  int pageNumber;
    private  int totalRecod;  //总条数
    private List<T> pageData;

    public Page() {
    }

    public Page(int pageSize, int pageNumber, int totalRecod, List<T> pageDate) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalRecod = totalRecod;
        this.pageData = pageData;
    }

    /**
     * 计算总页数
     * @return
     */
    public int getTotalPage(){
        return totalRecod%pageSize==0?totalRecod/pageSize:(totalRecod/pageSize)+1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalRecod() {
        return totalRecod;
    }

    public void setTotalRecod(int totalRecod) {
        this.totalRecod = totalRecod;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
