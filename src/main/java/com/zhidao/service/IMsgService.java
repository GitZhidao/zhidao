package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Msg;

import java.util.List;

public interface IMsgService {
     ServerResponse<Msg> addMsg(Msg msg);

     ServerResponse<List<Msg>> findAllMsg(int userid);
}
