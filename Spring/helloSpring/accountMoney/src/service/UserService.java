package service;

import dao.UserDao;

/**
 * Created by 王宁 on 2017/6/4.
 */
public class UserService {

    private UserDao dao;
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public void add(){
        System.out.println("service...");
        dao.add();
    }
}
