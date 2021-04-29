package com.xy.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Mythread thread = new Mythread();
        // 适配类
        FutureTask futureTask = new FutureTask(thread);

        // thread 的参数只有Runnable，这时候需要让callable和Runnable搭上关系
        // 于是用到了Runnable的实现类futureTask，他可以传入callable进去(看源码就知道了)
        new Thread(futureTask,"A").start(); // 线程启动的方式只有1个
        new Thread(futureTask,"A").start();  // 如果运行两次会产生几个call()？  只有1个，有缓存

        String o =(String) futureTask.get(); // get方法可能会产生阻塞，把他放到最后
        System.out.println(o);
    }
}

class Mythread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "123";
    }
}
