package dao;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/3.
 */
public class UserDao {
    public void add(User user){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    public List<User> findAll() {
       List<User> list= new ArrayList<User>();
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from User ");
            list=query.list();
            tx.commit();
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
       return list;
    }
    public int getTotal(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        int total = 0;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("select count (*) from User ");
            Object o = query.uniqueResult();
            Long lj = (Long)o;
            total = lj.intValue();
            tx.commit();
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

        return total;
    }
}
