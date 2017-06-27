package jdbc;

import java.sql.*;

/**
 * Created by 王宁 on 2017/4/18.
 */
public class getNum {
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
            String sql = "select count (*) from hero";

            ResultSet rs = s.executeQuery(sql);
            int num = 0;
            while (rs.next()){
                num = rs.getInt( 1);
            }
            System.out.println("表Hero中总共有:" + num+" 条数据");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
