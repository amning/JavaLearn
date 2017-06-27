package test;

import an.service.BookService;
import bean.User;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * Created by 王宁 on 2017/6/6.
 */
public class TestUser extends TestCase{
    public void testUser(){
        ApplicationContext c =new ClassPathXmlApplicationContext("b1.xml");
        BookService bookService =(BookService) c.getBean("service");
        bookService.book();

    }
    protected void setUp() throws Exception{
        System.out.println("setUp...");
    }
    protected void tearDown() throws Exception{
        System.out.println("tearDown...");
    }

}
