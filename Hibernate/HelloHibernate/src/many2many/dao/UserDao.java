package many2many.dao;

import many2many.bean.Role;
import many2many.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtils;

/**
 * Created by 王宁 on 2017/6/19.
 */
public class UserDao {
    //
    public void linkAdd(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();

            //添加两个用户，每个用户添加两个角色

            User u1 =new User();
            u1.setUserName("徐宁");
            u1.setUserPassword("233");

            User u2=new User();
            u2.setUserName("任磊");
            u2.setUserPassword("112");

            Role r1 = new Role();
            r1.setRoleName("总经理");
            r1.setRoleMome("总经理");
            Role r2 = new Role();
            r2.setRoleName("财务总监");
            r2.setRoleMome("财务总监");
            Role r3 = new Role();
            r3.setRoleName("技术总监");
            r3.setRoleMome("技术总监");
            Role r4 = new Role();
            r4.setRoleName("销售总监");
            r4.setRoleMome("销售总监");
            //u1-->r1,r2
            u1.getRoleSet().add(r1);
            u1.getRoleSet().add(r2);
            //u2-->r3,r4
            u2.getRoleSet().add(r3);
            u2.getRoleSet().add(r4);

            session.save(u1);
            session.save(u2);



            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    public void linkTable(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory= HibernateUtils.getSessionFactory();
            session = sessionFactory.openSession();
            tx=session.beginTransaction();

            User u1=session.get(User.class,8);
            Role r1=session.get(Role.class,16);
            u1.getRoleSet().remove(r1);


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }

}
