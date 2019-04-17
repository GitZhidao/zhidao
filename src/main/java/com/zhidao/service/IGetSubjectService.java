package com.zhidao.service;

import com.zhidao.common.ServerResponse;
import com.zhidao.pojo.Subject;

import java.util.List;

public interface IGetSubjectService {
    ServerResponse<String> focusSubject(int userid, String code);

    ServerResponse<List<Subject>> getAllFocusSubject(int userid);
}
