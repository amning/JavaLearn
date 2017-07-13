package me.test;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;


import me.entity.User;
import me.service.UserService;
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
        UserService userService=new UserService();
        User user =new User();
        user.setId(2);
        user.setUsername("谱子");
        user.setPassword("252");
        userService.updateUser(user);
 /*       Iterator<User> it = users.iterator();
        while (it.hasNext()){
            User user = it.next();
            System.out.println(user);
        }*/
    }

}
