package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.SubjectMapper;
import com.zhidao.pojo.Msg;
import com.zhidao.pojo.Subject;
import com.zhidao.service.ISubjectService;
import com.zhidao.util.RandNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:
 * @data: 2019/4/16 14:41
 * @description:
 * @Version: 1.0
 **/
@Service
public class ImplSubjectService implements ISubjectService{
    @Autowired
    SubjectMapper subjectMapper;
    @Override
    public ServerResponse<Subject> addSubject(Subject subject) {
     if (subjectMapper.selectByUseridAndTitle(subject.getUserid(),subject.getSubtitle())!=null){
        return ServerResponse.createByErrorMessage("重复主题名");
     }
        subject.setCode(RandNumberUtils.randNumber());
        int row=subjectMapper.insertSelective(subject);
        if (row==0){
            return ServerResponse.createByErrorMessage("发布失败");
        }
        return ServerResponse.createBySuccess("发布成功,你的主题编号是："+subject.getCode(),subject);
    }

    @Override
    public ServerResponse<List<Subject>> findAllSubject(int userid) {
        List<Subject> subjects=subjectMapper.selectAllSubjectByUserId(userid);
        if (subjects!=null){
            return ServerResponse.createBySuccess(subjects);
        }
        return ServerResponse.createByErrorMessage("请先发布信息");
    }
}