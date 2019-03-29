package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.GetMsg;
import com.zhidao.pojo.User;
import com.zhidao.service.IGetMsgService;
import com.zhidao.vo.GetMsgCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author:
 * @data: 2019/3/27 17:49
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/getMsg")
public class GetMsgController {
    @Autowired
    IGetMsgService iGetMsgService;

    //关注信息
    @RequestMapping(value = "/focusMsg",method = RequestMethod.POST)
    public ServerResponse<String> focusMsg(GetMsgCode getMsgCode, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        GetMsg getMsg=getMsgCode.getGetMsg();
        getMsg.setUserid(user.getUserid());
        ServerResponse serverResponse=iGetMsgService.focusMsg(getMsg,getMsgCode.getCode());
        return serverResponse;
    }


}
