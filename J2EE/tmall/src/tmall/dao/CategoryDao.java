package tmall.dao;

import tmall.bean.Category;
import tmall.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/15.
 * 增 public void add(Category bean)
 * 删 public void delete(int id)
 * 改 public void update(Category bean)
 * 查-->分页查询 public List<Category> list(int start,int count)
 *   -->根据id获取 public Category get(int id)
 *   -->查询所有 public List<Category> list()
 *   -->获取总数 public int getTotal()
 *
 */
public class CategoryDao {

    public void add(Category bean){
        String sql = "INSERT into category VALUES (null,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement s =c.prepareStatement(sql);
        ){
            s.setString(1,bean.getName());
            s.execute();
            ResultSet rs = s.getGeneratedKeys();
            if(rs.next()){
                int id =rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void delete(int id){
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();){
            String sql = "delete FROM  category where id = "+id;
            s.execute(sql);
    }catch (SQLException e ){
            }
    }
    public void update(Category bean){
        String sql= "update category set name = ? where id = ? ";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c .prepareStatement(sql);
                ){
            ps.setInt(2,bean.getId());
            ps.setString(1,bean.getName());
            ps.execute();
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
    public List<Category> list(int start,int count){
        List<Category> beans = new ArrayList<Category>();
        String sql = "SELECT *FROM category order by id DESC limit ?,?";
        try(Connection c = DBUtil.getConnection();
        PreparedStatement p = c.prepareStatement(sql);) {
            p.setInt(1,start);
            p.setInt(2,count);
            ResultSet rs = p.executeQuery();

            while (rs.next()){
                Category bean = new Category();
                int id = rs.getInt(1);
                String name =rs.getString(2);
                bean.setId(id);
                bean.setName(name);
                beans.add(bean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return beans;
    }
    public Category get(int id){
        Category bean = null;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();
            ) {
            String sql = "SELECT *FROM category where id = "+id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                bean = new Category();
                String name = rs.getString(2);
                bean.setName(name);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public List<Category> list(){
        return list(0,Short.MAX_VALUE);
    }
    public int getTotal(){
        int total = 0;
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement();){
            String sql = "SELECT COUNT (*) FROM category";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                total=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static void main(String[] args) {
        Category c = new Category();
        c.setId(3);
        c.setName("女包");
        new CategoryDao().update(c);
    }

}
