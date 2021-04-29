package com.xy.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Executors工具类,三大方法
public class Demo1 {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
        ExecutorService threadPool2 = Executors.newFixedThreadPool(100);// 创建一个固定的线程池的大小
        ExecutorService threadPool3 = Executors.newCachedThreadPool();//可伸缩的，遇强则强，遇弱则弱


        //使用线程池创建线程

        try {
            for (int i = 0; i < 1000; i++) {
                threadPool2.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，关闭线程池
            threadPool2.shutdown();
        }



    }
}
