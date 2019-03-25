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
    public @ResponseBody ServerResponse<String> regist(@RequestBody User user){
            ServerResponse serverResponse=iUserService.regist(user);
            return serverResponse;
    }

    //修改密码 传登陆时的user，修改密码输入时封装的newuser
    @RequestMapping("/updateuser")
    public ModelAndView UpdateUser(@ModelAttribute("user") User user,User newuser,@RequestParam("newpassword") String newpassword){
        ServerResponse serverResponse=iUserService.updateUser(newuser,newpassword);
        ModelAndView mv = new ModelAndView();
        if (serverResponse.isSuccess()){
            //修改成功跳转登陆界面
            mv.setViewName("redirect:/login.jsp");
            mv.addObject("serverResponse", serverResponse);
            return mv;
        }
        //修改失败不跳转
        return mv;
    }
////    @RequestMapping("/loginOut")
//    public ModelAndView loginOut()
}

