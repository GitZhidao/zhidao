package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    ServerResponse<User> findUser(String username,String password);

//    ServerResponse<String> delete(int id);
}
