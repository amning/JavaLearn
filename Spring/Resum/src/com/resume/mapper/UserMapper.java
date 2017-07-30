package com.resume.mapper;

import com.resume.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 王宁 on 2017/7/29.
 */
@MapperScan
public interface UserMapper {
    public User login(String username);
}
