package com.zhidao.vo;

import com.zhidao.pojo.GetMsg;

/**
 * @author:
 * @data: 2019/3/28 10:48
 * @description:
 * @Version: 1.0
 **/
public class GetMsgCode {
    private GetMsg getMsg;
    private String code;

    public GetMsgCode(GetMsg getMsg,String code){
        this.getMsg=getMsg;
        this.code=code;
    }

    public GetMsg getGetMsg() {
        return getMsg;
    }

    public void setGetMsg(GetMsg getMsg) {
        this.getMsg = getMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
