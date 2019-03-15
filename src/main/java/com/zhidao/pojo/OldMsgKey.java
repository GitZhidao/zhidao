package com.zhidao.pojo;

public class OldMsgKey {
    private Integer userid;

    private Integer msgid;

    public OldMsgKey(Integer userid, Integer msgid) {
        this.userid = userid;
        this.msgid = msgid;
    }

    public OldMsgKey() {
        super();
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
}