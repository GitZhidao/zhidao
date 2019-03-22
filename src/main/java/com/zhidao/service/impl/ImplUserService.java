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
    @Override
    public ServerResponse login(String username,String password) {
        User user=userMapper.selectByUsername(username);
        if (user==null){
            ServerResponse serverResponse=ServerResponse.createByErrorCodeMessage(ResponseCode.UnRegist.getCode(),"用户名不存在请注册！");
            return serverResponse;
        }
        else if(password !=user.getPassword()){
            return ServerResponse.createByErrorMessage("密码错误！");
        }
        else
            return ServerResponse.createBySuccess(user);
    }
}
