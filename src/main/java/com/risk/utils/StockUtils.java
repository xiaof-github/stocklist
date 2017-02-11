package com.risk.utils;

/**
 * Created by xiaof on 2017/2/11.
 */
public class StockUtils {
    public static String stockCode2req(String code){
        if (code.charAt(0) == '6'){
            code = "sh" + code;
        }else{
            code = "sz" + code;
        }
        return code;
    }
}
