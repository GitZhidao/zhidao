package com.zhidao.dao;

import com.zhidao.pojo.Msg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgMapper {
    int deleteByPrimaryKey(Integer msgid);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer msgid);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKeyWithBLOBs(Msg record);

    int updateByPrimaryKey(Msg record);

    //查询某一用户发送的所有时间。
    List<Msg> selectAllMsgBySubid(@Param("subid") int subid);

    //根据code查询msgid
    Msg selectMsgBySubid(int subid);


}