package tmall.dao;

import tmall.bean.Product;
import tmall.bean.ProductImage;
import tmall.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017/5/17.
 */
public class ProductImageDao {
    public static final String type_single="type_single"; //单个图片

    public static final String type_detail="type_detail";//详情图片

    public int getTotal(){
        int total = 0;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();
            ){
            String sql="SELECT COUNT (*) FROM productimage";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                total=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public void add(ProductImage bean){
        String sql = "INSERT into productimage values(null,?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ){
            ps.setInt(1,bean.getProduct().getId());
            ps.setString(2,bean.getType());
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
    public void update(ProductImage bean){
            String sql="UPDATE productimage set pid =?,type =? where id = ?";
        try(Connection c = DBUtil.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1,bean.getProduct().getId());
            ps.setString(2,bean.getType());
            ps.setInt(3,bean.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        ProductImage bean = new ProductImage();
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement();) {
            String sql = "DELETE FROM productimage where id ="+id;
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ProductImage get(int id ){
        ProductImage bean = new ProductImage();

        try(Connection c=DBUtil.getConnection();
           Statement s = c.createStatement();) {
            String sql= "SELECT  * FROM productimage WHERE id =?"+id;
            ResultSet rs = s.executeQuery(sql);

            if(rs.next()){
                int pid = rs.getInt("pid");
                String type =rs.getString("type");
                Product product = new ProductDao().get(pid);
                bean.setProduct(product);
                bean.setType(type);
                bean.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
    public List<ProductImage> list (Product p ,String type){
        return list(p,type,0,Short.MAX_VALUE);
    }

    private List<ProductImage> list(Product p, String type, int start,int count) {
        List<ProductImage> beans = new ArrayList<ProductImage>();
        String sql = "select * from productimage where pid=? and type=? order by id desc limit ?,?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1,p.getId());
            ps.setString(2,type);
            ps.setInt(3,start);
            ps.setInt(4,count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ProductImage bean = new ProductImage();
                int id = rs.getInt(1);
                bean.setId(id);
                bean.setProduct(p);
                bean.setType(type);

                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
