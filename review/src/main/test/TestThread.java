package main.test;

import charactor.Hero;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 王宁 on 2017/9/24.
 */
public class TestThread {
        public static void main(String [] args){
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
            threadPool.execute(new Runnable(){
                public void run(){
                    System.out.println("task 1");
                }
            });
            threadPool.execute(new Runnable(){
                public void run(){
                    System.out.println("task2");
                }
            });

    }
}
