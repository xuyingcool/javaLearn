package com.xy.juc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
   static ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
    public static void main(String[] args) throws InterruptedException {
        test4();
    }
    // 抛出异常
    public static void test1(){
        //()里要写队列的大小

        System.out.println(blockingQueue.add('A'));
        System.out.println(blockingQueue.add('B'));
        System.out.println(blockingQueue.add('C'));

        System.out.println("对首"+blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    // 不抛出异常，返回false
    public static void test2(){
        //()里要写队列的大小

        System.out.println(blockingQueue.offer('A'));
        System.out.println(blockingQueue.offer('B'));
        System.out.println(blockingQueue.offer('C'));
        System.out.println(blockingQueue.offer('D'));  // 返回值false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());  // 返回值null
    }

    // 一直阻塞,等待
    public static void test3() throws InterruptedException {
        blockingQueue.put("A");
        blockingQueue.put("B");
        blockingQueue.put("C");
//        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    // 等待设定的时间，就超时
    public static void test4() throws InterruptedException {
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));

        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
    }

}
