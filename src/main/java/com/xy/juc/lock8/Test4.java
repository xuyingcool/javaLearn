package com.xy.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 7. 一个是静态同步方法，一个是普通同步方法，先打电话还是先发短信？ 打电话
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Phone4 phone = new Phone4();
        new Thread(()->{phone.send();},"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone.call();},"B").start();
    }
}

//两个方法锁的东西不是同一个，所以不需要等待
class Phone4{

    //这里锁的是class模板
    public static synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    // 普通同步方法
    // 这里锁的是调用对象
    public  synchronized void call(){
        System.out.println("打电话");
    }
}

