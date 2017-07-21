package com.service.impl;

import com.dao.DAOImpl;
import com.entity.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.CategoryService;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/21.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    DAOImpl dao;

    @Override
    public List list() {
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        dc.addOrder(Order.desc("id"));
        return dao.findByCriteria(dc);
    }
}
