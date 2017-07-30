package com.resume.model;

/**
 * Created by 王宁 on 2017/7/26.
 */
public class User {
    private int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

