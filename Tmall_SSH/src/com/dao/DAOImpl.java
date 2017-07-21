package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 王宁 on 2017/7/21.
 * 提供setSessionFactory()方法， 以用于注入SessionFactory
 */
@Repository("com/dao")
public class DAOImpl extends HibernateTemplate {
    @Resource(name="sf")
    public void setSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

}
