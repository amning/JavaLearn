package main.test;

import charactor.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 王宁 on 2017/9/20.
 */
public class TestCompare {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        for(int i=0;i<10;i++){
            Item item=new Item(i,"item+i");
            items.add(item);
        }

            System.out.println(items);
        Collections.sort(items);
        System.out.println(items);

    }

}
