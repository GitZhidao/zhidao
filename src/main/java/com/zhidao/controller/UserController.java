package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.User;
import com.zhidao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:
 * @data: 2019/3/18 12:12
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/user")
//管理session中的属性
public class UserController{
    @Autowired
    IUserService iUserService;
    //登陆方法
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse Login(@RequestBody User user,HttpSession session) throws Exception {
        String username=user.getUsername();
        String password=user.getPassword() ;
        ServerResponse serverResponse = iUserService.login(username, password);
        if (serverResponse.isSuccess()){
            session.setAttribute("user",serverResponse.getData());
            return serverResponse;
        }
        return  serverResponse;
    }

    //用户注册时会转到该方法
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody ServerResponse<String> regist(@RequestBody User user){
        return iUserService.regist(user);
    }

    //修改密码 传登陆时的user，修改密码输入时封装的newuser
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse UpdateUser(User newUser,String newPassword,HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"用户需要登录");
        }
        ServerResponse serverResponse= iUserService.updateUser(newUser, newPassword);
        if (serverResponse.isSuccess()){
            session.removeAttribute("user");
        }
        return serverResponse;
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public ServerResponse loginOut( HttpSession session){
        session.removeAttribute("user");
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/get_user_info")//获取用户信息
    @ResponseBody
    public ServerResponse getUserInfo(HttpSession httpSession){
        User user= (User) httpSession.getAttribute("user");
        if (user!=null){
            System.out.println(user.getPassword());
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
    }
}

