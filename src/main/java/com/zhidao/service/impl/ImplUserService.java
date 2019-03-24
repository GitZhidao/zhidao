package com.zhidao.service.impl;

import com.zhidao.common.ResponseCode;
import com.zhidao.common.ServerResponse;
import com.zhidao.dao.UserMapper;
import com.zhidao.pojo.User;
import com.zhidao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author:
 * @data: 2019/3/18 22:29
 * @description:
 * @Version: 1.0
 **/
@Service
public class ImplUserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    //登陆
    @Override
    public ServerResponse login(String username,String password) {
        User user=userMapper.selectByUsername(username);
        System.out.println(user.getPassword());
        if (user==null){
            //用户名不存在
            ServerResponse serverResponse=ServerResponse.createByErrorCodeMessage(ResponseCode.UnRegist.getCode(),"用户名不存在请注册！");
            return serverResponse;
        }
        else if(!password.equals(user.getPassword())){
            //密码不正确
            return ServerResponse.createByErrorMessage("密码错误！");
        }
            return ServerResponse.createBySuccess(user);
    }

    //注册
    @Override
    public ServerResponse<String> regist(User user) {
        User user2=userMapper.selectByUsername(user.getUsername());
        if (user2!=null){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        int result=userMapper.insert(user);
        if (result!=0){
            return  ServerResponse.createBySuccessMessage("注册成功");
       }
        return ServerResponse.createByErrorMessage("注册失败");
    }
}
