package com.zhidao.pojo;

/**
 * @author: Mrlv
 * @data: 2019/4/16 13:49
 * @description:
 * @Version: 1.0
 **/
public class Subject {
    private int subid; //id
    private String subtitle;//主题标题
    private int userid;//用户id
    private String code;
    @Override
    public String toString() {
        return "Subject{" +
                "subid=" + subid +
                ", subtitle='" + subtitle + '\'' +
                ", userid=" + userid +
                ", code='" + code + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public Subject() {
    }

    public Subject(int subid, String subtitle, int userid, String code) {
        this.subid = subid;
        this.subtitle = subtitle;
        this.userid = userid;
        this.code = code;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
