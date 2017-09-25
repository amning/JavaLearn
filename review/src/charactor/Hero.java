package charactor;

/**
 * Created by 王宁 on 2017/9/19.
 */
public class Hero implements Comparable<Hero>{
    private String name;
    private int id;
    private float hp;
    private int damage;
    public Hero(){

    }
    public void attackHero(Hero h){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
        if(h.isDead()){
            System.out.println(h.name+"is dead");
        }
    }

    private boolean isDead() {
        return hp<=0?true:false;
    }
    public synchronized void adugen(){
        while (true){
            for (int i =1;i<=3;i++){
                System.out.println("发动攻击"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("开始充能");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    @Override
    public int compareTo(Hero o) {
         if(this.id<o.id) {
             return 1;
         }else
             return -1;
    }
}
