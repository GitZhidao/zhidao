package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Msg;
import com.zhidao.pojo.User;
import com.zhidao.service.IMsgService;
import com.zhidao.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author: lv
 * @data: 2019/3/26 14:01
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/msg")
public class MsgController{
    @Autowired
    IMsgService iMsgService;

    @RequestMapping(value = "/sendMsg",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Msg> sendMsg(@RequestBody Msg msg,HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        msg.setCreatTime(DateTimeUtils.dateToDate(new Date()).toString());
        return iMsgService.addMsg(msg);
    }

    //跟具查信息已发送信息
    @RequestMapping(value = "/allMsgByCode",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Msg>> findMsgByCode(String code,HttpSession session){
        System.out.println(code);
        User user= (User)session.getAttribute("user");
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        return iMsgService.findAllMsgByCode(code);
    }
}
