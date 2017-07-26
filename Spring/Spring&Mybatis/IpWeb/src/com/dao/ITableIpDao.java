package com.dao;

import com.entity.TableIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 王宁 on 2017/7/25.
 */
@Repository
public interface ITableIpDao {
    @Autowired
    public int getRowCount();
    @Autowired
    List<TableIp> selectByParams(Map<String, Object> params);
}
