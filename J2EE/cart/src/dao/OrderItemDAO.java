package dao;

import bean.Order;
import bean.OrderItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 王宁 on 2017/4/27.
 */
public class OrderItemDAO {
    public void insert(OrderItem oi){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8"
                                                            ,"root","wangning");
            String sql = "INSERT into orderitem VALUES (null,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            ps.setInt(3,oi.getOrder().getId());

            ps.execute();
            ps.close();
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
