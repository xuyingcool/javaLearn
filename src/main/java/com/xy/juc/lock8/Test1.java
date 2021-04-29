package com.xy.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁就是8个问题
 * 1.标准情况下，两个线程谁先打印出来？   发短信，先调用的获得锁了
 * 2.send 加延迟，两个线程谁先打印出来？  还是发短信，因为synchronized 锁的对象是方法的调用者，
 *         调用的方法两个用的是同一个对象，谁先拿到锁就先执行
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{phone.send();},"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone.call();},"B").start();
    }

}

class Phone{
    // synchronized 锁的对象是方法的调用者
    // 两个方法用的是同一个锁
    public synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
