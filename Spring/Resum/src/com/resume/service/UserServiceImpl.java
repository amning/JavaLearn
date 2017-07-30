package com.resume.service;

import com.resume.mapper.UserMapper;
import com.resume.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 王宁 on 2017/7/29.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    public User login(String username) {
        return userMapper.login(username);
    }
}
