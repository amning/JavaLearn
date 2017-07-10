package com.dao;

import com.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/7/7.
 */
public class UserDaoImp implements UserDao  {
    private HibernateTemplate hibernateTemplate;
    public User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void addUser() {
        user.setEmail("amning@qq.com");
        user.setPassword("233");
        user.setUsername("xxx");
        hibernateTemplate.save(user);
    }
    //get方法 根据id查询
    public User get(int id){
        user =hibernateTemplate.get(User.class,id);
        return user;
    }
    //find 查询所有
    public List<User> findAll() {
        List<User> list = (List<User>) hibernateTemplate.find("from  User ");
        return list;
    }
    //find 条件查询
    public List<User> find(String username){
        List<User> list = (List<User>) hibernateTemplate.find("from User where username=?",username);
        return list;
    }
    //find分页操作
    public List<User> findByPage(){
        List<User> list=new ArrayList<>();
        //TODO
        return list;
    }
}
