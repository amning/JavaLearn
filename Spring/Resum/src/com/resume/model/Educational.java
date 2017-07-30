package com.resume.model;

/**
 * Created by 王宁 on 2017/7/26.
 */
public class Educational {
    private int Eduid;
    private String School;
    private String Major;

    public int getEduid() {
        return Eduid;
    }

    public void setEduid(int eduid) {
        Eduid = eduid;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getGraduation() {
        return Graduation;
    }

    public void setGraduation(String graduation) {
        Graduation = graduation;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    private String Education;
    private String Graduation;
    private int UserId;
}
