package com.zhidao.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class RandNumberUtils {

    //信息编号生成
    public static String randNumber() {
        //用当前时间精确到毫秒，截取末尾五位
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS"); //时间格式 20190327120545161
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS"); //时间格式 2019-03-27 12:05:45.161
        String  formDate =sdf.format(date);
        String no = formDate.substring(12);//取末尾五位
        return "zd"+no;//返回DX开头的编号
    }

    //生成六位验证码
    public static String varifyCode() {
        //用当前时间精确到毫秒，截取末尾五位
        return  String.valueOf(new Random().nextInt(899999) + 100000);
    }
}
