package Service;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/3.
 */
public class UserService {
    UserDao dao = new UserDao();
    public List<User> findAll(){
        List<User> list =new ArrayList<>();

        list=dao.findAll();
        return list;
    }
    public User getUser(String username){
        User user = dao.getUserByName(username);
        return user;
    }
}
