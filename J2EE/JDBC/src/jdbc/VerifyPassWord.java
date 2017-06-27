package jdbc;

import java.sql.*;

/**
 * Created by 王宁 on 2017/4/18.
 * 1. 创建一个用户表，有字段name,password
 2. 插入一条数据
 3. SQL语句判断账号密码是否正确
 判断账号密码的正确方式是根据账号和密码到表中去找数据，
 如果有数据，就表明密码正确了，如果没数据，就表明密码错误。
 */
public class VerifyPassWord {

    public static void main(String [] args){
         //1.初始化驱动类com.mysql.jdbc.Driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("初始化成功");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(
                //与数据库建立连接
                Connection c =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demobase?characterEncoding=UTF-8",
                        "root","wangning");

                //创建Statement 用于sql语句的操作
                Statement s = c.createStatement();
        ){
            System.out.println("与数据库建立连接成功："+c);
            String name = "王宁";
            String password = "ngning";

            //创建sql语句
            String sql = "SELECT *FROM USER WHERE name = '"+name+"'and password = '"+password+"'";
            //String sql = "SELECT * FROM user WHERE name = '"+name+"'AND password ='"+password+"'";
            //语句写入
           ResultSet rs=  s.executeQuery(sql);//返回结果集给rs
            System.out.println("SQL写入成功");
            if(rs.next()){
                System.out.print("密码正确");
            }else
                System.out.print("密码错误");
        }catch (SQLException e ){
            e.printStackTrace();
        }

    }
}
