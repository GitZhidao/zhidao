package com.zhidao.pojo;

public class getMsg {
    private String id;

    private Integer userid;

    private Integer msgid;

    private String categoryname;

    private Integer status;

    public getMsg(String id, Integer userid, Integer msgid, String categoryname, Integer status) {
        this.id = id;
        this.userid = userid;
        this.msgid = msgid;
        this.categoryname = categoryname;
        this.status = status;
    }

    public getMsg() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}