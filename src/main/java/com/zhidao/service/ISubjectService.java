package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Subject;

import java.util.List;

/**
 * @author:
 * @data: 2019/4/16 14:41
 * @description:
 * @Version: 1.0
 **/
public interface ISubjectService {
    ServerResponse<Subject> addSubject(Subject subject);
    ServerResponse<List<Subject>> findAllSubject(int userid);
}
