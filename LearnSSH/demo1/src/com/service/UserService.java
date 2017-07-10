package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/7.
 */
@Transactional
public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add(){
        System.out.println("正在执行添加。。。");
        userDao.addUser();
        System.out.println("添加完毕。。。");
    }
    public void get(int id){
        User user= userDao.get(1);
        System.out.println(user);
    }
    public void findAll(){
        List<User> list = userDao.findAll();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()){
            User user=iterator.next();
            System.out.println(user);
        }
    }
    public static void main(String[] args) {
        UserService service = new UserService();
        service.findAll();
    }
}
