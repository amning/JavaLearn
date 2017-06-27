package Test;

import bean.Book;
import bean.Person;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * Created by 王宁 on 2017/6/4.
 */
public class Test extends TestCase {

    //增加测试方法
   /*
    public void testUser_Success()throws Exception{
        User action = new User();
        action.setUsername("admin");

        String result = action.login();

        assertEquals("success",result);
    }
*/
   public void testUser(){
       ApplicationContext context =
               new ClassPathXmlApplicationContext("applicationContext.xml");
       Person person = (Person) context.getBean("person");
       person.test1();
   }
    //测试类的生命周期方法
protected void setUp() throws Exception{
    System.out.println("setUp...");
}
protected void tearDown() throws Exception{
    System.out.println("tearDown...");
}
}
