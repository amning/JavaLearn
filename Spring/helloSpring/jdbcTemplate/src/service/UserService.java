package service;

import dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 王宁 on 2017/6/6.
 */

public class UserService {

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    public void add(){
        userDao.add();
    }
}
