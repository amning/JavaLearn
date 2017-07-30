package com.resume.model;

/*
 * Created by 王宁 on 2017/7/26.
 *  监理的基本信息实体类
 *  */
public class Basic{
    private int Id;
    private String Name;//姓名
    private String Gender;//性别
    private int Age;//年龄
    private String Address;//地址
    private String Email;//邮件
    private String Tel;//电话
    private String School;//毕业院校
    private String Introduce;//自我介绍

    public void setUserId(int userId) {
        UserId = userId;
    }

    private int UserId;//用户id

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }

}