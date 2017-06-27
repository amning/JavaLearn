package tmall.dao;

import tmall.bean.Product;
import tmall.bean.Review;
import tmall.bean.User;
import tmall.util.DBUtil;
import tmall.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/20.
 */
public class ReviewDao {
    public int getTotal(){
        int total = 0;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();) {
            String sql = "SELECT COUNT (*) FROM review";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public int getTotal(int pid){
        int total = 0;
        try(Connection c =DBUtil.getConnection();
        Statement s = c.createStatement();
        ) {
            String sql = "SELECT COUNT (*) FROM review where pid="+pid;
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                total = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public void add(Review bean){
        String sql = "INSERT into review VALUEs(null,?,?,?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,bean.getContent());
            ps.setInt(2,bean.getUser().getId());
            ps.setInt(3,bean.getProduct().getId());
            ps.setTimestamp(4, DateUtil.d2t(bean.getCreatDate()));

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id= rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Review bean){
        String sql = "UPDATE review set content = ?,uid=?,pid=?,creatdate=?,where id = ?";
        try(Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,bean.getContent());
            ps.setInt(2,bean.getUser().getId());
            ps.setInt(3,bean.getProduct().getId());
            ps.setTimestamp(4,DateUtil.d2t(bean.getCreatDate()));
            ps.setInt(5,bean.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try(Connection c = DBUtil.getConnection();
        Statement s = c.createStatement();) {
            String sql = "DELETE FROM review where id = "+id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Review get(int id){
        Review bean = new Review();

        try(Connection c =DBUtil.getConnection();
           Statement s = c.createStatement();) {
            String sql = "SELECT * FROM  review where id = "+id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                int pid = rs.getInt("pid");
                int uid = rs.getInt("uid");
                Date creatDate =DateUtil.t2d(rs.getTimestamp("creatDate"));
                String content = rs.getString("content");
                Product product = new ProductDao().get(pid);
                User user = new UserDao().get(uid);

                bean.setId(id);
                bean.setContent(content);
                bean.setCreatDate(creatDate);
                bean.setUser(user);
                bean.setProduct(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public List<Review> list(int pid){
        return list(pid,0,Short.MAX_VALUE);
    }

    private List<Review> list(int pid, int start, int count) {
        List<Review> beans = new ArrayList<Review>();
        String sql = "SELECT *FROM review where pid = ?  order by id desc limit ?,?";
        try (Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);){
            ps.setInt(1,pid);
            ps.setInt(2,start);
            ps.setInt(3,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Review bean = new Review();
                int id = rs.getInt(1);
                int uid = rs.getInt("uid");
                Date creatDate =DateUtil.t2d(rs.getTimestamp("creatDate"));
                String content = rs.getString("content");
                Product product = new ProductDao().get(pid);
                User user = new UserDao().get(uid);

                bean.setId(id);
                bean.setContent(content);
                bean.setCreatDate(creatDate);
                bean.setUser(user);
                bean.setProduct(product);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }
    public int getCount(int pid){
        String sql = "SELECT count(*) FROM review where pid = ? ";
        try(Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1,pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean isExist(String content,int pid){
        String sql = "SELECT * FROM review where content =? and pid=?";
        try (Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,content);
            ps.setInt(2,pid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
