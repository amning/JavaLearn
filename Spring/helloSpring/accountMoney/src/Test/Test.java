package Test;

import bean.Order;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import service.OrderService;

/**
 * Created by 王宁 on 2017/6/4.
 */
public class Test extends TestCase {

    public void testDemo(){

    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    OrderService orderService = (OrderService) context.getBean("orderService");
    orderService.acountMoney("任磊","巫岳",1000);
}
    //测试类的生命周期方法
protected void setUp() throws Exception{
    System.out.println("setUp...");
}
protected void tearDown() throws Exception{
    System.out.println("tearDown...");
}
}
