package com.resume.model;

/**
 * Created by 王宁 on 2017/7/26.
 *  工作经历实体类Work_info
 */
public class Work {
    private int WorkId;
    private String Company;
    private String Position;
    private String Duty;
    private String Departure;
    private int UserId;
    public int getWorkId() {
        return WorkId;
    }

    public void setWorkId(int workId) {
        WorkId = workId;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getDuty() {
        return Duty;
    }

    public void setDuty(String duty) {
        Duty = duty;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }


}
