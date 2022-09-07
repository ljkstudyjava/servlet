package com.student.Pojo;

public class TeacherInfoGrade {
    private int sno;
    private String sname;
    private int cno;
    private double score;


    public TeacherInfoGrade() {
    }

    public TeacherInfoGrade(int sno, String sname, int cno, double score) {
        this.sno = sno;
        this.sname = sname;
        this.cno = cno;
        this.score = score;
    }

    /**
     * 获取
     * @return sno
     */
    public int getSno() {
        return sno;
    }

    /**
     * 设置
     * @param sno
     */
    public void setSno(int sno) {
        this.sno = sno;
    }

    /**
     * 获取
     * @return sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设置
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * 获取
     * @return cno
     */
    public int getCno() {
        return cno;
    }

    /**
     * 设置
     * @param cno
     */
    public void setCno(int cno) {
        this.cno = cno;
    }

    /**
     * 获取
     * @return score
     */
    public double getScore() {
        return score;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return "TeacherInfoCourse{sno = " + sno + ", sname = " + sname + ", cno = " + cno + ", score = " + score + "}";
    }
}
