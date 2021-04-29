package com.xy.juc.functionInterface;

import java.util.function.Consumer;

/**
 * 消费型接口：只有输入，没有返回值
 */
public class Demo3 {
    public static void main(String[] args) {
        Consumer consumer = (num)->{
            System.out.println(num);
        };

        consumer.accept("ioasdji");
    }
}
