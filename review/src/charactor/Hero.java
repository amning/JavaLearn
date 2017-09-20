package charactor;

/**
 * Created by 王宁 on 2017/9/19.
 */
public class Hero {
    private String name;
    private int id;
    public Hero(){

    }
    public Hero(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
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
}
