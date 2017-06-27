package test;

import bean.Book;
import bean.BuyBook;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by 王宁 on 2017/6/6.
 */
public class TestUser extends TestCase{
    public void testUser(){
            ApplicationContext c =new ClassPathXmlApplicationContext("b1.xml");
        Book book = (Book) c.getBean("b");
        book.add();

    }
    protected void setUp() throws Exception{
        System.out.println("setUp...");
    }
    protected void tearDown() throws Exception{
        System.out.println("tearDown...");
    }

}
