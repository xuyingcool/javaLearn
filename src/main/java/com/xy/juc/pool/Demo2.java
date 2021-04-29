package com.xy.juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 四种拒绝策略
 * 1.ThreadPoolExecutor.AbortPolicy()  超过了我们的服务数量，就抛出异常
 * 2.new ThreadPoolExecutor.CallerRunsPolicy()   哪来的去哪里，交给送进来的线程执行
 * 3.ThreadPoolExecutor.DiscardPolicy()   队列满了就丢掉任务，不会抛出异常
 * 4.ThreadPoolExecutor.DiscardOldestPolicy()  队列满了，尝试去和最早的竞争，也不会抛出异常
 */
public class Demo2 {
    public static void main(String[] args) {
       ThreadPoolExecutor threadPoll =  new ThreadPoolExecutor(2,5,
                3, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()

       );

        try {

            for (int i = 0; i < 20; i++) {
                Thread.sleep(2);
                threadPoll.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"  ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoll.shutdown();
        }
    }
}
