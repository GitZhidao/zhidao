package com.zhidao.controller;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Subject;
import com.zhidao.pojo.User;
import com.zhidao.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:
 * @data: 2019/4/16 14:41
 * @description:
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    ISubjectService iSubjectService;

    @RequestMapping(value = "/addSubject",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Subject> addSubject(String subtitle, HttpSession session){
        User user= (User) session.getAttribute("user");
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        Subject subject=new Subject();
        subject.setSubtitle(subtitle);
        subject.setUserid(user.getUserid());
        return iSubjectService.addSubject(subject);
    }

    @RequestMapping(value = "/allSubject")
    @ResponseBody
    public ServerResponse<List<Subject>> findAllSendMsg(HttpSession session){
        User user= (User)session.getAttribute("user");
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(2,"用户未登录无法查看");
        }
        ServerResponse<List<Subject>> serverResponse=iSubjectService.findAllSubject(user.getUserid());
        session.setAttribute("subjects",serverResponse.getData());
        return serverResponse;
    }
}
