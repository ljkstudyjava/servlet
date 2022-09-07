package com.student.Pojo;

public class StudentInfoCourse {
    private String cname;
    private String cid;
    private String tname;
    private double score;

    public StudentInfoCourse(String cname, String cid, String tname, double score) {
        this.cname = cname;
        this.cid = cid;
        this.tname = tname;
        this.score = score;
    }

    public StudentInfoCourse() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentInfoCourse{" +
                "cname='" + cname + '\'' +
                ", cid='" + cid + '\'' +
                ", tname='" + tname + '\'' +
                ", score=" + score +
                '}';
    }
}
