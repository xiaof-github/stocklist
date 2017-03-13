package com.risk.service.impl;

import com.risk.entity.StockEntity;
import com.risk.service.Stock;
import com.risk.utils.StockHttpClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaof on 2017/2/3.
 */
@Service("stock")
public class Stockimpl implements Stock {
    public List<StockEntity> getStockInfo(String code){
        StockHttpClient client = new StockHttpClient();
        return client.getStockList(code);
    }
}
