package com.zhidao.dao;

import com.zhidao.pojo.GetMsg;

public interface GetMsgMapper {
    int deleteByPrimaryKey(String id);



    int insert(GetMsg record);



    int insertSelective(GetMsg record);



    GetMsg selectByPrimaryKey(String id);



    int updateByPrimaryKeySelective(GetMsg record);

    int updateByPrimaryKey(GetMsg record);
}
