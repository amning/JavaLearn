package test;

import Service.UserService;
import dao.UserDao;
import entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/3.
 */
public class TestDb {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        UserService service = new UserService();
        List<User> list;
        list = service.findAll();
        Iterator it = list.iterator();
        while (it.hasNext()){
            User user = (User)it.next();
            System.out.println(user.getEmail());
        }
    }

}
