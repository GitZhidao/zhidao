package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.GetMsgMapper;
import com.zhidao.dao.MsgMapper;
import com.zhidao.pojo.GetMsg;
import com.zhidao.pojo.Msg;
import com.zhidao.service.IGetMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:
 * @data: 2019/3/28 10:14
 * @description:
 * @Version: 1.0
 **/
@Service
public class ImplGetMsgService implements IGetMsgService {
    @Autowired
    MsgMapper msgMapper;

    @Autowired
    GetMsgMapper getMsgMapper;

    @RequestMapping(value = "/focusMsg",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> focusMsg(@RequestBody GetMsg getMsg, String code){
        Msg msg=msgMapper.selectMsgByCode(code);
        if (msg==null){
            return ServerResponse.createByErrorMessage("该消息不存在");
        }
        GetMsg getMsg1=getMsgMapper.selectByMsgId(msg.getMsgid());
        if (getMsg1!=null){
            return ServerResponse.createByErrorMessage("已关注该消息");
        }
        getMsg.setMsgid(msg.getMsgid());
        int row=getMsgMapper.insert(getMsg);
        if (row!=0){
            return ServerResponse.createBySuccessMessage("关注成功");
        }
        return ServerResponse.createByErrorMessage("关注失败");
   }

}
