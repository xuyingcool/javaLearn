package com.xy.juc.functionInterface;

import java.util.function.Supplier;

/**
 * 供给型接口：没有参数，只有返回值
 */
public class Demo4 {
    public static void main(String[] args) {
        Supplier<Integer> supplier = ()->{
            return 1024;
        };
        System.out.println(supplier.get());
    }
}
