package com.xy.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3.增加了一个普通方法后先发短信还是hello？  hello ，因为hello方法没有锁
 * 4.两个对象，两个同步方法，发短信还是打电话？  打电话，因为两个对象有两把锁，发短信被sleep了
 */

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(()->{phone.send();},"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone2.call();},"B").start();
    }
}

class Phone2 extends Phone{
    // 这里没有锁
    public void hello(){
        System.out.println("hello");
    }
}