package com.zhidao.dao;

import com.zhidao.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer subid);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(@Param("subid") Integer subid);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    //查询某一用户发送的所有时间。
    List<Subject> selectAllSubjectByUserId(@Param("userid") int userid);

    //根据code查询主体题
    Subject selectSubjectByCode(String code);

    int selectSubIdByCode(@Param("code") String code);

    Subject selectByUseridAndTitle(@Param("userid") int userid,@Param("subtitle") String subtitle);
}
