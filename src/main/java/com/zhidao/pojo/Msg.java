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

    private String code;

    private String location;

    private String filepath;

    private Integer userid;

    private String content;

    public Msg(Integer msgid, String title, String creattime,String endtime, String code, String location, String filepath, Integer userid, String content) {
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

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
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

    public String getCreatTime() {
        return creattime;
    }

    public void setCreatTime(String creatTime) {
        this.creattime = creatTime;
    }

    @Override
    public String toString() {
        return "Msg[msgId="+msgid+",title="+title+",content="+content+",creaTime="+creattime+",endtime="+endtime+",userid="+userid+",code="+code
                +",location="+location+",filepath"+filepath+"]";
    }
}