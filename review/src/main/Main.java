package main;

import charactor.Hero;
import main.MyStack;

/**
 * Created by 王宁 on 2017/9/19.
 */
public class Main {


    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        for(int i=0;i<10;i++){
            Hero hero = new Hero();
            hero.setId(i);
            hero.setName("abc"+i);
            myStack.push(hero);
        }
        System.out.println(myStack.peek());
        myStack.pull();
        System.out.println(myStack.peek());

    }
}
