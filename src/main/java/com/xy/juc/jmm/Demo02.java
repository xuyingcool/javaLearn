package com.xy.juc.jmm;

public class Demo02 {

    private static volatile int num = 1;
    static void add(){
        num++;
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
