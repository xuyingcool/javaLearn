package com.xy.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    AtomicReference<Thread> atomic = new AtomicReference<>();

    public void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"++>lock");
        while (!atomic.compareAndSet(null,thread)){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"在自旋");
        }

    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"-->unlock");
        atomic.compareAndSet(thread,null);

    }

}
