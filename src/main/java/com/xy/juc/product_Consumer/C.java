package com.xy.juc.product_Consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        PP data = new PP();
        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        data.printA();
                    }

                }
                ,"A").start();

        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        data.printB();
                    }
                }
                ,"B").start();

        new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        data.printC();
                    }
                }
                ,"C").start();
    }
}

class PP{

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    private int num = 1; // 1A 2B 3C
    public void printA(){
        lock.lock();
        try {
            while (num!=1){
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"打印了");
            num = 2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            while (num!=2){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"打印了");
            num = 3;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while (num!=3){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"打印了");
            num = 1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
