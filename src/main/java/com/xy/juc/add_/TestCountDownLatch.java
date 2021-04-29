package com.xy.juc.add_;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6); // 设置数量为6

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"go out");
                countDownLatch.countDown(); // 倒计时，数量减1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();  // 等待计数器归零，然后再向下执行
        System.out.println("door closed");
    }
}
