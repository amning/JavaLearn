package com.resume.controller;

import com.resume.model.User;
import com.resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 王宁 on 2017/7/26.
 */
@Controller
public class UserController {
    @Resource
    public UserService userService;
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        System.out.println("user"+user.getUsername());
        //调用service登录方法
        User loginuser = userService.login(user.getUsername());
        //放入session
        session.setAttribute("loginuser",loginuser.getId());

        //验证用户名和密码
        if((user.getUsername()!=null)&&(user.getPassword()!=null)){
            if (loginuser.getUsername().equals(user.getUsername())&&
                    (loginuser.getPassword().equals(user.getPassword()))){
                return "basic";
            }else return "error";
        }else return "error";
    }
}
