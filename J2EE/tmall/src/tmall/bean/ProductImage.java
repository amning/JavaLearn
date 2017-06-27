package tmall.bean;

/**
 * Created by 王宁 on 2017/5/13.
 */
public class ProductImage {
    private int id;
    private Product product;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
