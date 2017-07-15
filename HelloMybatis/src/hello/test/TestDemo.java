package hello.test;


import hello.dao.UserDao;
import hello.entity.User;
import hello.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 王宁 on 2017/7/10.
 */
public class TestDemo {
    private static ApplicationContext ctx;

    static
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args)
    {
        UserDao userDao = (UserDao)ctx.getBean("userMapper");
        //测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
        System.out.println("得到用户id=1的用户信息");
        User user = userDao.getUserById(1);
        System.out.println(user);

 }


}
