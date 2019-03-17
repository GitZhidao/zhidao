package com.zhidao.dao;

import com.zhidao.pojo.getMsg;

public interface getMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(getMsg record);

    int insertSelective(getMsg record);

    getMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(getMsg record);

    int updateByPrimaryKey(getMsg record);
}