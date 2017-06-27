/**
 * Created by 王宁 on 2017-4-14.
 */
public class Item implements LOL {
    String name;
    int prive;

    public Item(){

    }
    public Item(String name){
        this.name = name;
    }
    public void effect(){
        System.out.println("有效果");
    }
    public boolean disposable(){
        return false;
    }
}
