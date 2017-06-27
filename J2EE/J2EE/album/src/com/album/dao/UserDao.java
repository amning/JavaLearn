package com.album.dao;

import com.album.domain.User;
import com.album.util.DBUtils;
import org.glassfish.external.statistics.annotations.Reset;

import java.sql.*;

/**
 * Created by 王宁 on 2017/6/12.
 */
public class UserDao {
    public void add(User user){
        String sql="INSERT into _user values (null,?,?)";
        try(Connection c= DBUtils.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassWord());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                int id=rs.getInt(1);
                user.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUser(String userName){
        User bean=new User();;
        String sql="SELECT * FROM _user where username= ? ";
        try (Connection c = DBUtils.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id =rs.getInt("id");
                String passWord = rs.getString("passWord");
                bean.setId(id);
                bean.setPassWord(passWord);
                bean.setUserName(userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public void delById(int id){
        String sql="DELETE FROM _user where id = ?";
        try(Connection c = DBUtils.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUserById(int id){
        User bean=new User();;
        String sql="SELECT * FROM _user where id = ? ";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String userName =rs.getString("username");
                String passWord = rs.getString("passWord");
                bean.setId(id);
                bean.setPassWord(passWord);
                bean.setUserName(userName);
            }else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
