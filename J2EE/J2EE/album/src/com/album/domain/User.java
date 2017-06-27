package com.album.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 王宁 on 2017/6/12.
 */
public class User implements Serializable {
    private int  id;
    private String userName;
    private String passWord;
    private List<Image> images;

    public User(){

    }
    public User(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    public User(int id,String userName,String passWord,List<Image> images ){
        this.id=id;
        this.images = images;
        this.userName = userName;
        this.passWord = passWord;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
