package com.xy.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 5.增加了两个静态的同步方法，只有一个对象，发短信还是打电话？  发短信
 * 6.如果是两个对象了
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Phone3 phone = new Phone3();
        new Thread(()->{phone.send();},"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone.call();},"B").start();
    }
}

// phone3只有唯一的一个class对象
class Phone3{

    // static 静态方法
    // 类一加载就有了   class模板
    // 锁的是class
    public static synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}
