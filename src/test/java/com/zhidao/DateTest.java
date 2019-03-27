package com.zhidao;

import com.zhidao.util.DateTimeUtils;

import java.util.Date;

/**
 * @author:
 * @data: 2019/3/27 23:37
 * @description:
 * @Version: 1.0
 **/
public class DateTest {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        Date date1=new java.sql.Timestamp(date.getTime());
        System.out.println(date1);
        String dateString= DateTimeUtils.dateToStr(date1);
}
}
