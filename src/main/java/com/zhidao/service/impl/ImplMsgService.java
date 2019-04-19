package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.MsgMapper;
import com.zhidao.dao.SubjectMapper;
import com.zhidao.pojo.Msg;
import com.zhidao.pojo.Subject;
import com.zhidao.service.IMsgService;
import com.zhidao.util.DateTimeUtils;
import com.zhidao.util.RandNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author: lv
 * @data: 2019/3/26 13:43
 * @description:
 * @Version: 1.0
 **/
@Service
public class ImplMsgService implements IMsgService {
    @Autowired
    MsgMapper msgMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    @ResponseBody
    public ServerResponse<Msg> addMsg(@RequestBody Msg msg) {
        int row = msgMapper.insertSelective(msg);
        if (row == 0) {
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<List<Msg>> findAllMsgByCode(String code) {
        int subid=subjectMapper.selectSubIdByCode(code);
        List<Msg> msgs=msgMapper.selectAllMsgBySubid(subid);
        if (msgs!=null){
            return ServerResponse.createBySuccess(msgs);
        }
        return ServerResponse.createByErrorMessage("请先发布信息");
    }
}
