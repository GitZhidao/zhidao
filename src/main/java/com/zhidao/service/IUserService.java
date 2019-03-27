package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.User;

public interface IUserService {
    //登陆
    ServerResponse<User> login(String username, String password);
    //注册业务
    ServerResponse<String> regist(User user);

    ServerResponse<User> updateUser(User newuser,String newpassword);
}
