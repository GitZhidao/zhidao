package com.zhidao.util;

import com.zhidao.pojo.Msg;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeUtils {

    //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS"); //时间格式 2019-03-27 12:05:45.161

    //String转date
    public static Date  strTodate(String string) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        Date date =  sdf.parse(string);
        return date;
    }

    //date转string
    public static String  dateTostr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        String string=sdf.format(date);
        return string;
    }

    //date转int
    public static int dateToint(Date date){
        return Integer.parseInt(dateTostr(date));
    }

    //结束时间距当前时间临近排序 冒泡法
    public static List<Msg> rankDate(List<Msg> msgList){
        Date date=new Date();//获取当前时间
        Msg msg = null;
        for(int i=0;i<msgList.size()-1;i++){
            for (int j=0;j<msgList.size()-1-i;j++){
                long date1=msgList.get(j).getEndtime().getTime()-date.getTime();
                long date2=msgList.get(j+1).getEndtime().getTime()-date.getTime();
                if (date1>date2){
                    msg = msgList.get(j);
                    msgList.set(j, msgList.get(j+1));
                    msgList.set(j+1, msg);
                }
            }
        }
        return msgList;
    }
}
