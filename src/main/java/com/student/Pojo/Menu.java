package com.student.Pojo;

public class Menu {
    private int id;
    private String name;
    private String url;
    private int pId;
    private String target;


    public Menu() {
    }

    public Menu(int id, String name, String url, int pId, String target) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pId = pId;
        this.target = target;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return pId
     */
    public int getPId() {
        return pId;
    }

    /**
     * 设置
     * @param pId
     */
    public void setPId(int pId) {
        this.pId = pId;
    }

    /**
     * 获取
     * @return target
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置
     * @param target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    public String toString() {
        return "Menu{id = " + id + ", name = " + name + ", url = " + url + ", pId = " + pId + ", target = " + target + "}";
    }
}
