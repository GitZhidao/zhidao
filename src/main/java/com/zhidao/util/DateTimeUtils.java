package com.zhidao.util;

import com.zhidao.pojo.Msg;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeUtils {

    //标准格式
    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //字符转时间
    public static Date strToDate(String dateTimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    //时间转字符
    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    //CTS转yyyy-mm-dd HH:mm:ss
    public static Date dateToDate(Date date){
        return new java.sql.Timestamp(date.getTime());
    }

    //date转int
    public static int dateToint(Date date){
        return Integer.parseInt(dateToStr(date));
    }

    //结束时间距当前时间临近排序 冒泡法
    public static List<Msg> rankDate(List<Msg> msgList){
        Date date=new Date();//获取当前时间
        Msg msg;
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

    public static List<Msg> ConvertDate(List<Msg> msgs){
        for (int i=0;i<msgs.size()-1;i++){
            msgs.get(i).setEndtime(dateToDate(msgs.get(i).getEndtime()));
            return msgs;
        }
        return msgs;
    }
}
