package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.GetMsg;
import com.zhidao.pojo.Msg;
import com.zhidao.pojo.User;
import com.zhidao.service.IGetMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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

//    关注信息
    @RequestMapping(value = "/focusMsg",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> focusMsg(String msgCode, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        return iGetMsgService.focusMsg(user.getUserid(),msgCode);
    }


    public ServerResponse<List<Msg>> allFocusMsg(HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        return null;
    }
}
