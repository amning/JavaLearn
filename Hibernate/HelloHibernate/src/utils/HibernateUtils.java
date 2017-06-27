package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by 王宁 on 2017/6/14.
 */
public class HibernateUtils {
    private static final Configuration cfg;
    private static final SessionFactory sessionFactory;
    static {
         cfg=new Configuration();
         cfg.configure();
         sessionFactory =cfg.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void main(String[] args) {

    }
}
