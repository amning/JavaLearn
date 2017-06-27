package test;

import many2many.dao.UserDao;
import junit.framework.TestCase;
import one2many.bean.Customer;
import one2many.dao.GetDao;
import one2many.dao.GetDaoByQBC;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by 王宁 on 2017/6/14.
 */
public class TestHibernate extends TestCase {

    GetDaoByQBC dao = new GetDaoByQBC();
   public void testCode(){
      List<Customer> list =dao.getCustomerByO();
     if(null!=list)
         iterator(list);
     else System.out.println("未找到");

   }
   public void iterator(List list){
        Iterator<Object>i=list.iterator();

        while (i.hasNext()){
            Customer customer= (Customer) i.next();
            System.out.println(" Name "+" : "+customer.getCustName());
            System.out.println(" Level "+" : "+customer.getCustLeve1());
        }
    }
}
