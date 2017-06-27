package com.album.dao;

import com.album.domain.Image;
import com.album.domain.User;
import com.album.util.DBUtils;
import com.album.util.DateUtil;
import com.album.util.FileUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 王宁 on 2017/6/12.
 */
public class ImageDao {
    public void add(Image image, InputStream inputStream){
        FileUtils.upload(inputStream,image.getUrl());
        String sql="INSERT into image VALUES (null,?,?,?,?)";
        try(Connection c = DBUtils.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,image.getName());
            ps.setString(2,image.getUrl());
            ps.setTimestamp(3,DateUtil.d2t(image.getDate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void delByIdAndUrls(int id){
        String sql="DELETE FROM image where id = ?";
        try(Connection c = DBUtils.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Image> getByUserId(int userId){
        ArrayList<Image>  images = new ArrayList<Image>();
        String sql = "SELECT * FROM image where user_id = ? order by date desc";
        try(Connection c = DBUtils.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
        ps.setInt(1,userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Image image= new Image();
            Date date=rs.getDate("date");
            image.setDate(date);
            String name=rs.getString("name");
            image.setName(name);
            String url = rs.getString("url");
            image.setUrl(url);
            User user =new UserDao().getUserById(userId);
            image.setUser(user);
            images.add(image);
        }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return images;
     }



}
