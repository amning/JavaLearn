package an.service;

import an.dao.BookDao;
import an.dao.OrderDao;

import javax.annotation.Resource;

/**
 * Created by 王宁 on 2017/6/6.
 */
public class BookService {
    @Resource(name = "b_dao")
    private BookDao bookDao;
    @Resource(name = "o_dao")
    private OrderDao orderDao;
    public void book(){
        System.out.println("book..service");
        bookDao.book();
        orderDao.buy();
    }
}
