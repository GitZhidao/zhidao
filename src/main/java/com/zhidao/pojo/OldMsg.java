package com.zhidao.pojo;

public class OldMsg extends OldMsgKey {
    private String categoryname;

    private Integer status;

    public OldMsg(Integer userid, Integer msgid, String categoryname, Integer status) {
        super(userid, msgid);
        this.categoryname = categoryname;
        this.status = status;
    }

    public OldMsg() {
        super();
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