package jdbc;

import java.sql.*;

/**
 * Created by 王宁 on 2017/4/18.
 */
public class PPStatement {

    public static void main(String[] args){
        //1.初始化驱动类com.mysql.jdbc.Driver
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("初始化成功");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
     // String sql ="insert int hero values(null,?,?,?)";
       // String sql = "insert into hero values(null,?,?,?)";
        String sql = "INSERT INTO hero VALUES (null,?,?,?)";
        try(
                //与数据库建立连接
                Connection c =
                        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demobase?characterEncoding=UTF-8",
                                "root","wangning");

                //创建Statement 用于sql语句的操作
               PreparedStatement s = c.prepareStatement(sql);
        ){
          s.setString(1,"提莫");
          s.setFloat(2,330.0f);
          s.setInt(3,50);
          s.execute();
            System.out.println("SQL执行成功");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
