package com.zhidao.controller;

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
    public ModelAndView Login(@RequestParam("username") String username, @RequestParam("password") String password) {
        ServerResponse serverResponse = iUserService.login(username, password);
        ModelAndView mv = new ModelAndView();
        if (serverResponse.isSuccess()) {
            //用户名存在且密码正确
            mv.setViewName("main");//跳转主界面
            mv.addObject("serverResponse", serverResponse);
            return mv;
        }
        else if (serverResponse.getStatus() == ResponseCode.UnRegist.getCode()) {
            //用户名不存在
            mv.setViewName("redirect:/regist.jsp");//跳转注册界面
            mv.addObject("serverResponse", serverResponse);
            return mv;
        }
        mv.setViewName("redirect:/login.jsp");
        mv.addObject("serverResponse", serverResponse);
        return mv;
    }

    //用户注册时会转到该方法
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public ModelAndView regist(User user){
        ServerResponse serverResponse=iUserService.regist(user);
        ModelAndView modelAndView=new ModelAndView();
        if(serverResponse.isSuccess()){
            //注册成功转到登录页面
            modelAndView.setViewName("redirect:/login.jsp");//不在web-inf下面的jsp只能重定向
            modelAndView.addObject("serverResponse",serverResponse);//返回信息
            return modelAndView;
        }
        //失败回到注册页面
        modelAndView.setViewName("redirect:/regist.jsp");
        modelAndView.addObject("serverResponse",serverResponse);//返回信息
        return modelAndView;
    }

    @RequestMapping(value = "/userinfo",method = RequestMethod.POST)
    public @ResponseBody User getUserInfo(@ModelAttribute("user") User user){
        return user;
    }
}

