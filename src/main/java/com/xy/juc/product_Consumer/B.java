package com.xy.juc.product_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间通信问题，线程交替执行
 * A，B操作同一个变量
 */

public class B {
    public static void main(String[] args)  {
        Data2 data = new Data2();
        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            data.increment();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
                ,"A").start();

        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            data.decrement();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                ,"B").start();

        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            data.increment();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                ,"C").start();

        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            data.decrement();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                ,"D").start();
    }
}

// 等待 业务  通知
class Data2{
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition empty = lock.newCondition();

    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number!=0){
                // 等待操作
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"==》" +number);

            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public  void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (number==0){
                // 等待操作
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"==》" +number);
            // 通知其他线程，我-1完毕了
           condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }



    }
}
