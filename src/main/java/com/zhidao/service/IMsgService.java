package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Msg;

import java.util.List;

public interface IMsgService {
    public ServerResponse<String> addMsg(Msg msg);

    public ServerResponse<List<Msg>> findAllMsg(int userid);
}
