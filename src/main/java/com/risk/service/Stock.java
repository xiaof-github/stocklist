package com.risk.service;

import com.risk.entity.HighLimitEntity;
import com.risk.entity.StockEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xiaof on 2017/2/3.
 */
public interface Stock {
    List<StockEntity> getStockInfo(String code);
    int saveStock(StockEntity stockEntity);
    List<StockEntity> query();
    List<HighLimitEntity> queryHighLimit();
}
