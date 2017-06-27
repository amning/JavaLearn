package one2many.dao;

import one2many.bean.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import javax.persistence.Parameter;
import java.util.List;


/**
 * Created by 王宁 on 2017/6/20.
 */
 //hql方式进行对象获取
public class GetDao {

    //from语句查询所有数据库对象
    public List getAllCustomer( ) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        List<Customer> list=null;
        try {
            sessionFactory = HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            //创建query对象
            Query query = session.createQuery("from Customer"  );
            //调用list方法
            list =query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        return list;
    }



    //条件查询-->根据姓名得到客户
    public Customer getCustomer(String name ){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        Customer bean=null;
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            //创建query对象
            Query query= session.createQuery("from Customer where custName like ?");
            //调用list方法
             query.setParameter(0,name);
            bean= (Customer) query.getSingleResult();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    return bean;
    }

    //模糊查询
    public Customer getCustomer2(String name){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        Customer bean=null;
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            //创建query对象
            Query query= session.createQuery("from Customer where custName like ?");
            //调用list方法
            query.setParameter(0,name);
            bean= (Customer) query.getSingleResult();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
        return bean;
    }

    //分页查询
    public List getCuPage(int start,int count){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        List<Customer> list=null;
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            //创建query对象
            Query query= session.createQuery("from Customer ");
           //设置分页数据
            query.setFirstResult(start);
            query.setMaxResults(count);
          list =query.list();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
        return list;
    }
    public int  getAll(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        int total=0;
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            //创建query对象
            Query query = session.createQuery("select count (*) from Customer ");
            Object o = query.uniqueResult();

            Long lj=(Long)o;
            total=lj.intValue();
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
      return total;
    }
}
