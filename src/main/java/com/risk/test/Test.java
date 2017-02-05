package com.risk.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by xiaof on 2017/1/15.
 */
public class Test {
    private static Logger logger = LogManager.getLogger(Test.class.getName());
    public static void main(String[] args){
        System.out.println("111");
        logger.info("log info!");
    }
}
