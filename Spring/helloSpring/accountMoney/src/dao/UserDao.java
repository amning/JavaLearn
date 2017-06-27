package dao;

import bean.User;

/**
 * Created by 王宁 on 2017/6/6.
 */
public class UserDao {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void add(){
        System.out.println("dao...");
    }}
