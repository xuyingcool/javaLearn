package com.xy.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


// java.util.ConcurrentModificationException 并发修改异常
public class ListTest {


    public static void main(String[] args) {
//    并发下ArrayList 不安全

        /**
         * 解决方案：
         * 1.  List<String> list = new Vector<>();
         * 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
         *
         * 3. List<String> list = new CopyOnWriteArrayList<>();
         */
        //  CopyOnWrite写入时复制    COW  计算机程序设计领域的一种优化策略
        // 多个线程调用的时候，list  读写的时候，固定的。  写入(覆盖)
        // 写入的时候，避免覆盖造成数据问题，先复制一份，再插入
        // CopyOnWriteArrayList 比 Vector 好在哪里
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        list.add(UUID.randomUUID().toString().substring(0,5));
                        System.out.println(list);
                    },String.valueOf(i)).start();
        }

    }
}
