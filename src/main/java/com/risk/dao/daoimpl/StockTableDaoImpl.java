package com.risk.dao.daoimpl;

import com.risk.dao.StockTableDao;
import com.risk.entity.KavgEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaof on 2017/6/3.
 */
@Repository
public class StockTableDaoImpl implements StockTableDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public int createNewTable(@Param(value = "tableName") String tableName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int ret = sqlSession.update("com.risk.dao.StockTableDao.createNewTable", tableName);
        sqlSession.commit();
        sqlSession.close();
        return ret;
    }

    public int dropTable(@Param(value = "tableName") String tableName){
        return 0;
    }

    public int existTable(String tableName){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int ret = sqlSession.selectOne("com.risk.dao.StockTableDao.existTable", tableName);
        sqlSession.commit();
        sqlSession.close();
        return ret;
    }

    public int insertKavg(KavgEntity entity){
        return 0;
    }
}
