package java.com.xy.juc.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue 不存储元素
 * put了一个元素，必须从里面先take取出来，否则不能put进去值
 */
public class TestSynQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>(); // 同步隊列

        for (int i=1;i<4;i++){
            final int temp = i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"put " +temp);
                    blockingQueue.put(String.valueOf(temp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"T"+String.valueOf(temp)).start();
        }

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"=>>"+blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"=>>"+blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"=>>"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"QU").start();
    }
}
