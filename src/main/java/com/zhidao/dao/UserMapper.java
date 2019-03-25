package com.zhidao.dao;

import com.zhidao.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询用户名
    User selectByUsername(@Param("username") String username);

    //修改密码
    int updateById(@Param("user") User user,@Param("newpassword") String newpassword);
}