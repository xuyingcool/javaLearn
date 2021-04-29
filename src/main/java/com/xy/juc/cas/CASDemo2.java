package com.xy.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo2 {
    public static void main(String[] args) {
        Integer yewu = new Integer(2020);
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(yewu, 1);

        new Thread(() -> {
            int stamp = atomicInteger.getStamp(); // 获取版本号
            System.out.println("a1==>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicInteger.compareAndSet(yewu, 2021,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println(atomicInteger.getStamp());

            System.out.println(atomicInteger.compareAndSet(2021, yewu,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println(atomicInteger.getStamp());
        },"A").start();


        new Thread(() -> {
            int stamp = atomicInteger.getStamp(); // 获取版本号
            System.out.println("b==>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(atomicInteger.compareAndSet(yewu, 2021,
                    stamp, stamp + 1));
            System.out.println(atomicInteger.getStamp());
        },"B").start();
    }
}
