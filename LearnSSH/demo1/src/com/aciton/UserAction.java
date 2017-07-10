package com.aciton;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

/**
 * Created by 王宁 on 2017/7/7.
 */
public class UserAction extends ActionSupport {
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @Override
    public String execute() throws Exception {
        System.out.println("action...");
        userService.findAll();
        return NONE;
    }
}
