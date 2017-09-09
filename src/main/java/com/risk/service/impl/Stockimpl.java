package com.risk.service.impl;

import com.risk.dao.HighLimitDao;
import com.risk.dao.StockDao;
import com.risk.entity.HighLimitEntity;
import com.risk.entity.StockEntity;
import com.risk.service.Stock;
import com.risk.utils.StockHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xiaof on 2017/2/3.
 */
@Service("stock")
public class Stockimpl implements Stock {
    @Autowired
    private StockDao stockDao;
    @Autowired
    private HighLimitDao highLimitDao;

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    public List<StockEntity> getStockInfo(String code){
        StockHttpClient client = new StockHttpClient();
        return client.getStockList(code);
    }

    public int saveStock(StockEntity stockEntity){
        return stockDao.insert(stockEntity);
    }

    public List<StockEntity> query(){
        Map<String, String> params = new HashMap<String, String>();
        return stockDao.query(params);
    }

    public List<HighLimitEntity> queryHighLimit(){
        Map<String, Object> params = new HashMap<String, Object>();
        List<HighLimitEntity> highLimitEntities = null;
        int i = 0;
        Date date = new Date();
        Date target = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String dateString = dateFormat.format(date);
            System.out.println("date:" + dateString);
            target = dateFormat.parse(dateString);
            System.out.println("date:" + target);
            params.put("date", target);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        /* 如果当天不是交易日，就往前找，查询上一个交易日的涨停股 */
        while ((highLimitEntities = highLimitDao.query(params)) == null || highLimitEntities.size() == 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(target);
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            target = calendar.getTime();
            System.out.println("date:" + target);
            params.put("date", target);
            i = i+1;
            if(i>30){
                break;
            }
        }

        return highLimitEntities;
    }
}
