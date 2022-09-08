package com.student.Pojo;

public class BaseQuery {
    private int pageNum = 1;
    private int pageSize = 3;


    public BaseQuery() {
    }

    public BaseQuery(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return pageNum
     */
    public int getPageNum() {
        return pageNum;
    }

    /**
     * 设置
     * @param pageNum
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
