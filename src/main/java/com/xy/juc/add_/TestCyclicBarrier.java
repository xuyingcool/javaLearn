package com.xy.juc.add_;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        /**
         * 集齐7颗龙珠召唤神龙
         */
        // 召唤神龙的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功");
        });

        for (int i = 1; i < 8; i++) {
            final int  temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"获得了"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();  //  其实就是等待，然后里面在加数量
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
