package tmall.bean;

import java.util.List;

/**
 * Created by 王宁 on 2017/5/13.
 */
public class OrderItem {
    private int number;
    Product product;//订单项 一个产品对应多个订单项，一个订单项对应一个产品
    private Order order;//一个订单对应多个订单项
    private User user;//订单用户
    private int id;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
