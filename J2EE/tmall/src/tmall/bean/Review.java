package tmall.bean;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import java.util.Date;

/**
 * Created by 王宁 on 2017/5/13.
 */
public class Review {

    private int id;
    private String content;//评论内容
    private Date creatDate;
    private User user;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
