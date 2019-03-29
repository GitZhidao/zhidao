package com.zhidao.dao;

import com.zhidao.pojo.GetMsg;

/**
 * @author:
 * @data: 2019/3/28 0:38
 * @description:
 * @Version: 1.0
 **/
public interface GetMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(GetMsg record);

    int insertSelective(GetMsg record);

    GetMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GetMsg record);

    int updateByPrimaryKey(GetMsg record);

    GetMsg selectByMsgId(int msgId);
}
