package com.risk.dao.daoimpl;

import com.risk.dao.StockDao;
import com.risk.entity.StockEntity;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by xiaof on 2017/5/1.
 */
@Repository
public class StockDaoImpl implements StockDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public int insert(StockEntity stockEntity){
        int ret = sqlSession.insert("com.risk.dao.StockDao.insert", stockEntity);
        return ret;
    }
}
