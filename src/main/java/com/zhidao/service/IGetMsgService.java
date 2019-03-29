package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.GetMsg;

public interface IGetMsgService {
    ServerResponse<String> focusMsg(GetMsg getMsg,String code);
}
