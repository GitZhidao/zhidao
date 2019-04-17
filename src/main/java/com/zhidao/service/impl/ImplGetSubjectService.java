package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.GetSubjectMapper;
import com.zhidao.dao.SubjectMapper;
import com.zhidao.pojo.GetSubject;
import com.zhidao.pojo.Subject;
import com.zhidao.service.IGetSubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class ImplGetSubjectService implements IGetSubjectService {
    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    GetSubjectMapper getSubjectMapper;

    public ServerResponse<String> focusSubject(int userid, String code){
        Subject subject=subjectMapper.selectSubjectByCode(code);
        if (subject==null){
            return ServerResponse.createByErrorMessage("该消息不存在");
        }
        GetSubject getSubject=getSubjectMapper.selectSubjectByUserIdandSubId(subject.getSubid(),userid);
        if (getSubject!=null){
            return ServerResponse.createByErrorMessage("不能重复关注");
        }
        getSubject=new GetSubject();
        getSubject.setSubid(subject.getSubid());
        getSubject.setUserid(userid);
        int row=getSubjectMapper.insertSelective(getSubject);

        System.out.println(getSubject.getId());
        if (row!=0){
            return ServerResponse.createBySuccessMessage("关注成功");
        }
        return ServerResponse.createByErrorMessage("关注失败");
    }

    @Override
    public ServerResponse<List<Subject>> getAllFocusSubject(int userid) {
        List<Integer> subids=getSubjectMapper.selectByUserid(userid);
        if (subids==null){
            return ServerResponse.createBySuccessMessage("先关注信息");
        }
        List<Subject> subjects=new ArrayList<>();
        for(int i=0;i<subids.size()-1;i++){
            Subject subject=subjectMapper.selectByPrimaryKey(subids.get(i));
            subjects.add(subject);
        }
        return ServerResponse.createBySuccess(subjects);
    }
}
