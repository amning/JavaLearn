package service;

import dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 王宁 on 2017/6/10.
 */
//@Transactional
public class OrderService {
    private OrderDao orderDao;
    public void add(){
        System.out.println("service...");
        orderDao.add();
    }
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    //调用dao方法
    //业务逻辑层，写转账业务  转账=-->转出人减少钱，收账任增加钱
    public void acountMoney(String lessMoneyName,String moreMoneyName,int money){
        orderDao.lessMoney(money,lessMoneyName);
      //int i= 10/0;
        orderDao.moreMoney(money,moreMoneyName);
    }
}
