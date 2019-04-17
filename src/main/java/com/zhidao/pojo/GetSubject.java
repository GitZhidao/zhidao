package com.zhidao.pojo;

/**
 * @author:
 * @data: 2019/3/28 0:36
 * @description:
 * @Version: 1.0
 **/
public class GetSubject {


    private Integer id;
    private Integer userid;
    private Integer subid;
    private String categoryname;
    private Integer status;

    public GetSubject(Integer id, Integer userid, Integer subid, String categoryname, Integer status) {
        this.id = id;
        this.userid = userid;
        this.subid = subid;
        this.categoryname = categoryname;
        this.status = status;
    }

    public GetSubject() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSubid() {
        return this.subid;
    }

    public void setSubid(Integer msgid) {
        this.subid = msgid;
    }

    public String getCategoryname() {
        return this.categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GetSubject{" +
                "id='" + id + '\'' +
                ", userid=" + userid +
                ", subid=" + subid +
                ", categoryname='" + categoryname + '\'' +
                ", status=" + status +
                '}';
    }
}
