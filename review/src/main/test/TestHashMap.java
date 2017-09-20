package main.test;

import charactor.HasnMap;
import charactor.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 王宁 on 2017/9/20.
 */
public class TestHashMap {
    public static void main(String[] args) {
        HasnMap hm = new HasnMap();
        List<Hero> hs = new ArrayList<>();
        for(int i=0;i<3000000;i++){
            Hero h = new Hero("hero-"+hm.random());
            hs.add(h);
        }

        HashMap<String,List<Hero>> hashMap = new HashMap<>();
        for(Hero h:hs) {
            List<Hero> list = hashMap.get(h.getName());
            if (null == list) {
                list = new ArrayList<>();
                hashMap.put(h.getName(), list);
            }
        list.add(h);
        }
        long start =System.currentTimeMillis();
        List<Hero> result=hm.findByMap(hashMap,"hero-5555");
        long end =System.currentTimeMillis();
        System.out.println(result.size());
        System.out.println(end-start);

    /*    long start1 =System.currentTimeMillis();
        List<Hero> result1=hm.findByInteration(hs,"hero-5555");
        long end1 =System.currentTimeMillis();
        System.out.println(result1.size());
        System.out.println(end1-start1);
*/
    }

}
