package com.xy.juc.functionInterface;

import java.util.function.Function;

/**
 * Function 函数式接口，有一个输入参数，一个输出
 * 只要是函数式接口就可以用lambda表达式简化
 */
public class Demo1 {
    public static void main(String[] args) {
        // 工具类，输出输入的值
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };
        // lambda简化
        Function<String,String> function= str->{return str;};
        System.out.println(function.apply("Hello"));
    }
}
