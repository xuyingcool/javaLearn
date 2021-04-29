package com.xy.juc.demo1;


/**
 * 真正的多线程开发，公司中的
 * 线程就是一个单独的资源类，没有任何负数的操作
 * 属性、方法
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        // 并发,多线程操作同一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();
        new Thread(
                ()->{
                    for (int i = 0; i < 60; i++) {
                        ticket.sale();
                    }
                },"A").start();
        new Thread(
                ()->{
                    for (int i = 0; i < 60; i++) {
                        ticket.sale();
                    }
                },"B").start();
        new Thread(
                ()->{
                    for (int i = 0; i < 60; i++) {
                        ticket.sale();
                    }
                },"C").start();
    }
}

// 资源类OOP，不要让它继承类，变成一个不纯粹的
class Ticket{
    private  int num = 50;

    // synchronized 本质就是排队
    public synchronized void sale(){
        if(num>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+num--+"张票,剩余的票数为"+num);
        }
    }
}
