package com.xy.juc.forkjoin;

public class Demo1 {
    public static void main(String[] args) {

        long sum =0;
        for (long i = 0; i < 10_0000_0000; i++) {
            sum +=i;
        }
        System.out.println(sum);
    }
}
