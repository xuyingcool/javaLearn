package com.xy.juc.single;

//懒汉式
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"单例");
    }

    private static LazyMan lazyMan;

    public static LazyMan getInstance(){
        if(lazyMan==null){
            lazyMan = new LazyMan();
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
