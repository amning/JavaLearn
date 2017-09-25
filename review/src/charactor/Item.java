package charactor;

/**
 * Created by 王宁 on 2017/9/20.
 */
public class Item implements Comparable<Item> {
    int price;
    String name;
    int id;

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Item(int i, String s) {
    this.price = i;
    this.name = s;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Item o) {
        if(o.price>price)
            return 1;
        else
            return -1;
    }
}
