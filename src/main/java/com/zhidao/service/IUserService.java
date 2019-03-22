package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    ServerResponse<User> login(String username,String password);
    //注册业务
    ServerResponse<String> regist(User user);
}
