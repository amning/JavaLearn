package me.test;

import me.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by 王宁 on 2017/7/11.
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.findUserByIdTest();
    }
        public void findUserByIdTest() {
            // mybatis的配置文件
            String resource = "conf.xml";
            Reader reader = null;
            SqlSession sqlSession = null;
            try {
                reader = Resources.getResourceAsReader(resource);
                // 1.创建会话工场,传入mybatis的配置文件信息
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                // 2.通过工厂得到SqlSession
                sqlSession = sqlSessionFactory.openSession();
                // 3.通过sqlSession操作数据库
                // 第一个参数：映射文件中的statement的Id,等于namespace + "." + statement的id;
                // 第二个参数:指定和映射文件中所匹配的parameterType类型的参数;
                // sqlSession.selectOne结果是与映射文件所匹配的resultType类型的对象;
                // selectOne：查询一条结果
                User user = (User) sqlSession.selectOne("me.entity.UserMapper.selectUserByID", 1);
                System.out.println(user);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
