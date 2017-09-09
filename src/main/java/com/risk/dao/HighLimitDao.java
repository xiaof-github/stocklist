package com.risk.dao;

import com.risk.entity.HighLimitEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaof on 2017/9/3.
 */
public interface HighLimitDao {
    List<HighLimitEntity> query(Map<String, Object> params);
}
