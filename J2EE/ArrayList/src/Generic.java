import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王宁 on 2017-4-14.
 * 借助泛型和前面学习的面向对象的知识，
 * 设计一个ArrayList，使得这个ArrayList里，又可以放Hero，又可以放Item,
 * 但是除了这两种对象，其他的对象都不能放
 */
public class Generic

{
    public static void main(String [] args){
        ArrayList<Hero> heros = new ArrayList<>();
    iT(heros);

}
/*
首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
hero 0
hero 1
hero 2
...
hero 99.

通过遍历的手段，删除掉名字编号是8的倍数的对象
 */
    public static void iT(ArrayList<Hero> a){
        for(int i = 0;i<100;i++){
            a.add(new Hero("hero"+i));
        }

        System.out.println("\n");

        /*
        不能够在使用Iterator和增强for循环遍历数据的同时，删除数据，
        否则会抛出ConcurrentModificationException
        解决办法:是准备一个临时容器，专门用来保存需要删除的对象。 然后再删掉
         */
        List<Hero> tempHeros = new ArrayList<>();

        for (int i = 1;i<100;i++){
            //int id = Integer.parseInt(h.name.substring(10));

            if(i%8==0){
                Hero h = a.get(i);
                tempHeros.add(h);
            }
        }

        for(Hero h :tempHeros){
            a.remove(h);
        }

        itPut(a);
        System.out.println("\n");
    }
    public static void itPut(ArrayList<Hero> a){

        for (Hero h : a) {
            System.out.println(h);

        }
    }

}
