package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.UserMapper;
import com.zhidao.pojo.User;
import com.zhidao.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse findUser(String username,String password) {
        User user=userMapper.selectByUsername(username);
        if (user!=null){
            /**/
            ServerResponse serverResponse=ServerResponse.createBySuccess("成功",user);
        }
        return  ServerResponse.createByErrorMessage("查询失败");
    }
}
