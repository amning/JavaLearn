package jdbc;

import java.sql.*;

/**
 * Created by 王宁 on 2017/4/18.
 * 设计一个方法，进行分页查询

 public static void list(int start, int count)


 start 表示开始页数，count表示一页显示的总数
 list(0,5) 表示第一页，一共显示5条数据
 list(10,5) 表示第三页，一共显示5条数据
 */
public class listDemo {
    public static void list(int start,int count){
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
           String sql ="select * from hero limit 'start','count'";
           String sql1 ="select * from hero limit 4,5";

            ResultSet rs = s.executeQuery(sql);
            int id = 0;
            String name =null;
            while(rs.next()){
                id = rs.getInt(1);
                name = rs.getString(2);
                System.out.println("id=："+id+"  name:"+name);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void main(String [] args){
        list(1,5);
    }
}
