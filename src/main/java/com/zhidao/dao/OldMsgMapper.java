package com.zhidao.dao;

import com.zhidao.pojo.OldMsg;
import com.zhidao.pojo.OldMsgKey;

public interface OldMsgMapper {
    int deleteByPrimaryKey(OldMsgKey key);

    int insert(OldMsg record);

    int insertSelective(OldMsg record);

    OldMsg selectByPrimaryKey(OldMsgKey key);

    int updateByPrimaryKeySelective(OldMsg record);

    int updateByPrimaryKey(OldMsg record);
}