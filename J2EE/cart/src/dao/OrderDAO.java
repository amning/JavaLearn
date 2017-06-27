package dao;

import bean.Order;

import java.sql.*;

/**
 * Created by 王宁 on 2017/4/27.
 */
public class OrderDAO {
    public void insert(Order o){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","" +
                    "root","wangning");
            String sql = "INSERT into order_ VALUES (null,?)";

            PreparedStatement ps =c.prepareStatement(sql);
            ps.setInt(1,o.getUser().getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                o.setId(id);
            }
            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
