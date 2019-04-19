package com.zhidao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Msg {
    private Integer msgid;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String creattime;

    private String location;

    private String filepath;

    private String content;

    private Integer subid;

    public Msg(Integer msgid, String title, String endtime, String creattime, String location, String filepath, Integer userid, String content, Integer subid) {
        this.msgid = msgid;
        this.title = title;
        this.endtime = endtime;
        this.creattime = creattime;
        this.location = location;
        this.filepath = filepath;
        this.content = content;
        this.subid = subid;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msgid=" + msgid +
                ", title='" + title + '\'' +
                ", endtime='" + endtime + '\'' +
                ", creattime='" + creattime + '\'' +
                ", location='" + location + '\'' +
                ", filepath='" + filepath + '\'' +
                ", content='" + content + '\'' +
                ", subid=" + subid +
                '}';
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

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreatTime() {
        return creattime;
    }

    public void setCreatTime(String creatTime) {
        this.creattime = creatTime;
    }

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        this.subid = subid;
    }
}