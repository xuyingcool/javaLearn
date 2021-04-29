package com.xy.juc.single;

//懒汉式
public class LazyManLock {
    private LazyManLock(){
        System.out.println(Thread.currentThread().getName()+"单例");
    }

    private static LazyManLock lazyMan;

    //双重检测锁模式，懒汉式单例  DCL懒汉式
    public static LazyManLock getInstance(){
        if(lazyMan==null){
           synchronized (LazyMan.class){
               if(lazyMan==null){
                   lazyMan = new LazyManLock();
                   /**
                    * 1.分配内存空间
                    * 2.执行构造方法，初始化对象
                    * 3.把这个对象指向这个空间
                    *
                    * 需要避免指令重排
                    */
               }
           }
        }
        return lazyMan;
    }
    //多线程并发，会有问题
    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            new Thread(() -> {
                lazyMan.getInstance();
            }).start();
        }
    }
}
