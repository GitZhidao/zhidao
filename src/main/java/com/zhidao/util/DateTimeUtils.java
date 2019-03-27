package com.zhidao.util;

import com.zhidao.pojo.Msg;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeUtils {

    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";



    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static Date dateToDate(Date date){
        Date sqlDate=new java.sql.Timestamp(date.getTime());
        return sqlDate;
    }


    //date转int
    public static int dateToint(Date date){
        return Integer.parseInt(dateToStr(date));
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
