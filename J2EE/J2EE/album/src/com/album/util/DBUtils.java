package com.album.util;

/**
 * Created by 王宁 on 2017/6/12.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 王宁 on 2017/5/15.
 */
public class DBUtils{
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "demobase";
    static String encoding = "UTF-8";
    static String loginName="root";
    static String password = "wangning";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String url=String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",ip,port,database,encoding);
        return DriverManager.getConnection(url,loginName,password);
    }
    public static void main(String[] args)throws SQLException{

    }

}

