package com.risk.controller;

import com.risk.entity.StockEntity;
import com.risk.service.Stock;
import com.risk.utils.HttpServletUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiaof on 2017/1/16.
 */
@Controller
@RequestMapping("/")
public class Price {
    @Autowired
    private Stock stock;

    private Logger logger = LogManager.getLogger(Price.class);

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @RequestMapping("/test")
    public void testLogger(HttpServletRequest request, HttpServletResponse response) {
        String test = "test";
        logger.info("test 1111");

        HttpServletUtils.responseAccessData(response, test);
    }

    @RequestMapping(value = "/api/list", method = RequestMethod.GET)
    public void stockList(@RequestParam(value = "code", required = false) String code, HttpServletResponse response){
        logger.info("request param: " + code);

        HttpServletUtils.responseAccessData(response, stock.getStockInfo(code));

    }

    @RequestMapping(value = "/api/stock", method = RequestMethod.POST)
    @ResponseBody
    //public String saveStock(@RequestBody StockEntity body){
    public String saveStock(@ModelAttribute StockEntity body){
        logger.info("body: " + body.toString());
        int code = 0;
        stock.saveStock(body);

        return "code:" + code;

    }
}
