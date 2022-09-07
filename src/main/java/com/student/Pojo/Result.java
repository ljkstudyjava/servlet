package com.student.Pojo;

public class Result {
    private int CODE;
    private String msg;
    private Object data;


    public Result() {
    }

    public Result(int CODE, String msg) {
        this.CODE = CODE;
        this.msg = msg;
    }

    public Result(int CODE, String msg, Object data) {
        this.CODE = CODE;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取
     * @return CODE
     */
    public int getCODE() {
        return CODE;
    }

    /**
     * 设置
     * @param CODE
     */
    public void setCODE(int CODE) {
        this.CODE = CODE;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "Result{CODE = " + CODE + ", msg = " + msg + ", data = " + data + "}";
    }
}
