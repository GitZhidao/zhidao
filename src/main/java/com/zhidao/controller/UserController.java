package com.zhidao.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.User;
import com.zhidao.service.IUserService;
import com.zhidao.util.RandNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    @ResponseBody
    public  ServerResponse<String> regist(@RequestBody User user,HttpSession session){
        String verifyCode=user.getCode();
        JSONObject jsonObject= (JSONObject) session.getAttribute("verifyCode");
        if (!jsonObject.getString("verifyCode").equals(user.getCode())){
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        if ((System.currentTimeMillis() - jsonObject.getLong("verifyTime")) > 1000 * 60 * 5){
            return ServerResponse.createByErrorMessage("验证码失效");
        }
        else {
            return iUserService.regist(user);
        }
    }

    @RequestMapping(value = "/sendVerifyCode",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> sendVerifyCode(@RequestParam("username")String username,HttpSession session) throws Exception {
        JSONObject json=null;
        String verifyCode= RandNumberUtils.varifyCode();
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","101335","449cfe91-6a1f-4a90-9f7d-b51b245469d5");
        String result = client.send(username, "您正在注册吱道信息系统，验证码为:" + verifyCode + "，该码有效期为5分钟，请勿告诉他人！");
        json=JSONObject.parseObject(result);
        if (json.getIntValue("code")!=0){
            return ServerResponse.createByErrorMessage("发送验证码失败");
        };
        json=new JSONObject();
        json.put("verifyCode",verifyCode);
        json.put("verifyTime",System.currentTimeMillis());
        session.setAttribute("verifyCode", json);
        return ServerResponse.createBySuccess("发送成功");
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

