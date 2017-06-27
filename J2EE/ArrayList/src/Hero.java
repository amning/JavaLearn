/**
 * Created by 王宁 on 2017-4-14.
 */
public class Hero implements LOL {
    public String name;
    public float hp;

    public int damage;

    public Hero() {

    }

    public Hero(String name) {

        this.name = name;
    }

    public String toString() {
        return name;
    }


}
