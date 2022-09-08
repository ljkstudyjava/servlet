package com.student.Pojo;

import java.util.List;

public class Page<E> {
    private int pageNum;
    private int pageSize;
    private int total;
    private int pages;
    private boolean first;
    private boolean last;
    private boolean hasPrevious;
    private boolean hasNext;
    private List<E> list;


    public Page() {
    }

    public Page(int pageNum, int pageSize, int total, int pages, boolean first, boolean last, boolean hasPrevious, boolean hasNext, List<E> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
        this.first = first;
        this.last = last;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.list = list;
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

    /**
     * 获取
     * @return total
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 获取
     * @return pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * 设置
     * @param pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * 获取
     * @return first
     */
    public boolean isFirst() {
        return pageNum == 1;
    }

    /**
     * 设置
     * @param first
     */
    public void setFirst(boolean first) {
        this.first = first;
    }

    /**
     * 获取
     * @return last
     */
    public boolean isLast() {
        return pageNum == pages;
    }

    /**
     * 设置
     * @param last
     */
    public void setLast(boolean last) {
        this.last = last;
    }

    /**
     * 获取
     * @return hasPrevious
     */
    public boolean isHasPrevious() {
        return pageNum != 1;
    }

    /**
     * 设置
     * @param hasPrevious
     */
    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    /**
     * 获取
     * @return hasNext
     */
    public boolean isHasNext() {
        return pageNum != pages;
    }

    /**
     * 设置
     * @param hasNext
     */
    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 获取
     * @return list
     */
    public List<E> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<E> list) {
        this.list = list;
    }

    public String toString() {
        return "Page{pageNum = " + pageNum + ", pageSize = " + pageSize + ", total = " + total + ", pages = " + pages + ", first = " + first + ", last = " + last + ", hasPrevious = " + hasPrevious + ", hasNext = " + hasNext + ", list = " + list + "}";
    }
}
