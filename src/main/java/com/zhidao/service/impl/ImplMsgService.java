package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.MsgMapper;
import com.zhidao.pojo.Msg;
import com.zhidao.service.IMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lv
 * @data: 2019/3/26 13:43
 * @description:
 * @Version: 1.0
 **/
@Service
public class ImplMsgService implements IMsgService {
    @Autowired
   MsgMapper msgMapper;
    @Override
    public ServerResponse<String> addMsg(Msg msg) {
        int row=msgMapper.insertSelective(msg);
        if (row==0){
            return ServerResponse.createByError();
        }
        return ServerResponse.createBySuccessMessage("发布成功");
    }
}
