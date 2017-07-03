package Service;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/3.
 */
public class UserService {
    public List<User> findAll(){
        List<User> list =new ArrayList<>();
        UserDao dao = new UserDao();
        list=dao.findAll();
        return list;
    }
}
