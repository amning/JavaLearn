package me.test;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import me.dao.UserDaoInte;
import me.entity.User;
import me.utils.MybatisUtil;
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
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
        public static void main(String[] args) {

        sqlSessionFactory = getSqlSessionFactory();
          SqlSession session = sqlSessionFactory.openSession();
            try {
                UserDaoInte dao=session.getMapper(UserDaoInte.class);
                session.delete("me.dao.UserDaoInte.delUserById",1);

            } finally {
                session.close();
            }
        }

}
