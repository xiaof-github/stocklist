package com.risk.dao.daoimpl;

import com.risk.dao.HighLimitDao;
import com.risk.entity.HighLimitEntity;
import com.risk.entity.StockEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaof on 2017/9/3.
 */
@Repository
public class HighLimitDaoImpl implements HighLimitDao {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public List<HighLimitEntity> query(Map<String, Object> params){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<HighLimitEntity> entities = sqlSession.selectList("com.risk.dao.HighLimitDao.query", params);
        sqlSession.close();
        return entities;
    }
}
