package dao;

import bean.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtils;

import java.util.List;

/**
 * Created by 王宁 on 2017/6/22.
 */
public class GetDaoByQBC {
        public List<Customer> getCustomer(){
            List<Customer> list = null;
            try(
                    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                    Session session =sessionFactory.openSession();
            ){
                Transaction transaction=session.beginTransaction();
                Criteria criteria = session.createCriteria(Customer.class);
                list  = criteria.list();
                transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
        //条件查询
    public List<Customer> getCustomerByI(){
        List<Customer> list = null;
        try(
                SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                Session session =sessionFactory.openSession();
        ){
            Transaction transaction=session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            //使用add方法，设置条件值-->Restrictions对象
            //criteria.add(Restrictions.eq("cid",1));
            //模糊查询
           criteria.add(Restrictions.like("custName","%宁%"));
            list = criteria.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //排序查询
    public List<Customer> getCustomerByO(){
        List<Customer> list = null;
        try(
                SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                Session session =sessionFactory.openSession();
        ){
            Transaction transaction=session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            //使用add方法，设置条件值-->Restrictions对象
            //criteria.add(Restrictions.eq("cid",1));
            criteria.addOrder(Order.desc("cid"));
            list = criteria.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //分页查询
    public List<Customer> getCustomerPage(int count,int start){
        List<Customer> list = null;
        try(
                SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                Session session =sessionFactory.openSession();
        ){
            Transaction transaction=session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            //使用add方法，设置条件值-->Restrictions对象
            //criteria.add(Restrictions.eq("cid",1));

            criteria.setFirstResult(start);
            criteria.setMaxResults(count);
            list = criteria.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //统计查询
    public int getTongji( ){
        int total =0;
        try(
                SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                Session session =sessionFactory.openSession();
        ){
            Transaction transaction=session.beginTransaction();
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.setProjection(Projections.rowCount());//统计
            Object obj = criteria.uniqueResult();
            Long l = (Long) obj;
           total = l.intValue();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }

    public int getLixian( ){
        int total =0;
        try(
                SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
                Session session =sessionFactory.openSession();
        ){
            Transaction transaction=session.beginTransaction();
          //  Criteria criteria = session.createCriteria(Customer.class);
            DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
            Criteria criteria = detachedCriteria.getExecutableCriteria(session);
            criteria.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return total;
    }
}
