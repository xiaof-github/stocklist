package com.risk.dao.daoimpl;

import com.risk.dao.StockDao;
import com.risk.entity.StockEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaof on 2017/5/1.
 */
@Repository
public class StockDaoImpl implements StockDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public int insert(StockEntity stockEntity){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int ret = sqlSession.insert("com.risk.dao.StockDao.insert", stockEntity);
        sqlSession.commit();
        sqlSession.close();
        return ret;
    }

    public List<StockEntity> query(Map<String, String> params){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<StockEntity> entities = sqlSession.selectList("com.risk.dao.StockDao.getStock", params);
        sqlSession.close();
        return entities;
    }
}
