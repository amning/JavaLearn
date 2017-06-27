package dao;

import bean.User;

import java.sql.*;

/**
 * Created by 王宁 on 2017/4/26.
 */
public class UserDAO {
    public User getUser(String name,String password){
        User result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "wangning");
            String sql ="SELECT *FROM USER WHERE NAME =? and password=?";
            PreparedStatement ps =c.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                result=new User();
                result.setId(rs.getInt(1));
                result.setName(name);
                result.setPassword(password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void addUser(User u) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8",
                    "root", "wangning");
            String sql = "INSERT into USER VALUES (null,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            String name = u.getName();
            String password = u.getPassword();
            ps.setString(1, name);
            ps.setString(2, password);
            ps.execute();
            c.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

