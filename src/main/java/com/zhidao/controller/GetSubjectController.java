package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Subject;
import com.zhidao.pojo.User;
import com.zhidao.service.IGetSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Mrlv
 * @data: 2019/4/17 17:12
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/getSubject")
public class GetSubjectController {

    @Autowired
    IGetSubjectService iGetSubjectService;
    //    关注信息
    @RequestMapping(value = "/focusSubject",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> focusSubject(String code, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        return iGetSubjectService.focusSubject(user.getUserid(),code);
    }


    @RequestMapping("/allFocusSubject")
    @ResponseBody
    public ServerResponse<List<Subject>> allFocusSubject(HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        return iGetSubjectService.getAllFocusSubject(user.getUserid());
    }
}
