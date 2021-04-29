package com.xy.juc.lock;

import java.util.concurrent.TimeUnit;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();

        new Thread(() -> {
            try {
                spinLock.lock();
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
            }
        },"A").start();


        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> {
            try {
                spinLock.lock();
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
            }
        },"B").start();
    }
}
