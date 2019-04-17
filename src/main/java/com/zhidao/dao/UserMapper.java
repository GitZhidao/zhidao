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

    User selectByUsername(@Param("username") String username);

    int checkEmail(@Param("email") String email);

    int checkUsername(@Param("username") String username);

    int updateById(@Param("userid") int userid,@Param("newPassword") String newPassword);
}