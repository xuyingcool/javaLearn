package com.xy.juc.functionInterface;


import java.util.function.Predicate;

/**
 * 断定性接口，有一个输入参数，返回值只能是布尔值
 */
public class Demo2 {
    public static void main(String[] args) {
//        new Predicate<>()

        Predicate<String> p = (str)->{
                return str.isEmpty();
        };
        System.out.println(p.test("123"));
    }
}
