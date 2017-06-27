package bean;

/**
 * Created by 王宁 on 2017/4/27.
 */
public class Order {
    private int id;
    private  User user;

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
