package com.xy.juc.single;

//饿汉式单例
public class Hungry {

    // 缺点：浪费空间
    private Hungry(){}

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
