package me.test;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import me.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by 王宁 on 2017/7/10.
 */
public class TestDemo {
       private static SqlSessionFactory sqlSessionFactory;
        private static Reader reader;

        static{
            try{
                reader    = Resources.getResourceAsReader("conf.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public static SqlSessionFactory getSession(){
            return sqlSessionFactory;
        }

        public static void main(String[] args) {
            SqlSession session = sqlSessionFactory.openSession();
            try {
                User user = (User) session.selectOne("selectUserByID", 1);
                System.out.println(user);
            } finally {
                session.close();
            }
        }

}
