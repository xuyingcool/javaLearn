package com.xy.juc.jmm;

import java.util.concurrent.TimeUnit;

public class Demo01 {
    static volatile int sum =0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (sum==0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        sum =1;
        System.out.println(sum);
    }
}
