package com.zhidao.dao;

import com.zhidao.pojo.GetSubject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GetSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GetSubject record);

    int insertSelective(GetSubject record);

    GetSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GetSubject record);

    int updateByPrimaryKey(GetSubject record);

    //查询是否用户已经关注
    GetSubject selectSubjectByUserIdandSubId(@Param("subid") int subid, @Param("userid") int userid);

    List<Integer> selectByUserid(@Param("userid") int userid);
}
