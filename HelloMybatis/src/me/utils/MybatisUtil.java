package me.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by 王宁 on 2017/7/11.
 */
public class MybatisUtil {
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
    /*
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    */
    public static SqlSession getSession(){
        SqlSession session = `.openSession();
        return session;
    }

}
