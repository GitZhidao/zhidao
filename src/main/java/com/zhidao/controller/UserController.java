package com.zhidao.controller;

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
@SessionAttributes(names = {"user"},types = {User.class})
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView Login(@RequestParam("username") String username, @RequestParam("password") String password) {
        ServerResponse serverResponse = iUserService.login(username, password);
        if (serverResponse.isSuccess()) {
            ModelAndView mv = new ModelAndView("main");
            mv.addObject("serverResponse", serverResponse);
            return mv;
        }
//        else if (serverResponse.getStatus() == 2) {
//            ModelAndView mv = new ModelAndView("regist");
//            mv.addObject("serverResponse", serverResponse);
//            return mv;
//        }
        ModelAndView mv = new ModelAndView("regist");
        mv.addObject("serverResponse", serverResponse);
        return mv;
    }
}

