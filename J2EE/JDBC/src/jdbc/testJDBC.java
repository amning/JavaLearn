/**
 * Created by 王宁 on 2017/4/18.
 */
package jdbc;

import java.sql.*;

public class testJDBC {

           public static void main(String[] args) {
            Connection c =null;
            Statement s = null;
            //初始化驱动
            try {
                //驱动类com.mysql.jdbc.Driver
                //就在 mysql-connector-java-5.0.8-bin.jar中
                //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
                Class.forName("com.mysql.jdbc.Driver");

                c =
                        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demobase?characterEncoding=UTF-8","root","wangning");
                System.out.println("连接成功，获取连接对象： " + c);
                s = c.createStatement();
                System.out.println("获取statement对象"+s);
                String sql ="SELECT * FROM hero";
                /*
                删除
               for(int i = 5;i<105;i++){
                    sql = "delete from hero where id = "+i;
                    s.ORMdemo(sql);
                }
                增加： String sql = "insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
                */

                /*
                executeQuery 执行SQL查询语句
                 */
                ResultSet rs = s.executeQuery(sql);
                while (rs.next()){
                    int id = rs.getInt("id");//也可以使用字段名
                    String name = rs.getString(2);//也可以使用字段的顺序
                    float hp = rs.getInt("hp");
                    int damage = rs.getInt(4);
                    System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
                }//此处不需要关闭ResultSet，statement关闭时会自动关闭ResultSet；
                //rs.close();


                System.out.println("执行成功");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
                // 先关闭Statement
                if(s!=null){
                    try {
                        s.close();
                    }catch (SQLException e ){
                        e.printStackTrace();
                    }
                }
                // 后关闭Connection
                if(c!=null){
                    try {
                        c.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }


    }
}
