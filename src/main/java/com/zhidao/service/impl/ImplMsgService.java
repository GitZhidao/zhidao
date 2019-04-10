package com.zhidao.service.impl;

import com.zhidao.common.ServerResponse;
import com.zhidao.dao.MsgMapper;
import com.zhidao.pojo.Msg;
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
    @Override
    @ResponseBody
    public ServerResponse<Msg> addMsg(@RequestBody Msg msg) {
        msg.setCode(RandNumberUtils.randNumber());
        int row=msgMapper.insertSelective(msg);
        if (row==0){
            return ServerResponse.createByErrorMessage("发布失败");
        }
        return ServerResponse.createBySuccess("发布成功,你的信息码是：",msg);
    }

    @Override
    public ServerResponse<List<Msg>> findAllMsg(int userid) {
        List<Msg> msgs=msgMapper.selectAllMsgByUserId(userid);
        if (msgs!=null){
            for (Msg msg : DateTimeUtils.rankDate(msgs)) {
                msg.setEndtime(DateTimeUtils.dateToDate(msg.getEndtime()));;
            }
            return  ServerResponse.createBySuccess(msgs);
        }
        return ServerResponse.createByErrorMessage("请先关注信息");
    }
}
