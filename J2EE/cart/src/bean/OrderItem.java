package bean;

/**
 * Created by 王宁 on 2017/4/27.
 */

public class OrderItem {
    private int id;
    private Product product;
    private int num;
    private Order order;
    private float totalPrice;

    public float getTotalNrice() {
        return totalPrice;
    }

    public void setTotalNrice(float totalNrice) {
        this.totalPrice = totalNrice;
    }

    public float getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(float totalNumber) {
        this.totalNumber = totalNumber;
    }

    private float totalNumber;

    public float getTotalpice() {
        return totalpice;
    }

    public void setTotalpice(float totalpice) {
        this.totalpice = totalpice;
    }

    float totalpice=0;
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
