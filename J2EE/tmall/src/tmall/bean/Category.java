package tmall.bean;

import java.util.List;

/**
 * Created by 王宁 on 2017/5/12.
 */
public class Category {
    private int id;
    private String name;
    List<Product> products;
   List<List<Product>> productsByRow;

    //重写toString 方法 当打印Category对象的时候，会打印其名称
    @Override
    public String toString(){
        return "Category[name="+name+"]";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }
}
