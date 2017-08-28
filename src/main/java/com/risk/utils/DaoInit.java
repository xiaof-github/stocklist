package com.risk.utils;

import com.risk.dao.StockTableDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xiaof on 2017/5/30.
 */
public class DaoInit implements InitializingBean {
    private String tableName;

    @Autowired
    private StockTableDao stockTableDao;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void afterPropertiesSet() throws Exception {
        if (stockTableDao.existTable(tableName) < 1){
            stockTableDao.createNewTable(tableName);
            System.out.println("Init method after properties are set : ");
        }
    }
}
