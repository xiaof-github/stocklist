package com.risk.dao;

import com.risk.entity.KavgEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xiaof on 2017/5/28.
 */
public interface StockTableDao {
    int insertKavg(KavgEntity entity);
    int createNewTable(@Param(value = "tableName") String tableName);
    int dropTable(@Param("tableName") String tableName);
    int existTable(String tableName);

}
