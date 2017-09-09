package com.risk.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaof on 2017/1/15.
 */
public class Test {
    private static Logger logger = LogManager.getLogger(Test.class.getName());
    public static void main(String[] args){
        System.out.println("111");
        logger.info("log info!");

        Date currentTime = new Date();
        Date date = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2007-1-18";
        try {
            date = format1.parse(str);
            System.out.println(date);
            String dateString = format1.format(date);
            System.out.println(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
