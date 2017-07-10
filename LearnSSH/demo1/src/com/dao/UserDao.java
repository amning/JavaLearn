package com.dao;

import com.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/7.
 */
public interface UserDao {
    public void addUser();
    public User get(int id);
    public List<User> findAll();
    public List<User> find(String username);
}
