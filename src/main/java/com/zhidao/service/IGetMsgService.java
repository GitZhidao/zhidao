package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.GetMsg;
import com.zhidao.pojo.Msg;

import java.util.List;

public interface IGetMsgService {
    ServerResponse<String> focusMsg(int userid,String code);

    ServerResponse<List<Msg>> getAllFocusMsg(int userid);
}
