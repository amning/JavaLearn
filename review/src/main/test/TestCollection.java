package main.test;

import charactor.Hero;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 王宁 on 2017/9/20.
 */
public class TestCollection {
    public static void main(String[] args) {
        Comparator <Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Set<Integer> set=new TreeSet<>(c);
        for(int i=0;i<10;i++){
            set.add(i);
        }
        System.out.println(set);
    }
}
