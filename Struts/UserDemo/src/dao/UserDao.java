package dao;

import bean.Customer;
import bean.Manager;
import bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by 王宁 on 2017/6/15.
 */
public class UserDao {
    public void add(User user){
        try(
         SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
         Session session =sessionFactory.openSession();
         ){
            Transaction transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
            }catch (Exception e){
                e.printStackTrace();
            }
    }
    public User getById(int id){
        User user;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session =sessionFactory.openSession();
        //开启事务
        Transaction transaction=session.beginTransaction();
        //crud操作

         user=session.get(User.class,id);//1.实体类class  2.id
        //提交事务
        transaction.commit();
        //关闭资源
        session.close();
        sessionFactory.close();
        return user;
    }//int id,String userName
    public void update( int id,User u_user){

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session =sessionFactory.openSession();
        //开启事务
        Transaction transaction=session.beginTransaction();
        //crud操作

        User user=session.get(User.class,id);//1.实体类class  2.id
        user.setPassWord(u_user.getPassWord());
        user.setUserName(u_user.getUserName());

        session.update(user);
        //提交事务
        transaction.commit();
        //关闭资源
        session.close();
        sessionFactory.close();
    }
    public void deleteById(int id){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session =sessionFactory.openSession();
        //开启事务
        Transaction transaction=session.beginTransaction();
        //crud操作

        //User user=session.get(User.class,id);
        User user=new User();
        user.setId(id);
        session.delete(user);
        //提交事务
        transaction.commit();
        //关闭资源
        session.close();
        sessionFactory.close();
    }
    public void LinkAdd1(Customer customer,Manager manager){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();
            /*
            //1、
            //1.1建立客户
            customer=new Customer();
            customer.setCustName("徐宁");
            customer.setCustLeve1("V3");
            customer.setCustSource("网络");
            customer.setCustPhone("233");
            customer.setCustMobile("332");
            //1.2建立联系人
            Manager manager=new Manager();
            manager.setmName("lucy");
            manager.setmGender("woman");
            manager.setmPhone("999");

            //2
            //2.1把联系人对象放到客户对象的set集合中
            */
            customer.getManagers().add(manager);
            //2.2 把客户放到联系人里面
            manager.setCustomer(customer);

            //3、保存到数据库

            session.save(customer);
            session.save(manager);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
    public void LinkAdd2(Customer customer,Manager manager) {

            SessionFactory sessionFactory = null;
            Session session = null;
            Transaction tx = null;

            try {
                sessionFactory=HibernateUtils.getSessionFactory();
                session = sessionFactory.openSession();
                tx=session.beginTransaction();

                //2
                //2.1把联系人对象放到客户对象的set集合中

                customer.getManagers().add(manager);
            /*
            2.2 把客户放到联系人里面
           manager.setCustomer(customer);
           */

                //3、保存到数据库
                session.save(customer);
                //session.save(manager);

                tx.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                session.close();
                sessionFactory.close();
            }

    }
    public void linkDelete(int id){

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();

            Customer customer=session.get(Customer.class,id);
            session.delete(customer);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    //把某一个manager赋给另一个customer
    public void linkUpdate(Customer customer,Manager manager,int id,int mid){

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory=HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();

            //1\根据id查询联系人和客户
            customer=session.get(Customer.class,id);
            manager = session.get(Manager.class,mid);
            //2、设置持久态对象的值
            customer.getManagers().add(manager);
            manager.setCustomer(customer);


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

    }
