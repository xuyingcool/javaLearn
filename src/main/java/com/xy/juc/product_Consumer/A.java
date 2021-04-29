package com.xy.juc.product_Consumer;

/**
 * 线程间通信问题，线程交替执行
 * A，B操作同一个变量
 */

public class A {
    public static void main(String[] args)  {
        Data data = new Data();
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
class Data{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        if (number!=0){
            // 等待操作
            System.out.println(Thread.currentThread().getName()+"在等待");
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"==》" +number);
        this.notifyAll();
        // 通知其他线程，我+1完毕了
    }

    public synchronized void decrement() throws InterruptedException {
        if (number==0){
            // 等待操作
            System.out.println(Thread.currentThread().getName()+"在等待");
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"==》" +number);
        // 通知其他线程，我-1完毕了
        this.notifyAll();
    }
}
