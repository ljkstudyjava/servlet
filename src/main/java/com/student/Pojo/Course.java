package com.student.Pojo;

public class Course {
    private int cid;
    private String cname;
    private int tno;


    public Course() {
    }

    public Course(int cid, String cname, int tno) {
        this.cid = cid;
        this.cname = cname;
        this.tno = tno;
    }

    /**
     * 获取
     * @return cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * 获取
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 获取
     * @return tno
     */
    public int getTno() {
        return tno;
    }

    /**
     * 设置
     * @param tno
     */
    public void setTno(int tno) {
        this.tno = tno;
    }

    public String toString() {
        return "Course{cid = " + cid + ", cname = " + cname + ", tno = " + tno + "}";
    }
}
