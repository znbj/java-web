package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
    private int totalPage;				//1.总页数
    private int total;				//2.总条数
    private int pageSize;				//3.每页显示的个数
    private int pageNumber;				//4.当前是第几页
    private List<T> data;				//当前页数据

    public int getTotalPage() {
        return (int)Math.ceil(total*1.0/pageSize);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
