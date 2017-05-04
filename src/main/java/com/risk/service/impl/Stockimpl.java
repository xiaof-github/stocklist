package com.risk.service.impl;

import com.risk.dao.StockDao;
import com.risk.entity.StockEntity;
import com.risk.service.Stock;
import com.risk.utils.StockHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaof on 2017/2/3.
 */
@Service("stock")
public class Stockimpl implements Stock {
    @Autowired
    private StockDao stockDao;

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
}
