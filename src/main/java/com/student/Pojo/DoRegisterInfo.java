package com.student.Pojo;

public class DoRegisterInfo {
    private String userName;
    private String password;
    private int roleId;
    private int sno;
    private String sname;
    private String sex;
    private String address;

    public DoRegisterInfo(String userName, String password, int roleId, int sno, String sname, String sex, String address) {
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.address = address;
    }

    public DoRegisterInfo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "doRegisterInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
