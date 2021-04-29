package com.xy.juc.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class Test03 {
    private static volatile AtomicInteger num = new AtomicInteger();
    static void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {



        for (int j = 20; j > 0; j--) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            //有两个线程 main 和gc一直在
        }
        System.out.println(num);
    }

}
