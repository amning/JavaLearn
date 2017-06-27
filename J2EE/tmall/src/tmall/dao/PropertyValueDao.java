package tmall.dao;

import tmall.bean.Product;
import tmall.bean.Property;
import tmall.bean.PropertyValue;
import tmall.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/17.
 */
public class PropertyValueDao {
    public int getTotal(){
        int total = 0;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();) {
            String sql= "SELECT count *FROM propertyvalue";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                total=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return total;
    }
    public void add(PropertyValue bean){
        String sql ="INSERT  into propertyvalue values(null,?,?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1,bean.getProduct().getId());
            ps.setInt(2,bean.getProperty().getId());
            ps.setString(3,bean.getValue());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(PropertyValue bean){
        String sql = "UPDATE propertyvalue set pid=?,ptid=?,value=? where id =?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps =c.prepareStatement(sql);) {
            ps.setInt(1,bean.getProduct().getId());
            ps.setInt(2,bean.getProperty().getId());
            ps.setString(3,bean.getValue());
            ps.setInt(4,bean.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try(Connection c =DBUtil.getConnection();
        Statement s = c.createStatement();) {
            String sql ="DELETE FROM propertyvalue WHERE id="+id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public PropertyValue get(int id){
        PropertyValue bean = new PropertyValue();
        try(Connection c =DBUtil.getConnection();
        Statement s =c.createStatement();) {
            String sql="SELECT *FROM propertyvalue WHERE id ="+id;
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){

                int pid=rs.getInt("pid");
                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");
                Property property = new PropertyDao().get(ptid);
                Product product = new ProductDao().get(pid);
                bean.setProduct(product);
                bean.setProperty(property);

                bean.setValue(value);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public PropertyValue get(int ptid,int pid){
        PropertyValue bean = new PropertyValue();
        String sql = "SELECT *from propertyvalue WHERE ptid=? and pid=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1,ptid);
            ps.setInt(2,pid);

            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                int id = rs.getInt("id");
                String value = rs.getString("value");

                Property property = new PropertyDao().get(ptid);
                Product product = new ProductDao().get(pid);
                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return bean;
    }
    public List<PropertyValue> list(){
        return list(0,Short.MAX_VALUE);
    }
    public List<PropertyValue> list(int start,int count){
        List<PropertyValue> beans = new ArrayList<PropertyValue>();
        String sql="SELECT *FROM propertyvalue order by id DESC limit ?,?";

        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PropertyValue bean = new PropertyValue();
                int id = rs.getInt(1);

                int pid = rs.getInt("pid");
                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");

                Product product = new ProductDao().get(pid);
                Property property = new PropertyDao().get(id);
                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);

                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    //查询某个产品下所有的属性值
    public List<PropertyValue> list(int pid){
        List<PropertyValue> beans = new ArrayList<PropertyValue>();
        String sql = "SELECT *FROM propertyvalue where pid =? order by ptid desc";
        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PropertyValue bean = new PropertyValue();
                int id = rs.getInt(1);
                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");

                Product product = new ProductDao().get(pid);
                Property property = new PropertyDao().get(id);
                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);

                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }
    //初始化某个产品对应的属性值
    public void init(Product product){
        List<Property> pts =new PropertyDao().list(product.getCategory().getId());

        for(Property pt:pts){
            PropertyValue pv = get(pt.getId(), product.getId());
            if(null==pv){
                pv=new PropertyValue();
                pv.setProduct(product);
                pv.setProperty(pt);
                this.add(pv);
            }
        }
    }

}
