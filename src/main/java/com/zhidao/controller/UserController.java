package com.zhidao.controller;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.zhidao.common.ResponseCode;
import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.User;
import com.zhidao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author:
 * @data: 2019/3/18 12:12
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/user")
//管理session中的属性
@SessionAttributes(names = {"user","serverResponse"},types = {User.class,ServerResponse.class})
public class UserController {
    @Autowired
    IUserService iUserService;

    //登陆方法
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse Login(@RequestBody @RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) {
        ServerResponse serverResponse = iUserService.login(username, password);
        if (serverResponse.isSuccess()){
            session.setAttribute("user",serverResponse.getData());
            return serverResponse;
        }
        return  serverResponse;
    }

    //用户注册时会转到该方法
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public @ResponseBody ServerResponse<String> regist(@RequestBody User user){
            ServerResponse serverResponse=iUserService.regist(user);
            return serverResponse;
    }

    //修改密码 传登陆时的user，修改密码输入时封装的newuser
    @RequestMapping("/updateuser")
    @ResponseBody
    public ServerResponse UpdateUser(@RequestBody User newuser,@RequestParam("newpassword") String newpassword,HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"需要登录");
        }
        ServerResponse serverResponse=iUserService.updateUser(newuser,newpassword);
        return serverResponse;
    }

    @RequestMapping("/loginOut")
    public ServerResponse loginOut(@ModelAttribute User user,HttpSession session){
        session.removeAttribute("user");
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/get_user_info")//获取用户信息
    public ServerResponse getUserInfo(@ModelAttribute("user") User user){
        if (user!=null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
    }
}

