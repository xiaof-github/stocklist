package com.risk.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xiaof on 2017/1/16.
 */
public class HttpServletUtils {
    private static Logger log = LogManager.getLogger(HttpServletUtils.class);

    public static void responseAccessData(HttpServletResponse response,
                                          Object object) {

        RespObject respObject = new RespObject(RespObject.SUCCESS,
                RespObject.SUCCESS_MSG, object);
        Gson gson = new GsonBuilder().create();
        responseJson(response, gson.toJson(respObject));
    }


    public static void responseErrorData(HttpServletResponse response,int respCode,String respMsg){

        RespObject respObject = new RespObject(respCode,
                respMsg, null);
        Gson gson = new GsonBuilder().create();
        responseJson(response, gson.toJson(respObject));
    }

    private static void responseJson(HttpServletResponse response, String json) {

        try {
            response.setContentType("text/html; charset=UTF-8");
            responseCORS(response);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private static void responseCORS(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, Accept-Language, Content-Language, Content-Type");
    }
}
