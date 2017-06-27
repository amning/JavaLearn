import java.io.Serializable;

/**
 * Created by 王宁 on 2017/4/12.
 */
public class Hero implements Serializable{
    private static final long serialVersionUID = 1L;
    public String name;
    public float hp;
    public int i;
    public Hero(String name){
        this.name = name;

    }
    public Hero(String name,int i){
        this.name=name;
        this.hp = hp;
    }
}
