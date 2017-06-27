package jdbc;

import java.sql.*;

/**
 *
 ORM=Object Relationship Database Mapping
 对象和关系数据库的映射
 简单说，一个对象，对应数据库里的一条记录

 提供方法get(int id)
 返回一个Hero对象
 */
public class ORMdemo {
    public static Hero get(int id){
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("初始化成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                //与数据库建立连接
                Connection c =
                        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demobase?characterEncoding=UTF-8",
                                "root", "wangning");
                Statement ps = c.createStatement();
        ) {
            String sql = "SELECT * FROM hero WHERE id ="+id;

             ResultSet rs = ps.executeQuery(sql);

            if (rs.next()) {
               hero = new Hero();
               String name = rs.getString(2);
               float hp = rs.getFloat(3);
               int damage = rs.getInt(4);
               hero.name = name ;
               hero.hp = hp;
               hero.id=id;
               hero.damage = damage;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }
    public static void main(String[] args) {
        //1.初始化驱动类com.mysql.jdbc.Driver
        Hero hero = get(212);
        System.out.println(hero.name);
    }
}


