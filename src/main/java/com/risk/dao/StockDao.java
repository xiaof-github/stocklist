package com.risk.dao;

import com.risk.entity.StockEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaof on 2017/4/30.
 */
public interface StockDao {
    int insert(StockEntity stockEntity);
    List<StockEntity> query(Map<String, String> params);
}
