package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Msg;

public interface IMsgService {
    public ServerResponse<String> addMsg(Msg msg);
}
