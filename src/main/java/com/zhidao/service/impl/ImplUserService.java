package com.zhidao.service.impl;

import com.zhidao.common.ResponseCode;
import com.zhidao.common.ServerResponse;
import com.zhidao.dao.UserMapper;
import com.zhidao.pojo.User;
import com.zhidao.service.IUserService;
import com.zhidao.util.MD5Util;
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

    //登陆
    @Override
    public ServerResponse login(String username,String password) {
        User user=userMapper.selectByUsername(username);
        if (user==null){
            //用户名不存在
            ServerResponse serverResponse=ServerResponse.createByErrorCodeMessage(ResponseCode.UnRegist.getCode(),"用户名不存在请注册！");
            return serverResponse;
        }
        //MD5明文解密
        String md5Password=MD5Util.MD5EncodeUtf8(password);
        if(!md5Password.equals(user.getPassword())){
            //密码不正确
            return ServerResponse.createByErrorMessage("密码错误！");
        }
            return ServerResponse.createBySuccess(user);
    }

    //注册
    @Override
    public ServerResponse<String> regist(User user) {
        int checkUsername=userMapper.checkUsername(user.getUsername());
        if (checkUsername!=0){
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        int checkEmail=userMapper.checkEmail(user.getEmail());
        if (checkEmail!=0){
            return ServerResponse.createByErrorMessage("邮箱已存在");
        }
        //md5对密码进行加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int result=userMapper.insert(user);
        if (result!=0){
            return  ServerResponse.createBySuccessMessage("注册成功");
       }
        return ServerResponse.createByErrorMessage("注册失败");
    }

    //修改密码
    @Override
    public ServerResponse<User> updateUser(User newUser, String newPassword) {
        User user=userMapper.selectByUsername(newUser.getUsername());
        if (user==null){
            return  ServerResponse.createByErrorMessage("用户名不存在");
        }
        else if(!user.getPassword().equals(newUser.getPassword())) {
            return ServerResponse.createByErrorMessage("原密码错误");
        }
        int row=userMapper.updateById(user.getUserid(),newPassword);
        if (row==0){
            return ServerResponse.createByError();//修改失败
        }
        return ServerResponse.createBySuccess("密码修改成功",user);
    }
}
