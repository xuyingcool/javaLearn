package jucLearn.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 独占锁(写锁) 一次智能被1个线程占有
 * 共享锁(读锁)  多个线程可以同时占有
 * ReadWriteLock
 * 读-读      可以共存
 * 读-写      不可以共存
 * 写-写      不可以共存
 */
public class TestReadWriteLockDemo1 {
    public static void main(String[] args) {
        MyCacheLock myCache = new MyCacheLock();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get2(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    // 存，写
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");
    }

    // 取，读
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕");
    }
}


/**
 * 加上读写锁之后的缓存
 */
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();

    //读写锁,好处：更加细腻度的控制
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 存，写
    //写入的时候只希望，同时只有一个线程往里面写
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
//            TimeUnit.SECONDS.sleep(2);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }

    // 取，读
    //读的时候，可以有多个线程同时读
    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }


    }

    // 这里不加锁，写的时候就去读了
    public void get2(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕");
    }
}
