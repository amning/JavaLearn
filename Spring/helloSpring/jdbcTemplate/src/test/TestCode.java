package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * Created by 王宁 on 2017/6/9.
 */
public class TestCode {
    @Test
    public void testDemo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("b1.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
