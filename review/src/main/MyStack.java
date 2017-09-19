package main;

import charactor.Hero;
import inte.Stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 王宁 on 2017/9/19.
 */
public class MyStack implements Stack{

    private List<Hero> heros = new LinkedList<>();

    @Override
    public void push(Hero hero) {
        heros.add(hero);
    }

    @Override
    public Hero pull() {
        int last = heros.size()-1;
       Hero h =  heros.get(last);
       heros.remove(h);
       return h;
    }

    @Override
    public Hero peek() {
        int last = heros.size()-1;
        Hero h =  heros.get(last);
        //heros.remove(h);
        return h;
    }
}
