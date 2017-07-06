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
        List<User> list=null;
        User user1  = dao.getUserByName("徐宁");
        User user2  = dao.getUserByName("任磊");

        System.out.println(user1);
  /*      Iterator it = list.iterator();
        while (it.hasNext()){
            User user = (User)it.next();
            System.out.println(user.getEmail());
        }*/
    }

}
