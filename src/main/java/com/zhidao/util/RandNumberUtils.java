package com.zhidao.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class RandNumberUtils {

    //信息编号生成
    public static String randNumber() {
        //用当前时间精确到毫秒，截取末尾五位
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
        String  formDate =sdf.format(date);
        String no = formDate.substring(12);//取末尾五位
        return "DX"+no;//返回DX开头的编号
    }
}
