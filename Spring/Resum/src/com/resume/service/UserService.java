package com.resume.service;

import com.resume.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by 王宁 on 2017/7/26.
 */

public interface UserService {
    public User login(String username);
}
