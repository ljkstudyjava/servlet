package com.student.Pojo;
//教师信息
public class Teacher {
    private int tno;
    private String tname;
    private String gender;
    private int phone;


    public Teacher() {
    }

    public Teacher(int tno, String tname, String gender, int phone) {
        this.tno = tno;
        this.tname = tname;
        this.gender = gender;
        this.phone = phone;
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

    /**
     * 获取
     * @return tname
     */
    public String getTname() {
        return tname;
    }

    /**
     * 设置
     * @param tname
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Teacher{tno = " + tno + ", tname = " + tname + ", gender = " + gender + ", phone = " + phone + "}";
    }
}
