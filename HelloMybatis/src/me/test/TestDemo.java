package me.test;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

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
        public static void main(String[] args) {
          SqlSession session = MybatisUtil.getSession();
            try {
                User user = (User) session.selectOne("selectUserByID", 1);
                System.out.println(user);
            } finally {
                session.close();
            }
        }

}
