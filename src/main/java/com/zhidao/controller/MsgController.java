package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Msg;
import com.zhidao.pojo.User;
import com.zhidao.service.IMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author: lv
 * @data: 2019/3/26 14:01
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    IMsgService iMsgService;

    @RequestMapping(value = "/sendMsg",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> sendMsg(@RequestBody Msg msg, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        msg.setUserid(user.getUserid());
        return iMsgService.addMsg(msg);
    }

    //查找所以已发送信息
    @RequestMapping(value = "/findAllMsg")
    public ServerResponse findAllMsg(int userid, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        return iMsgService.findAllMsg(user.getUserid());
    }
}
