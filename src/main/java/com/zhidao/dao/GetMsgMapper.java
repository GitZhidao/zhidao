package com.zhidao.dao;

import com.zhidao.pojo.GetMsg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    //查询是否用户已经关注
    GetMsg selectMsgByUserIdandMsgId(@Param("msgid") int msgid, @Param("userid") int userId);

    List<Integer> selectByUsid(@Param("userid") int userid);
}
