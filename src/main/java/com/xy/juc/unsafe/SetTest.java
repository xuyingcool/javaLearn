package com.xy.juc.unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

// java.util.ConcurrentModificationException
public class SetTest {

    public static void main(String[] args) {


        /**
         * 解决方法:
         * 1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
         * 2. Set<String> set =new CopyOnWriteArraySet<>();
         */
        Set<String> set =new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(
                    ()->{
                        set.add(UUID.randomUUID().toString().substring(0,5));
                        System.out.println(set);
                    },String.valueOf(i)).start();
        }
    }
}
