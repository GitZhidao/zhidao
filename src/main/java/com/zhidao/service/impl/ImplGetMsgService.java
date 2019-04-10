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

    public ServerResponse<String> focusMsg(int userid,String code){
        Msg msg=msgMapper.selectMsgByCode(code);
        if (msg==null){
            return ServerResponse.createByErrorMessage("该消息不存在");
        }
        GetMsg getMsg=getMsgMapper.selectMsgByUserIdandMsgId(msg.getMsgid(),userid);
        if (getMsg!=null){
            return ServerResponse.createByErrorMessage("不能重复关注");
        }
        getMsg=new GetMsg();
        getMsg.setMsgid(msg.getMsgid());
        getMsg.setUserid(userid);
        int row=getMsgMapper.insertSelective(getMsg);
        System.out.println(getMsg.getId());
        if (row!=0){
            return ServerResponse.createBySuccessMessage("关注成功");
        }
        return ServerResponse.createByErrorMessage("关注失败");
   }
}
