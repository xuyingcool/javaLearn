package com.xy.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS  : compareAndSet
 *
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(20);
        // public final boolean compareAndSet(int expect, int update)
        // 期望的值是这个，那么就更新
        // CAS是CPU的并发原语
        System.out.println(atomicInteger.compareAndSet(20, 21));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(20, 21));
    }
}
