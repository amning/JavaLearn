package tmall.dao;

import tmall.bean.Category;
import tmall.bean.Property;
import tmall.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/17.
 */
public class PropertyDao {
    public int getTotal(int cid){
        int total= 0;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();
            ) {
            String sql = "SELECT COUNT (*) from property where cid ="+cid;

            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total=rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public void add(Property bean){
        String sql = "INSERT into property VALUES (null,?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ) {
            ps.setInt(1,bean.getCategory().getId());
            ps.setString(2,bean.getName());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id  = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Property bean){
        String sql="UPDATE property set cid =?,name=? where id = ?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ){
            ps.setInt(1,bean.getCategory().getId());
            ps.setString(2,bean.getName());
            ps.setInt(3,bean.getId());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(int id){

        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();) {
            String sql ="DELETE *FROM property WHERE id="+id;
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Property get(String name,int cid){

        Property bean = null;
        String sql = "SELECT *from property where name =? and cid= ?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1,name);
            ps.setInt(2,cid);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                int id = rs.getInt("id");
                bean = new Property();
                bean.setName(name);
                Category category = new CategoryDao().get(cid);
                bean.setCategory(category);
                bean.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public Property get(int id){
        Property bean =new Property();
        try (Connection connection = DBUtil.getConnection();
            Statement s = connection.createStatement()){
            String sql = "SELECT *FROM property WHERE id ="+id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                String name =rs.getString("name");
                int cid = rs.getInt("cid");
                bean.setName(name);
                Category category = new CategoryDao().get(cid);
                bean.setCategory(category);
                bean.setId(id);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public List<Property> list(int cid){
        return list(cid,0,Short.MAX_VALUE);
    }

    private List<Property> list(int cid, int start, int count) {
        List<Property> beans=new ArrayList<Property>();
        String sql = "SELECT * FROM property where cid=? order by id DESC limit ?，?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps =c.prepareStatement(sql);
        ) {
            ps.setInt(1,cid);
            ps.setInt(2,start);
            ps.setInt(3,count);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Property bean = new Property();
                int id = rs.getInt(1);
                String name= rs.getString("name");
                bean.setName(name);
                Category category = new CategoryDao().get(cid);
                bean.setCategory(category);
                bean.setId(id);

                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

}
