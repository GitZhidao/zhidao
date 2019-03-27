package com.zhidao.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Msg {
    private Integer msgid;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creattime;

    private String code;

    private String location;

    private String filepath;

    private Integer userid;

    private String content;

    public Msg(Integer msgid, String title, Date creattime,Date endtime, String code, String location, String filepath, Integer userid, String content) {
        this.msgid = msgid;
        this.title = title;
        this.endtime = endtime;
        this.creattime=creattime;
        this.code = code;
        this.location = location;
        this.filepath = filepath;
        this.userid = userid;
        this.content = content;
    }

    public Msg() {
        super();
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatTime() {
        return creattime;
    }

    public void setCreatTime(Date creatTime) {
        this.creattime = creatTime;
    }
}