package com.xy.juc.demo1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 真正的多线程开发，公司中的
 * 线程就是一个单独的资源类，没有任何负数的操作
 * 属性、方法
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        // 并发,多线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();
        new Thread(()->{ for (int i = 0; i < 60; i++)  ticket.sale(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 60; i++)  ticket.sale(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 60; i++)  ticket.sale(); },"C").start();
    }
}

// lock三部曲
class Ticket2{
    private  int num = 50;
    Lock lock = new ReentrantLock();

    public void sale(){
        // 加锁
        lock.lock();

        try {
            //业务代码
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+num--+"张票,剩余的票数为"+num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //解锁
            lock.unlock();
        }
    }
}
